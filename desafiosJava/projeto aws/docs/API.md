# 📚 API do Sistema Farmacêutico

## Endpoints Principais

### 🏥 Dashboard
```
GET /api/dashboard
```
Retorna estatísticas gerais do sistema.

### 💊 Produtos
```
GET    /api/produtos     - Lista todos os produtos
POST   /api/produtos     - Cria novo produto
PUT    /api/produtos/:id - Atualiza produto
DELETE /api/produtos/:id - Remove produto
```

### 📦 Estoque
```
GET  /api/estoque       - Lista status do estoque
PUT  /api/estoque/:id   - Ajusta estoque
```

### 💰 Vendas
```
GET  /api/vendas        - Lista vendas
POST /api/vendas        - Processa nova venda
```

### 📈 Relatórios
```
GET /api/relatorios/vendas?periodo=dia|semana|mes|ano
```

## Exemplo de Uso

```bash
# Listar produtos
curl http://localhost:3000/api/produtos

# Criar produto
curl -X POST http://localhost:3000/api/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Paracetamol","categoria":"Analgésico","preco":15.90}'

# Dashboard
curl http://localhost:3000/api/dashboard
```

## Estrutura dos Dados

### Produto
```json
{
  "id": "string",
  "nome": "string",
  "categoria": "string",
  "preco": "number",
  "estoque": "number",
  "validade": "date",
  "fornecedor": "string"
}
```

### Venda
```json
{
  "id": "string",
  "produtos": [{"produtoId": "string", "quantidade": "number"}],
  "total": "number",
  "cliente": "string",
  "data": "date"
}
```
