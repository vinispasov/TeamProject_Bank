package tools;

public class CreditNotApprovedException extends Exception {
	

	private String message;
	
	public CreditNotApprovedException (String message){
		this.message=message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
