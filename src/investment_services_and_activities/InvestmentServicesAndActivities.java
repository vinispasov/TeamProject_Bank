package investment_services_and_activities;

public abstract class InvestmentServicesAndActivities {
    private int number;
    private double feesAndCommissions;
    private double investmentYield;
    private String name;
    private double currentPrice;
    static final int AGE_OF_MAJORITY =18;


    public String getName() {
        return name;
    }

    public abstract void sell();

    public abstract void buy();


    public int getPeriod() {
        return period;
    }

    public double getFeesAndCommissions() {
        return feesAndCommissions;
    }

    public double getInvestmentYield() {
        return investmentYield;
    }

    private int period;

    public int getNumber() {
        return number;
    }


    public InvestmentServicesAndActivities(String name, int number, double currentPrice, int period, double feesAndCommissions, double investmentYield) {
        this.name = name;
        this.number = number;
        this.currentPrice = currentPrice;
        this.period = period;
        this.feesAndCommissions = feesAndCommissions;
        this.investmentYield = investmentYield;
    }

    public InvestmentServicesAndActivities() {
    }

    public double getCurrentPrice() {
        return currentPrice;
    }


}
