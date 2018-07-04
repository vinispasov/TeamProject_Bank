package BankProduct.investment_services_and_activities;

public class GovermentBonds extends InvestmentServicesAndActivities {
    @Override
    public void buy() {
        System.out.printf("Client %s,buys %d coverment bonds each with currentPrice %d for sum %d ",
                "", getNumber(), getCurrentPrice(), getNumber()* getCurrentPrice());
    }

    @Override
    public void sell() {
        System.out.printf("Client %s,sells %d goverment bonds each with currentPrice %d for sum %d ",
                "", getNumber(), getCurrentPrice(), getNumber()* (getCurrentPrice()+getPeriod()*getInvestmentYield()));

    }
}
