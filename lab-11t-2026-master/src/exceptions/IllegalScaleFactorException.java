package exceptions;

/**
 * Множник у методі scale є некоректним.
 */
public class IllegalScaleFactorException extends RuntimeException {

    public IllegalScaleFactorException(String message) {
        super(message);
    }
}
