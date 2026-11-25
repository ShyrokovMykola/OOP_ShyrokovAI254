package exceptions;

/**
 * Спроба видалити рахунок з ненульовим балансом.
 */
public class NonZeroBalanceException extends AccountException {

    public NonZeroBalanceException(String message) {
        super(message);
    }
}
