# 🚀 Guia de Execução Rápida

## ⚡ Executar em 3 Passos

### 1️⃣ Instalar Dependências
```bash
npm install
```

### 2️⃣ Executar o Projeto
```bash
npm start
```

### 3️⃣ Acessar a Aplicação
Abra seu navegador e acesse: **http://localhost:3000**

---

## 🎯 O que você verá

- ✅ **Dashboard** com estatísticas das tarefas
- 📝 **Formulário** para adicionar novas tarefas
- 📋 **Lista** de tarefas existentes
- 🔄 **Funcionalidades** de marcar como concluída e remover

## 🛠️ Funcionalidades Implementadas

- **CRUD completo** de tarefas
- **API REST** funcional
- **Interface responsiva** e moderna
- **Sistema de prioridades** (baixa, média, alta)
- **Estados das tarefas** (pendente, em andamento, concluída)
- **Estatísticas em tempo real**

## 📱 Testando a API

### Listar tarefas
```bash
curl http://localhost:3000/api/tasks
```

### Criar tarefa
```bash
curl -X POST http://localhost:3000/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Teste API","priority":"alta"}'
```

### Atualizar status
```bash
curl -X PUT http://localhost:3000/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"status":"concluida"}'
```

## 🌐 Deploy na AWS

### Pré-requisitos
- AWS CLI configurado
- Permissões para EC2 e S3

### Executar Deploy
```bash
chmod +x scripts/deploy.sh
./scripts/deploy.sh
```

## 📁 Estrutura do Projeto

```
projeto-portfolio/
├── frontend/          # Interface HTML/CSS/JS
├── backend/           # Servidor Node.js/Express
├── scripts/           # Scripts de deploy
├── docs/              # Documentação
├── .github/           # CI/CD GitHub Actions
└── README.md          # Documentação completa
```

## 🔧 Desenvolvimento

### Modo desenvolvimento
```bash
npm run dev
```

### Executar testes
```bash
npm test
```

### Linting
```bash
npm run lint
```

---

## 🎉 Pronto!

Agora você tem um projeto funcional para seu portfólio DIO! 

**Dicas para personalizar:**
- Altere as cores no CSS
- Adicione mais campos nas tarefas
- Implemente autenticação
- Conecte com banco de dados real
- Adicione mais funcionalidades

**Para o portfólio:**
- Faça commit e push para GitHub
- Adicione screenshots da aplicação
- Documente as tecnologias usadas
- Explique a arquitetura escolhida
- Mencione os serviços AWS utilizados
