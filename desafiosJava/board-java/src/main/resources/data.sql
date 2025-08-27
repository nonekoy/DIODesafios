-- Dados iniciais para o board de tarefas
INSERT INTO tasks (title, description, status, priority, created_at, updated_at, due_date) VALUES
('Implementar autenticacao de usuarios', 'Criar sistema de login e registro com Spring Security', 'TODO', 'HIGH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', 7, CURRENT_TIMESTAMP)),
('Criar API REST para tarefas', 'Desenvolver endpoints CRUD para gerenciamento de tarefas', 'IN_PROGRESS', 'URGENT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', 3, CURRENT_TIMESTAMP)),
('Design da interface do usuario', 'Criar mockups e prototipos das telas principais', 'REVIEW', 'MEDIUM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', 5, CURRENT_TIMESTAMP)),
('Configurar banco de dados', 'Instalar e configurar PostgreSQL para producao', 'DONE', 'HIGH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', -2, CURRENT_TIMESTAMP)),
('Testes unitarios', 'Implementar testes para todas as classes de servico', 'TODO', 'MEDIUM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', 10, CURRENT_TIMESTAMP)),
('Documentacao da API', 'Criar documentacao Swagger para os endpoints', 'TODO', 'LOW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', 14, CURRENT_TIMESTAMP)),
('Deploy em producao', 'Configurar ambiente de producao e fazer deploy', 'TODO', 'URGENT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', 1, CURRENT_TIMESTAMP)),
('Otimizacao de performance', 'Analisar e otimizar consultas ao banco de dados', 'IN_PROGRESS', 'MEDIUM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', 8, CURRENT_TIMESTAMP)),
('Correcao de bugs', 'Corrigir problemas reportados pelos usuarios', 'REVIEW', 'HIGH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', 2, CURRENT_TIMESTAMP)),
('Atualizacao de dependencias', 'Atualizar bibliotecas para versoes mais recentes', 'DONE', 'LOW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, DATEADD('DAY', -1, CURRENT_TIMESTAMP));
