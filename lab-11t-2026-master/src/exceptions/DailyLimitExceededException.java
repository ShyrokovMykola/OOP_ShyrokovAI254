package exceptions;

/**
 * Перевищено денний ліміт на зняття коштів.
 */
public class DailyLimitExceededException extends AccountException {

    public DailyLimitExceededException(String message) {
        super(message);
    }
}
