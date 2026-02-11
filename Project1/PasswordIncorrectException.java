/**
 * Thrown if password attempt is incorrect.
 */
public class PasswordIncorrectException extends Exception {
	public PasswordIncorrectException(String msg) {
		super(msg);
	}
	public PasswordIncorrectException() {
		super("Incorrect Password");
	}
}
