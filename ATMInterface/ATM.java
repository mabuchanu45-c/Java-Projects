import java.util.Scanner;

public class ATM {
    private final Bank bank;
    private final Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Welcome to the ATM ===");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        Account account = null;
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();
            account = bank.authenticate(userId, pin);
            if (account != null) {
                break;
            }
            attempts++;
            System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
        }

        if (account == null) {
            System.out.println("Too many incorrect attempts. Access denied.");
            return;
        }

        System.out.println("Login successful. Welcome, " + userId + "!");
        showMenu(account);
    }

    private void showMenu(Account account) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("--- Transaction History ---");
                    if (account.getHistory().isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        account.getHistory().forEach(System.out::println);
                    }
                    break;
                case "2":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = Double.parseDouble(scanner.nextLine());
                    if (account.withdraw(withdrawAmt)) {
                        System.out.println("Withdrawal successful. New balance: Rs." + account.getBalance());
                    } else {
                        System.out.println("Insufficient Funds.");
                    }
                    break;
                case "3":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = Double.parseDouble(scanner.nextLine());
                    account.deposit(depositAmt);
                    System.out.println("Deposit successful. New balance: Rs." + account.getBalance());
                    break;
                case "4":
                    System.out.print("Enter recipient account ID: ");
                    String toId = scanner.nextLine();
                    Account toAccount = bank.getAccount(toId);
                    if (toAccount == null) {
                        System.out.println("Recipient account not found.");
                    } else {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmt = Double.parseDouble(scanner.nextLine());
                        if (transferAmt > account.getBalance()) {
                            System.out.println("Insufficient Funds.");
                        } else {
                            account.recordTransferOut(transferAmt, toId);
                            toAccount.recordTransferIn(transferAmt, account.getAccountId());
                            System.out.println("Transfer successful. New balance: Rs." + account.getBalance());
                        }
                    }
                    break;
                case "5":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
