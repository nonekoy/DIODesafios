package strategy;

/**
 * Implementação concreta da estratégia de pagamento com PIX
 */
public class PixPayment implements PaymentStrategy {
    
    private String pixKey;
    private String accountHolder;
    
    public PixPayment(String pixKey, String accountHolder) {
        this.pixKey = pixKey;
        this.accountHolder = accountHolder;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println("Processando pagamento com PIX...");
        System.out.println("Chave PIX: " + pixKey);
        System.out.println("Titular: " + accountHolder);
        System.out.println("Valor: R$ " + String.format("%.2f", amount));
        
        // Simulação de processamento PIX
        try {
            Thread.sleep(500); // PIX é mais rápido
            System.out.println("✅ Pagamento PIX processado com sucesso!");
            System.out.println("💰 Transferência instantânea realizada");
            return true;
        } catch (InterruptedException e) {
            System.out.println("❌ Erro no processamento PIX");
            return false;
        }
    }
    
    @Override
    public String getStrategyInfo() {
        return "Pagamento PIX";
    }
}
