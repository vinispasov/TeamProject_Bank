import financial_unit.*;
import bank_product.*;
import investment_services_and_activities.*;
import tools.*;


public class Main {

    public static void main(String[] args) {

        Client ivan = new Client("Ivan Todorov", "Tsar Boris III", 1000, 500, 80, Entity.PHYSICAL);
        Client telerik = new Client("Telerik Academy", "Aleksandar Malinov Boulevard 31", 10000, 1000, 100, Entity.CORPORATE);
        Bank bnb = new Bank("BNB","Knyaz Aleksandar I", 1000000);



        bnb.addNewClient(ivan);
        ivan.requestCredit();
        bnb.giveCreditPhysical(ivan, "IvansCreditOne",4,500,CreditTypePhysical.STUDENT);

        //bnb.removeBankProduct(ivan, "IvansCreditOne");
        bnb.showClientsBankProducts(ivan);


    }
}