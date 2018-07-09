package tools;

public class InvalidAddressException extends Exception{

	private String message;
	
	public InvalidAddressException (String message){
		this.message=message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
