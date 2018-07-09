package tools;

public class InvalidAvailableCurrencyException extends Exception {

  private String message;
	
	public InvalidAvailableCurrencyException (String message){
		this.message=message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
