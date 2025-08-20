# 🚀 Bootcamp Java - Programação Orientada a Objetos

Este projeto demonstra na prática todos os conceitos fundamentais da **Programação Orientada a Objetos (POO)** em Java, conforme o desafio da Digital Innovation One.

## 🎯 Objetivo

Colocar em prática os **4 pilares principais da POO** através de um projeto Java real:
- **ABSTRAÇÃO**
- **ENCAPSULAMENTO** 
- **HERANÇA**
- **POLIMORFISMO**

## 🏗️ Arquitetura do Projeto

O projeto simula um sistema de **Bootcamp** com as seguintes entidades:

### 📚 Classes Principais

1. **`Conteudo`** (Classe Abstrata)
   - Classe pai para `Curso` e `Mentoria`
   - Demonstra **ABSTRAÇÃO** e **HERANÇA**

2. **`Curso`** 
   - Herda de `Conteudo`
   - Possui carga horária e calcula XP baseado nela

3. **`Mentoria`**
   - Herda de `Conteudo` 
   - Possui data/hora e XP fixo

4. **`Dev`**
   - Representa um desenvolvedor
   - Pode se inscrever em bootcamps e progredir

5. **`Bootcamp`**
   - Gerencia todo o sistema
   - Contém conteúdos e devs inscritos

## 🔧 Pré-requisitos

- ✅ Java JDK 11 ou superior
- ✅ Maven 3.6+
- ✅ IDE Java (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Como Executar

### 1. Compilar o Projeto
```bash
mvn clean compile
```

### 2. Executar via Maven
```bash
mvn exec:java -Dexec.mainClass="Main"
```

### 3. Executar via JAR
```bash
mvn package
java -jar target/poo-java-1.0.0.jar
```

### 4. Executar via IDE
- Abra o projeto na sua IDE
- Execute a classe `Main.java`

## 📖 Conceitos Demonstrados

### 🔺 ABSTRAÇÃO
- Classes representam entidades reais do domínio
- Foco nos aspectos essenciais, ignorando detalhes irrelevantes

### 🔺 ENCAPSULAMENTO  
- Atributos privados com acesso controlado via getters/setters
- Implementação escondida, interface pública

### 🔺 HERANÇA
- `Curso` e `Mentoria` herdam de `Conteudo`
- Reutilização de código e hierarquia de classes

### 🔺 POLIMORFISMO
- Tratamento uniforme de diferentes tipos de conteúdo
- Método `calcularXp()` implementado de forma diferente em cada classe filha

## 🎮 Funcionalidades

- ✅ Criação de bootcamps com múltiplos conteúdos
- ✅ Inscrição de desenvolvedores
- ✅ Sistema de progressão e XP
- ✅ Diferentes tipos de conteúdo (cursos e mentorias)
- ✅ Relacionamentos entre entidades

## 📊 Exemplo de Saída

```
🚀 BOOTCAMP JAVA - DEMONSTRAÇÃO POO 🚀
========================================

1️⃣ CRIANDO O BOOTCAMP
✅ Bootcamp criado: Java Developer

2️⃣ CRIANDO CURSOS
✅ Curso criado: Java Básico - XP: 80.0
✅ Curso criado: Java Intermediário - XP: 120.0
✅ Curso criado: Java Avançado - XP: 160.0

3️⃣ CRIANDO MENTORIAS
✅ Mentoria criada: Mentoria Java POO - XP: 30.0
✅ Mentoria criada: Mentoria Projeto Final - XP: 30.0

[... continua com mais detalhes ...]
```

## 🗂️ Estrutura do Projeto

```
src/
├── main/
│   └── java/
│       ├── domain/
│       │   ├── Conteudo.java      # Classe abstrata
│       │   ├── Curso.java         # Herda de Conteudo
│       │   ├── Mentoria.java      # Herda de Conteudo
│       │   ├── Dev.java           # Classe Dev
│       │   └── Bootcamp.java      # Classe principal
│       └── Main.java              # Classe de execução
├── pom.xml                        # Configuração Maven
└── README.md                      # Este arquivo
```

## 🎓 Aprendizados

Este projeto demonstra:

1. **Modelagem de Domínio**: Como abstrair entidades reais em classes
2. **Relacionamentos**: Como conectar diferentes classes
3. **Herança**: Como criar hierarquias de classes
4. **Polimorfismo**: Como tratar objetos de forma uniforme
5. **Encapsulamento**: Como proteger dados e comportamentos

## 🤝 Contribuição

Este projeto foi criado para fins educacionais. Contribuições são bem-vindas!

- ⭐ Dê uma estrela no projeto
- 🐛 Reporte issues encontrados
- 💡 Sugira melhorias

## 📚 Recursos Adicionais

- [Digital Innovation One](https://digitalinnovation.one/)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Maven Documentation](https://maven.apache.org/guides/)

---

**Desenvolvido com ❤️ para a comunidade Java**

*Projeto baseado no desafio da Digital Innovation One*
