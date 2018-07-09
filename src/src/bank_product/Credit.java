package bank_product;
import java.util.Scanner;

import tools.AmountConditionMismatchException;
import tools.ClientRefuseContractException;
import tools.CreditNotApprovedException;
import tools.Entity;
import tools.OutOfAgeException;
import tools.PeriodConditionMismatchException;



public class Credit extends BankProduct{
	//tool numbers for some Math calculations:
    private static final double FORTY_PERCENT =0.4;
	private static final int HUNDRED = 100;
	private static final double NEGATIVE_NUMBER =-1;
	//months conditions for all physical credit products:
	private static final int MIN_MONTHS_CUSTOM = 6;
	private static final int MAX_MONTHS_CUSTOM = 120;
	private static final int MIN_MONTHS_RESIDENTIAL = 60;
	private static final int MAX_MONTHS_RESIDENTIAL = 240;
	private static final int MIN_MONTHS_STUDENT = 12;
	private static final int MAX_MONTHS_STUDENT= 60;
	private static final int MIN_MONTHS_FAST = 1;
	private static final int MAX_MONTHS_FAST = 24;
	//months conditions for all corporate credit products:
	private static final int MIN_MONTHS_BUSINESS =6;
	private static final int MAX_MONTHS_BUSINESS = 60;
	private static final int MIN_MONTHS_INVESTMENT = 12;
	private static final int MAX_MONTHS_INVESTMENT = 120;
	//amount conditions for all physical credit products:
	private static final int MIN_AMOUNT_CUSTOM =500;
	private static final int MAX_AMOUNT_CUSTOM = 40000;
	private static final int MIN_AMOUNT_RESIDENTIAL =40000;
	private static final int MAX_AMOUNT_RESIDENTIAL = 150000;
	private static final int MIN_AMOUNT_STUDENT =1000;
	private static final int MAX_AMOUNT_STUDENT=12000;
	private static final int MIN_AMOUNT_FAST = 300;
	private static final int MAX_AMOUNT_FAST = 3000;
	//amount conditions for all corporate credit products:
	private static final int MIN_AMOUNT_BUSINESS =20000;
	private static final int MAX_AMOUNT_BUSINESS = 100000;
	private static final int MIN_AMOUNT_INVESTMENT =50000;
	private static final int MAX_AMOUNT_INVESTMENT = 250000;
	//Overdraft details
	private static final int MONTHS_OVERDRAFT = 12;
	private static final int OVERDRAFT=2;

	//rates and taxes for Physical and Cooperate entities:
	private static final int PHYSICAL_TAX = 5;
	private static final int CORPORATE_TAX = 10;
	//rates for all physical credit products:
	private static final int CUSTOM_RATE=7;
	private static final int RESIDENTIAL_RATE=4;
	private static final int STUDENT_RATE=3;
	private static final int FAST_RATE=10;
	private static final int CUSTOM_OVERDRAFT_RATE=1;
	//rates for all corporate credit products:
	private static final int BUSINESS_RATE=4;
	private static final int INVESTMENT_RATE=3;
	private static final int CORPORATE_OVERDRAFT_RATE=2;
	//counter for separating the reasons for declined client:

	//reasons for declined client:
	private static final int NUMBER_3_DECLINE_CONTRACT=3;
	private static final int NUMBER_2_PHYSICAL=2;
	private static final int NUMBER_1_CORPORATE=1;
	private static final int NUMBER_0_BIG_AMOUNT_LOW_PERIOD=0;
	private static final int NUMBER_4_AMOUNT_MISMATCH =4;
	// 0-means the desire amount is too big, or the period is too small.
	//1-means, corporate entity can not get credit for physical entity.
	//2-means, physical entity can not get credit for cooperate entity.
	//3-means, client decline the contract.
	//4-means, there is amount mismatch between the desire amount and conditions for the amount for this type of credit
	
	//fields
	private double monthlyFee;
    
	
    //constructors
	//constructor for physical credit:
	public Credit(String name,int incomes,String idOrBulstat,Entity entity,CreditTypePhysical creditType,int periodOfProductMonthly,int amount) throws CreditNotApprovedException {
		super(name,idOrBulstat,incomes);
		try {
			prepareCreditDetails(entity,creditType,periodOfProductMonthly,amount,incomes,idOrBulstat);
		} catch (CreditNotApprovedException | ClientRefuseContractException | AmountConditionMismatchException | PeriodConditionMismatchException e) {
			if (getCounterReasonForCreditNotApproved()==NUMBER_1_CORPORATE) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("Sorry, cooperate entity can not get credit for physical entity.");
			}
			else if(getCounterReasonForCreditNotApproved()==NUMBER_2_PHYSICAL) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("Sorry, physical entity can not get credit for cooperate entity.");
			}
			else if (getCounterReasonForCreditNotApproved()==NUMBER_3_DECLINE_CONTRACT) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("Client decline contract.");
			}
			else if (getCounterReasonForCreditNotApproved()==NUMBER_4_AMOUNT_MISMATCH) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("There is amount mismatch between the desire amount and the conditions for the amount.");
				System.out.println();
				System.out.println("For CUSTOM credit the amount could be between: "+MIN_AMOUNT_CUSTOM+" and "+MAX_AMOUNT_CUSTOM);
				System.out.println("For RESIDENTIAL credit the amount could be between: "+MIN_AMOUNT_RESIDENTIAL+" and "+MAX_AMOUNT_RESIDENTIAL);
				System.out.println("For STUDENT credit the amount could be between: "+MIN_AMOUNT_STUDENT+" and "+MAX_AMOUNT_STUDENT);
				System.out.println("For FAST credit the amount could be between: "+MIN_AMOUNT_FAST+" and "+MAX_AMOUNT_FAST);
			}
			else if (super.getCounterReasonForCreditNotApproved()==BankProduct.NUMBER_5_PERIOD_MISMATCH) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("There is period mismatch between the desire period and the conditions for the deposit.");
				System.out.println();
				System.out.println("For CUSTOM credit the period could be between: "+MIN_MONTHS_CUSTOM+" and "+MAX_MONTHS_CUSTOM);
				System.out.println("For RESIDENTIAL credit the period could be between: "+MIN_MONTHS_RESIDENTIAL+" and "+MAX_MONTHS_RESIDENTIAL);
				System.out.println("For STUDENT credit the period could be between: "+MIN_MONTHS_STUDENT+" and "+MAX_MONTHS_STUDENT);
				System.out.println("For FAST credit the period could be between: "+MIN_MONTHS_FAST+" and "+MAX_MONTHS_FAST);
			}
			else {
				System.out.println("Credit with this conditions is declined.You can increase the period or decrease the amount and try again.");
				throw new CreditNotApprovedException("Credit not approved");
			}
		}
	}
	
	//constructor for corporate credit:
  public Credit(String name,int incomes,String idOrBulstat,Entity entity,CreditTypeCorporate creditType,int periodOfProductMonthly,int amount) throws CreditNotApprovedException{
		super(name,idOrBulstat,incomes);
		try {
			prepareCreditDetails(entity,creditType,periodOfProductMonthly,amount,incomes,idOrBulstat);
		} catch (CreditNotApprovedException | ClientRefuseContractException | AmountConditionMismatchException | PeriodConditionMismatchException e) {
			
		    if (getCounterReasonForCreditNotApproved()==NUMBER_1_CORPORATE) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("Sorry, cooperate entity can not get credit for physical entity.");
			}
			else if(getCounterReasonForCreditNotApproved()==NUMBER_2_PHYSICAL) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("Sorry, physical entity can not get credit for cooperate entity.");
			}
			else if (getCounterReasonForCreditNotApproved()==NUMBER_3_DECLINE_CONTRACT) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("Client decline contract.");
			}
			else if (getCounterReasonForCreditNotApproved()==NUMBER_4_AMOUNT_MISMATCH) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("There is amount mismatch between the desire amount and the conditions for the amount.");
				System.out.println();
				System.out.println("For BUSINESS credit the amount could be between: "+MIN_AMOUNT_BUSINESS+" and "+MAX_AMOUNT_BUSINESS);
				System.out.println("For INVESTMENT credit the amount could be between: "+MIN_AMOUNT_INVESTMENT+" and "+MAX_AMOUNT_INVESTMENT);
			}
			else if (super.getCounterReasonForCreditNotApproved()==BankProduct.NUMBER_5_PERIOD_MISMATCH) {
				setCounterReasonForCreditNotApproved(NUMBER_0_BIG_AMOUNT_LOW_PERIOD);
				System.out.println("There is period mismatch between the desire period and the conditions for the deposit.");
				System.out.println();
				System.out.println("For BUSINESS credit the period could be between: "+MIN_MONTHS_BUSINESS+" and "+MAX_MONTHS_BUSINESS);
				System.out.println("For INVESTMENT credit the period could be between: "+MIN_MONTHS_INVESTMENT+" and "+MAX_MONTHS_INVESTMENT);
				
			}
			else {
				System.out.println("Credit with this conditions is declined.You can increase the period or decrease the amount and try again.");
				throw new CreditNotApprovedException("Credit not approved.");
			}
		}
	}
	
	
	//getters and setters
	public double getMonthlyFee() {
		return monthlyFee;
	}

	//methods
	//method prepare details for physical entity:
	private void prepareCreditDetails(Entity entity,CreditTypePhysical creditType,int periodOfProductMonthly,int amount,int incomes,String idOrBulstat) throws CreditNotApprovedException,ClientRefuseContractException, AmountConditionMismatchException, PeriodConditionMismatchException {
		
		if (entity==Entity.PHYSICAL) {
			
			switch (creditType) {
			case CUSTOM:
				
			   //checking is the credit period correct;
			   periodOfProductMonthly=checkPeriod(periodOfProductMonthly,MIN_MONTHS_CUSTOM,MAX_MONTHS_CUSTOM);
			   //checking the amount
			   amount=checkDesireAmount(amount,MIN_AMOUNT_CUSTOM,MAX_AMOUNT_CUSTOM);
			   //checking details of the client
			   boolean isApprovedCustom=isApproved(periodOfProductMonthly,amount,incomes,CUSTOM_RATE,PHYSICAL_TAX,idOrBulstat);
			   
			   if (isApprovedCustom) {
				System.out.println("The credit is approved!");
				
				//setting the parameters
				super.setPeriodOfProductMonthly(periodOfProductMonthly);
				super.setRate(CUSTOM_RATE);
				super.setTax(PHYSICAL_TAX);
				double accountBalance=this.monthlyFee*super.getPeriodOfProductMonthly();
				super.setAccountBalance(accountBalance*NEGATIVE_NUMBER);
			   }
			   else {
				throw new CreditNotApprovedException("Credit not approved");
			   }
			   break;
			   
			case RESIDENTIAL:
				
				//checking is the credit period correct;
				   periodOfProductMonthly=checkPeriod(periodOfProductMonthly,MIN_MONTHS_RESIDENTIAL,MAX_MONTHS_RESIDENTIAL);
				   super.setPeriodOfProductMonthly(periodOfProductMonthly);
				   //checking the amount
				   amount=checkDesireAmount(amount,MIN_AMOUNT_RESIDENTIAL,MAX_AMOUNT_RESIDENTIAL);
				   //checking details of the client
				   boolean isApprovedResidential=isApproved(periodOfProductMonthly,amount,incomes,RESIDENTIAL_RATE,PHYSICAL_TAX,idOrBulstat);
				   
				   if (isApprovedResidential) {
					System.out.println("The credit is approved!");
					
					//setting the parameters
					super.setRate(RESIDENTIAL_RATE);
					super.setTax(PHYSICAL_TAX);
					double accountBalance=this.monthlyFee*super.getPeriodOfProductMonthly();
					super.setAccountBalance(accountBalance*NEGATIVE_NUMBER);
				   }
				   else {
					throw new CreditNotApprovedException("Credit not approved");
				   }
				   break;
			case STUDENT:
				
				//checking is the credit period correct;
				   periodOfProductMonthly=checkPeriod(periodOfProductMonthly,MIN_MONTHS_STUDENT,MAX_MONTHS_STUDENT);
				   super.setPeriodOfProductMonthly(periodOfProductMonthly);
				   //checking the amount
				   amount=checkDesireAmount(amount,MIN_AMOUNT_STUDENT,MAX_AMOUNT_STUDENT);
				   //checking details of the client
				   boolean isApprovedStudent=isApproved(periodOfProductMonthly,amount,incomes,STUDENT_RATE,PHYSICAL_TAX,idOrBulstat);
				   
				   if (isApprovedStudent) {
					System.out.println("The credit is approved!");
					
					//setting the parameters
					super.setRate(STUDENT_RATE);
					super.setTax(PHYSICAL_TAX);
					double accountBalance=this.monthlyFee*super.getPeriodOfProductMonthly();
					super.setAccountBalance(accountBalance*NEGATIVE_NUMBER);
				   }
				   else {
					throw new CreditNotApprovedException("Credit not approved");
				   }
				   break;
			case FAST:
				
				//checking is the credit period correct;
				   periodOfProductMonthly=checkPeriod(periodOfProductMonthly,MIN_MONTHS_FAST,MAX_MONTHS_FAST);
				   super.setPeriodOfProductMonthly(periodOfProductMonthly);
				   //checking the amount
				   amount=checkDesireAmount(amount,MIN_AMOUNT_FAST,MAX_AMOUNT_FAST);
				   //checking details of the client
				   boolean isApprovedFast=isApproved(periodOfProductMonthly,amount,incomes,FAST_RATE,PHYSICAL_TAX,idOrBulstat);
				   
				   if (isApprovedFast) {
					System.out.println("The credit is approved!");
					
					//setting the parameters
					super.setRate(FAST_RATE);
					super.setTax(PHYSICAL_TAX);
					double accountBalance=this.monthlyFee*super.getPeriodOfProductMonthly();
					super.setAccountBalance(accountBalance*NEGATIVE_NUMBER);
				   }
				   else {
					throw new CreditNotApprovedException("Credit not approved");
				   }
				break;

            case OVERDRAFT:
				
				//checking is the credit period correct;
				  if (periodOfProductMonthly!=MONTHS_OVERDRAFT) {
					  Scanner sc=new Scanner(System.in);
			       while(true) {
					System.out.println("Overdraft period should be 12 months.Do you want to continue with these conditions: type here 'yes' or 'no':");
					String answer=sc.nextLine().toLowerCase();
					if (answer.equals("yes")) {
						 super.setPeriodOfProductMonthly(periodOfProductMonthly);
						 sc.close();
						 break;
					}
					else if(answer.equals("no")) {
						setCounterReasonForCreditNotApproved(NUMBER_3_DECLINE_CONTRACT);
						sc.close();
						throw new ClientRefuseContractException();
					}
				   }
				}
				   //checking details of the client
				   boolean isApprovedOverdraft=isApproved(periodOfProductMonthly,incomes*OVERDRAFT,incomes,CUSTOM_OVERDRAFT_RATE,PHYSICAL_TAX,idOrBulstat);
				   
				   if (isApprovedOverdraft) {
					System.out.println("The credit is approved!");
					
					//setting the parameters
					super.setRate(CUSTOM_OVERDRAFT_RATE);
					super.setTax(PHYSICAL_TAX);
					double accountBalance=this.monthlyFee*super.getPeriodOfProductMonthly();
					super.setAccountBalance(accountBalance*NEGATIVE_NUMBER);
				   }
				   else {
					throw new CreditNotApprovedException("Credit not approved");
				   }
				break;

			default:
				break;
			}
		}
		else {
			setCounterReasonForCreditNotApproved(NUMBER_1_CORPORATE);
			throw new CreditNotApprovedException("Credit not approved");
		}	
	}
	
	//method prepare details for cooperate entity:
	
private void prepareCreditDetails(Entity entity,CreditTypeCorporate creditType,int periodOfProductMonthly,int amount,int incomes,String idOrBulstat) throws CreditNotApprovedException, ClientRefuseContractException, AmountConditionMismatchException, PeriodConditionMismatchException {
		
		if (entity==Entity.CORPORATE) {
			
			switch (creditType) {
			case BUSINESS:
				
			   //checking is the credit period correct;
			   periodOfProductMonthly=checkPeriod(periodOfProductMonthly,MIN_MONTHS_BUSINESS,MAX_MONTHS_BUSINESS);
			   super.setPeriodOfProductMonthly(periodOfProductMonthly);
			   //checking the amount
			   amount=checkDesireAmount(amount,MIN_AMOUNT_BUSINESS,MAX_AMOUNT_BUSINESS);
			   //checking details of the client
			   boolean isApprovedCustom=isApproved(periodOfProductMonthly,amount,incomes,BUSINESS_RATE,CORPORATE_TAX,idOrBulstat);
			   
			   if (isApprovedCustom) {
				System.out.println("The credit is approved!");
				
				//setting the parameters
				super.setRate(BUSINESS_RATE);
				super.setTax(CORPORATE_TAX);
				double accountBalance=this.monthlyFee*super.getPeriodOfProductMonthly();
				super.setAccountBalance(accountBalance*NEGATIVE_NUMBER);
			   }
			   else {
				throw new CreditNotApprovedException("Credit not approved");
			   }
			   break;
			   
			case INVESTMENT:
				
				//checking is the credit period correct;
				   periodOfProductMonthly=checkPeriod(periodOfProductMonthly,MIN_MONTHS_INVESTMENT,MAX_MONTHS_INVESTMENT);
				   super.setPeriodOfProductMonthly(periodOfProductMonthly);
				   //checking the amount
				   amount=checkDesireAmount(amount,MIN_AMOUNT_INVESTMENT,MAX_AMOUNT_INVESTMENT);
				   //checking details of the client
				   boolean isApprovedResidential=isApproved(periodOfProductMonthly,amount,incomes,INVESTMENT_RATE,CORPORATE_TAX,idOrBulstat);
				   
				   if (isApprovedResidential) {
					System.out.println("The credit is approved!");
					
					//setting the parameters
					super.setRate(INVESTMENT_RATE);
					super.setTax(CORPORATE_TAX);
					double accountBalance=this.monthlyFee*super.getPeriodOfProductMonthly();
					super.setAccountBalance(accountBalance*NEGATIVE_NUMBER);
				   }
				   else {
					throw new CreditNotApprovedException("Credit not approved");
				   }
				   break;
			case OVERDRAFT:
				
				//checking is the credit period correct;
				 if (periodOfProductMonthly!=MONTHS_OVERDRAFT) {
					  Scanner sc=new Scanner(System.in);
			       while(true) {
					System.out.println("Overdraft period should be 12 months.Do you want to continue with these conditions: type here 'yes' or 'no':");
					String answer=sc.nextLine().toLowerCase();
					if (answer.equals("yes")) {
						 super.setPeriodOfProductMonthly(periodOfProductMonthly);
						 sc.close();
						 break;
					}
					else if(answer.equals("no")) {
						setCounterReasonForCreditNotApproved(NUMBER_3_DECLINE_CONTRACT);
						sc.close();
						throw new ClientRefuseContractException();
					}
				   }
				}
				   //checking details of the client
				   boolean isApprovedStudent=isApproved(periodOfProductMonthly,incomes*OVERDRAFT,incomes,CORPORATE_OVERDRAFT_RATE,CORPORATE_TAX,idOrBulstat);
				   
				   if (isApprovedStudent) {
					System.out.println("The credit is approved!");
					
					//setting the parameters
					super.setRate(CORPORATE_OVERDRAFT_RATE);
					super.setTax(CORPORATE_TAX);
					double accountBalance=this.monthlyFee*super.getPeriodOfProductMonthly();
					super.setAccountBalance(accountBalance*NEGATIVE_NUMBER);
				   }
				   else {
					throw new CreditNotApprovedException("Credit not approved");
				   }
				   break;
				   
			default:
				break;
			}
		}
		else {
			setCounterReasonForCreditNotApproved(NUMBER_2_PHYSICAL);
			throw new CreditNotApprovedException("Credit not approved");
		}
		
		
	}
	
	private boolean isApproved(int periodMonths,int amount,int incomes,int rate,int tax,String idOrBulstat) {
		//find monthly fee
		double monthlyFee=amount/periodMonths;
		//find rate amount
		double rateAmount=monthlyFee*rate/HUNDRED;
		//monthly fee + rate amount-->the whole amount to pay every month
		double result=monthlyFee+rateAmount;
		
		//find if the incomes of the entity are enough for credit
		//that is the max possible fee that the entity could pay in
		double maxMonthFee=incomes*FORTY_PERCENT;
		
		if (result<=maxMonthFee) {
			double monthlyFeeWithTax=result+tax;
			this.monthlyFee=monthlyFeeWithTax;
			return true;
		}
		else {
			return false;
		}
	}
	
}
