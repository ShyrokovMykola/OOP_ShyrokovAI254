package model;

import exceptions.DailyLimitExceededException;
import exceptions.InsufficientFundsException;

import java.time.LocalDate;
import java.util.Locale;

/**
 * Банківський рахунок з денним лімітом на зняття коштів.
 */
public class CheckingAccount extends BankAccount {

    private static final double DEFAULT_LIMIT = 300;

    private double dailyWithdrawalLimit = DEFAULT_LIMIT;

    // Ліміт є денним, тому враховуємо всі зняття за поточну дату
    private LocalDate withdrawalDay = LocalDate.now();
    private double spentThisDay;

    public CheckingAccount(String customerName, Long accountNumber, Long userId, String userPassword) {
        super(customerName, accountNumber, userId, userPassword);
    }

    public double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }

    public void setDailyWithdrawalLimit(double dailyWithdrawalLimit) {
        this.dailyWithdrawalLimit = AccountValidator.validLimit(dailyWithdrawalLimit);
    }

    @Override
    public void deposit(double amount) {
        AccountValidator.validAmount(amount);
        setAccountBalance(Money.plus(getAccountBalance(), amount));
    }

    @Override
    public void withdraw(double amount) {
        AccountValidator.validAmount(amount);
        startNewDayIfNeeded();
        ensureWithinLimit(amount);
        ensureEnoughFunds(amount);

        setAccountBalance(Money.minus(getAccountBalance(), amount));
        spentThisDay = Money.plus(spentThisDay, amount);
    }

    private void startNewDayIfNeeded() {
        LocalDate today = LocalDate.now();
        if (!today.equals(withdrawalDay)) {
            withdrawalDay = today;
            spentThisDay = 0;
        }
    }

    private void ensureWithinLimit(double amount) {
        if (Money.plus(spentThisDay, amount) > dailyWithdrawalLimit) {
            throw new DailyLimitExceededException(String.format(Locale.US,
                    "Daily withdrawal limit exceeded: limit is %.2f, already withdrawn today %.2f",
                    dailyWithdrawalLimit, spentThisDay));
        }
    }

    private void ensureEnoughFunds(double amount) {
        if (amount > getAccountBalance()) {
            throw new InsufficientFundsException(String.format(Locale.US,
                    "Insufficient funds: account balance is %.2f", getAccountBalance()));
        }
    }
}
