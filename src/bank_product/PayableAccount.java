package bank_product;

public class PayableAccount extends Account implements MoneyTransferable {
	
	public PayableAccount(String name,String idOrBulstat,int incomesMonthly) {
		super(name,idOrBulstat,incomesMonthly);
		super.setTax(5);
	}
	
	@Override
	public void incomesTransfer() {
		super.setAccountBalance(super.getIncomesMonthly());
	}
	

}
