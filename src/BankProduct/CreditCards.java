package BankProduct;

public class CreditCards extends BankProduct {
    private int validity;
    private int annualMaintenance;
    private int gracePeriod;
    private int creditLimit;

    public CreditCards() {
    }

    public CreditCards(int validity, int annualMaintenance, int gracePeriod, int creditLimit) {
        this.validity = validity;
        this.annualMaintenance = annualMaintenance;
        this.gracePeriod = gracePeriod;
        this.creditLimit = creditLimit;

    }
}
