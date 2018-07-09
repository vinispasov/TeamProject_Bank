import financial_unit.*;
import bank_product.*;
import investment_services_and_activities.*;
import tools.*;


public class Main {

    public static void main(String[] args) {

        Bank bnb = new Bank("BNB","Knyaz Aleksandar I", 10000000);


        System.out.println("-------------------------------------------------------------------------------------------------------------");

        Client ivan = new Client("Ivan Todorov", "Tsar Boris III", 100000, 500, 80, Entity.PHYSICAL, "9001011234");
        Client telerik = new Client("Telerik Academy", "Aleksandar Malinov 31", 100000, 1000, 100, Entity.CORPORATE,"123456789");

        bnb.addNewClient(ivan);
        bnb.addNewClient(telerik);

        System.out.println("-------------------------------------------------------------------------------------------------------------");

        bnb.giveCreditPhysical(ivan, "KreditZaKushta",60,41000, CreditTypePhysical.RESIDENTIAL);// Credit is declined.
        System.out.println((int)bnb.getAvailableCurrency());
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.giveCreditPhysical(ivan, "KreditZaKushtaAdjusted",240,40000, CreditTypePhysical.RESIDENTIAL);
        System.out.println((int)bnb.getAvailableCurrency());
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.giveCreditCorporate(telerik, "NovaSgrada", 120, 240000, CreditTypeCorporate.INVESTMENT);
        System.out.println((int)bnb.getAvailableCurrency());
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.giveCreditCorporate(telerik, "NoviKomputri", 60, 22000, CreditTypeCorporate.BUSINESS);
        System.out.println((int)bnb.getAvailableCurrency());
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        //bnb.removeBankProduct(ivan, "IvansCreditOne");

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        bnb.showAllClientsAndProducts();
        bnb.removeClient(ivan);
        bnb.showAllClientsAndProducts();

    }
}