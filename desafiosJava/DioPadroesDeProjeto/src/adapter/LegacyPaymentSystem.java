package adapter;

/**
 * Sistema de pagamento legado que será adaptado
 * Esta classe representa um sistema antigo com interface incompatível
 */
public class LegacyPaymentSystem {
    
    private String merchantId;
    private String terminalId;
    
    public LegacyPaymentSystem(String merchantId, String terminalId) {
        this.merchantId = merchantId;
        this.terminalId = terminalId;
        System.out.println("🔌 Sistema de pagamento legado inicializado");
        System.out.println("🏪 Merchant ID: " + merchantId);
        System.out.println("💳 Terminal ID: " + terminalId);
    }
    
    /**
     * Método legado para processar pagamento
     * Interface incompatível com o sistema moderno
     */
    public boolean processLegacyPayment(String cardData, double amount, String currency) {
        System.out.println("🔌 PROCESSANDO PAGAMENTO LEGADO");
        System.out.println("💳 Dados do cartão: " + cardData);
        System.out.println("💰 Valor: " + amount + " " + currency);
        System.out.println("🏪 Merchant: " + merchantId);
        System.out.println("💳 Terminal: " + terminalId);
        
        // Simulação de processamento legado
        try {
            Thread.sleep(2000); // Sistema legado é mais lento
            System.out.println("✅ Pagamento legado processado com sucesso!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("❌ Erro no processamento legado");
            return false;
        }
    }
    
    /**
     * Método legado para obter status
     */
    public String getLegacyStatus() {
        return "LEGACY_ACTIVE";
    }
    
    /**
     * Método legado para cancelar transação
     */
    public boolean cancelLegacyTransaction(String transactionId) {
        System.out.println("🔌 Cancelando transação legada: " + transactionId);
        System.out.println("✅ Transação legada cancelada!");
        return true;
    }
    
    public String getMerchantId() {
        return merchantId;
    }
    
    public String getTerminalId() {
        return terminalId;
    }
}
