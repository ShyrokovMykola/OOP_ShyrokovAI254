import exceptions.AccountException;
import exceptions.InvalidMenuOptionException;
import model.Bank;
import model.BankAccount;
import model.CheckingAccount;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public class ClientInterface {

    private static final List<String> OPTIONS = List.of(
            "1 - Create account",
            "2 - Delete account",
            "3 - Make account deposit",
            "4 - Make account withdrawal",
            "5 - Print account info",
            "6 - Exit"
    );

    private final Bank bank = new Bank();

    private final ConsoleInput input = new ConsoleInput();

    private boolean running;

    public void start() {
        running = true;
        while (running) {
            showMenu();
            try {
                execute(input.menuOption());
            } catch (AccountException | InvalidMenuOptionException e) {
                // Після повідомлення про помилку повертаємося в головне меню
                System.err.println("\nError: " + e.getMessage());
            } catch (NoSuchElementException e) {
                // Потік вводу закрито (Ctrl+D / Ctrl+Z)
                System.err.println("\nInput stream is closed, exiting...");
                running = false;
            }
        }
    }

    private void execute(int option) {
        switch (option) {
            case 1 -> createAccount();
            case 2 -> deleteAccount();
            case 3 -> makeDeposit();
            case 4 -> makeWithdrawal();
            case 5 -> showAccount();
            case 6 -> running = false;
            default -> throw new InvalidMenuOptionException("Please enter a valid choice (1 thru 6)");
        }
    }

    private void createAccount() {
        showTitle("Creating new account: ");

        String name = input.name();
        Long userId = input.userId();
        String password = input.password();
        String confirmation = input.passwordConfirmation();

        bank.open(name, userId, password, confirmation);
        System.out.println("\nAccount has been successfully created");
    }

    private void deleteAccount() {
        showTitle("Deleting account: ");

        bank.close(logIn());
        System.out.println("\nAccount has been successfully deleted");
    }

    private void makeDeposit() {
        showTitle("Making a deposit: ");

        BankAccount account = logIn();
        account.deposit(input.amount());
        showResult("Deposit", account);
    }

    private void makeWithdrawal() {
        showTitle("Making a withdrawal: ");

        BankAccount account = logIn();
        account.withdraw(input.amount());
        showResult("Withdrawal", account);
    }

    private void showAccount() {
        showTitle("Printing account info: ");

        BankAccount account = logIn();

        System.out.println("\nAccount info: ");
        System.out.println(" - account number: " + account.getAccountNumber());
        System.out.println(" - customer name: " + account.getCustomerName());
        System.out.printf(Locale.US, " - account balance: %.2f%n", account.getAccountBalance());

        if (account instanceof CheckingAccount checking) {
            System.out.println(" - account type: Checking");
            System.out.printf(Locale.US, " - account daily withdrawal limit: %.2f%n",
                    checking.getDailyWithdrawalLimit());
        }

        input.line("\nPress Enter to return to main menu...");
    }

    private BankAccount logIn() {
        Long userId = input.userId();
        String password = input.password();
        return bank.authorize(userId, password);
    }

    private void showMenu() {
        showTitle("Banking system: ");
        OPTIONS.forEach(System.out::println);
        System.out.println();
    }

    private void showTitle(String title) {
        System.out.println("\n****************");
        System.out.println(title);
        System.out.println("****************");
    }

    private void showResult(String operation, BankAccount account) {
        System.out.printf(Locale.US, "%n%s has been successfully completed, account balance: %.2f%n",
                operation, account.getAccountBalance());
    }
}
