package investment_services_and_activities;

import investment_services_and_activities.InvestmentServicesAndActivities;

public class CorporateBonds extends InvestmentServicesAndActivities {


    public CorporateBonds() {
    }

    public CorporateBonds(String name, int number, double currentPrice, int period, double feesAndCommissions, double investmentYield) {
        super(name, number, currentPrice, period, feesAndCommissions, investmentYield);
    }

    @Override
    public void buy() {
        System.out.printf("Client %s,buys %d corporate bonds each with price %.2f for sum %.2f\n ",
                "", getNumber(), getCurrentPrice(), getNumber()* getCurrentPrice());
    }

    @Override
    public void sell() {
        System.out.printf("Client %s,sells %d corporative bonds each with price %.2f for sum %.2f\n ",
                "", getNumber(), getCurrentPrice()+getInvestmentYield()*getPeriod(), getNumber()* (getCurrentPrice()+getPeriod()*getInvestmentYield()));
    }
}

