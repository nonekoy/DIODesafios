# 📚 Documentação Detalhada dos Padrões de Projeto

## 🔒 Padrão Singleton

### **Definição Teórica**
O Singleton é um padrão criacional que garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela.

### **Problema Resolvido**
- **Controle de Recursos**: Quando você precisa garantir que apenas uma instância de uma classe exista
- **Configurações Globais**: Para configurações que devem ser compartilhadas em toda a aplicação
- **Logging**: Para sistemas de log centralizados
- **Conexões de Banco**: Para pools de conexão únicos

### **Implementação no Projeto**
```java
public class Singleton {
    private static Singleton instance;
    private Singleton() { /* construtor privado */ }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### **Vantagens**
- ✅ Garante uma única instância
- ✅ Acesso global controlado
- ✅ Lazy initialization
- ✅ Thread-safe (com synchronized)

### **Desvantagens**
- ❌ Pode dificultar testes unitários
- ❌ Pode criar acoplamento global
- ❌ Violação do princípio de responsabilidade única

---

## 🎯 Padrão Strategy

### **Definição Teórica**
O Strategy é um padrão comportamental que define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis.

### **Problema Resolvido**
- **Algoritmos Intercambiáveis**: Quando você tem diferentes formas de realizar a mesma tarefa
- **Eliminação de Condicionais**: Para evitar grandes blocos if-else ou switch
- **Extensibilidade**: Para adicionar novos algoritmos sem modificar código existente

### **Implementação no Projeto**
```java
public interface PaymentStrategy {
    boolean pay(double amount);
    String getStrategyInfo();
}

public class CreditCardPayment implements PaymentStrategy { /* ... */ }
public class PixPayment implements PaymentStrategy { /* ... */ }
```

### **Vantagens**
- ✅ Fácil adição de novas estratégias
- ✅ Elimina condicionais complexas
- ✅ Favorece composição sobre herança
- ✅ Estratégias podem ser alteradas em runtime

### **Desvantagens**
- ❌ Pode criar muitas classes pequenas
- ❌ Cliente deve conhecer as estratégias disponíveis
- ❌ Pode aumentar a complexidade do sistema

---

## 🏗️ Padrão Facade

### **Definição Teórica**
O Facade é um padrão estrutural que fornece uma interface unificada para um conjunto de interfaces em um subsistema.

### **Problema Resolvido**
- **Complexidade de Subsistemas**: Quando um subsistema tem muitas classes e dependências
- **Interface Simplificada**: Para fornecer uma API mais simples para o cliente
- **Desacoplamento**: Para reduzir dependências entre subsistemas

### **Implementação no Projeto**
```java
public class BankFacade {
    private BankAccount account;
    private TransactionLogger logger;
    
    public boolean deposit(double amount) {
        // Encapsula a complexidade interna
        boolean success = account.deposit(amount);
        logger.logTransaction("DEPÓSITO", amount, account.getAccountNumber(), success);
        return success;
    }
}
```

### **Vantagens**
- ✅ Simplifica a interface para o cliente
- ✅ Reduz acoplamento entre subsistemas
- ✅ Facilita manutenção e evolução
- ✅ Centraliza lógica de coordenação

### **Desvantagens**
- ❌ Pode se tornar uma "superclasse" com muitas responsabilidades
- ❌ Pode criar dependências ocultas
- ❌ Pode dificultar testes unitários

---

## 🏭 Padrão Factory Method

### **Definição Teórica**
O Factory Method é um padrão criacional que define uma interface para criar objetos, mas deixa as subclasses decidirem qual classe instanciar.

### **Problema Resolvido**
- **Criação de Objetos**: Quando você não quer especificar classes concretas
- **Extensibilidade**: Para permitir que subclasses decidam que objetos criar
- **Reutilização**: Para reutilizar código de criação em diferentes contextos

### **Implementação no Projeto**
```java
public abstract class DocumentFactory {
    public abstract Document createDocument(String title, String author);
    
    public final void processDocument(String title, String author) {
        Document document = createDocument(title, author);
        // Processa o documento...
    }
}
```

### **Vantagens**
- ✅ Encapsula a lógica de criação
- ✅ Facilita extensão com novos tipos
- ✅ Reduz acoplamento entre classes
- ✅ Permite polimorfismo na criação

### **Desvantagens**
- ❌ Pode criar muitas subclasses
- ❌ Pode complicar a hierarquia de classes
- ❌ Pode ser overkill para casos simples

---

## 👁️ Padrão Observer

### **Definição Teórica**
O Observer é um padrão comportamental que define uma dependência um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados.

### **Problema Resolvido**
- **Notificações**: Quando objetos precisam ser notificados sobre mudanças de estado
- **Desacoplamento**: Para reduzir acoplamento entre objetos relacionados
- **Eventos**: Para implementar sistemas de eventos

### **Implementação no Projeto**
```java
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();
    
    public void attach(Observer observer) { observers.add(observer); }
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
```

### **Vantagens**
- ✅ Baixo acoplamento entre objetos
- ✅ Fácil adição/remoção de observadores
- ✅ Notificação automática
- ✅ Suporte a múltiplos observadores

### **Desvantagens**
- ❌ Pode causar notificações em cascata
- ❌ Observadores podem não ser notificados na ordem esperada
- ❌ Pode causar vazamentos de memória se não for bem gerenciado

---

## 🔌 Padrão Adapter

### **Definição Teórica**
O Adapter é um padrão estrutural que permite que interfaces incompatíveis trabalhem juntas, convertendo a interface de uma classe em outra interface esperada pelo cliente.

### **Problema Resolvido**
- **Interfaces Incompatíveis**: Quando um cliente espera uma interface, mas o sistema fornece outra
- **Integração de Sistemas**: Para integrar sistemas legados com sistemas modernos
- **APIs Externas**: Para adaptar APIs de terceiros à interface esperada

### **Implementação no Projeto**
```java
public class LegacyPaymentAdapter implements ModernPaymentInterface {
    private LegacyPaymentSystem legacySystem;
    
    @Override
    public boolean processPayment(PaymentData paymentData) {
        // Converte dados modernos para formato legado
        String legacyCardData = convertToLegacyFormat(paymentData);
        return legacySystem.processLegacyPayment(legacyCardData, amount, currency);
    }
}
```

### **Vantagens**
- ✅ Permite reutilização de código legado
- ✅ Facilita integração entre sistemas
- ✅ Mantém compatibilidade
- ✅ Reduz necessidade de reescrever código

### **Desvantagens**
- ❌ Pode adicionar complexidade
- ❌ Pode impactar performance
- ❌ Pode criar dependências ocultas
- ❌ Pode dificultar manutenção

---

## 🎯 Quando Usar Cada Padrão

### **Singleton**
- ✅ Quando você precisa de uma única instância de uma classe
- ✅ Para configurações globais ou recursos compartilhados
- ✅ Em sistemas de logging ou cache

### **Strategy**
- ✅ Quando você tem diferentes algoritmos para a mesma tarefa
- ✅ Para eliminar condicionais complexas
- ✅ Quando algoritmos podem mudar em runtime

### **Facade**
- ✅ Para simplificar interfaces complexas
- ✅ Quando você quer reduzir acoplamento entre subsistemas
- ✅ Para fornecer uma API mais simples

### **Factory Method**
- ✅ Quando você não quer especificar classes concretas
- ✅ Para permitir extensibilidade em subclasses
- ✅ Quando objetos têm configurações complexas

### **Observer**
- ✅ Para sistemas de notificações
- ✅ Quando objetos precisam reagir a mudanças de estado
- ✅ Para implementar sistemas de eventos

### **Adapter**
- ✅ Para integrar sistemas com interfaces incompatíveis
- ✅ Quando você quer reutilizar código legado
- ✅ Para adaptar APIs externas

---

## 📖 Recursos Adicionais

- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)
