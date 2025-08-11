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
            System.out.printf("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��%n", interest, balance);
        }
    }

    @Override
    public String summary() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%",
                accountNumber, ownerName, balance, interestRate);
    }
}
