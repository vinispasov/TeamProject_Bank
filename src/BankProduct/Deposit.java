package BankProduct;

public class Deposit extends BankProduct{

	private int monthlyPaidAmount;
	
	public Deposit(String nameOfProduct, int annualInterestRate, int periodOfProductMonthly,int monthlyPaidAmount) {
		super(nameOfProduct, annualInterestRate, periodOfProductMonthly);
		this.monthlyPaidAmount=monthlyPaidAmount;
	}

}
