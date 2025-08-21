package strategy;

/**
 * Implementação concreta da estratégia de pagamento com cartão de crédito
 */
public class CreditCardPayment implements PaymentStrategy {
    
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    
    public CreditCardPayment(String cardNumber, String cardHolder, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Processando pagamento com cartão de crédito...");
        System.out.println("Cartão: " + maskCardNumber(cardNumber));
        System.out.println("Titular: " + cardHolder);
        System.out.println("Valor: R$ " + String.format("%.2f", amount));
        
        // Simulação de processamento
        try {
            Thread.sleep(1000); // Simula processamento
            System.out.println("✅ Pagamento com cartão de crédito aprovado!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("❌ Erro no processamento do cartão de crédito");
            return false;
        }
    }
    
    @Override
    public String getStrategyInfo() {
        return "Pagamento com Cartão de Crédito";
    }
    
    /**
     * Método auxiliar para mascarar o número do cartão
     */
    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() <= 4) return cardNumber;
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}
