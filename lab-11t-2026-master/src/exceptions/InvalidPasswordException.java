package exceptions;

/**
 * Пароль не відповідає вимогам (довжина, наявність цифри).
 */
public class InvalidPasswordException extends AccountException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
