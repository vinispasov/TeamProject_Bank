package investment_services_and_activities;

import investment_services_and_activities.InvestmentServicesAndActivities;

public class GovermentBonds extends InvestmentServicesAndActivities {
    public GovermentBonds(String name, int number, int price, int period, int feesAndCommissions, int investmentYield) {
        super(name, number, price, period, feesAndCommissions, investmentYield);
    }

    @Override
    public void buy() {
        System.out.printf("Client %s,buys %d goverment bonds each with currentPrice %.2f for sum %.2f \n",
                "", getNumber(), getCurrentPrice(), getNumber()* getCurrentPrice());
    }

    @Override
    public void sell() {
        System.out.printf("Client %s,sells %d goverment bonds each with price %.2f for sum %.2f \n",
                "", getNumber(), getCurrentPrice()+getCurrentPrice()*getInvestmentYield(), getNumber()* (getCurrentPrice()+getPeriod()*getInvestmentYield()));

    }
}
