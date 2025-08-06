package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custId, acctId;
	private int balance;
	
	public Account() {
		System.out.println("�⺻ ������ ȣ��");
	}
	
	public Account(String custId, String acctId, int balance) {
		super();
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

	public void setBalance(int newBalance) {balance = newBalance;}
	
	public int getBalance() {
		return balance;
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	// �Ա�
	public void deposit(int amount) {
		balance += amount;
	}
	// ���
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount > balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�. (��û �ݾ�: %d, ���� �ܾ�: %d)", amount, balance);
			// exception ������ �߻� 
			throw new InsufficientBalanceException(errMessage);
		}
		balance -= amount;
	}
}
