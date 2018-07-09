package bank_product;

import tools.AmountConditionMismatchException;
import tools.CreditNotApprovedException;
import tools.PeriodConditionMismatchException;
import java.util.Scanner;
public class Deposit extends BankProduct{

	//deposit period
	private static final int MIN_MONTHS_DEPOSIT=1;
	private static final int MAX_MONTHS_DEPOSIT=24;
	//deposit rates and taxes
	private static final int RATE_DEPOSIT=2;
	private static final int TAX_DEPOSIT=5;
	//deposit amount
	private static final int MIN_AMOUNT_DEPOSIT=10;
	private static final int MAX_AMOUNT_DEPOSIT=1000000;
	
	//constructor
	public Deposit(String name,String idOrBulstat,int incomes,int amount,int period)throws CreditNotApprovedException {
		super(name,idOrBulstat,incomes);
	
		
		try {
			period=checkPeriod(period,MIN_MONTHS_DEPOSIT,MAX_MONTHS_DEPOSIT);
			amount=checkDesireAmount(amount,MIN_AMOUNT_DEPOSIT,MAX_AMOUNT_DEPOSIT);
			super.setAccountBalance(amount);
			super.setIdOrBulstat(idOrBulstat);
			super.setPeriodOfProductMonthly(period);
			super.setRate(RATE_DEPOSIT);
			super.setTax(TAX_DEPOSIT);
			System.out.println("The deposit is approved.");
		} catch (AmountConditionMismatchException | PeriodConditionMismatchException e) {
			if (super.getCounterReasonForCreditNotApproved()==BankProduct.NUMBER_4_AMOUNT_MISMATCH) {
				System.out.println("There is amount mismatch between the desire amount and the conditions for the amount.");
				System.out.println();
				System.out.println("For DEPOSIT the amount could be between: "+MIN_AMOUNT_DEPOSIT+" and "+MAX_AMOUNT_DEPOSIT);
			}
			else if (super.getCounterReasonForCreditNotApproved()==BankProduct.NUMBER_5_PERIOD_MISMATCH) {
				System.out.println("There is period mismatch between the desire period and the conditions for the deposit.");
				System.out.println();
				System.out.println("For DEPOSIT the period could be between: "+MIN_MONTHS_DEPOSIT+" and "+MAX_MONTHS_DEPOSIT);
			}
			super.setCounterReasonForCreditNotApproved(0);
		}
		
		
	}

	
	
	

}
