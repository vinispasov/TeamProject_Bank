package bank_product;

import tools.CreditNotApprovedException;

public class BankCards extends BankProduct {
	
	//card valid period
	private static final int PERIOD_VALID_CARD =60;
	//fields
    private int annualMaintenance;
    private double withdrawTax;

    //constructor
    protected BankCards(String name, String idOrBulstat, int incomesMonthly, int annualMaintenance,double withdrawTax) throws CreditNotApprovedException {
        super(name, idOrBulstat, incomesMonthly);
        this.annualMaintenance = annualMaintenance;
        this.withdrawTax=withdrawTax;
    }

    //getters and setters
    public int getAnnualMaintenance() {
        return annualMaintenance;
    }

    public double getWithdrawTax() {
        return withdrawTax;
    }

	public static int getPeriodValidCard() {
		return PERIOD_VALID_CARD;
	}
}
