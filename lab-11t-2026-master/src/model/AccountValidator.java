package model;

import exceptions.InvalidAmountException;
import exceptions.InvalidCustomerNameException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidUserIdException;
import exceptions.InvalidWithdrawalLimitException;
import exceptions.NegativeBalanceException;

/**
 * Перевірки полів рахунку та сум операцій.
 */
final class AccountValidator {

    private static final int MIN_PASSWORD_LENGTH = 8;

    private AccountValidator() {
    }

    static String validName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidCustomerNameException("Customer name cannot be empty");
        }
        return name;
    }

    static Long validUserId(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidUserIdException("User id must be a positive integer");
        }
        return id;
    }

    static String validPassword(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidPasswordException(
                    "Password must be at least " + MIN_PASSWORD_LENGTH + " characters long");
        }
        if (!password.matches("(?s).*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit");
        }
        return password;
    }

    static Double validBalance(Double balance) {
        if (balance == null || balance.isNaN() || balance < 0) {
            throw new NegativeBalanceException("Account balance must be 0 or greater");
        }
        return balance;
    }

    static double validLimit(double limit) {
        if (Double.isNaN(limit) || limit < 0) {
            throw new InvalidWithdrawalLimitException("Daily withdrawal limit must be 0 or greater");
        }
        return limit;
    }

    static double validAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new InvalidAmountException("Amount must be a number greater than 0");
        }
        if (Money.round(amount) != amount) {
            throw new InvalidAmountException("Amount must have at most two decimal places");
        }
        return amount;
    }
}
