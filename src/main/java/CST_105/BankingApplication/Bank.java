//Code by Heather Stone
package CST_105.BankingApplication;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Bank {
	//initiating scanner to take input
	public static Scanner sc = new Scanner(System.in);
	//create private string for name
	private static String name="GCU Bank";
	
	static DecimalFormat money = new DecimalFormat("$0.00");
	
	
	//constructor if you want to change the bank name
	public Bank(String name) {
		
		
	}
	//main method 
	public static void main(String[] args) {
		
		
		
		//creating new object saving and checking
		//and hard coding (setters) amounts for variables below
		Saving saving = new Saving();
		saving.setBalance(5000);
		saving.setAccount("191923");
		saving.setServiceFee(25.00);
		saving.setAnnualInterestRate(.06);
		saving.setMinBalance(200.00);
		Checking checking = new Checking();
		checking.setBalance(5000);
		checking.setAccount("991773");
		checking.setOverDraft(45.00);
		//calling display Menu method
		displayMenu(checking, saving);
	
	
}
	//New method to display Menu
	private static void displayMenu(Checking checking, Saving saving) {
		int option;
		do {
		System.out.println("===================================");
		System.out.println(" MAIN MENU");
		System.out.println(" "+ name.toUpperCase());
		System.out.println("===================================");
		System.out.println("Pick an option: ");
		System.out.println("---------------------");
		System.out.println(" 1: : Deposit to Checking");
		System.out.println(" 2: : Deposit to Savings");
		System.out.println(" 3: : Write a Check");
		System.out.println(" 4: : Withdraw from Savings");
		System.out.println(" 5: : Get balance");
		System.out.println(" 6: : Close month");
		System.out.println("---------------------");
		System.out.println(" 9: : Exit");
		option = sc.nextInt();
		actionMenu(option,checking, saving);
		} while (option != 9);

		
	}
	
	//method (case statement) to read input from a user at menu page and call specific method
	private static void actionMenu(int opt, Checking checking, Saving savings) {
		switch (opt) {
		case 1: displayDepositChecking(checking);  
		break;
		case 2: displayDepositSavings(savings);  
		break;
		case 3: displayWithdrawChecking(checking);  
		break;
		case 4: displayWithdrawSavings(savings);  
		break;
		case 5: displayBalanceScreen(checking, savings);  
		break;
		case 6: doEndMonth(checking, savings);  
		break;
		case 9: displayExitScreen();  
		break;
		
		}
	}
	
		//Different methods to reach from case statement 
		private static void displayDepositChecking(Checking checking) {
		System.out.println("DEPOSIT INTO CHECKING " + checking.getAccount());
		System.out.println("Your Checking balance is " + money.format(checking.getBalance()));
		System.out.println("How much would you like to deposit?: ");
		
		//Inputting value from keyboard 
		Scanner scan = new Scanner(System.in);
		double depositChecking = scan.nextDouble();
		//Adding previous balance to deposit
		double newCheckingBalance = depositChecking + checking.getBalance();
		//Setting balance to value of newCheckingBalance
		checking.setBalance(newCheckingBalance);
		System.out.println("Your new balance is "+ money.format(newCheckingBalance));
		
		}
	
		private static void displayDepositSavings(Saving saving) {
		System.out.println("DEPOSIT INTO SAVINGS " + saving.getAccount());
		System.out.println("Your Savings balance is " + money.format(saving.getBalance()));
		System.out.println("How much would you like to deposit?: ");
		//Inputting value from keyboard to deposit Savings and adding to previous balance
		Scanner scan = new Scanner(System.in);
		double depositSavings = scan.nextDouble();
		double newSavingsBalance = depositSavings + saving.getBalance();
		//Setting balance to value of newSavingsBalance
		saving.setBalance(newSavingsBalance);
		System.out.println("Your new balance is "+ money.format(newSavingsBalance));
		}

		private static void displayWithdrawChecking(Checking checking) {
		System.out.println("You Checking balance is " + money.format(checking.getBalance()) + "!");	
		System.out.println("You will have a " + money.format(checking.getOverDraft()) + " fee if check amount is greater than balance.");
		System.out.print("How much would you like to withdraw?: ");
		//Inputting value from keyboard to withdraw and subtracting it from balance
		Scanner scan = new Scanner(System.in);
		double writeCheck = scan.nextDouble();
		//Setting newCheckingBalance to subtract the withdraw amount
		double newCheckingBalance = checking.getBalance() - writeCheck;
		//if statement to check that they are not over drawn, charge fee if balance is less than 0
		if (newCheckingBalance < 0) {
			newCheckingBalance = newCheckingBalance - checking.getOverDraft();
			System.out.println("OVERDRAFT NOTICE: " + money.format(checking.getOverDraft()) + " fee assessed!");
		}
		//Setting balance to value of newSavingsBalance
				checking.setBalance(newCheckingBalance);
		System.out.println("Your new balance is " + money.format(newCheckingBalance));
		
		}
		private static void displayWithdrawSavings(Saving saving) {
		System.out.println("You Savings balance is " + money.format(saving.getBalance()) + "!");	
		System.out.println("You will have a " + money.format(saving.getServiceFee()) + " fee if your account balance is below " + money.format(saving.getMinBalance()) + " at the end of the month.");
		System.out.print("How much would you like to withdraw?: ");
		//Inputting value from keyboard to subtract the withdraw amount
		Scanner scan = new Scanner(System.in);
		double withdrawSavings = scan.nextDouble();
		//Subtracting withdraw from balance
		double newSavingsBalance = saving.getBalance() - withdrawSavings;
		//Setting balance to value of newSavingsBalance
		saving.setBalance(newSavingsBalance);
		System.out.println("Your new balance is "+ money.format(newSavingsBalance));
		}
		
		//Print current balance of both accounts
		private static void displayBalanceScreen(Checking checking, Saving saving) {
		System.out.println("You Savings balance is " + money.format(saving.getBalance()) + "!");
		System.out.println("You Checking balance is " + money.format(checking.getBalance()) + "!");
			
		}
		private static void doEndMonth(Checking checking, Saving saving) {
		System.out.println("Calculate end of month items.");
		double newSavingsBalance = 0;
		double interestEarned = 0;
		//if savings balance is less than min. balance then charge fee 
		if (saving.getBalance() < saving.getMinBalance()) {
			//Subtracting service from balance because saving is below min. balance
			newSavingsBalance = saving.getBalance() - saving.getServiceFee();
			//Setting balance to value of newSavingsBalance
			saving.setBalance(newSavingsBalance);
			//Informing the user they are below min. balance, they are getting charged a service fee, and new balance.
			System.out.println("Your savings account is below the minimum balance of " + money.format(saving.getMinBalance()) + ".");
			System.out.println("You are being charged a service fee of " + money.format(saving.getServiceFee()) + ".");
			System.out.println("Your current savaing balance is " + money.format(newSavingsBalance) + ".");
		}
		//else add 6% annual interest of balance to the balance
		else {
			interestEarned = saving.getBalance() * (saving.getAnnualInterestRate()/12);
			newSavingsBalance = interestEarned + saving.getBalance();
			//Setting balance to value of newSavingsBalance
			saving.setBalance(newSavingsBalance);
			//Informing the user of the interest they earned and their new balance
			System.out.println("You earned " + money.format(interestEarned) + " on your savings account!");
			System.out.println("Your current saving balance is " + money.format(newSavingsBalance) + ".");
			}
		}
		private static void displayExitScreen() {
		System.out.println("Thank you for your business.");
		}	
	
}	

	
