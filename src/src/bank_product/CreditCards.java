package bank_product;
import java.util.Calendar;
import java.util.GregorianCalendar;

import tools.CreditNotApprovedException;
import tools.Entity;

public class CreditCards extends BankCards implements BillsPayable,ClientYearsCheckable,CardValidityCheckable {

	//fields
    private double creditLimit;
    private final static int FROM_PERCENT_TO_NUMBER=100;
    private final static int RATE_CREDIT_CARD=7;
    
    

    //constructor
    public CreditCards(String name, String idOrBulstat, int incomesMonthly,int annualMaintenance,double withdrawTax, double creditLimit) throws CreditNotApprovedException {
        super(name, idOrBulstat, incomesMonthly,annualMaintenance,withdrawTax);
        super.setPeriodOfProductMonthly(getPeriodValidCard());
        super.setRate(RATE_CREDIT_CARD);
        this.creditLimit = creditLimit;
    }

    //methods
    @Override
    public void billsPayable(double sumNeededToPayBill) {
            if (sumNeededToPayBill < creditLimit) {
                System.out.printf(this.getName()+"%s pay %.2f for this bill,and he has to pay %.2f to bank \n ", "", sumNeededToPayBill, sumNeededToPayBill * getRate()/FROM_PERCENT_TO_NUMBER
                +sumNeededToPayBill);
                creditLimit=creditLimit-sumNeededToPayBill-sumNeededToPayBill*getRate()/FROM_PERCENT_TO_NUMBER;
            } else {
                System.out.printf(this.getName()+"%s cannot pay with this card,the creditLimit of the card is reached\n","");
            }
            }

    @Override
    public void clientYearsCheck(int birthYear,int birthMonth,int birthDay) {
        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, years;

        y = cal.get(Calendar.YEAR);// current year ,
        m = cal.get(Calendar.MONTH);// current month
        d = cal.get(Calendar.DAY_OF_MONTH);//current day
        cal.set(birthYear, birthMonth, birthDay);// here client birthDate
        years = y - cal.get(Calendar.YEAR);
        if (years<18||(years==18&&(m < cal.get(Calendar.MONTH)))
                || (years==18&&(m == cal.get(Calendar.MONTH)) && (d < cal
                .get(Calendar.DAY_OF_MONTH)))) {
            System.out.printf(this.getName()+" %s is under age,he cannot be approve for credit card\n","");
        }else{
            System.out.printf(this.getName()+"%s is approved for credit card\n","");
        }
    }

    @Override
    public void cardValidityCheck(int validityYear, int validityMonth, int validityDay) {
        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d;

        y = cal.get(Calendar.YEAR);// current year ,
        m = cal.get(Calendar.MONTH);// current month
        d = cal.get(Calendar.DAY_OF_MONTH);//current day
        cal.set(validityYear, validityMonth, validityDay);// here client birthDate
        if (y>cal.get(Calendar.YEAR)||(y==cal.get(Calendar.YEAR)&&(m > cal.get(Calendar.MONTH)))
                || (y==cal.get(Calendar.YEAR)&&(m == cal.get(Calendar.MONTH)) && (d > cal
                .get(Calendar.DAY_OF_MONTH)))) {
            System.out.printf(this.getName()+"%s credit card is valid\n","");
        }else{
            System.out.printf(this.getName()+"%s credit card is expired,he/she cannot pay for this" +
                    "bill with this card,he/she have to reissue the card\n","");
        }
    }
    public void cashFromATMWithdraw(int withdrawalSum) {
        if(creditLimit>withdrawalSum){
            System.out.printf(this.getName()+"%s withdraw %d BGN,and now his/her credit card limit is %.2f\n"," ",withdrawalSum,creditLimit-withdrawalSum-getWithdrawTax());
            creditLimit=creditLimit-withdrawalSum-getWithdrawTax();
        }
        else {
            System.out.printf(this.getName()+"%s cannot withdraw %d BGN,his/her credit limit is %.2f\n"," ",withdrawalSum,creditLimit);
        }
    }
}
