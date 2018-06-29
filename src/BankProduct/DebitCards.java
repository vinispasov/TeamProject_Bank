package BankProduct;

import BankProduct.BankProduct;

public class DebitCards extends BankProduct {


    private int debitCardIssuance;
    private int debitCardAccountMaintenance;
    private int cashWithdrawalFromATM;
    public DebitCards() {
    }



    public DebitCards(int debitCardIssuance, int debitCardAccountMaintenance, int cashWithdrawalFromATM) {
        this.debitCardIssuance = debitCardIssuance;
        this.debitCardAccountMaintenance = debitCardAccountMaintenance;
        this.cashWithdrawalFromATM = cashWithdrawalFromATM;
    }
}
