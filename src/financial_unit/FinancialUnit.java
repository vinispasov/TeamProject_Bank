package financial_unit;

public class FinancialUnit {

   private String name;
   private String adress;
   private int availableCurrency;

    public FinancialUnit(){

    };

    public FinancialUnit(String name, String adress, int availableCurrency) {
        this.name = name;
        this.adress = adress;
        this.availableCurrency = availableCurrency;
    }


}
