package financial_unit;

import bank_product.Account;

import bank_product.BankCards;

import bank_product.BankProduct;
import bank_product.Credit;
import java.util.ArrayList;
import bank_product.Deposit;

import java.util.List;

import java.util.Scanner;

import tools.Entity;
import tools.InvalidAvailableCurrencyException;
import tools.InvalidIdOrBulstatException;
import tools.InvalidMonthlySalaryException;


public class Client extends FinancialUnit {

	//available currency for client
	private static final int MIN_AVAILABLE_CURRENCY=0;
	private static final int MAX_AVAILABLE_CURRENCY=1000000;
	//numbers for id or bulstat
	private static final int ID_NUMBERS = 10;
	private static final int BULSTAT_NUMBER_NINE = 9;
	private static final int BULSTAT_NUMBER_THIRTEEN = 13;
	//fields
    private int monthlySalary;
    private Entity entity;
    private String idOrBulstat;
    private List<Account> bankAccounts=new ArrayList<Account>();
    

//constructor
	public Client(String name, String address, int availableCurrency,Entity entity,String idOrBulstat,int monthlySalary) {
		super(name, address, availableCurrency);
		try {
			this.entity=entity;
			setIdOrBulstat(idOrBulstat);
			setMonthlySalary(monthlySalary);
			System.out.println("New client was created.");
			
		} catch (InvalidIdOrBulstatException | InvalidMonthlySalaryException e) {
			System.out.println(e.getMessage());
		}
	}


    private List<BankProduct> bankProductsList; // List to hold all credits and deposits of the client.
    private List<BankCards> bankCardsList; //List to hold all credit and debit cards of the client.




    public int getMonthlySalary() {
        return monthlySalary;
    }


    
    public void setMonthlySalary(int monthlySalary) throws InvalidMonthlySalaryException {
    	if(monthlySalary<0) {
    		throw new InvalidMonthlySalaryException("The monthly incomes should be a positive number.");
    	}
    	this.monthlySalary=monthlySalary;
    }


    private void setIdOrBulstat(String idOrBulstat) throws InvalidIdOrBulstatException {
    	Scanner sc=new Scanner(System.in);
    	 if(idOrBulstat.length()!=ID_NUMBERS
    			 &&idOrBulstat.length()!=BULSTAT_NUMBER_NINE
    			 &&idOrBulstat.length()!=BULSTAT_NUMBER_THIRTEEN) {
			throw new InvalidIdOrBulstatException("The id number should be 10 digits.The bulstat should be 9 or 13 digits.");
		}
    	 else {
			if (idOrBulstat.length()==ID_NUMBERS&&this.getEntity()==Entity.CORPORATE) {
				throw new InvalidIdOrBulstatException("For corporate entity you should enter 9 or 13 digit bulstat number.");
			}
			else if (idOrBulstat.length()==BULSTAT_NUMBER_NINE&&this.getEntity()==Entity.PHYSICAL
					||idOrBulstat.length()==BULSTAT_NUMBER_THIRTEEN&&this.getEntity()==Entity.PHYSICAL) {
				throw new InvalidIdOrBulstatException("For physical entity you should enter 10 digit id number.");
			}else {
				this.idOrBulstat=idOrBulstat;
			}
		}
    }

	public Entity getEntity() {
		return entity;
	}



	@Override
	 public void setAvailableCurrency(int availableCurrency) throws InvalidAvailableCurrencyException {
		if(availableCurrency<MIN_AVAILABLE_CURRENCY||availableCurrency>MAX_AVAILABLE_CURRENCY) {
			throw new InvalidAvailableCurrencyException("Available currency for client should be between: "+MIN_AVAILABLE_CURRENCY+" and "+MAX_AVAILABLE_CURRENCY);
		}
		setCorrectAvailableCurrency(availableCurrency);
	}

	public List<Account> getBankAccountsList() {
		return bankAccounts;
	}



    public String getIdOrBulstat() {
        return idOrBulstat;
    }

}