package exceptions;

/**
 * Значення інтервалу часу не вміщується в тип int.
 */
public class TimeSpanOverflowException extends RuntimeException {

    public TimeSpanOverflowException(String message) {
        super(message);
    }
}
