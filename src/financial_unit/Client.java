package financial_unit;

import bank_product.Credit;
import bank_product.Deposit;
import java.util.List;
import tools.Entity;

public class Client extends FinancialUnit {


    private int monthlySalary;
    private int creditScore;
    private Entity entity;
    private String idOrBulstat;

    private List<Credit> creditList;
    private List<Deposit> depositList;




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




    // the client initiates the transaction.
    public void requestCredit() {

    }

    public void payCredit() {

    }

    public void giveDeposit() {

    }

    @Override
    public String toString() {
        return "Client name: " + this.getName() + "Id: " + this.getIdOrBulstat() + " ";
    }
}