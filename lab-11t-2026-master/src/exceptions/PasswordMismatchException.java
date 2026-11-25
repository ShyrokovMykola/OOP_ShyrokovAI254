package exceptions;

/**
 * Пароль та підтвердження паролю не збігаються.
 */
public class PasswordMismatchException extends AccountException {

    public PasswordMismatchException(String message) {
        super(message);
    }
}
