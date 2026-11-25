package exceptions;

/**
 * Рахунок з таким userId вже існує.
 */
public class DuplicateUserIdException extends AccountException {

    public DuplicateUserIdException(String message) {
        super(message);
    }
}
