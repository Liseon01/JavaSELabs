package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {

    private final List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    private String issueAccountNumber() {
        return "AC" + (nextAccountNumber++);
    }

    public SavingsAccount createSavingsAccount(String ownerName, double initialBalance, double interestRatePercent) {
        String accNo = issueAccountNumber();
        SavingsAccount acc = new SavingsAccount(accNo, ownerName, initialBalance, interestRatePercent);
        accounts.add(acc);
        System.out.printf("���� ���°� �����Ǿ����ϴ�: %s%n", acc.summary());
        return acc;
    }

    public CheckingAccount createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accNo = issueAccountNumber();
        CheckingAccount acc = new CheckingAccount(accNo, ownerName, initialBalance, withdrawalLimit);
        accounts.add(acc);
        System.out.printf("üŷ ���°� �����Ǿ����ϴ�: %s%n", acc.summary());
        return acc;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account from = findAccount(fromAccountNumber);
        Account to = findAccount(toAccountNumber);

        from.withdraw(amount);
        to.deposit(amount);

        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", amount, fromAccountNumber, toAccountNumber);
    }

    public void printAllAccounts() {
        System.out.println("=== ��� ���� ��� ===");
        for (Account a : accounts) {
            System.out.println(a.summary());
        }
        System.out.println("===================");
    }
}
