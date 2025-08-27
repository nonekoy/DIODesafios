# 📚 Documentação da API

## Visão Geral

API REST para o Sistema de Gerenciamento de Tarefas - Projeto Portfolio DIO.

**Base URL:** `http://localhost:3000/api`

## Endpoints

### 📋 Tarefas

#### Listar todas as tarefas
```http
GET /api/tasks
```

**Resposta:**
```json
[
  {
    "id": 1,
    "title": "Estudar AWS",
    "status": "pendente",
    "priority": "alta",
    "createdAt": "2024-01-15T10:30:00.000Z"
  }
]
```

#### Criar nova tarefa
```http
POST /api/tasks
```

**Body:**
```json
{
  "title": "Nova tarefa",
  "priority": "media"
}
```

**Resposta:**
```json
{
  "id": 4,
  "title": "Nova tarefa",
  "status": "pendente",
  "priority": "media",
  "createdAt": "2024-01-15T10:30:00.000Z"
}
```

#### Atualizar status da tarefa
```http
PUT /api/tasks/:id
```

**Body:**
```json
{
  "status": "concluida"
}
```

**Resposta:**
```json
{
  "id": 1,
  "title": "Estudar AWS",
  "status": "concluida",
  "priority": "alta",
  "createdAt": "2024-01-15T10:30:00.000Z"
}
```

#### Remover tarefa
```http
DELETE /api/tasks/:id
```

**Resposta:**
```json
{
  "message": "Tarefa removida"
}
```

## Status Codes

- `200` - Sucesso
- `201` - Criado com sucesso
- `400` - Requisição inválida
- `404` - Não encontrado
- `500` - Erro interno do servidor

## Modelos de Dados

### Tarefa
```json
{
  "id": "number",
  "title": "string",
  "status": "pendente | em_andamento | concluida",
  "priority": "baixa | media | alta",
  "createdAt": "ISO 8601 date string"
}
```

## Exemplos de Uso

### JavaScript (Fetch API)
```javascript
// Listar tarefas
const response = await fetch('/api/tasks');
const tasks = await response.json();

// Criar tarefa
const newTask = await fetch('/api/tasks', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ title: 'Minha tarefa', priority: 'alta' })
});
```

### cURL
```bash
# Listar tarefas
curl http://localhost:3000/api/tasks

# Criar tarefa
curl -X POST http://localhost:3000/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Nova tarefa","priority":"alta"}'
```

## Limitações

- **Desenvolvimento:** Dados armazenados em memória (perdidos ao reiniciar)
- **Produção:** Recomenda-se implementar banco de dados real
- **Autenticação:** Não implementada nesta versão
- **Validação:** Básica, pode ser expandida

## Próximas Versões

- [ ] Autenticação JWT
- [ ] Validação avançada
- [ ] Paginação
- [ ] Filtros e busca
- [ ] Upload de arquivos
- [ ] Logs e monitoramento
