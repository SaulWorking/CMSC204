
public class AccountLockedException extends Exception {
	public AccountLockedException(String msg) {
		super(msg);
	}
	
	public AccountLockedException() {
		super("Account is locked. You cannot access it.");
	}
}
