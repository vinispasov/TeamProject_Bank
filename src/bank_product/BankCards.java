package bank_product;

public class BankCards extends BankProduct {
    private int annualMaintenance;
    private double withdrawTax;

    public BankCards(String name, String idOrBulstat, int incomesMonthly, int annualMaintenance,double withdrawTax) {
        super(name, idOrBulstat, incomesMonthly);
        this.annualMaintenance = annualMaintenance;
        this.withdrawTax=withdrawTax;
    }

    public int getAnnualMaintenance() {
        return annualMaintenance;
    }

    public double getWithdrawTax() {
        return withdrawTax;
    }
}
