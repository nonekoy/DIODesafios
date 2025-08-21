package strategy;

/**
 * PADRÃO STRATEGY - Padrão Comportamental
 * 
 * PROBLEMA:
 * - Definir uma família de algoritmos relacionados
 * - Encapsular cada algoritmo e torná-los intercambiáveis
 * - Permitir que algoritmos variem independentemente dos clientes
 * 
 * SOLUÇÃO:
 * - Interface comum para todos os algoritmos
 * - Implementações concretas para cada estratégia
 * - Cliente usa a interface, não as implementações
 * - Mudança de estratégia em tempo de execução
 * 
 * EXEMPLOS PRÁTICOS:
 * - Diferentes estratégias de pagamento
 * - Algoritmos de ordenação
 * - Estratégias de compressão
 * - Diferentes formatos de exportação
 * 
 * VANTAGENS:
 * + Fácil adição de novas estratégias
 * + Elimina condicionais complexas
 * + Favorece composição sobre herança
 * + Estratégias podem ser alteradas em runtime
 * 
 * DESVANTAGENS:
 * - Pode criar muitas classes pequenas
 * - Cliente deve conhecer as estratégias disponíveis
 * - Pode aumentar a complexidade do sistema
 */
public interface PaymentStrategy {
    
    /**
     * Método comum para todas as estratégias de pagamento
     * @param amount valor a ser pago
     * @return true se o pagamento foi processado com sucesso
     */
    boolean pay(double amount);
    
    /**
     * Método para obter informações da estratégia
     * @return descrição da estratégia
     */
    String getStrategyInfo();
}
