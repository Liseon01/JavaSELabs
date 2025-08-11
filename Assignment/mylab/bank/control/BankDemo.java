package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        SavingsAccount ac1000 = bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0);
        CheckingAccount ac1001 = bank.createCheckingAccount("��ö��", 20000.0, 5000.0);
        SavingsAccount ac1002 = bank.createSavingsAccount("�̿���", 30000.0, 2.0);

        System.out.println();
        bank.printAllAccounts();

        System.out.println();
        System.out.println("=== �Ա�/��� �׽�Ʈ ===");
        try {
            bank.deposit(ac1000.getAccountNumber(), 5000.0);   // -> 15000
            bank.withdraw(ac1001.getAccountNumber(), 3000.0);  // -> 17000
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== ���� ���� �׽�Ʈ ===");
        ac1000.applyInterest();

        System.out.println();
        System.out.println("=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer(ac1002.getAccountNumber(), ac1001.getAccountNumber(), 5000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println();
        bank.printAllAccounts();

        try {
            bank.withdraw(ac1001.getAccountNumber(), 6000.0);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.withdraw(ac1001.getAccountNumber(), 6000.0);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
