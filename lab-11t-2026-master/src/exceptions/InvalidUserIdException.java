package exceptions;

/**
 * Ідентифікатор користувача не є додатним цілим числом.
 */
public class InvalidUserIdException extends AccountException {

    public InvalidUserIdException(String message) {
        super(message);
    }
}
