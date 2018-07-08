package financial_unit;

import bank_product.*;
import tools.Entity;
import tools.OutOfCurrencyException;

import java.util.*;

public class Bank extends FinancialUnit {

    private static final int ANNUAL_CARD_MAINTENANCE_TAX = 10;

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

    public void addCreditCard(Client client, String cardName, double tax, double limit){
        System.out.println("The client " + client.getName() + " applied for new credit Card with limit " + limit + " with name: " + cardName + ".");
        CreditCards creditCard = new CreditCards(cardName, client.getIdOrBulstat(), client.getMonthlySalary(), ANNUAL_CARD_MAINTENANCE_TAX, tax, limit);
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        products.add(creditCard);
    }

    public void addDebitCard(Client client, String cardName, double tax, double balance){
        System.out.println("The client " + client.getName() + " applied for new credit Card with balance " + balance + " with name: " + cardName + ".");
        DebitCards debitCard = new DebitCards(cardName, client.getIdOrBulstat(), client.getMonthlySalary(), ANNUAL_CARD_MAINTENANCE_TAX, tax, balance);
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        products.add(debitCard);
    }

    public void chargeAnnualMantenanceTaxToAllCards(Client client) {

        List<BankProduct> bankProducts = clientProducts.get(client.getIdOrBulstat());
        for (BankProduct product: bankProducts) {
            if (product instanceof BillsPayable) {
                BillsPayable billsPayable = (BillsPayable) product;
                billsPayable.billsPayable(ANNUAL_CARD_MAINTENANCE_TAX);
            }
        }
    }

    //Creates a new Credit object and assigns it to a client. All calculations are inside the Credit class.
    //This is for the PHYSICAL credit options.
    public void giveCreditPhysical(Client client, String creditName, int periodOfProductMonthly, int amount, CreditTypePhysical creditType){
        try {
            checkCurrency(getAvailableCurrency(), amount);
        } catch (OutOfCurrencyException e){
            System.out.println(e.getMessage());
            return;
        }
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
    public void giveCreditCorporate(Client client, String creditName, int periodOfProductMonthly, int amount, CreditTypeCorporate creditType){
        try {
            checkCurrency(getAvailableCurrency(), amount);
        } catch (OutOfCurrencyException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("The client " + client.getName() + " applied for new credit of type " + creditType + " with name: " + creditName + ".");
        Credit credit = new Credit(creditName, client.getIdOrBulstat(), client.getMonthlySalary(), Entity.CORPORATE, creditType, periodOfProductMonthly, amount);
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        products.add(credit);

        if (credit.getTax() > 0) {
            setAvailableCurrency(getAvailableCurrency() - amount);
            client.setAvailableCurrency(client.getAvailableCurrency() + amount);
        }

    }

    private void checkCurrency (double availableCurrency, int amount) throws OutOfCurrencyException{
        if(this.getAvailableCurrency() < amount) {
            throw new OutOfCurrencyException("The bank does not have sufficient currency for this operation.");
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
        clientList.remove(client);
        clientProducts.remove(client);

    }
//Show the information for a given client.
    public void showClient (Client client) {
        System.out.println(client.toString());

    }

    public void showClientsBankProducts(Client client) {
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        System.out.println("\nClient name: " + client.getName());
        for (BankProduct product : products) {
            System.out.print("Bank product name: " + product.getName() + " | ");
            System.out.print("Owed to the bank: " + product.getAccountBalance() + " | ");
            System.out.print("Tax percentage: " + product.getTax() + "\n");

        }


    }

    //Prints all clients and their corresponding bank products. Uses the "showClientsBankProducts" method.
    public void showAllClientsAndProducts() {
        System.out.println("\nList of all clients and bank products:");
        for (Client client : clientList) {
            String bulstat = client.getIdOrBulstat();
            showClientsBankProducts(client);
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