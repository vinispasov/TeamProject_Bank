package tools;

public class InvalidMonthlySalaryException extends Exception{


	private String message;
	
	public InvalidMonthlySalaryException (String message){
		this.message=message;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
