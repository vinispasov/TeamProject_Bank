package bank_product; 
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import tools.CreditNotApprovedException;
import tools.OutOfAgeException;
import java.util.Random;
public abstract class Account {
	//number of digits that should contain any of listed here:
		private static final int ID_NUMBERS = 10;
		private static final int BULSTAT_NUMBER_NINE =9;
		private static final int BULSTAT_NUMBER_THIRTEEN =13;
		//tools for checking the clients ages:
		private static final char MAX_DECADE = 5;
		private static final char MAX_YEAR_OF_DECADE = 3;
		private static final char DECADE = 6;
		private static final char MIN_DECADE = 0;
		private static final char MIN_YEAR_OF_DECADE = 0;
		private static final int MIN_SIZE_OF_NAME = 2;
	    //fields
		private String name;
		private String idOrBulstat;
		private int incomesMonthly;
		private double accountBalance;
		private int tax;
		private String iban;
	
		
		//constructor
		public Account(String name,String idOrBulstat,int incomesMonthly) throws CreditNotApprovedException {
			
			try {
				idOrBulstat=checkIdOrBulstat(idOrBulstat);
				setIdOrBulstat(idOrBulstat);
				setName(name);
				setIncomesMonthly(incomesMonthly);
				accountBalance = 0;
				tax =0;
				Random r=new Random();
				iban="BG12BNBG34"+r.nextLong();
			} catch (OutOfAgeException e) {
               System.out.println("Sorry,this service is declined, because the person does not have the age to get this kind of product.");
               throw new CreditNotApprovedException("Credit not approved");
			}
			
		
		}
		
		
			//getters and setters
		    public String getName() {
			   return name;
		    }

     		public void setName(String name) {
	    		this.name = name;
		    }

			public String getIdOrBulstat() {
				return idOrBulstat;
			}

			void setIdOrBulstat(String idOrBulstat) {
				this.idOrBulstat = idOrBulstat;
			}

			public double getAccountBalance() {
				return accountBalance;
			}

			public void setAccountBalance(double accountBalance) {
				this.accountBalance += accountBalance;
			}

			public int getTax() {
				return tax;
			}

			void setTax(int tax) {
				this.tax = tax;
			}


			public String getIban() {
				return iban;
			}


			public int getIncomesMonthly() {
				return incomesMonthly;
			}


			private void setIncomesMonthly(int incomesMonthly) {
				Scanner sc=new Scanner(System.in);
				while(incomesMonthly<0) {
					System.out.println("Incorrect incomes entered.Try again: ");
					incomesMonthly=sc.nextInt();
				}
				sc.close();
				this.incomesMonthly = incomesMonthly;
			}

			
	//methods
			
	 String checkIdOrBulstat(String idOrBulstat) throws OutOfAgeException {
		 boolean isWrongId=false;
	    	if(idOrBulstat.length()==ID_NUMBERS) {
	    		for (Character ch : idOrBulstat.toCharArray()) {
	    			if(!Character.isDigit(ch)) {
	    				isWrongId=true;
	    				break;
	    			}
					
				}
	    		if (!isWrongId) {
	    			checkAge(idOrBulstat);
	    			return idOrBulstat;
				}
		    }
			else if(idOrBulstat.length()==BULSTAT_NUMBER_NINE
						||idOrBulstat.length()==BULSTAT_NUMBER_THIRTEEN) {
				return idOrBulstat;
		    }
	    	isWrongId=true;
			if (isWrongId) {
				 Scanner sc=new Scanner(System.in);
			      System.out.println("Personal Id should be 10 digits.Bulstat should be 9 or 13 digits.Try again here: ");
			     idOrBulstat=sc.nextLine();
				 return checkIdOrBulstat(idOrBulstat);
			  }
			return idOrBulstat;
				
	 }
			

	String checkAge(String id) throws OutOfAgeException {
		boolean isApproved=false;
		for (int i = 0; i < id.length();) {
				
	      	if(((id.charAt(i)-'0')==MAX_DECADE&&(id.charAt(i+1)-'0')>=MAX_YEAR_OF_DECADE)
						||(id.charAt(i)-'0')>=DECADE
						||(id.charAt(i)-'0')==MIN_DECADE&&(id.charAt(i+1)-'0')==MIN_YEAR_OF_DECADE){
				isApproved=true;
				break;
			}
			else {
	 			isApproved=false;
	 			break;
			}
	    }
	    if (isApproved) {
			return id;
		}
	    else {
			throw new OutOfAgeException();
		}
	}	
}
