package Exception;

public class InvalidChoiceException extends RuntimeException {
	String message;

	public InvalidChoiceException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
