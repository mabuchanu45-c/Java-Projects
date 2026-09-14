import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String accountId;
    private final String pin;
    private double balance;
    private final List<Transaction> history;

    public Account(String accountId, String pin, double initialBalance) {
        this.accountId = accountId;
        this.pin = pin;
        this.balance = initialBalance;
        this.history = new ArrayList<>();
    }

    public String getAccountId() { return accountId; }
    public boolean checkPin(String enteredPin) { return pin.equals(enteredPin); }
    public double getBalance() { return balance; }
    public List<Transaction> getHistory() { return history; }

    public void deposit(double amount) {
        balance += amount;
        history.add(new Transaction("Deposit", amount, "New balance: Rs." + balance));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        history.add(new Transaction("Withdraw", amount, "New balance: Rs." + balance));
        return true;
    }

    public void recordTransferOut(double amount, String toAccount) {
        balance -= amount;
        history.add(new Transaction("Transfer Out", amount, "To account: " + toAccount));
    }

    public void recordTransferIn(double amount, String fromAccount) {
        balance += amount;
        history.add(new Transaction("Transfer In", amount, "From account: " + fromAccount));
    }
}