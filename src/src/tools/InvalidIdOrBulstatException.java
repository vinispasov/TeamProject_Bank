package tools;

public class InvalidIdOrBulstatException extends Exception {

private String message;
	
	public InvalidIdOrBulstatException (String message){
		this.message=message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
