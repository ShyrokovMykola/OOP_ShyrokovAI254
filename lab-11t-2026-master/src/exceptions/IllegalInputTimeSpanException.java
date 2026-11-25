package exceptions;

/**
 * Вхідний інтервал часу є некоректним.
 */
public class IllegalInputTimeSpanException extends RuntimeException {

    public IllegalInputTimeSpanException(String message) {
        super(message);
    }
}
