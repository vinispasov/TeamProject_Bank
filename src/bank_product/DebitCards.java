package bank_product;

import our_exceptions.UnderAgeException;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DebitCards extends BankCards implements
        BillsPayable,CardValidityCheckable,CashFromATMWithdrawable {
    public DebitCards(String name, String idOrBulstat, int incomesMonthly, int annualMaintenance,double withdrawTax, double cardBalance) {
            super(name, idOrBulstat, incomesMonthly, annualMaintenance,withdrawTax);
        this.cardBalance = cardBalance;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    private double cardBalance;



    public void checkClientYears(int birthYear, int birthMonth, int birthDay) throws UnderAgeException {
        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, years;

        y = cal.get(Calendar.YEAR);// current year ,
        m = cal.get(Calendar.MONTH);// current month
        d = cal.get(Calendar.DAY_OF_MONTH);//current day
        cal.set(birthYear, birthMonth, birthDay);// here client birthDate
        years = y - cal.get(Calendar.YEAR);
        if (years < AGE_OF_MAJORITY || (years == AGE_OF_MAJORITY && (m < cal.get(Calendar.MONTH))) || (years == AGE_OF_MAJORITY && (m == cal.get(Calendar.MONTH)) && (d < cal.get(Calendar.DAY_OF_MONTH)))) {
            throw new UnderAgeException("The client is under age,he cannot be approve for debit card\n");
        }else{
            System.out.printf("Client %s,is approved for debit card\n",getName());
        }
    }
    public void billsPayable(double sumNeededToPayBill) {
            if (getCardBalance() > sumNeededToPayBill) {
                System.out.printf("Client %s,pay %.2f BGN for this bill,and the available money in his/her debit card now are %.2f BGN\n ",getName(),sumNeededToPayBill, getCardBalance()-sumNeededToPayBill);
                cardBalance-=sumNeededToPayBill;
            } else {
                System.out.printf("Client %s,cannot pay with this debit card,the available money are less than the money needed to pay the bill\n",getName());
            }
    }
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
            System.out.printf("Client %s debit card is valid\n",getName());
        }else{
            System.out.printf("Client %s,debit card is expired,he/she have to reissue the card\n",getName());
        }
    }

    @Override
    public void cashFromATMWithdraw(int withdrawlSum) {
        if(getCardBalance()>withdrawlSum){
            System.out.printf("Client %s withdrawl %d BGN,and now the available money" +
                    "in his/her debit card are %.2f",getName(),withdrawlSum,getCardBalance()-withdrawlSum-getWithdrawTax());
            cardBalance=cardBalance-withdrawlSum-getWithdrawTax();
        }
    else {
            System.out.printf("Client %s,cannot withdraw %d BGN,the available money are %.2f",getName(),withdrawlSum,getCardBalance());
        }
    }
}
