package bank_product;

import investment_services_and_activities.CorporateBonds;
import investment_services_and_activities.GovermentBonds;

public class Main {
    public static void main(String[] args) {
        GovermentBonds govermentBonds = new GovermentBonds("Pesho", 100, 30, 2, 40, 5);
        govermentBonds.buy();
        CorporateBonds corporateBonds=new CorporateBonds("Pesho", 100, 30, 2, 40, 5);
        corporateBonds.sell();
    }
}
