import financial_unit.*;
import bank_product.*;
import investment_services_and_activities.*;
import tools.*;


public class Main {

    public static void main(String[] args) {

        Bank bnb = new Bank("BNB","Knyaz Aleksandar I", 10000000);


        System.out.println("-------------------------------------------------------------------------------------------------------------");

        Client john = new Client("John Wilson", "Tsar Boris III", 100000, 500, 80, Entity.PHYSICAL, "9001011234");
        Client telerik = new Client("Telerik Academy", "Aleksandar Malinov 31", 100000, 1000, 100, Entity.CORPORATE,"123456789");

        bnb.addNewClient(john);
        bnb.addNewClient(telerik);

        System.out.println("-------------------------------------------------------------------------------------------------------------");

        bnb.giveCreditPhysical(john, "KreditZaKushta",60,41000, CreditTypePhysical.RESIDENTIAL);// Credit is declined.

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.giveCreditPhysical(john, "KreditZaKushtaAdjusted",240,40000, CreditTypePhysical.RESIDENTIAL);

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.giveCreditCorporate(telerik, "NovaSgrada", 120, 240000, CreditTypeCorporate.INVESTMENT);

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.giveCreditCorporate(telerik, "NoviKomputri", 60, 22000, CreditTypeCorporate.BUSINESS);

        System.out.println("-------------------------------------------------------------------------------------------------------------");

        //bnb.removeBankProduct(john, "IvansCreditOne");

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.addDebitCard(john, "John's DebitCard", 10, 1000);
        bnb.addCreditCard(telerik, "Company Credit Card", 8, 10000);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.showAllClientsAndProducts();


    }
}