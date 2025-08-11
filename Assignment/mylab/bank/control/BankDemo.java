package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        SavingsAccount ac1000 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        CheckingAccount ac1001 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        SavingsAccount ac1002 = bank.createSavingsAccount("이영희", 30000.0, 2.0);

        System.out.println();
        bank.printAllAccounts();

        System.out.println();
        System.out.println("=== 입금/출금 테스트 ===");
        try {
            bank.deposit(ac1000.getAccountNumber(), 5000.0);   // -> 15000
            bank.withdraw(ac1001.getAccountNumber(), 3000.0);  // -> 17000
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== 이자 적용 테스트 ===");
        ac1000.applyInterest();

        System.out.println();
        System.out.println("=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(ac1002.getAccountNumber(), ac1001.getAccountNumber(), 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println();
        bank.printAllAccounts();

        try {
            bank.withdraw(ac1001.getAccountNumber(), 6000.0);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw(ac1001.getAccountNumber(), 6000.0);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
