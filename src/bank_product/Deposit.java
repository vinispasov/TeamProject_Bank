package bank_product;
public class Deposit extends BankProduct{

	//deposit period
	private static final int MIN_MONTHS_DEPOSIT=1;
	private static final int MAX_MONTHS_DEPOSIT=24;
	//deposit rates and taxes
	private static final int RATE_DEPOSIT=2;
	private static final int TAX_DEPOSIT=5;
	//deposit amount
	private static final int MIN_AMOUNT_DEPOSIT=10;
	private static final int MAX_AMOUNT_DEPOSIT=1000000000;
	
	//constructor
	public Deposit(String name,String idOrBulstat,int incomes,int amount) {
		super(name,idOrBulstat,incomes);
		int period=checkCreditPeriod(super.getPeriodOfProductMonthly(),MIN_MONTHS_DEPOSIT,MAX_MONTHS_DEPOSIT);
		
		amount=checkDesireAmount(amount,MIN_AMOUNT_DEPOSIT,MAX_AMOUNT_DEPOSIT);
		
		super.setAccountBalance(amount);
		super.setIdOrBulstat(idOrBulstat);
		super.setPeriodOfProductMonthly(period);
		super.setRate(RATE_DEPOSIT);
		super.setTax(TAX_DEPOSIT);	
	}

	
	
	

}
