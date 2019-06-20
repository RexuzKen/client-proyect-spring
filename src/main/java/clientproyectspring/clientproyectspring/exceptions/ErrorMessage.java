package clientproyectspring.clientproyectspring.exceptions;

public class ErrorMessage {
	
	private String error;
	private String message;
	private String path;
	
	public ErrorMessage(Exception ex, String path) {
		this.error = ex.getClass().getSimpleName();
		this.message = ex.getMessage();
		this.path = path;
	}
	
	public ErrorMessage(String error, String message, String path) {
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
