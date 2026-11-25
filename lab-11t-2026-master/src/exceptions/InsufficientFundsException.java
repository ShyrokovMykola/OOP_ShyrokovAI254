package exceptions;

/**
 * На рахунку недостатньо коштів для зняття.
 */
public class InsufficientFundsException extends AccountException {

    public InsufficientFundsException(String message) {
        super(message);
    }
}
