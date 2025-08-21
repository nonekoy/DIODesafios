import singleton.Singleton;
import strategy.*;
import facade.BankFacade;
import factory.*;
import observer.*;
import adapter.*;

/**
 * CLASSE PRINCIPAL - Demonstração de Padrões de Projeto
 * 
 * Esta classe demonstra a implementação e uso de vários padrões de projeto
 * em Java puro, com exemplos práticos e explicações teóricas.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("🚀 INICIANDO DEMONSTRAÇÃO DE PADRÕES DE PROJETO");
        System.out.println("==================================================");
        System.out.println("📚 Padrões implementados:");
        System.out.println("   1. Singleton (Criacional)");
        System.out.println("   2. Strategy (Comportamental)");
        System.out.println("   3. Facade (Estrutural)");
        System.out.println("   4. Factory Method (Criacional)");
        System.out.println("   5. Observer (Comportamental)");
        System.out.println("   6. Adapter (Estrutural)");
        System.out.println("==================================================\n");
        
        // Aguarda um pouco para melhor visualização
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Demonstração dos padrões
        demonstrateSingleton();
        demonstrateStrategy();
        demonstrateFacade();
        demonstrateFactoryMethod();
        demonstrateObserver();
        demonstrateAdapter();
        
        System.out.println("\n🎉 DEMONSTRAÇÃO CONCLUÍDA!");
        System.out.println("==================================================");
        System.out.println("✅ Todos os padrões de projeto foram demonstrados com sucesso!");
        System.out.println("📖 Verifique os comentários no código para entender cada padrão");
        System.out.println("🔍 Analise a estrutura do projeto para ver a implementação");
    }
    
    /**
     * Demonstra o padrão Singleton
     */
    private static void demonstrateSingleton() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🔒 DEMONSTRANDO PADRÃO SINGLETON");
        System.out.println("=".repeat(60));
        
        // Obtém a primeira instância
        Singleton instance1 = Singleton.getInstance();
        instance1.doSomething();
        
        // Tenta obter outra instância
        Singleton instance2 = Singleton.getInstance();
        instance2.doSomething();
        
        // Verifica se são a mesma instância
        if (instance1 == instance2) {
            System.out.println("✅ Confirmação: Ambas as referências apontam para a mesma instância!");
        }
        
        // Demonstra versão thread-safe
        System.out.println("\n🔄 Testando versão thread-safe...");
        Singleton threadSafeInstance = Singleton.getThreadSafeInstance();
        threadSafeInstance.doSomething();
    }
    
    /**
     * Demonstra o padrão Strategy
     */
    private static void demonstrateStrategy() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎯 DEMONSTRANDO PADRÃO STRATEGY");
        System.out.println("=".repeat(60));
        
        // Cria estratégias de pagamento
        PaymentStrategy creditCardStrategy = new CreditCardPayment("1234-5678-9012-3456", "João Silva", "12/25");
        PaymentStrategy pixStrategy = new PixPayment("joao.silva@email.com", "João Silva");
        
        // Cria o processador de pagamento
        PaymentProcessor processor = new PaymentProcessor(creditCardStrategy);
        
        // Processa pagamento com cartão de crédito
        processor.processPayment(150.00);
        
        // Troca para estratégia PIX
        processor.setPaymentStrategy(pixStrategy);
        processor.processPayment(75.50);
        
        // Volta para cartão de crédito
        processor.setPaymentStrategy(creditCardStrategy);
        processor.processPayment(200.00);
    }
    
    /**
     * Demonstra o padrão Facade
     */
    private static void demonstrateFacade() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🏗️ DEMONSTRANDO PADRÃO FACADE");
        System.out.println("=".repeat(60));
        
        // Cria o sistema bancário simplificado
        BankFacade bankSystem = new BankFacade("12345-6", "Maria Santos", 1000.00);
        
        // Operações bancárias simplificadas
        bankSystem.checkBalance();
        bankSystem.deposit(500.00);
        bankSystem.withdraw(200.00);
        bankSystem.transfer(150.00, "98765-4");
        bankSystem.checkBalance();
        
        // Histórico de transações
        bankSystem.getTransactionHistory();
    }
    
    /**
     * Demonstra o padrão Factory Method
     */
    private static void demonstrateFactoryMethod() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🏭 DEMONSTRANDO PADRÃO FACTORY METHOD");
        System.out.println("=".repeat(60));
        
        // Cria fábricas para diferentes tipos de documento
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        DocumentFactory wordFactory = new WordDocumentFactory();
        
        // Processa documentos usando as fábricas
        pdfFactory.processDocument("Relatório Anual", "Ana Costa");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        wordFactory.processDocument("Proposta Comercial", "Carlos Lima");
    }
    
    /**
     * Demonstra o padrão Observer
     */
    private static void demonstrateObserver() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("👁️ DEMONSTRANDO PADRÃO OBSERVER");
        System.out.println("=".repeat(60));
        
        // Cria a agência de notícias (Subject)
        NewsAgency newsAgency = new NewsAgency("TechNews Brasil");
        
        // Cria canais de notícias (Observers)
        NewsChannel channel1 = new NewsChannel("Canal 1", "Geral");
        NewsChannel channel2 = new NewsChannel("Canal 2", "Esportes");
        NewsChannel channel3 = new NewsChannel("Canal 3", "Tecnologia");
        
        // Adiciona observadores à agência
        newsAgency.attach(channel1);
        newsAgency.attach(channel2);
        newsAgency.attach(channel3);
        
        // Publica notícias (muda o estado)
        newsAgency.publishNews("Nova tecnologia revoluciona mercado!");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        newsAgency.publishSportsNews("Seleção brasileira vence partida decisiva!");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        newsAgency.publishTechNews("Inteligência artificial avança em 2024!");
        
        // Remove um observador
        newsAgency.detach(channel2);
        
        // Publica mais uma notícia
        newsAgency.publishNews("Última notícia do dia!");
    }
    
    /**
     * Demonstra o padrão Adapter
     */
    private static void demonstrateAdapter() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🔌 DEMONSTRANDO PADRÃO ADAPTER");
        System.out.println("=".repeat(60));
        
        // Cria o sistema legado
        LegacyPaymentSystem legacySystem = new LegacyPaymentSystem("MERCH001", "TERM001");
        
        // Cria o adapter
        ModernPaymentInterface modernInterface = new LegacyPaymentAdapter(legacySystem);
        
        // Cria dados de pagamento modernos
        ModernPaymentInterface.PaymentData paymentData = new ModernPaymentInterface.PaymentData(
            "9876-5432-1098-7654",
            "Pedro Oliveira",
            "06/26",
            "123",
            299.99,
            "BRL"
        );
        
        // Usa a interface moderna (que internamente usa o sistema legado)
        System.out.println("💳 Dados do pagamento:");
        System.out.println(paymentData.toString());
        
        boolean success = modernInterface.processPayment(paymentData);
        
        if (success) {
            System.out.println("🎉 Pagamento realizado com sucesso via interface moderna!");
        }
        
        // Verifica status
        String status = modernInterface.getStatus();
        System.out.println("📊 Status do sistema: " + status);
        
        // Cancela transação
        modernInterface.cancelTransaction("TXN123");
    }
}
