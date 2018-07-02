package financial_unit;
import bank_product.Credit;
import bank_product.Deposit;
import java.util.List;
import tools.Entity;

public class Client extends FinancialUnit {

    private int monthlySalary;
    private double money;
    private Entity entity;
    private List<Credit>creditList;
    private List<Deposit>depositList;



}
