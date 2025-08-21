package facade;

/**
 * PADRÃO FACADE - Padrão Estrutural
 * 
 * PROBLEMA:
 * - Subsistema complexo com muitas classes e dependências
 * - Interface difícil de usar para o cliente
 * - Acoplamento forte entre cliente e subsistema
 * 
 * SOLUÇÃO:
 * - Interface unificada que simplifica o uso do subsistema
 * - Encapsula a complexidade interna
 * - Reduz dependências entre cliente e subsistema
 * 
 * EXEMPLOS PRÁTICOS:
 * - API simplificada para operações bancárias
 * - Interface unificada para sistema de arquivos
 * - Wrapper para APIs externas complexas
 * 
 * VANTAGENS:
 * + Simplifica a interface para o cliente
 * + Reduz acoplamento entre subsistemas
 * + Facilita manutenção e evolução
 * + Centraliza lógica de coordenação
 * 
 * DESVANTAGENS:
 * - Pode se tornar uma "superclasse" com muitas responsabilidades
 * - Pode criar dependências ocultas
 * - Pode dificultar testes unitários
 */
public class BankFacade {
    
    private BankAccount account;
    private TransactionLogger logger;
    
    public BankFacade(String accountNumber, String accountHolder, double initialBalance) {
        this.account = new BankAccount(accountNumber, accountHolder, initialBalance);
        this.logger = new TransactionLogger();
        System.out.println("🏦 Sistema bancário inicializado para: " + accountHolder);
    }
    
    /**
     * Método simplificado para depósito
     */
    public boolean deposit(double amount) {
        System.out.println("\n--- DEPÓSITO ---");
        boolean success = account.deposit(amount);
        logger.logTransaction("DEPÓSITO", amount, account.getAccountNumber(), success);
        return success;
    }
    
    /**
     * Método simplificado para saque
     */
    public boolean withdraw(double amount) {
        System.out.println("\n--- SAQUE ---");
        boolean success = account.withdraw(amount);
        logger.logTransaction("SAQUE", amount, account.getAccountNumber(), success);
        return success;
    }
    
    /**
     * Método simplificado para consulta de saldo
     */
    public void checkBalance() {
        System.out.println("\n--- CONSULTA DE SALDO ---");
        double balance = account.getBalance();
        System.out.println(account.getAccountInfo());
        logger.logBalanceCheck(account.getAccountNumber(), balance);
    }
    
    /**
     * Método para transferir dinheiro (operações combinadas)
     */
    public boolean transfer(double amount, String destinationAccount) {
        System.out.println("\n--- TRANSFERÊNCIA ---");
        System.out.println("Transferindo R$ " + String.format("%.2f", amount) + " para conta " + destinationAccount);
        
        // Primeiro faz o saque
        boolean withdrawSuccess = account.withdraw(amount);
        if (withdrawSuccess) {
            logger.logTransaction("TRANSFERÊNCIA ENVIADA", amount, account.getAccountNumber(), true);
            System.out.println("✅ Transferência realizada com sucesso!");
            return true;
        } else {
            logger.logTransaction("TRANSFERÊNCIA FALHOU", amount, account.getAccountNumber(), false);
            System.out.println("❌ Falha na transferência");
            return false;
        }
    }
    
    /**
     * Método para obter histórico de transações
     */
    public void getTransactionHistory() {
        logger.printTransactionHistory();
    }
    
    /**
     * Método para obter informações da conta
     */
    public String getAccountInfo() {
        return account.getAccountInfo();
    }
    
    /**
     * Método para limpar histórico
     */
    public void clearTransactionHistory() {
        logger.clearHistory();
    }
}
