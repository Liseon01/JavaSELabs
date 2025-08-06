package workshop.account.entity;

public class Account {
	private String custId, acctId;
	private int balance;
	
	public Account() {
		System.out.println("기본 생성자 호출");
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
	// 입금
	public void deposit(int amount) {
		balance += amount;
	}
	// 출금
	public void withdraw(int amount) {
		balance -= amount;
	}
}
