
public class UserAccount {
	public final int MAX_FAILURES = 3;
	private String username;
	private String encryptedPassword;
	private int failureCount;
	private boolean locked;
	
	
	public UserAccount(String username, String encryptedPassword) {
		this.username = username;
		this.encryptedPassword = encryptedPassword;
		failureCount  = 0;
		locked = false;
	}
	
	public UserAccount() {
		this("InvalidUser","");
	}
	
	public String getEncryptedPassword() throws AccountLockedException, PasswordIncorrectException {
		
		if(locked)
			throw new AccountLockedException("Cannot return password. Too many password attempts have been made.");
		
		if(encryptedPassword != "PasswordTemplateStringReadFile")
			throw new PasswordIncorrectException("Incorrect Password Entered?");
		
		return encryptedPassword;
	}
	public boolean checkPassword() {
		return false;
	}
	/**
	 * Increases the amount of failures a user has.
	 * Users have a limit of three password attempts
	 */
	public void incrementFailure() {failureCount++;}
	/**
	 * Resets user's password failure.
	 */
	public void resetFailure() {failureCount = 0;}
	/**
	 * Displays whether or not user can is locked from entering password.
	 * 
	 * @return Account status of user.
	 */
	public boolean checkStatus() {return locked;};
	
	/**
	 * 
	 */
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		
		if(obj == null) 
			return false;
		
		UserAccount clone = (UserAccount)obj;
		if(this.getClass() != clone.getClass())
			return false;
		
		boolean result = true;
		
		if(!this.username.equals(clone.username)) 
			result = false;
			
		if(!this.encryptedPassword.equals(clone.encryptedPassword))
			result = false;
			
		if(!(this.failureCount == clone.failureCount))
			result = false;
		
		if(!(this.locked = clone.locked))
			result = false;
		
			return result;
	}
	
	public String toString() {
		String userInfo;
		userInfo = username + " " + encryptedPassword + " " + failureCount;

		if(locked) {
			userInfo += " Account Locked.";
			return userInfo;
		}
		
		return userInfo;
	}
	
}
