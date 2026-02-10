
public class DuplicateUserException extends Exception {
	public DuplicateUserException(String msg) {
		super(msg);
	}
	public DuplicateUserException() {
		super("Duplicate User");
	}
}
