package CST_105.BankingApplication;


public class Checking extends Account  {

	
	private double overDraft;	
	
	public double getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

	
	public double doWithdraw(double amount) {
	return amount;
	
	}
	
	public void checking(double balance, String account) {
		super.setBalance(balance);
		super.setAccount(account);
	//System.out.println("You Checking balance is " + balance + "!");	
	}
}
