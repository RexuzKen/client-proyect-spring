package clientproyectspring.clientproyectspring.exceptions;

public class ClientNotFoundException extends NotFoundException{

	private static final String error = "Client not found";
	
	public ClientNotFoundException(String att, String value) {
		super(error + " with " + att + " : " + value);
	}

	
}
