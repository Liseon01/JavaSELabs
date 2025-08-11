package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {

    private final double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() { return withdrawalLimit; }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(withdrawalLimit);
        }
        super.withdraw(amount);
    }

    @Override
    public String summary() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��",
                accountNumber, ownerName, balance, withdrawalLimit);
    }
}
