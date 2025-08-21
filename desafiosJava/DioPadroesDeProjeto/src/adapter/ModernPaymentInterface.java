package adapter;

/**
 * Interface moderna para sistema de pagamento
 * Esta é a interface que o cliente moderno espera
 */
public interface ModernPaymentInterface {
    
    /**
     * Processa pagamento com interface moderna
     * @param paymentData dados do pagamento em formato moderno
     * @return true se o pagamento foi processado com sucesso
     */
    boolean processPayment(PaymentData paymentData);
    
    /**
     * Obtém o status do sistema
     * @return status do sistema
     */
    String getStatus();
    
    /**
     * Cancela uma transação
     * @param transactionId ID da transação
     * @return true se a transação foi cancelada
     */
    boolean cancelTransaction(String transactionId);
    
    /**
     * Classe interna para dados de pagamento modernos
     */
    class PaymentData {
        private String cardNumber;
        private String cardHolder;
        private String expiryDate;
        private String cvv;
        private double amount;
        private String currency;
        
        public PaymentData(String cardNumber, String cardHolder, String expiryDate, 
                          String cvv, double amount, String currency) {
            this.cardNumber = cardNumber;
            this.cardHolder = cardHolder;
            this.expiryDate = expiryDate;
            this.cvv = cvv;
            this.amount = amount;
            this.currency = currency;
        }
        
        // Getters
        public String getCardNumber() { return cardNumber; }
        public String getCardHolder() { return cardHolder; }
        public String getExpiryDate() { return expiryDate; }
        public String getCvv() { return cvv; }
        public double getAmount() { return amount; }
        public String getCurrency() { return currency; }
        
        @Override
        public String toString() {
            return "PaymentData{" +
                   "cardNumber='" + maskCardNumber(cardNumber) + '\'' +
                   ", cardHolder='" + cardHolder + '\'' +
                   ", expiryDate='" + expiryDate + '\'' +
                   ", amount=" + amount +
                   ", currency='" + currency + '\'' +
                   '}';
        }
        
        private String maskCardNumber(String cardNumber) {
            if (cardNumber.length() <= 4) return cardNumber;
            return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        }
    }
}
