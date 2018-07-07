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

    public CurrencyChange(double currencyRate, AvailableBankCurrencies
            currencyToSell, AvailableBankCurrencies currencyToBuy) {
        this.currencyRate = currencyRate;
        this.currencyToSell = currencyToSell;
        this.currencyToBuy = currencyToBuy;
    }

    private double currencyRate;
    private AvailableBankCurrencies currencyToSell;
    private AvailableBankCurrencies currencyToBuy;

    void changeCurrency(double sumToBeChanged){
        System.out.printf("Client %s change %.2f %s for %.2f %s\n "," ",sumToBeChanged,
                getCurrencyToBuy().toString(),sumToBeChanged*getCurrencyRate(),getCurrencyToSell().toString());

    }
}
