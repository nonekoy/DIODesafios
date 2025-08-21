package facade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe do subsistema bancário - Logger de Transações
 * Registra todas as operações realizadas
 */
public class TransactionLogger {
    
    private List<String> transactions;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    public TransactionLogger() {
        this.transactions = new ArrayList<>();
    }
    
    public void logTransaction(String operation, double amount, String accountNumber, boolean success) {
        String timestamp = LocalDateTime.now().format(formatter);
        String status = success ? "SUCESSO" : "FALHA";
        String logEntry = String.format("[%s] %s - R$ %.2f - Conta: %s - %s", 
                                      timestamp, operation, amount, accountNumber, status);
        
        transactions.add(logEntry);
        System.out.println("📝 LOG: " + logEntry);
    }
    
    public void logBalanceCheck(String accountNumber, double balance) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = String.format("[%s] CONSULTA SALDO - Conta: %s - Saldo: R$ %.2f", 
                                      timestamp, accountNumber, balance);
        
        transactions.add(logEntry);
        System.out.println("📝 LOG: " + logEntry);
    }
    
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactions);
    }
    
    public void printTransactionHistory() {
        System.out.println("\n📋 HISTÓRICO DE TRANSAÇÕES:");
        System.out.println("================================");
        
        if (transactions.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
        System.out.println("================================");
    }
    
    public void clearHistory() {
        transactions.clear();
        System.out.println("🗑️ Histórico de transações limpo.");
    }
}
