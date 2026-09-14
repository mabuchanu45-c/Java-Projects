import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        // Seed accounts for testing
        accounts.put("1001", new Account("1001", "1234", 5000.0));
        accounts.put("1002", new Account("1002", "5678", 10000.0));
        accounts.put("1003", new Account("1003", "3333", 56000.0));
        accounts.put("1004", new Account("1004", "4444", 10000.0));
        accounts.put("1005", new Account("1005", "5555", 50000.0));
        accounts.put("1006", new Account("1006", "6666", 12000.0));
        
    }

    public Account authenticate(String accountId, String pin) {
        Account acc = accounts.get(accountId);
        if (acc != null && acc.checkPin(pin)) {
            return acc;
        }
        return null;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public boolean accountExists(String accountId) {
        return accounts.containsKey(accountId);
    }
}