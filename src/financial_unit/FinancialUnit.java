package financial_unit;

public abstract class FinancialUnit {

    private String name;
    private String address;
    private double availableCurrency;


    public FinancialUnit() {

    }

    public FinancialUnit(String name, String address, double availableCurrency) {
        setName(name);
        setAddress(address);
        setAvailableCurrency(availableCurrency);
    }


    public String getName() {
        return name;
    }

    // Name must be of only alphabet characters and start with a capital letter.
    public void setName(String name) {
        if (name.matches("([A-Za-z\\s]*)") && Character.isUpperCase(name.charAt(0))) {
            this.name = name;
        } else {
            System.out.println("The entered name is invalid.");
        }

    }

    public String getAddress() {
        return address;
    }

    // Address must be of only alphanumeric characters.
    public void setAddress(String address) {
        if (address.matches("([A-Za-z0-9\\s]*)")) {
            this.address = address;
        } else {
            System.out.println("The address entered is invalid.");
        }
    }

    public double getAvailableCurrency() {
        return availableCurrency;

    }

    // Available currency must be of only numeric characters.
    public void setAvailableCurrency(double availableCurrency) {

        this.availableCurrency = availableCurrency;
    }

}