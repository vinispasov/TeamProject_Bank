package BankProduct.investment_services_and_activities;

public abstract class InvestmentServicesAndActivities {
    private int number;
    private int feesAndCommissions;
    private int investmentYield;
    private String name;
    private int currentPrice;


    public String getName() {
        return name;
    }

    public abstract void sell();

    public abstract void buy();


    public int getPeriod() {
        return period;
    }

    public int getFeesAndCommissions() {
        return feesAndCommissions;
    }

    public int getInvestmentYield() {
        return investmentYield;
    }

    private int period;

    public int getNumber() {
        return number;
    }


    public InvestmentServicesAndActivities(String name, int number, int price, int period, int feesAndCommissions, int investmentYield) {
        this.name = name;
        this.number = number;
        this.currentPrice = getCurrentPrice();
        this.period = period;
        this.feesAndCommissions = feesAndCommissions;
        this.investmentYield = investmentYield;
    }

    public InvestmentServicesAndActivities() {
    }

    public int getCurrentPrice() {
        return currentPrice;
    }


}
