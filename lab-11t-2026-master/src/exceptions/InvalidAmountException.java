package exceptions;

/**
 * Сума операції є некоректною.
 */
public class InvalidAmountException extends AccountException {

    public InvalidAmountException(String message) {
        super(message);
    }
}
