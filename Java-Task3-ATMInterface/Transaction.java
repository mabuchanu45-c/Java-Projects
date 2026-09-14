import java.time.LocalDateTime;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime timestamp;
    private final String details;

    public Transaction(String type, double amount, String details) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.details = details;
    }

    @Override
    public String toString() {
        return "[" + timestamp.toLocalTime().withNano(0) + "] " + type +
               " - Rs." + amount + " | " + details;
    }
}