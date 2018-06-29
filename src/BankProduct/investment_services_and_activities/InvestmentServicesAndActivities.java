package BankProduct.investment_services_and_activities;

public class InvestmentServicesAndActivities {
    public String getName() {
        return name;
    }

    private String name;
    private int currentPrice;

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

    private int number;
    private int feesAndCommissions;
    private int investmentYield;
    public InvestmentServicesAndActivities(String name, int price, int period, int feesAndCommissions, int investmentYield) {
        this.name = name;
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
