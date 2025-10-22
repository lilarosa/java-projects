/**
 * BankAccount 类：封装余额、存取款校验
 */
public class BankAccount {
    private String owner;
    private String iban;
    private double balance;

    public BankAccount(String owner, String iban, double initialBalance) {
        this.owner = owner;
        this.iban = iban;
        this.balance = Math.max(0, initialBalance);
    }

    public String getOwner() { return owner; }
    public String getIban() { return iban; }
    public double getBalance() { return balance; }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{owner='" + owner + "', iban='" + iban + "', balance=" + balance + "}";
    }
}
