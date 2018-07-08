package financial_unit;

import bank_product.BankProduct;
import bank_product.Credit;
import bank_product.CreditTypeCorporate;
import bank_product.CreditTypePhysical;
import tools.Entity;
import tools.OutOfCurrencyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank extends FinancialUnit {


    private List<Client> clientList = new ArrayList<>();
    private Map<String, List<BankProduct>> clientProducts = new HashMap<>();


    public Bank(String name, String address, int availableCurrency) {
        super.setName(name);
        super.setAddress(address);
        super.setAvailableCurrency(availableCurrency);
        System.out.println("New bank " + this.getName() + " started operation." +
                        "\nThe availavle currency in the bank is: " + availableCurrency);

    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void addNewClient(Client client) {
        clientList.add(client);
        clientProducts.put(client.getIdOrBulstat(), new ArrayList<>());
        System.out.println("The bank " + getName() + " added new client - " + client.getName() + ".");
    }

    //Creates a new Credit object and assigns it to a client. All calculations are inside the Credit class.
    //This is for the PHYSICAL credit options.
    public void giveCreditPhysical(Client client, String creditName, int periodOfProductMonthly, int amount, CreditTypePhysical creditType) {
        System.out.println("The client " + client.getName() + " applied for new credit of type " + creditType + " with name: " + creditName + ".");
        Credit credit = new Credit(creditName, client.getMonthlySalary(), client.getIdOrBulstat(), Entity.PHYSICAL, creditType, periodOfProductMonthly, amount);
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        products.add(credit);

        if (credit.getTax() > 0) {
            setAvailableCurrency(getAvailableCurrency() - amount);
            client.setAvailableCurrency(client.getAvailableCurrency() + amount);
        }

    }

    //Creates a new Credit object and assigns it to a client. All calculations happen inside the Credit class.
    //This is for the CORPORATE credit options.
    public void giveCreditCorporate(Client client, String creditName, int periodOfProductMonthly, int amount, CreditTypeCorporate creditType) {
        System.out.println("The client " + client.getName() + " applied for new credit of type " + creditType + " with name: " + creditName + ".");
        Credit credit = new Credit(creditName, client.getIdOrBulstat(), client.getMonthlySalary(), Entity.CORPORATE, creditType, periodOfProductMonthly, amount);
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        products.add(credit);

        if (credit.getTax() > 0) {
            setAvailableCurrency(getAvailableCurrency() - amount);
            client.setAvailableCurrency(client.getAvailableCurrency() + amount);
        }


    }

    //Removes a concrete bank client. The product name MUST be unique.
    public void removeBankProduct(Client client, String productName) {
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        for (BankProduct product : products) {
            if (product.getName().equals(productName)) {
                products.remove(product);
                break;
            }
        }
    }

    public void removeClient(Client client) {

    }

    public void showClientsBankProducts(Client client) {
        System.out.println(client.toString());

    }

    //Prints all clients and their corresponding bank products.
    public void showAllClientsAndProducts() {
        System.out.println("List of all clients and bank products: ");
        for (Client client : clientList) {
            String bulstat = client.getIdOrBulstat();
            System.out.println(client.toString());

            List<BankProduct> products = clientProducts.get(bulstat);
            for (BankProduct product : products) {
                System.out.print("Credit name: " + product.getName() + " | ");
                System.out.print("Owed to the bank: " + product.getAccountBalance() + " | ");
                System.out.print("Tax percentage: " + product.getTax() + "\n");

            }
        }


//        clientProducts.keySet();
//        clientProducts.values();
//        for (int i = 0; i < clientProdu ; i++) {
//            clientProducts.values();
//        }
    }

    public void listClientsByCreditScore() {

    }


    public void recieveDeposit() {

    }

    public void payInterest() {

    }

    //  public void ()


}