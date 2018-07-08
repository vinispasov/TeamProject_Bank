package financial_unit;

import bank_product.BankCards;
import bank_product.BankProduct;
import bank_product.Credit;
import bank_product.Deposit;

import java.util.List;

import tools.Entity;

public class Client extends FinancialUnit {


    private int monthlySalary;
    private int creditScore;
    private Entity entity;
    private String idOrBulstat;

    private List<BankProduct> bankProductsList; // List to hold all credits and deposits of the client.
    private List<BankCards> bankCardsList; //List to hold all credit and debit cards of the client.


    public Client(String name, String adress, int availableCurrency, int monthlySalary, int creditScore, Entity entity, String idOrBulstat) {
        super.setName(name);
        super.setAddress(adress);
        super.setAvailableCurrency(availableCurrency);
        setIdOrBulstat(idOrBulstat);
        setMonthlySalary(monthlySalary);
        setCreditScore(creditScore);
        this.entity = entity;
    }


    public int getMonthlySalary() {
        return monthlySalary;
    }

    // Monthly salary must be of only numeric characters.
    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getIdOrBulstat() {
        return idOrBulstat;
    }

    public void setIdOrBulstat(String idOrBulstat) {
        this.idOrBulstat = idOrBulstat;
    }


    // the bank initiates the transaction.
    public void requestCredit() {

    }

    public void payCredit() {

    }

    public void giveDeposit() {

    }

    //Overrides toString method to easily print the Client's fields.
    @Override
    public String toString() {
        return "\nClient name: " + this.getName() + " | "
                + "Id: " + this.getIdOrBulstat() + " | "
                + "CreditScore: " + this.getCreditScore() + " | "
                + "Available Currency: " + this.getAvailableCurrency() + " | ";
    }
}