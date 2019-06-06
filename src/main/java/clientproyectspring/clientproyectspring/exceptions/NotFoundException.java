package clientproyectspring.clientproyectspring.exceptions;

public class NotFoundException extends RuntimeException{
	
	private static final String error = "404";
	
	public NotFoundException(String message) {
		super(error + " : " + message);
	}
}
