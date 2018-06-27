package BankProduct;

public class Credit extends BankProduct{
	
    private int monthlyFee;
	
	public Credit(String nameOfProduct, int annualInterestRate, int periodOfProductMonthly,int monthlyFee) {
		super(nameOfProduct, annualInterestRate, periodOfProductMonthly);
		this.monthlyFee=monthlyFee;
	}

}
