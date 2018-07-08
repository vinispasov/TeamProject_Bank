package bank_product;
enum AvailableBankCurrencies {
    BGN,USD,EUR,GBP
}
public class CurrencyChange  {
    public double getCurrencyRate() {
        return currencyRate;
    }

    public AvailableBankCurrencies getCurrencyToSell() {
        return currencyToSell;
    }

    public AvailableBankCurrencies getCurrencyToBuy() {
        return currencyToBuy;
    }

    public CurrencyChange(String clientName, double currencyRate, AvailableBankCurrencies
            currencyToSell, AvailableBankCurrencies currencyToBuy) {
        this.clientName=clientName;
        this.currencyRate = currencyRate;
        this.currencyToSell = currencyToSell;
        this.currencyToBuy = currencyToBuy;
    }
    private String clientName;
    private double currencyRate;
    private AvailableBankCurrencies currencyToSell;
    private AvailableBankCurrencies currencyToBuy;
    public static final double CHANGE_TAX=0.05;

    void changeCurrency(double sumToBeChanged){
        System.out.printf("Client %s change %.2f %s for %.2f %s\n ",getClientName(),sumToBeChanged,
                getCurrencyToBuy().toString(),(sumToBeChanged-CHANGE_TAX*sumToBeChanged)*getCurrencyRate(),getCurrencyToSell().toString());

    }

    public String getClientName() {
        return clientName;
    }
}
