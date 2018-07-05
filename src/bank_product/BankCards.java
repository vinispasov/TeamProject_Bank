package bank_product;

import java.util.Date;

public class BankCards extends BankProduct {
    private Date payDate;
    private Date validityDate;
    private double paidSum;
    private int annualMaintenance;

    public BankCards() {
    }

    public Date getPayDate() {
        return payDate;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public int getAnnualMaintenance() {
        return annualMaintenance;
    }

    public double getPaidSum() {
        return paidSum;
    }



    public BankCards(String nameOfProduct, int annualInterestRate, int periodOfProductMonthly, int accountBalance, Date payDate, Date validityDate, int annualMaintenance, double paidSum) {
        this.payDate = payDate;
        this.validityDate = validityDate;
        this.annualMaintenance = annualMaintenance;
        this.paidSum = paidSum;
    }


}
