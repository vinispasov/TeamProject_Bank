package bank_product;

import tools.CreditNotApprovedException;

public class SavingAccount extends Account implements MoneyTransferable {

	//fields
	private double rate;
	//constructor
	public SavingAccount(String name,String idOrBulstat,int incomesMonthly)throws CreditNotApprovedException {
		super(name,idOrBulstat,incomesMonthly);
		rate=0.012;
		super.setTax(10);
	}
	
	@Override
	public void incomesTransfer() {
		double rateAmount=super.getIncomesMonthly()*rate;
		super.setAccountBalance(super.getIncomesMonthly()+rateAmount);
	}

	public double getRate() {
		return rate;
	}


	
}
