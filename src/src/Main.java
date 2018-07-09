import financial_unit.*;
import bank_product.*;
import investment_services_and_activities.*;
import tools.*;


public class Main {

    public static void main(String[] args) {

       Client ivan = new Client("","ul.508", 100, Entity.PHYSICAL,"0000000000",500);
       Client telerik = new Client("Telerik Academy", "Aleksandar Malinov Boulevard ", 10000,Entity.CORPORATE,"012902012",7000);
       Bank bnb = new Bank("BNB","ul.508", 100000000);
        
       bnb.currencyChange(ivan,AvailableBankCurrencies.USD, AvailableBankCurrencies.BGN, 90);
        bnb.giveCreditCorporate(telerik, 9, 20000,CreditTypeCorporate.BUSINESS);
       bnb.giveCreditPhysical(ivan, 12, 2000, CreditTypePhysical.FAST);
        bnb.createDebitCard(ivan, 2000);
     CreditCards cardTelerik= bnb.createCreditCard(telerik, 300000);
      cardTelerik.cashFromATMWithdraw(1000);
      cardTelerik.cardValidityCheck(2019, 8, 15);
      cardTelerik.billsPayable(3000);
      cardTelerik.clientYearsCheck(2000, 07, 20);

      bnb.oneMonthLater();



        


    }
}