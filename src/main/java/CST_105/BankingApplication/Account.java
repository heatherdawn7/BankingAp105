package CST_105.BankingApplication;

public class Account {
	
	private double balance;
	private String account;
	
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount() {
		return this.account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public double doWithdraw(double amount) {
	return this.balance = this.balance - amount;
	
	}
	public void doDeposit(double amount) {
		
	}

}
