package clientproyectspring.clientproyectspring.exceptions;

public class ErrorMessage {
	
	private String exception;
	private String message;
	private String path;
	
	public ErrorMessage(Exception ex, String path) {
		this.exception = ex.getClass().getSimpleName();
		this.message = ex.getMessage();
		this.path = path;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
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
