package bank_product;

import financial_unit.Client;
import tools.AvailableBankCurrencies;

public class CurrencyChange  {
	//currency rates
	private static final double BGN_TO_USD_RATE=0.60;
	private static final double BGN_TO_EUR_RATE=0.51;
	private static final double BGN_TO_GBP_RATE=0.45;
	private static final double USD_TO_BGN_RATE=1.66;
	private static final double USD_TO_EUR_RATE=0.85;
	private static final double USD_TO_GBP_RATE=0.75;
	private static final double EUR_TO_BGN_RATE=1.95;
	private static final double EUR_TO_USD_RATE=1.17;
	private static final double EUR_TO_GBP_RATE=0.88;
	private static final double GBP_TO_BGN_RATE=2.21;
	private static final double GBP_TO_USD_RATE=1.32;
	private static final double GBP_TO_EUR_RATE=1.13;
	
	
	 //fields
    private double currencyRate;
    private AvailableBankCurrencies currencyToSell;
    private AvailableBankCurrencies currencyToBuy;
    
    //constructor
    public CurrencyChange(AvailableBankCurrencies currencyToSell, AvailableBankCurrencies currencyToBuy,double amount) {
        
    	switch (currencyToSell) {
		case BGN: 
			
			switch (currencyToBuy) {
		case USD:this.currencyRate=BGN_TO_USD_RATE;
		         this.currencyToSell=AvailableBankCurrencies.BGN;
		         this.currencyToBuy=AvailableBankCurrencies.USD;
			break;
		case EUR:this.currencyRate=BGN_TO_EUR_RATE;
		this.currencyToSell=AvailableBankCurrencies.BGN;
        this.currencyToBuy=AvailableBankCurrencies.EUR;
		break;
		
		case GBP:this.currencyRate=BGN_TO_GBP_RATE;	
		this.currencyToSell=AvailableBankCurrencies.BGN;
        this.currencyToBuy=AvailableBankCurrencies.GBP;
        break;
		default:
			break;
		}
			break;
   case USD: 
			
			switch (currencyToBuy) {
		case BGN:this.currencyRate=USD_TO_BGN_RATE;	
		this.currencyToSell=AvailableBankCurrencies.USD;
        this.currencyToBuy=AvailableBankCurrencies.BGN;
			break;
			
		case EUR:this.currencyRate=USD_TO_EUR_RATE;	
		this.currencyToSell=AvailableBankCurrencies.USD;
        this.currencyToBuy=AvailableBankCurrencies.EUR;
		break;
		
		case GBP:this.currencyRate=USD_TO_GBP_RATE;	
		this.currencyToSell=AvailableBankCurrencies.USD;
        this.currencyToBuy=AvailableBankCurrencies.GBP;
        break;
        
		default:
			break;
		}
			break;

   case EUR: 
		
		switch (currencyToBuy) {
	case BGN:this.currencyRate=EUR_TO_BGN_RATE;
	this.currencyToSell=AvailableBankCurrencies.EUR;
    this.currencyToBuy=AvailableBankCurrencies.BGN;
		break;
	case USD:this.currencyRate=EUR_TO_USD_RATE;
	this.currencyToSell=AvailableBankCurrencies.EUR;
    this.currencyToBuy=AvailableBankCurrencies.USD;
	break;
	case GBP:this.currencyRate=EUR_TO_GBP_RATE;
	this.currencyToSell=AvailableBankCurrencies.EUR;
    this.currencyToBuy=AvailableBankCurrencies.GBP;
    break;
	default:
		break;
	}
		break;
   case GBP: 
		
		switch (currencyToBuy) {
	case BGN:this.currencyRate=GBP_TO_BGN_RATE;
	this.currencyToSell=AvailableBankCurrencies.GBP;
    this.currencyToBuy=AvailableBankCurrencies.BGN;
		break;
	case USD:this.currencyRate=GBP_TO_USD_RATE;	
	this.currencyToSell=AvailableBankCurrencies.GBP;
    this.currencyToBuy=AvailableBankCurrencies.USD;
	break;
	case EUR:this.currencyRate=GBP_TO_EUR_RATE;
	this.currencyToSell=AvailableBankCurrencies.GBP;
    this.currencyToBuy=AvailableBankCurrencies.EUR;
    break;
	default:
		break;
	}
		break;
		default:
			break;
		}
    }

  //getters and setters
    public double getCurrencyRate() {
        return currencyRate;
    }

    public AvailableBankCurrencies getCurrencyToSell() {
        return currencyToSell;
    }

    public AvailableBankCurrencies getCurrencyToBuy() {
        return currencyToBuy;
    }

    
    //methods
    public void changeCurrency(Client client,double sumToBeChanged){
        System.out.printf(client.getName()+"%schange %.2f %s for %.2f %s\n "," ",sumToBeChanged,
                getCurrencyToSell().toString(),sumToBeChanged*getCurrencyRate(),getCurrencyToBuy().toString());
    }


    public CurrencyChange(String clientName, double currencyRate, AvailableBankCurrencies
            currencyToSell, AvailableBankCurrencies currencyToBuy) {
        this.clientName=clientName;
        this.currencyRate = currencyRate;
        this.currencyToSell = currencyToSell;
        this.currencyToBuy = currencyToBuy;
    }
    private String clientName;
    public static final double CHANGE_TAX=0.05;

    void changeCurrency(double sumToBeChanged){
        System.out.printf("Client %s change %.2f %s for %.2f %s\n ",getClientName(),sumToBeChanged,
                getCurrencyToBuy().toString(),(sumToBeChanged-CHANGE_TAX*sumToBeChanged)*getCurrencyRate(),getCurrencyToSell().toString());

    }


    public String getClientName() {
        return clientName;
    }
}
