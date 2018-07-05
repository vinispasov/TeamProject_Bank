package investment_services_and_activities;

public class Shares extends InvestmentServicesAndActivities {
    public int getSellingPrice() {
        return sellingPrice;
    }

    private int sellingPrice;
    public Shares() {
    }

    @Override
    public void buy() {
        System.out.printf("Client %s,buys %d shares each with currentPrice %.2f for sum %.2f ",
                "", getNumber(), getCurrentPrice(), getNumber()* getCurrentPrice());
    }
    public void sell() {
        System.out.printf("Client %s,sells %d goverment bonds each with currentPrice %.2f for sum %.2f ",
                "", getNumber(), getCurrentPrice(), getNumber()* (getCurrentPrice()+getPeriod()*getInvestmentYield()));

    }
}
