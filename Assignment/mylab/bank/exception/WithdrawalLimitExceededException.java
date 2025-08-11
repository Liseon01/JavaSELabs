package mylab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(double limit) {
        super("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + String.format("%.1f��", limit));
    }
}
