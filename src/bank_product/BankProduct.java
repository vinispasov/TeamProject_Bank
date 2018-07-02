package bank_product;

import java.util.Scanner;

import tools.OutOfAgeException;

public abstract class BankProduct {

	//tools for checking the clients ages:
	private static final char MAX_DECADE = 5;
	private static final char MAX_YEAR_OF_DECADE = 3;
	private static final char DECADE = 6;
	private static final char MIN_DECADE = 0;
	private static final char MIN_YEAR_OF_DECADE = 0;
	//number of digits that should contain any of listed here:
		private static final int ID_NUMBERS = 10;
		private static final int BULSTAT_NUMBER_NINE =9;
		private static final int BULSTAT_NUMBER_THIRTEEN =13;
	private int rate;
	private int periodOfProductMonthly;
	private double accountBalance;
	private int tax;
	private String idOrBulstat;
	
	//constructors
	public BankProduct() {
		this.rate =0;
		this.periodOfProductMonthly =0;
		this.accountBalance = 0;
		this.setTax(0);
		this.setIdOrBulstat("");
	}
	
	//methods
	
	String checkAge(String id) throws OutOfAgeException {
		if((id.charAt(0)==MAX_DECADE&&id.charAt(1)>=MAX_YEAR_OF_DECADE)
				||id.charAt(0)>=DECADE
				||id.charAt(0)==MIN_DECADE&&id.charAt(1)==MIN_YEAR_OF_DECADE){
			return id;
		}
		else {
			throw new OutOfAgeException();
		}
	}
	//
   String checkIdOrBulstat(String idOrBulstat) throws OutOfAgeException {
		
		if(idOrBulstat.length()==ID_NUMBERS) {
			checkAge(idOrBulstat);
			return idOrBulstat;
		}
		else if(idOrBulstat.length()==BULSTAT_NUMBER_NINE
				||idOrBulstat.length()==BULSTAT_NUMBER_THIRTEEN) {
			return idOrBulstat;
		}
		else {
			Scanner sc=new Scanner(System.in);
			while(true) {
				System.out.println("Personal Id should be 10 digits.Bulstat should be 9 or 13 digits.Try again here: ");
				idOrBulstat=sc.nextLine();
				if (idOrBulstat.length()==ID_NUMBERS
						||idOrBulstat.length()==BULSTAT_NUMBER_NINE
						||idOrBulstat.length()==BULSTAT_NUMBER_THIRTEEN) {
					System.out.println("Correct input!");
					sc.close();
					return checkIdOrBulstat(idOrBulstat);
				}
			}
		}
	}
	//
	int checkCreditPeriod(int period,int minPeriod,int maxPeriod) {
		if (period<minPeriod||period>maxPeriod) {
			Scanner sc=new Scanner(System.in);
			while(true) {
				System.out.println("The period for this kind of product should be between "+minPeriod+" and "+maxPeriod+" including.Please try again here: ");
				period=sc.nextInt();
				if (period>=minPeriod&&period<=maxPeriod) {
					System.out.println("Correct period.");
					sc.close();
					break;
				}
			}
		}
		return period;
	}
	//
    int checkDesireAmount(int amount,int minAmount,int maxAmount) {
		Scanner sc=new Scanner(System.in);
		while(amount<minAmount||amount>maxAmount) {
			System.out.println("The amount of credit that you can get is between "+minAmount+" and "+ maxAmount+". Type new amount here:");
			amount=sc.nextInt();
		}
		System.out.println("The new amount is set.");
		sc.close();
		return amount;
	}
	//getters and setters
	public int getAnnualInterestRate() {
		return rate;
	}

	void setRate(int rate) {
		this.rate = rate;
	}

	public int getPeriodOfProductMonthly() {
		return periodOfProductMonthly;
	}

	void setPeriodOfProductMonthly(int period){
		this.periodOfProductMonthly=period;
	}
	

	public double getAccountBalance() {
		return accountBalance;
	}

	void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getIdOrBulstat() {
		return idOrBulstat;
	}

	void setIdOrBulstat(String idOrBulstat) {
		this.idOrBulstat=idOrBulstat;
	}

	public int getTax() {
		return tax;
	}
 
	void setTax(int tax) {
		this.tax = tax;
	}
	

	
}
