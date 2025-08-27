const express = require('express');
const cors = require('cors');
const path = require('path');

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware básico
app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname, '../frontend')));

// Dados simulados (em produção seria um banco real)
let tasks = [
  { id: 1, title: 'Estudar AWS', status: 'pendente', priority: 'alta' },
  { id: 2, title: 'Fazer projeto DIO', status: 'em_andamento', priority: 'alta' },
  { id: 3, title: 'Revisar código', status: 'concluida', priority: 'media' }
];

// Rotas da API
app.get('/api/tasks', (req, res) => {
  res.json(tasks);
});

app.post('/api/tasks', (req, res) => {
  const { title, priority } = req.body;
  const newTask = {
    id: tasks.length + 1,
    title,
    status: 'pendente',
    priority: priority || 'media',
    createdAt: new Date().toISOString()
  };
  tasks.push(newTask);
  res.status(201).json(newTask);
});

app.put('/api/tasks/:id', (req, res) => {
  const { id } = req.params;
  const { status } = req.body;
  const task = tasks.find(t => t.id == id);
  if (task) {
    task.status = status;
    res.json(task);
  } else {
    res.status(404).json({ error: 'Tarefa não encontrada' });
  }
});

app.delete('/api/tasks/:id', (req, res) => {
  const { id } = req.params;
  tasks = tasks.filter(t => t.id != id);
  res.json({ message: 'Tarefa removida' });
});

// Rota principal
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, '../frontend/index.html'));
});

app.listen(PORT, () => {
  console.log(`🚀 Servidor rodando na porta ${PORT}`);
  console.log(`📱 Acesse: http://localhost:${PORT}`);
});
