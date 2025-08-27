const express = require('express');
const cors = require('cors');
const path = require('path');
const AWS = require('aws-sdk');
const { v4: uuidv4 } = require('uuid');
const moment = require('moment');

const app = express();
const PORT = process.env.PORT || 3000;

// Configuração AWS
AWS.config.update({
  region: process.env.AWS_REGION || 'us-east-1',
  accessKeyId: process.env.AWS_ACCESS_KEY_ID,
  secretAccessKey: process.env.AWS_SECRET_ACCESS_KEY
});

// Inicializar DynamoDB
const dynamodb = new AWS.DynamoDB.DocumentClient();

// Middleware básico
app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname, '../frontend')));

// Dados simulados para desenvolvimento (em produção seria DynamoDB)
let produtos = [
  {
    id: '1',
    nome: 'Paracetamol 500mg',
    categoria: 'Analgésico',
    preco: 15.90,
    estoque: 150,
    validade: '2025-12-31',
    fornecedor: 'LabCorp',
    codigoBarras: '7891234567890',
    receitaObrigatoria: false,
    createdAt: moment().toISOString()
  },
  {
    id: '2',
    nome: 'Dipirona 500mg',
    categoria: 'Analgésico',
    preco: 12.50,
    estoque: 200,
    validade: '2025-10-15',
    fornecedor: 'MedPharm',
    codigoBarras: '7891234567891',
    receitaObrigatoria: false,
    createdAt: moment().toISOString()
  },
  {
    id: '3',
    nome: 'Amoxicilina 500mg',
    categoria: 'Antibiótico',
    preco: 45.80,
    estoque: 75,
    validade: '2024-08-20',
    fornecedor: 'AntibioLab',
    codigoBarras: '7891234567892',
    receitaObrigatoria: true,
    createdAt: moment().toISOString()
  }
];

let vendas = [
  {
    id: '1',
    produtos: [
      { produtoId: '1', quantidade: 2, precoUnitario: 15.90 }
    ],
    total: 31.80,
    formaPagamento: 'Cartão de Crédito',
    cliente: 'João Silva',
    data: moment().subtract(1, 'day').toISOString()
  }
];

// Rotas da API

// 1. PRODUTOS
app.get('/api/produtos', async (req, res) => {
  try {
    // Em produção, buscar do DynamoDB
    res.json(produtos);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao buscar produtos' });
  }
});

app.post('/api/produtos', async (req, res) => {
  try {
    const { nome, categoria, preco, estoque, validade, fornecedor, codigoBarras, receitaObrigatoria } = req.body;
    
    const novoProduto = {
      id: uuidv4(),
      nome,
      categoria,
      preco: parseFloat(preco),
      estoque: parseInt(estoque),
      validade,
      fornecedor,
      codigoBarras,
      receitaObrigatoria: Boolean(receitaObrigatoria),
      createdAt: moment().toISOString()
    };
    
    produtos.push(novoProduto);
    res.status(201).json(novoProduto);
  } catch (error) {
    res.status(400).json({ error: 'Dados inválidos' });
  }
});

app.put('/api/produtos/:id', async (req, res) => {
  try {
    const { id } = req.params;
    const produto = produtos.find(p => p.id === id);
    
    if (!produto) {
      return res.status(404).json({ error: 'Produto não encontrado' });
    }
    
    Object.assign(produto, req.body);
    res.json(produto);
  } catch (error) {
    res.status(400).json({ error: 'Erro ao atualizar produto' });
  }
});

app.delete('/api/produtos/:id', async (req, res) => {
  try {
    const { id } = req.params;
    produtos = produtos.filter(p => p.id !== id);
    res.json({ message: 'Produto removido com sucesso' });
  } catch (error) {
    res.status(500).json({ error: 'Erro ao remover produto' });
  }
});

// 2. ESTOQUE
app.get('/api/estoque', async (req, res) => {
  try {
    const estoqueResumo = produtos.map(p => ({
      id: p.id,
      nome: p.nome,
      estoque: p.estoque,
      categoria: p.categoria,
      validade: p.validade,
      status: p.estoque > 10 ? 'OK' : p.estoque > 0 ? 'BAIXO' : 'ESGOTADO'
    }));
    
    res.json(estoqueResumo);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao buscar estoque' });
  }
});

app.put('/api/estoque/:id', async (req, res) => {
  try {
    const { id } = req.params;
    const { quantidade, operacao } = req.body; // operacao: 'adicionar' ou 'remover'
    
    const produto = produtos.find(p => p.id === id);
    if (!produto) {
      return res.status(404).json({ error: 'Produto não encontrado' });
    }
    
    if (operacao === 'adicionar') {
      produto.estoque += parseInt(quantidade);
    } else if (operacao === 'remover') {
      produto.estoque = Math.max(0, produto.estoque - parseInt(quantidade));
    }
    
    res.json(produto);
  } catch (error) {
    res.status(400).json({ error: 'Operação inválida' });
  }
});

// 3. VENDAS
app.get('/api/vendas', async (req, res) => {
  try {
    res.json(vendas);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao buscar vendas' });
  }
});

app.post('/api/vendas', async (req, res) => {
  try {
    const { produtos: produtosVenda, formaPagamento, cliente } = req.body;
    
    let total = 0;
    const produtosProcessados = [];
    
    // Processar cada produto da venda
    for (const item of produtosVenda) {
      const produto = produtos.find(p => p.id === item.produtoId);
      if (!produto) {
        return res.status(400).json({ error: `Produto ${item.produtoId} não encontrado` });
      }
      
      if (produto.estoque < item.quantidade) {
        return res.status(400).json({ error: `Estoque insuficiente para ${produto.nome}` });
      }
      
      // Atualizar estoque
      produto.estoque -= item.quantidade;
      
      const precoTotal = produto.preco * item.quantidade;
      total += precoTotal;
      
      produtosProcessados.push({
        produtoId: item.produtoId,
        quantidade: item.quantidade,
        precoUnitario: produto.preco,
        precoTotal
      });
    }
    
    const novaVenda = {
      id: uuidv4(),
      produtos: produtosProcessados,
      total,
      formaPagamento,
      cliente,
      data: moment().toISOString()
    };
    
    vendas.push(novaVenda);
    res.status(201).json(novaVenda);
  } catch (error) {
    res.status(400).json({ error: 'Erro ao processar venda' });
  }
});

// 4. DASHBOARD E MÉTRICAS
app.get('/api/dashboard', async (req, res) => {
  try {
    const totalProdutos = produtos.length;
    const totalEstoque = produtos.reduce((sum, p) => sum + p.estoque, 0);
    const valorEstoque = produtos.reduce((sum, p) => sum + (p.preco * p.estoque), 0);
    const produtosBaixoEstoque = produtos.filter(p => p.estoque <= 10).length;
    const produtosVencendo = produtos.filter(p => moment(p.validade).diff(moment(), 'days') <= 30).length;
    
    const vendasHoje = vendas.filter(v => moment(v.data).isSame(moment(), 'day')).length;
    const vendasMes = vendas.filter(v => moment(v.data).isSame(moment(), 'month')).length;
    const receitaMes = vendas.filter(v => moment(v.data).isSame(moment(), 'month'))
      .reduce((sum, v) => sum + v.total, 0);
    
    const dashboard = {
      produtos: {
        total: totalProdutos,
        estoque: totalEstoque,
        valorEstoque: valorEstoque.toFixed(2),
        baixoEstoque: produtosBaixoEstoque,
        vencendo: produtosVencendo
      },
      vendas: {
        hoje: vendasHoje,
        mes: vendasMes,
        receitaMes: receitaMes.toFixed(2)
      },
      alertas: {
        estoqueBaixo: produtos.filter(p => p.estoque <= 5).map(p => p.nome),
        vencendo: produtos.filter(p => moment(p.validade).diff(moment(), 'days') <= 7).map(p => p.nome)
      }
    };
    
    res.json(dashboard);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao gerar dashboard' });
  }
});

// 5. RELATÓRIOS
app.get('/api/relatorios/vendas', async (req, res) => {
  try {
    const { periodo } = req.query; // 'dia', 'semana', 'mes', 'ano'
    
    let vendasFiltradas = [];
    const agora = moment();
    
    switch (periodo) {
      case 'dia':
        vendasFiltradas = vendas.filter(v => moment(v.data).isSame(agora, 'day'));
        break;
      case 'semana':
        vendasFiltradas = vendas.filter(v => moment(v.data).isSame(agora, 'week'));
        break;
      case 'mes':
        vendasFiltradas = vendas.filter(v => moment(v.data).isSame(agora, 'month'));
        break;
      case 'ano':
        vendasFiltradas = vendas.filter(v => moment(v.data).isSame(agora, 'year'));
        break;
      default:
        vendasFiltradas = vendas;
    }
    
    const totalVendas = vendasFiltradas.length;
    const receitaTotal = vendasFiltradas.reduce((sum, v) => sum + v.total, 0);
    const mediaTicket = totalVendas > 0 ? (receitaTotal / totalVendas) : 0;
    
    const relatorio = {
      periodo,
      totalVendas,
      receitaTotal: receitaTotal.toFixed(2),
      mediaTicket: mediaTicket.toFixed(2),
      vendas: vendasFiltradas
    };
    
    res.json(relatorio);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao gerar relatório' });
  }
});

// Rota principal
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, '../frontend/index.html'));
});

// Health check para AWS
app.get('/health', (req, res) => {
  res.json({ 
    status: 'OK', 
    timestamp: moment().toISOString(),
    service: 'Farmacia AWS API',
    version: '1.0.0'
  });
});

app.listen(PORT, () => {
  console.log(`🏥 Sistema Farmacêutico rodando na porta ${PORT}`);
  console.log(`📱 Acesse: http://localhost:${PORT}`);
  console.log(`🔗 API: http://localhost:${PORT}/api`);
  console.log(`💊 Dashboard: http://localhost:${PORT}/dashboard`);
});
