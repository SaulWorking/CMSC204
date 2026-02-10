public class InvalidCommandException extends Exception {
	public InvalidCommandException(String msg) {
		super(msg);
	}
	public InvalidCommandException() {
		super("Invalid command");
	}
}