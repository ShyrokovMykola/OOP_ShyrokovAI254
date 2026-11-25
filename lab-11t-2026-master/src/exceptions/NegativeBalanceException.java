package exceptions;

/**
 * Спроба встановити від'ємний баланс рахунку.
 */
public class NegativeBalanceException extends AccountException {

    public NegativeBalanceException(String message) {
        super(message);
    }
}
