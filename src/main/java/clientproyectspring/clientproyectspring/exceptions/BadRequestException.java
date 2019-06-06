package clientproyectspring.clientproyectspring.exceptions;

public class BadRequestException extends RuntimeException{
	
	private static final String error = "400";
	
	public BadRequestException(String message) {
		super(error + "  "+ message);
	}
}
