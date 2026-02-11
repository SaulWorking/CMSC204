/**
 * Thrown if there is a duplicate user in the system.
 */
public class DuplicateUserException extends Exception {
	public DuplicateUserException(String msg) {
		super(msg);
	}
	public DuplicateUserException() {
		super("Duplicate User");
	}
}
