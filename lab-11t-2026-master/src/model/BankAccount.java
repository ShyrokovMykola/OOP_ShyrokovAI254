package model;

/**
 * Базовий клас банківського рахунку.
 */
public abstract class BankAccount {

    private String customerName;
    private Long accountNumber;
    private Long userId;
    private String userPassword;
    private Double accountBalance = 0.0;

    public BankAccount(String customerName, Long accountNumber, Long userId, String userPassword) {
        this.customerName = AccountValidator.validName(customerName);
        this.accountNumber = accountNumber;
        this.userId = AccountValidator.validUserId(userId);
        this.userPassword = AccountValidator.validPassword(userPassword);
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public boolean hasPassword(String password) {
        return userPassword.equals(password);
    }

    public boolean isEmpty() {
        return accountBalance == 0;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = AccountValidator.validName(customerName);
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = AccountValidator.validUserId(userId);
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = AccountValidator.validPassword(userPassword);
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = AccountValidator.validBalance(accountBalance);
    }
}
