package exceptions;

/**
 * Базовий клас для виняткових ситуацій, пов'язаних з банківським рахунком.
 */
public class AccountException extends RuntimeException {

    public AccountException(String message) {
        super(message);
    }
}
