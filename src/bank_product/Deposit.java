package bank_product;
import tools.OutOfAgeException;
public class Deposit extends BankProduct{

	
	private static final int MIN_MONTHS_DEPOSIT=1;
	private static final int MAX_MONTHS_DEPOSIT=24;
	private static final int RATE_DEPOSIT=2;
	private static final int TAX_DEPOSIT=5;
	private static final int MIN_AMOUNT_DEPOSIT=10;
	private static final int MAX_AMOUNT_DEPOSIT=1000000000;
	//constructor
	public Deposit(int amount) {
		int period=checkCreditPeriod(super.getPeriodOfProductMonthly(),MIN_MONTHS_DEPOSIT,MAX_MONTHS_DEPOSIT);
		String idOrBulstat="";
		try {
			idOrBulstat=checkIdOrBulstat(super.getIdOrBulstat());
		} catch (OutOfAgeException e) {
			System.out.println("Sorry,the deposit is decline, because the person does not have the age to get deposite.");
		}
		amount=checkDesireAmount(amount,MIN_AMOUNT_DEPOSIT,MAX_AMOUNT_DEPOSIT);
		
		super.setAccountBalance(amount);
		super.setIdOrBulstat(idOrBulstat);
		super.setPeriodOfProductMonthly(period);
		super.setRate(RATE_DEPOSIT);
		super.setTax(TAX_DEPOSIT);	
	}

	//getters and setters

	//methods
	
	
	
	

}
