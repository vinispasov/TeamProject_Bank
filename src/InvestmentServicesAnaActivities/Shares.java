package bank.telerikacademy;

public class Shares extends InvestmentServicesAndActivities implements Buyable {
    private int currentPrice;

    @Override
    public int getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public void buy() {
        System.out.printf("Client %s,buys %d shares each with currentPrice %d for sum %d ",
                "", getNumber(), getCurrentPrice(), getNumber()* getCurrentPrice());
    }
}
