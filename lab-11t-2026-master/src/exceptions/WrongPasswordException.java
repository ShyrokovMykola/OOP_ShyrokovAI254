package exceptions;

/**
 * Введений пароль не відповідає паролю рахунку.
 */
public class WrongPasswordException extends AccountException {

    public WrongPasswordException(String message) {
        super(message);
    }
}
