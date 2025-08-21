package facade;

/**
 * Classe do subsistema bancário - Conta Bancária
 * Representa uma conta com operações básicas
 */
public class BankAccount {
    
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("💰 Depósito de R$ " + String.format("%.2f", amount) + " realizado");
            System.out.println("Saldo atual: R$ " + String.format("%.2f", balance));
            return true;
        }
        return false;
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("💸 Saque de R$ " + String.format("%.2f", amount) + " realizado");
            System.out.println("Saldo atual: R$ " + String.format("%.2f", balance));
            return true;
        } else {
            System.out.println("❌ Saldo insuficiente para saque de R$ " + String.format("%.2f", amount));
            return false;
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountInfo() {
        return "Conta: " + accountNumber + " | Titular: " + accountHolder + " | Saldo: R$ " + String.format("%.2f", balance);
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
}
