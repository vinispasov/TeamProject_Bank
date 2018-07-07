package bank_product;

import investment_services_and_activities.CorporateBonds;
import investment_services_and_activities.GovermentBonds;
import investment_services_and_activities.Shares;
import tools.Entity;

public class Main {
    public static void main(String[] args) {
        GovermentBonds govermentBonds = new GovermentBonds("Pesho", 100, 30, 2, 40, 5);
        govermentBonds.buy();
        CorporateBonds corporateBonds=new CorporateBonds("Pesho", 100, 30, 2, 40, 5);
        corporateBonds.sell();
        Credit credit=new Credit("Petyr",1000,"8011111111",Entity.PHYSICAL,CreditTypePhysical.CUSTOM,12,1200);
        Shares share=new Shares();
        share.buy();
        CreditCards creditCards=new CreditCards("P", "8000000000",1000
                ,40, 1.8,1000);
        creditCards.clientYearsCheck(2000,1,12);
        DebitCards debitCards=new DebitCards("P", "8000000000",100
                ,40,1.8,250);
        debitCards.cardValidityCheck(2018,7,5);
        debitCards.billsPayable(211);
        debitCards.billsPayable(43);
        corporateBonds.clientYearsCheck(2000,1,21);
        creditCards.cashFromATMWithdraw(20);
        CurrencyChange clientM=new CurrencyChange(1.69570,AvailableBankCurrencies.BGN,
                AvailableBankCurrencies.USD);
        clientM.changeCurrency(100);
    }
}
