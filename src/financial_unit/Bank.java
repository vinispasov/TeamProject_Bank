package financial_unit;

import bank_product.BankProduct;
import bank_product.Credit;
import bank_product.CreditTypePhysical;
import com.sun.rmi.rmid.ExecPermission;
import tools.Entity;
import tools.OutOfCurrencyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank extends FinancialUnit {


    List<Client> clientList = new ArrayList<>();
    Map<String, List<BankProduct>> clientProducts = new HashMap<>();



    public Bank(String name, String address, int availableCurrency) {
        super.setName(name);
        super.setAddress(address);
        super.setAvailableCurrency(availableCurrency);

    }


    public List<Client> getClientList() {
        return clientList;
    }



    public void addNewClient(Client client) {
        clientList.add(client);
        clientProducts.put(client.getIdOrBulstat(), new ArrayList<>());
    }


    public void giveCreditPhysical(Client client, String creditName, int periodOfProductMonthly, int amount, CreditTypePhysical creditType) {
        Credit credit = new Credit(creditName, client.getMonthlySalary(), client.getIdOrBulstat(), Entity.PHYSICAL, creditType, periodOfProductMonthly, amount);
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        products.add(credit);
    }

    public void giveCreditCorporate(Client client, String creditName, int periodOfProductMonthly, int amount, CreditTypePhysical creditType) {
        Credit credit = new Credit(creditName, client.getMonthlySalary(), client.getIdOrBulstat(), Entity.CORPORATE, creditType, periodOfProductMonthly, amount);
        List<BankProduct> products = clientProducts.get(client.getIdOrBulstat());
        products.add(credit);
    }

    /**
     * @param client      This is the bank client.
     * @param productName must be unique.
     */
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


    }

    public void showAllClientsAndProducts() {

    }

    public void listClientsByCreditScore() {

    }


    public void recieveDeposit() {

    }

    public void payInterest() {

    }


}