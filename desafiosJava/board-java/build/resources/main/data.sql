-- Dados iniciais para o board de tarefas
INSERT INTO tasks (title, description, status, priority, created_at, updated_at, due_date) VALUES
('Implementar autenticação de usuários', 'Criar sistema de login e registro com Spring Security', 'TODO', 'HIGH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL 7 DAY),
('Criar API REST para tarefas', 'Desenvolver endpoints CRUD para gerenciamento de tarefas', 'IN_PROGRESS', 'URGENT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL 3 DAY),
('Design da interface do usuário', 'Criar mockups e protótipos das telas principais', 'REVIEW', 'MEDIUM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL 5 DAY),
('Configurar banco de dados', 'Instalar e configurar PostgreSQL para produção', 'DONE', 'HIGH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP - INTERVAL 2 DAY),
('Testes unitários', 'Implementar testes para todas as classes de serviço', 'TODO', 'MEDIUM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL 10 DAY),
('Documentação da API', 'Criar documentação Swagger para os endpoints', 'TODO', 'LOW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL 14 DAY),
('Deploy em produção', 'Configurar ambiente de produção e fazer deploy', 'TODO', 'URGENT', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL 1 DAY),
('Otimização de performance', 'Analisar e otimizar consultas ao banco de dados', 'IN_PROGRESS', 'MEDIUM', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL 8 DAY),
('Correção de bugs', 'Corrigir problemas reportados pelos usuários', 'REVIEW', 'HIGH', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL 2 DAY),
('Atualização de dependências', 'Atualizar bibliotecas para versões mais recentes', 'DONE', 'LOW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP - INTERVAL 1 DAY);
