
public class UserAccount
{
	public final int MAX_FAILURES = 3;
	String username;
	String encryptedPassword;
	int failureCount;
	boolean locked;
	
	
	public UserAccount(String username, String encryptedPassword)
	{
		this.username = username;
		this.encryptedPassword = encryptedPassword;
		failureCount  = 0;
		locked = false;
	}
	
	public UserAccount()
	{
		this("InvalidUser","");
	}
	
	public String getEncryptedPassword() {return encryptedPassword;}
	public String getUser() {return username;}

	/**
	 *Client user password checking 
	 * 
	 * @param password
	 * @return
	 * @throws AccountLockedException
	 * @throws PasswordIncorrectException
	 */
	public boolean checkPassword(String password) throws AccountLockedException, PasswordIncorrectException {
			if(locked)
				throw new AccountLockedException("Cannot return password. Too many password attempts have been made.");
		
			if(!Utilities.encryptPassword(password).equals(encryptedPassword)) {
				incrementFailure();
				throw new PasswordIncorrectException("Incorrect Password Entered.");
			}
		resetFailure();
		return true;
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
	
	/**
	 * Returns status of user account.
	 * 
	 * @return locked;
	 */
	public boolean checkStatus() {return locked;};
	
	/**
	 * Locks user account. 
	 */
	public void lockAccount()
	{
		if(failureCount >= 3)
			locked = true;
	}

	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		
		if(obj == null) 
			return false;
		
		UserAccount clone = (UserAccount)obj;
		if(this.getClass() != clone.getClass())
			return false;
			
		if(!this.username.equals(clone.username)) 
			return false;
		
		if(!this.encryptedPassword.equals(clone.encryptedPassword))
			return false;
			
		if(!(this.failureCount == clone.failureCount))
			return false;
		
		if(!(this.locked == clone.locked))
			return false;
		
		return true;
	}
	
	public String toString() 
	{
		String userInfo;
		userInfo = username + " " + encryptedPassword + " " + failureCount;

		if(locked)
		{
			userInfo += " Account Locked.";
			return userInfo;
		}
		return userInfo;
	}
	
}
