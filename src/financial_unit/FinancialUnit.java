package financial_unit;

import tools.OutOfCurrencyException;

public class FinancialUnit {

    private String name;
    private String address;
    private int availableCurrency;



    public FinancialUnit() {

    }

    public FinancialUnit(String name, String address, int availableCurrency) {
        setName(name);
        setAddress(address);
        setAvailableCurrency(availableCurrency);
    }


    public String getName() {
        return name;
    }

    // Name must be of only alphabet characters, start with a capital letter and be no longer than 40 symbols.
    public void setName(String name) {
        if (name.matches("([^A-Za-z]+){0,39}$") && Character.isUpperCase(name.charAt(0))) {
            this.name = name;
        } else {
            System.out.println("The entered name is invalid.");
        }

    }


    public String getAddress() {
        return address;
    }

    // Address must be of only alphanumeric characters and be no longer than 50 symbols.
    public void setAddress(String address) {
        if (address.matches("([^A-Za-z0-9]+){0,49}$")) {
            this.address = address;
        } else {
            System.out.println("The address entered is invalid.");
        }
    }

    public int getAvailableCurrency() {
        return availableCurrency;

    }

    // Available currency must be of only numeric characters.
    public void setAvailableCurrency(int availableCurrency) {

        this.availableCurrency = availableCurrency;
    }




}