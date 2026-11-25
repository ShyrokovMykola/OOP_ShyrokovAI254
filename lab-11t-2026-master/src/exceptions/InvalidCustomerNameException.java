package exceptions;

/**
 * Ім'я клієнта порожнє.
 */
public class InvalidCustomerNameException extends AccountException {

    public InvalidCustomerNameException(String message) {
        super(message);
    }
}
