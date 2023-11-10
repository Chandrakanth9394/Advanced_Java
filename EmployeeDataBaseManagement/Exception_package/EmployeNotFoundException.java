package Exception;

public class EmployeNotFoundException extends RuntimeException {
	String message;

	public EmployeNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
