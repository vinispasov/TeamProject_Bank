package bank_product;

import tools.CreditNotApprovedException;

public class PayableAccount extends Account implements MoneyTransferable {
	
	public PayableAccount(String name,String idOrBulstat,int incomesMonthly) throws CreditNotApprovedException{
		super(name,idOrBulstat,incomesMonthly);
		super.setTax(5);
	}
	
	@Override
	public void incomesTransfer() {
		super.setAccountBalance(super.getIncomesMonthly());
	}
	

}
