package financial_unit;
import java.util.HashSet;
import java.util.Iterator;

import bank_product.Account;
import tools.AvailableBankCurrencies;
import bank_product.Credit;
import bank_product.CreditCards;
import bank_product.CreditTypeCorporate;
import bank_product.Deposit;
import bank_product.PayableAccount;
import bank_product.SavingAccount;
import bank_product.BankProduct;
import bank_product.Credit;
import bank_product.CreditTypePhysical;
import bank_product.CurrencyChange;
import bank_product.DebitCards;
import financial_unit.Client;

import com.sun.rmi.rmid.ExecPermission;

import tools.CreditNotApprovedException;
import tools.Entity;
import tools.InvalidAvailableCurrencyException;
import tools.OutOfCurrencyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bank extends FinancialUnit {


	//available currency for bank
	private static final int MAX_AVAILABLE_CURRENCY =Integer.MAX_VALUE;
	private static final int MIN_AVAILABLE_CURRENCY = 2000000;
	private static final int ANUAL_MAINTENANCE_CARD = 10;
	private static final double WITH_DRAW_TAX = 1;
	//fields
    private HashSet<Client> clientList = new HashSet<>();
    private Map<String, List<Account>> clientAccounts = new HashMap<>();
   

    //constructor
    public Bank(String name, String address, int availableCurrency) {
		super(name, address, availableCurrency);
		System.out.println("New bank was created.");
	}


    //getters and setters
    public HashSet<Client> getClientList() {
        return clientList;
    }



    @Override
	 public void setAvailableCurrency(int availableCurrency) throws InvalidAvailableCurrencyException {
		
		if(availableCurrency<MIN_AVAILABLE_CURRENCY||availableCurrency>MAX_AVAILABLE_CURRENCY) {
			throw new InvalidAvailableCurrencyException("Available currency for bank should be between: "+MIN_AVAILABLE_CURRENCY+" and "+MAX_AVAILABLE_CURRENCY);
		}
		setCorrectAvailableCurrency(availableCurrency);
	}


    //methods
    private void addNewClient(Client client) {
    	this.clientList.add(client);
		this.clientAccounts.put(client.getIdOrBulstat(),client.getBankAccountsList());
    }


    public void giveCreditPhysical(Client client, int periodOfProductMonthly, int amount, CreditTypePhysical creditType) {
       
		try {
			Credit credit = new Credit(client.getName(), client.getMonthlySalary(), client.getIdOrBulstat(), client.getEntity(), creditType, periodOfProductMonthly, amount);
			client.getBankAccountsList().add(credit);
			addNewClient(client);
			client.setAvailableCurrency(client.getAvailableCurrency()-credit.getTax());
			this.setAvailableCurrency(this.getAvailableCurrency()+credit.getTax());
			System.out.println("New physical client "+client.getName()+" with address "+client.getAddress()+" and id:"+client.getIdOrBulstat()+" get new credit.");
			System.out.println("The new "+creditType+" credit with rate "+credit.getRate()+"% and iban: "+credit.getIban()+ " was created and the client paid tax "+credit.getTax());
			System.out.println("The amount that the client got is "+amount+" and it's for "+credit.getPeriodOfProductMonthly()+" months.The client should return to the bank "+(credit.getAccountBalance()*-1)+" as a monthly payments which costs "+credit.getMonthlyFee());
		} catch (CreditNotApprovedException | InvalidAvailableCurrencyException e) {
			System.out.println(e.getMessage());
		}
    }

    public void giveCreditCorporate(Client client, int periodOfProductMonthly, int amount, CreditTypeCorporate creditType) {
		try {
		Credit credit = new Credit(client.getName(), client.getMonthlySalary(), client.getIdOrBulstat(), client.getEntity(), creditType, periodOfProductMonthly, amount);
			client.getBankAccountsList().add(credit);
			addNewClient(client);
			client.setAvailableCurrency(client.getAvailableCurrency()-credit.getTax());
			this.setAvailableCurrency(this.getAvailableCurrency()+credit.getTax());
			System.out.println("New corporate client "+client.getName()+" with address "+client.getAddress()+" and bulstat:"+client.getIdOrBulstat()+" get new credit.");
			System.out.println("The new "+creditType+" credit with rate "+credit.getRate()+"% and iban: "+credit.getIban()+ " was created and the client paid tax "+credit.getTax());
			System.out.println("The amount that the client got is "+amount+" and it's for "+credit.getPeriodOfProductMonthly()+" months.The client should return to the bank "+(credit.getAccountBalance()*-1)+" as a monthly payments which costs "+credit.getMonthlyFee());
		} catch (CreditNotApprovedException | InvalidAvailableCurrencyException e) {
			System.out.println(e.getMessage());
		}
        
    }
    public void createDeposit(Client client, int periodOfProductMonthly, int amount) {
		try {
		Deposit deposit = new Deposit(client.getName(), client.getIdOrBulstat(),client.getMonthlySalary(),amount,periodOfProductMonthly);
			client.getBankAccountsList().add(deposit);
			addNewClient(client);
			client.setAvailableCurrency(client.getAvailableCurrency()-deposit.getTax());
			this.setAvailableCurrency(this.getAvailableCurrency()+deposit.getTax());
			System.out.println("Client "+client.getName()+", with address "+client.getAddress()+" and id or bulstat:"+client.getIdOrBulstat()+" set new deposit.");
			System.out.println("The new deposit with rate "+deposit.getRate()+"% and iban: "+deposit.getIban()+ " was created and the client paid tax "+deposit.getTax());
			System.out.println("The amount that the client set is "+amount+" and it's for "+deposit.getPeriodOfProductMonthly()+" months.");
		} catch (CreditNotApprovedException | InvalidAvailableCurrencyException e) {
			System.out.println(e.getMessage());
		}
        
    }
    
    
    public void createSavingAccount(Client client) {
    	try {
			SavingAccount savingAccount=new SavingAccount(client.getName(),client.getIdOrBulstat(),client.getMonthlySalary());
			client.getBankAccountsList().add(savingAccount);
			addNewClient(client);
			client.setAvailableCurrency(client.getAvailableCurrency()-savingAccount.getTax());
			this.setAvailableCurrency(this.getAvailableCurrency()+savingAccount.getTax());
			System.out.println("Client "+client.getName()+" with address "+client.getAddress()+" and bulstat:"+client.getIdOrBulstat()+" get new saving account.");
			System.out.println("The new saving account with rate:"+savingAccount.getRate()+"% and iban: "+savingAccount.getIban()+ " was created and the client paid tax "+savingAccount.getTax());
		} catch (CreditNotApprovedException | InvalidAvailableCurrencyException e) {
			System.out.println(e.getMessage());
		}
    }
    public void createPayableAccount(Client client) {
    	try {
			Account payableAccount=new PayableAccount(client.getName(),client.getIdOrBulstat(),client.getMonthlySalary());
			client.getBankAccountsList().add(payableAccount);
			addNewClient(client);
			client.setAvailableCurrency(client.getAvailableCurrency()-payableAccount.getTax());
			this.setAvailableCurrency(this.getAvailableCurrency()+payableAccount.getTax());
			System.out.println("Client "+client.getName()+" with address "+client.getAddress()+" and bulstat:"+client.getIdOrBulstat()+" get new payable account.");
			System.out.println("The new payable account with iban: "+payableAccount.getIban()+ " was created and the client paid tax "+payableAccount.getTax());
		} catch (CreditNotApprovedException | InvalidAvailableCurrencyException e) {
			System.out.println(e.getMessage());
		}
    }

    public CreditCards createCreditCard(Client client,int creditLimit) {
    	try {
			CreditCards card=new CreditCards(client.getName(),client.getIdOrBulstat(),client.getMonthlySalary(),ANUAL_MAINTENANCE_CARD,WITH_DRAW_TAX,creditLimit);
			client.getBankAccountsList().add(card);
			addNewClient(client);
			client.setAvailableCurrency(client.getAvailableCurrency()-card.getTax());
			this.setAvailableCurrency(this.getAvailableCurrency()+card.getTax());
			System.out.println("Client "+client.getName()+" with address "+client.getAddress()+" and bulstat:"+client.getIdOrBulstat()+" get new credit card.");
			System.out.println("The new credit card with rate "+card.getRate()+"% and iban: "+card.getIban()+ " was created and the client paid no tax.");
			System.out.println("The credit limit is "+creditLimit+" and it's for "+card.getPeriodOfProductMonthly()+" months.");
			return card;
		} catch (CreditNotApprovedException | InvalidAvailableCurrencyException e) {
			e.getMessage();
		}
    	return null;
    }
    
    public void createDebitCard(Client client,int cardBalance) {
    	try {
			 DebitCards card=new DebitCards(client.getName(),client.getIdOrBulstat(),client.getMonthlySalary(),ANUAL_MAINTENANCE_CARD,WITH_DRAW_TAX,cardBalance);
			client.getBankAccountsList().add(card);
			addNewClient(client);
			client.setAvailableCurrency(client.getAvailableCurrency()-card.getTax());
			this.setAvailableCurrency(this.getAvailableCurrency()+card.getTax());
			System.out.println("Client "+client.getName()+" with address "+client.getAddress()+" and id or bulstat:"+client.getIdOrBulstat()+" get new debit card.");
			System.out.println("The new debit card with iban: "+card.getIban()+ " was created and the client paid no tax.");
			System.out.println("The card balance is "+cardBalance+" and it's for "+card.getPeriodOfProductMonthly()+" months.");
		} catch (CreditNotApprovedException | InvalidAvailableCurrencyException e) {
			e.getMessage();
		}
    }
    public void currencyChange(Client client,AvailableBankCurrencies currencyToSell, AvailableBankCurrencies currencyToBuy,double amount) {
    	CurrencyChange change=new CurrencyChange(currencyToSell,currencyToBuy,amount);
    	change.changeCurrency(client,amount);
    }
    /**
     * @param client      This is the bank client.
     * @param productName must be unique.
     */
    public void removeBankProduct(Client client, String iban) {
        List<Account> products = clientAccounts.get(client.getIdOrBulstat());
        for (Account product : products) {
            if (product.getIban().equals(iban)) {
                products.remove(product);
                break;
            }
        }
    }
    
    public void oneMonthLater() {
    	
			try {
				System.out.println("---------Clients monthly incomes--------");
				for (Client client : clientList) {
				System.out.println(client.getName()+"'s money before incomes: "+client.getAvailableCurrency());
				client.setAvailableCurrency(client.getMonthlySalary());
				System.out.println(client.getName()+"'s money after incomes: "+client.getAvailableCurrency());
				System.out.println();
				}
				System.out.println("---------Clients monthly payments to the bank---------");
				for (Iterator iterator = clientList.iterator(); iterator.hasNext();) {
					Client client = (Client) iterator.next();
					List<Account>accounts=clientAccounts.get(client.getIdOrBulstat());
					for (Account account : accounts) {
						if (account instanceof Credit) {
						    Credit credit=(Credit) account;
						    System.out.printf(account.getName()+"%s account before monthly payment: %.2f\n"," ",credit.getAccountBalance());
						    credit.setAccountBalance(credit.getMonthlyFee());
						    System.out.printf(account.getName()+"%s account after monthly payment: %.2f\n"," ",credit.getAccountBalance());
						    System.out.println();
						}
					}
				}
				
			} catch (InvalidAvailableCurrencyException e) {
				e.getMessage();
			}
	
    }

   

}