package mylab.bank.entity;

public class SavingsAccount extends Account {

    private final double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRatePercent) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRatePercent;
    }

    public double getInterestRate() { return interestRate; }
    
    public void applyInterest() {
        double interest = balance * (interestRate / 100.0);
        if (interest > 0) {
            deposit(interest);
            System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원%n", interest, balance);
        }
    }

    @Override
    public String summary() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%",
                accountNumber, ownerName, balance, interestRate);
    }
}
