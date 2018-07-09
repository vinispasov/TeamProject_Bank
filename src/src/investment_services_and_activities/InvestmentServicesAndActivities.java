package investment_services_and_activities;

public abstract class InvestmentServicesAndActivities {
	//fields
    private int number;
    private double feesAndCommissions;
    private double investmentYield;
    private String name;
    private int period;
    private double currentPrice;
    static final int AGE_OF_MAJORITY =18;

    //constructor
    public InvestmentServicesAndActivities(String name, int number, double currentPrice, int period, double feesAndCommissions, double investmentYield) {
        this.name = name;
        this.number = number;
        this.currentPrice = currentPrice;
        this.period = period;
        this.feesAndCommissions = feesAndCommissions;
        this.investmentYield = investmentYield;
    }

    //methods
    public abstract void sell();

    public abstract void buy();

    //getters and setters
    public int getPeriod() {
        return period;
    }

    public double getFeesAndCommissions() {
        return feesAndCommissions;
    }

    public double getInvestmentYield() {
        return investmentYield;
    }

    public int getNumber() {
        return number;
    }
   
    public double getCurrentPrice() {
        return currentPrice;
    }


}
