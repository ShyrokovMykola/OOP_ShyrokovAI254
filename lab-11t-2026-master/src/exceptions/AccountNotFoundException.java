package exceptions;

/**
 * Рахунок з вказаним userId не знайдено.
 */
public class AccountNotFoundException extends AccountException {

    public AccountNotFoundException(String message) {
        super(message);
    }
}
