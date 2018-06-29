package BankProduct.investment_services_and_activities;

public class Shares extends InvestmentServicesAndActivities implements Buyable {
    public int getSellingPrice() {
        return sellingPrice;
    }

    private int sellingPrice;
    public Shares() {
    }

    @Override
    public void buy() {
        System.out.printf("Client %s,buys %d shares each with currentPrice %d for sum %d ",
                "", getNumber(), getCurrentPrice(), getNumber()* getCurrentPrice());
    }
}
