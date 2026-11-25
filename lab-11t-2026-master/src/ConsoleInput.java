import exceptions.InvalidAmountException;
import exceptions.InvalidMenuOptionException;
import exceptions.InvalidUserIdException;

import java.util.Scanner;

/**
 * Зчитування та розбір даних, які вводить користувач.
 */
public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    /*
     * Читаємо рядок цілком: scanner.next() розбив би ім'я "Ivan Petrenko" на два
     * токени, і прізвище потрапило б у поле userId
     */
    public String line(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public String name() {
        return line(">>> Enter customer name: ").trim();
    }

    public String password() {
        return line(">>> Enter user password: ");
    }

    public String passwordConfirmation() {
        return line(">>> Confirm password: ");
    }

    public int menuOption() {
        String text = line(">>> Choose your option: ").trim();
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new InvalidMenuOptionException("Please enter a valid choice (1 thru 6)");
        }
    }

    public Long userId() {
        String text = line(">>> Enter user id: ").trim();
        try {
            return Long.valueOf(text);
        } catch (NumberFormatException e) {
            throw new InvalidUserIdException("User id must be a positive integer");
        }
    }

    public double amount() {
        String text = line(">>> Enter amount: ").trim();
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            throw new InvalidAmountException("Amount must be a number greater than 0");
        }
    }
}
