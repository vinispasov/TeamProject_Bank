package bank_product;

import java.util.Scanner;

import tools.OutOfAgeException;

public abstract class BankProduct extends Account{

	//fields
	private int rate;
	private int periodOfProductMonthly;
	
	
	//constructors
	public BankProduct(String name,String idOrBulstat,int incomesMonthly) {
		super(name,idOrBulstat,incomesMonthly);
		this.rate=0;
		this.periodOfProductMonthly=0;
	}
	
	//methods

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
	

	
}
