package bank.telerikacademy;

public class InvestmentServicesAndActivities {
    private String name;
    private int currentPrice;
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
