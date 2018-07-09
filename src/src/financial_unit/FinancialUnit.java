package financial_unit;
import java.util.Scanner;
import tools.InvalidAddressException;
import tools.InvalidAvailableCurrencyException;
import tools.OutOfCurrencyException;

public abstract class FinancialUnit {

	//fields
    private static final int MIN_SIZE_OF_NAME = 2;
    private static final int MIN_SIZE_OF_ADDRESS = 5;
    private static final int MAX_SIZE_OF_NAME = 40;
    private static final int MAX_SIZE_OF_ADDRESS = 70;
	private String name;
    private String address;
	private int availableCurrency;



    


	
 //constructor
	public FinancialUnit(String name, String address, int availableCurrency) {

	    try {
			setName(name);
			setAddress(address);
			setAvailableCurrency(availableCurrency);
		} catch (InvalidAddressException | InvalidAvailableCurrencyException e) {
			System.out.println(e.getMessage());
		}
		
	}

	//getters and setters
    public String getName() {
        return name;
    }

    public static int getMinSizeOfName() {
		return MIN_SIZE_OF_NAME;
	}


    // Name must be of only alphabet characters
    
	public void setName(String name) {
		boolean containDigit=true;
		   Scanner sc=new Scanner(System.in);
		   
			while(containDigit||name.isEmpty()||name==null||name.length()<getMinSizeOfName()) {
				containDigit=false;
			 for (Character ch : name.toCharArray()) {
				 if (ch==' ') {
					continue;
				}
				if (!Character.isAlphabetic(ch)) {
					containDigit=true;
					break;
				}
			 }
			    if (containDigit||name.isEmpty()||name==null||name.length()<getMinSizeOfName()) {
			    	System.out.println("Invalid name entered.Try again:");
			    		name=sc.nextLine();
			    	containDigit=true;
				}
			}
		
		this.name=name;
	}
    
    public String getAddress() {
        return address;
    }


    // Address must be of only alphanumeric characters and be no longer than 50 symbols.
    public void setAddress(String address) throws InvalidAddressException {
			    if (address.isEmpty()||address==null||address.length()<MIN_SIZE_OF_ADDRESS
			    		||address.length()>MAX_SIZE_OF_ADDRESS) {
			    	throw new InvalidAddressException("Invalid address.");
				}
   		this.address = address;
    }

    public int getAvailableCurrency() {
        return availableCurrency;

    }

    // Available currency must be of only numeric characters.
    public abstract void setAvailableCurrency(int availableCurrency) throws InvalidAvailableCurrencyException;



    void setCorrectAvailableCurrency(int availableCurrency) {
        this.availableCurrency += availableCurrency;
    }


	public static int getMaxSizeOfName() {
		return MAX_SIZE_OF_NAME;
	}

}