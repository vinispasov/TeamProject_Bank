package BankProduct;
import java.util.Scanner;

public abstract class BankProduct {

	private String nameOfProduct;
	private int annualInterestRate;
	private int periodOfProductMonthly;
	private int accountBalance;
	
	//constructor
	public BankProduct(String nameOfProduct, int annualInterestRate, int periodOfProductMonthly) {
		this.nameOfProduct = nameOfProduct;
		this.annualInterestRate = annualInterestRate;
		this.periodOfProductMonthly = periodOfProductMonthly;
		this.accountBalance = 0;
	}
	
	
	//getters and setters

	public String getNameOfProduct() {
		return nameOfProduct;
	}

	public void setNameOfProduct(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}

	public int getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(int annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public int getPeriodOfProductMonthly() {
		return periodOfProductMonthly;
	}

	public void setPeriodOfProductMonthly(int periodOfProductMonthly) {
		if (periodOfProductMonthly<1||periodOfProductMonthly>60) {
			Scanner sc=new Scanner(System.in);
			System.out.println("The period should be between 1 and 60 months.Try again: ");
			while(true) {
				periodOfProductMonthly=sc.nextInt();
				if (periodOfProductMonthly>=1&&periodOfProductMonthly<=60) {
					System.out.println("Correct period.");
					break;
				}
			}
		}
		this.periodOfProductMonthly = periodOfProductMonthly;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	

	
}
