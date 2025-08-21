package adapter;

/**
 * PADRÃO ADAPTER - Padrão Estrutural
 * 
 * PROBLEMA:
 * - Interfaces incompatíveis entre sistemas
 * - Cliente espera uma interface, mas sistema fornece outra
 * - Integração de sistemas legados com sistemas modernos
 * 
 * SOLUÇÃO:
 * - Classe intermediária que converte uma interface em outra
 * - Encapsula a complexidade da conversão
 * - Permite que sistemas incompatíveis trabalhem juntos
 * 
 * EXEMPLOS PRÁTICOS:
 * - Integração com APIs externas
 * - Adaptação de sistemas legados
 * - Conversão de formatos de dados
 * - Wrapper para bibliotecas de terceiros
 * 
 * VANTAGENS:
 * + Permite reutilização de código legado
 * + Facilita integração entre sistemas
 * + Mantém compatibilidade
 * + Reduz necessidade de reescrever código
 * 
 * DESVANTAGENS:
 * - Pode adicionar complexidade
 * - Pode impactar performance
 * - Pode criar dependências ocultas
 * - Pode dificultar manutenção
 */
public class LegacyPaymentAdapter implements ModernPaymentInterface {
    
    private LegacyPaymentSystem legacySystem;
    
    public LegacyPaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
        System.out.println("🔌 Adapter criado para sistema legado!");
    }
    
    @Override
    public boolean processPayment(PaymentData paymentData) {
        System.out.println("🔄 ADAPTER: Convertendo dados modernos para formato legado...");
        
        // Converte dados modernos para formato legado
        String legacyCardData = convertToLegacyFormat(paymentData);
        
        // Chama o sistema legado
        boolean result = legacySystem.processLegacyPayment(
            legacyCardData, 
            paymentData.getAmount(), 
            paymentData.getCurrency()
        );
        
        if (result) {
            System.out.println("✅ ADAPTER: Pagamento processado com sucesso via sistema legado!");
        } else {
            System.out.println("❌ ADAPTER: Falha no processamento via sistema legado!");
        }
        
        return result;
    }
    
    @Override
    public String getStatus() {
        // Converte status legado para formato moderno
        String legacyStatus = legacySystem.getLegacyStatus();
        String modernStatus = convertLegacyStatus(legacyStatus);
        
        System.out.println("🔄 ADAPTER: Status legado '" + legacyStatus + "' convertido para '" + modernStatus + "'");
        return modernStatus;
    }
    
    @Override
    public boolean cancelTransaction(String transactionId) {
        System.out.println("🔄 ADAPTER: Cancelando transação via sistema legado...");
        return legacySystem.cancelLegacyTransaction(transactionId);
    }
    
    /**
     * Converte dados modernos para formato legado
     */
    private String convertToLegacyFormat(PaymentData paymentData) {
        // Simula conversão de formato
        String legacyFormat = String.format("CARD:%s|HOLDER:%s|EXP:%s|CVV:%s", 
            paymentData.getCardNumber(),
            paymentData.getCardHolder(),
            paymentData.getExpiryDate(),
            paymentData.getCvv()
        );
        
        System.out.println("🔄 ADAPTER: Dados convertidos para formato legado: " + legacyFormat);
        return legacyFormat;
    }
    
    /**
     * Converte status legado para formato moderno
     */
    private String convertLegacyStatus(String legacyStatus) {
        switch (legacyStatus) {
            case "LEGACY_ACTIVE":
                return "ACTIVE";
            case "LEGACY_INACTIVE":
                return "INACTIVE";
            case "LEGACY_ERROR":
                return "ERROR";
            default:
                return "UNKNOWN";
        }
    }
}
