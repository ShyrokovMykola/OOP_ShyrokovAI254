package exceptions;

/**
 * Значення інтервалу часу стає від'ємним.
 */
public class NegativeTimeSpanException extends RuntimeException {

    public NegativeTimeSpanException(String message) {
        super(message);
    }
}
