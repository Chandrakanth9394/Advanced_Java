//custom exception - step 1 create a class and use IS-A relationship
//Override the getMessage();
//throw the exception externally

package Exception;

public class DataNotFoundException extends RuntimeException {
	String message;

	public DataNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
