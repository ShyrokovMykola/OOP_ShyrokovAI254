package model;

import exceptions.AccountNotFoundException;
import exceptions.DuplicateUserIdException;
import exceptions.NonZeroBalanceException;
import exceptions.PasswordMismatchException;
import exceptions.WrongPasswordException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Сховище рахунків. Ключем є userId, тому він завжди унікальний.
 */
public class Bank {

    private final Map<Long, BankAccount> accountsById = new HashMap<>();

    private long lastAccountNumber = 0;

    public void open(String name, Long userId, String password, String confirmation) {
        if (accountsById.containsKey(userId)) {
            throw new DuplicateUserIdException("Account with user id " + userId + " already exists");
        }
        if (!password.equals(confirmation)) {
            throw new PasswordMismatchException("Password and confirmation do not match");
        }

        // Ім'я, userId та пароль перевіряються в конструкторі рахунку
        BankAccount account = new CheckingAccount(name, lastAccountNumber + 1, userId, password);
        accountsById.put(userId, account);
        lastAccountNumber++;
    }

    public BankAccount authorize(Long userId, String password) {
        BankAccount account = accountsById.get(userId);
        if (account == null) {
            throw new AccountNotFoundException("Account with user id " + userId + " is not found");
        }
        if (!account.hasPassword(password)) {
            throw new WrongPasswordException("Wrong password");
        }
        return account;
    }

    public void close(BankAccount account) {
        if (!account.isEmpty()) {
            throw new NonZeroBalanceException(String.format(Locale.US,
                    "Cannot delete account with non-zero balance (%.2f)", account.getAccountBalance()));
        }
        accountsById.remove(account.getUserId());
    }
}
