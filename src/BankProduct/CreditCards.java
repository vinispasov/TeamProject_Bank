package BankProduct;

import java.util.Date;

public class CreditCards extends BankCards implements BillsPayable {
    final static int CREDIT_LIMIT = 50000;

    private int creditLimit;

    private double interestRate;

    public CreditCards() {
    }

    public double getInterestRate() {
        return interestRate;
    }



    public CreditCards(int annualMaintenance, int creditLimit,double interestRate) {
        this.creditLimit = creditLimit;
        this.interestRate=interestRate;

    }

    @Override
    public void billsPayable() {
        if (getPayDate().getTime()>getValidityDate().getTime() ) {
            if (creditLimit < CREDIT_LIMIT) {
                System.out.printf("Client %s,pay %f for this bill,and he have to pay %f to bank \n ", "", getPaidSum(), getPaidSum() * getInterestRate()
                +getPaidSum());
            } else {
                System.out.printf("Client %s,cannot pay with this card,the creditLimit of the card is reached\n","");
            }
        } else {
            System.out.printf("Client %s,have to reussue the card,because the validity of card is " + "expired\n", "");
        }
    }

}
