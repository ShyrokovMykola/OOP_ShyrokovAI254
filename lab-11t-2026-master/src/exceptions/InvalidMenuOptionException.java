package exceptions;

/**
 * Обрано неіснуючий пункт головного меню.
 */
public class InvalidMenuOptionException extends RuntimeException {

    public InvalidMenuOptionException(String message) {
        super(message);
    }
}
