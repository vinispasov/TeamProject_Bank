package BankProduct.investment_services_and_activities;

public class CorporateBonds extends InvestmentServicesAndActivities {


    public CorporateBonds() {
    }

    @Override
    public void buy() {
        System.out.printf("Client %s,buys %d corporate bonds each with price %d for sum %d ",
                "", getNumber(), getCurrentPrice(), getNumber()* getCurrentPrice());
    }

    @Override
    public void sell() {
        System.out.printf("Client %s,sells %d corporative bonds each with price %d for sum %d ",
                "", getNumber(), getCurrentPrice(), getNumber()* (getCurrentPrice()+getPeriod()*getInvestmentYield()));
    }
}

