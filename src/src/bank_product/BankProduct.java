package bank_product;

import static bank_product.BankProduct.setCounterReasonForCreditNotApproved;

import java.util.Scanner;

import tools.AmountConditionMismatchException;
import tools.CreditNotApprovedException;
import tools.OutOfAgeException;
import tools.PeriodConditionMismatchException;

public abstract class BankProduct extends Account{

	 static final int NUMBER_4_AMOUNT_MISMATCH = 4;
	 static final int NUMBER_5_PERIOD_MISMATCH = 5;
	//fields
	private int rate;
	private int periodOfProductMonthly;
	private static int counterReasonForCreditNotApproved=0;
	
	
	//constructors
	public BankProduct(String name,String idOrBulstat,int incomesMonthly) throws CreditNotApprovedException{
		super(name,idOrBulstat,incomesMonthly);
		this.rate=0;
		this.periodOfProductMonthly=0;
	}
	
	//methods

	int checkPeriod(int period,int minPeriod,int maxPeriod)throws PeriodConditionMismatchException {
		if (period<minPeriod||period>maxPeriod) {
			BankProduct.counterReasonForCreditNotApproved=NUMBER_5_PERIOD_MISMATCH;
			throw new PeriodConditionMismatchException();
		}
		return period;
	}
	//
     int checkDesireAmount(int amount,int minAmount,int maxAmount) throws AmountConditionMismatchException {
    	 
    		 if(amount<minAmount||amount>maxAmount) {
    			BankProduct.counterReasonForCreditNotApproved=NUMBER_4_AMOUNT_MISMATCH;
    		   throw new AmountConditionMismatchException();
    		 }
    		 return amount;
	}
	//getters and setters
	

	void setRate(int rate) {
		this.rate = rate;
	}
	public int getRate() {
		return rate;
	}

	public int getPeriodOfProductMonthly() {
		return periodOfProductMonthly;
	}

	void setPeriodOfProductMonthly(int period){
		this.periodOfProductMonthly=period;
	}

	public static int getCounterReasonForCreditNotApproved() {
		return counterReasonForCreditNotApproved;
	}

	static void setCounterReasonForCreditNotApproved(int counterReasonForCreditNotApproved) {
		BankProduct.counterReasonForCreditNotApproved = counterReasonForCreditNotApproved;
	}
	

	
}
