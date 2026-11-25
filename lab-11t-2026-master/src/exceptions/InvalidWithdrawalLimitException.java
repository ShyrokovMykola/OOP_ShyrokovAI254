package exceptions;

/**
 * Значення денного ліміту на зняття коштів є некоректним.
 */
public class InvalidWithdrawalLimitException extends AccountException {

    public InvalidWithdrawalLimitException(String message) {
        super(message);
    }
}
