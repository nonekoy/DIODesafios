package strategy;

/**
 * Contexto que usa as estratégias de pagamento
 * Demonstra como o cliente pode trocar de estratégia dinamicamente
 */
public class PaymentProcessor {
    
    private PaymentStrategy paymentStrategy;
    
    /**
     * Construtor que define uma estratégia inicial
     */
    public PaymentProcessor(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    
    /**
     * Método para alterar a estratégia de pagamento
     */
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
        System.out.println("🔄 Estratégia alterada para: " + strategy.getStrategyInfo());
    }
    
    /**
     * Processa o pagamento usando a estratégia atual
     */
    public boolean processPayment(double amount) {
        System.out.println("\n--- PROCESSANDO PAGAMENTO ---");
        System.out.println("Estratégia atual: " + paymentStrategy.getStrategyInfo());
        
        boolean result = paymentStrategy.pay(amount);
        
        if (result) {
            System.out.println("🎉 Pagamento finalizado com sucesso!");
        } else {
            System.out.println("💥 Falha no processamento do pagamento");
        }
        
        return result;
    }
    
    /**
     * Obtém informações da estratégia atual
     */
    public String getCurrentStrategyInfo() {
        return paymentStrategy.getStrategyInfo();
    }
}
