# Board de Tarefas - Spring Boot

Um sistema completo de gerenciamento de tarefas desenvolvido em Java com Spring Boot, seguindo as melhores práticas de desenvolvimento e arquitetura em camadas.

## 🚀 Funcionalidades

- **Dashboard Interativo**: Visualização de estatísticas e métricas das tarefas
- **Board Kanban**: Interface visual com colunas para diferentes status
- **CRUD Completo**: Criar, ler, atualizar e deletar tarefas
- **Gerenciamento de Status**: Mover tarefas entre colunas (A Fazer → Em Andamento → Em Revisão → Concluída)
- **Sistema de Prioridades**: Urgente, Alta, Média e Baixa
- **Datas de Vencimento**: Controle de prazos com alertas de tarefas vencidas
- **API REST**: Endpoints para integração com outros sistemas
- **Interface Responsiva**: Design moderno e adaptável a diferentes dispositivos

## 🏗️ Arquitetura

O projeto segue a arquitetura em camadas (Layered Architecture) com as seguintes responsabilidades:

### 📁 Estrutura do Projeto

```
src/main/java/com/dio/board/
├── domain/           # Camada de domínio (entidades)
│   ├── Task.java
│   ├── TaskStatus.java
│   └── TaskPriority.java
├── repository/       # Camada de persistência
│   └── TaskRepository.java
├── service/          # Camada de negócio
│   ├── TaskService.java
│   ├── TaskStatistics.java
│   └── impl/
│       └── TaskServiceImpl.java
├── controller/       # Camada de apresentação
│   ├── TaskController.java (REST API)
│   └── WebController.java (Web Interface)
└── BoardApplication.java
```

### 🔧 Tecnologias Utilizadas

- **Java 17**: Linguagem de programação
- **Spring Boot 3.2.0**: Framework principal
- **Spring Data JPA**: Persistência de dados
- **H2 Database**: Banco de dados em memória
- **Thymeleaf**: Template engine para views
- **Bootstrap 5**: Framework CSS
- **Font Awesome**: Ícones
- **Gradle**: Gerenciador de dependências
- **Lombok**: Redução de código boilerplate

## 🛠️ Como Executar

### Pré-requisitos

- Java 17 ou superior
- Gradle (opcional, o projeto usa Gradle Wrapper)

### Passos para Execução

1. **Clone o repositório**
   ```bash
   git clone <url-do-repositorio>
   cd board-java
   ```

2. **Execute o projeto**
   ```bash
   # Usando Gradle Wrapper
   ./gradlew bootRun
   
   # Ou usando Gradle instalado
   gradle bootRun
   ```

3. **Acesse a aplicação**
   - **Interface Web**: http://localhost:8080
   - **Dashboard**: http://localhost:8080/
   - **Board Kanban**: http://localhost:8080/board
   - **Nova Tarefa**: http://localhost:8080/tasks/new
   - **Console H2**: http://localhost:8080/h2-console

### Configuração do Banco de Dados

- **URL**: jdbc:h2:mem:boarddb
- **Usuário**: sa
- **Senha**: (vazia)

## 📊 API REST

### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/tasks` | Lista todas as tarefas |
| GET | `/api/tasks/{id}` | Busca tarefa por ID |
| POST | `/api/tasks` | Cria nova tarefa |
| PUT | `/api/tasks/{id}` | Atualiza tarefa |
| DELETE | `/api/tasks/{id}` | Remove tarefa |
| GET | `/api/tasks/status/{status}` | Busca tarefas por status |
| GET | `/api/tasks/priority/{priority}` | Busca tarefas por prioridade |
| GET | `/api/tasks/overdue` | Busca tarefas vencidas |
| GET | `/api/tasks/search?title={title}` | Busca tarefas por título |
| PATCH | `/api/tasks/{id}/status` | Atualiza status da tarefa |
| PATCH | `/api/tasks/{id}/priority` | Atualiza prioridade da tarefa |
| GET | `/api/tasks/statistics` | Obtém estatísticas das tarefas |

### Exemplo de Uso da API

```bash
# Criar nova tarefa
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Nova Tarefa",
    "description": "Descrição da tarefa",
    "status": "TODO",
    "priority": "HIGH",
    "dueDate": "2024-01-15T10:00:00"
  }'

# Listar todas as tarefas
curl http://localhost:8080/api/tasks

# Buscar tarefas por status
curl http://localhost:8080/api/tasks/status/TODO
```

## 🎯 Funcionalidades Detalhadas

### Dashboard
- **Estatísticas em Tempo Real**: Contadores de tarefas por status
- **Taxa de Conclusão**: Barra de progresso visual
- **Tarefas Recentes**: Lista das tarefas mais recentes
- **Indicadores Visuais**: Cores e ícones para facilitar identificação

### Board Kanban
- **4 Colunas**: A Fazer, Em Andamento, Em Revisão, Concluída
- **Drag & Drop Visual**: Interface intuitiva para mover tarefas
- **Indicadores de Prioridade**: Cores diferentes para cada nível
- **Alertas de Vencimento**: Tarefas vencidas destacadas
- **Contadores**: Número de tarefas em cada coluna

### Gerenciamento de Tarefas
- **Formulário Completo**: Campos para todos os atributos
- **Validação**: Campos obrigatórios e formatos corretos
- **Edição Inline**: Atualização rápida de status e prioridade
- **Exclusão Segura**: Confirmação antes de deletar

## 🔍 Boas Práticas Implementadas

### Arquitetura
- **Separação de Responsabilidades**: Cada camada tem função específica
- **Inversão de Dependência**: Uso de interfaces e injeção de dependência
- **Padrão Repository**: Abstração da camada de persistência
- **Padrão Service**: Lógica de negócio centralizada

### Código
- **Validação de Dados**: Bean Validation para entradas
- **Tratamento de Erros**: Respostas HTTP apropriadas
- **Documentação**: Javadoc e comentários explicativos
- **Nomenclatura**: Convenções Java e Spring Boot

### Interface
- **Design Responsivo**: Adaptável a diferentes telas
- **UX Intuitiva**: Navegação clara e feedback visual
- **Acessibilidade**: Uso de ícones e cores significativas
- **Performance**: Carregamento otimizado

## 📈 Melhorias Futuras

- [ ] Autenticação e autorização de usuários
- [ ] Categorização de tarefas
- [ ] Sistema de comentários
- [ ] Notificações por email
- [ ] Relatórios e exportação
- [ ] Integração com calendário
- [ ] Anexos de arquivos
- [ ] Histórico de alterações
- [ ] Tempo estimado vs. real
- [ ] Dashboard avançado com gráficos

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto foi desenvolvido para fins educacionais como parte do curso da Digital Innovation One.

## 👨‍💻 Autor

Desenvolvido seguindo as melhores práticas de desenvolvimento Java e Spring Boot.

---

**Board de Tarefas** - Uma solução completa para gerenciamento de projetos e tarefas! 🚀
