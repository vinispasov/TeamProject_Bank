package bank_product;

public class SavingAccount extends Account implements MoneyTransferable {

	//fields
	private double rate;
	//constructor
	public SavingAccount(String name,String idOrBulstat,int incomesMonthly) {
		super(name,idOrBulstat,incomesMonthly);
		rate=0.012;
		super.setTax(10);
	}
	
	@Override
	public void incomesTransfer() {
		double rateAmount=super.getIncomesMonthly()*rate;
		super.setAccountBalance(super.getIncomesMonthly()+rateAmount);
	}

	
}
