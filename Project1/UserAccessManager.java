import java.util.Scanner;


import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * Manager class that provides methods for managing users.
 */
public class UserAccessManager
{
	/**
	 * Comparison variable. To be used for comparison readability
	 */
	private static final boolean isLocked = true;
	
	/**
	 * List of accounts.
	 */
	private List<UserAccount> Accounts;
	
	/**
	 * Initializes Accounts list with an array list
	 */
	public UserAccessManager()
	{
		Accounts = new ArrayList<>(); 
	}

	/**
	 * This method loads all user accounts from a .txt file. 
	 * 
	 * 
	 * @param filename file to be opened
	 * @throws FileNotFoundException exception thrown if file is not found
	 */
	public void loadAccounts(String filename)throws FileNotFoundException
	{
			File dataFile = new File(filename);
			if(!dataFile.exists())
				throw new FileNotFoundException("Unable to load file: " + filename);
			
			Scanner reader = new Scanner(dataFile);
			
			while(reader.hasNextLine()) 
			{
				//https://www.w3schools.com/java/ref_string_split.asp
				String regex = "\\s+";
				String  data = reader.nextLine().trim();
				
				String userInfo[] = data.split(regex);
				
				String username = userInfo[0];
				String encryptedPassword = userInfo[1];
				
				UserAccount userAccount = new UserAccount(username,encryptedPassword);
				Accounts.add(userAccount);
			}
			reader.close();
		}

	
	
	/**
	 * This method adds users to the the UserAccessManager Accounts list.
	 * It assumes the users are already sorted.
	 * 
	 * @param username user to be added
	 * @param encryptedPassword encrpyt password before adding
	 * @throws DuplicateUserException thrown if there is a duplicate user
	 * @throws InvalidCommandException thrown if username or encrypted password is null/empty
	 */
	public void addUser(String username, String encryptedPassword)throws DuplicateUserException,InvalidCommandException
	{	
		if(username == null || username.isEmpty() || encryptedPassword == null || encryptedPassword.isEmpty())
			throw new InvalidCommandException("Cannot add invalid user.");
		
		for(UserAccount user : Accounts)
		{
			if(user.getUser().equals(username))
			{
				throw new DuplicateUserException("User " + "\'" + user.getUser() + "\' " + "already exists");
			}
		}
		Accounts.add(new UserAccount(username,encryptedPassword));
	}
	
	

	/**
	 * This removes a given user from the UserAccessManager Accounts list.
	 * 
	 * @param username user to be removed
	 * @throws UserNotFoundException thrown if there is a user not found
	 * @throws InvalidCommandException thrown if username or encrypted password is null/empty
	 */
	public void removeUser(String username)throws UserNotFoundException, InvalidCommandException
	{
		if(username == null || username.isEmpty())
			throw new InvalidCommandException("Enter a valid user to remove.");
			
		int userIndex = linearSearch(username);
		
		if(userIndex == -1)
			throw new UserNotFoundException("Unable to remove invalid user: " + username);
		
		Accounts.remove(userIndex);
	}
	

																																
	/**
	 * Checks if a given password and username is valid in the Accounts list.
	 *
	 * @param username user to be verified
	 * @param encryptedPassword password encrypted by Utilities method
	 * @return returns the access status of the user.
	 * @throws UserNotFoundException
	 * @throws AccountLockedException
	 * @throws InvalidCommandException
	 */
	public boolean verifyAccess(String username, String encryptedPassword)throws InvalidCommandException,  UserNotFoundException, AccountLockedException, PasswordIncorrectException
	{	
		int userIndex = linearSearch(username);

			if(username == null || username.isEmpty() || encryptedPassword == null || encryptedPassword.isEmpty()) 
				throw new InvalidCommandException("Cannot add verify incorrect user.");
		
			if(userIndex == -1) 
				throw new UserNotFoundException(username + " " + "not found");	
			
			UserAccount user = Accounts.get(userIndex);

			if(user.checkStatus() == isLocked)
				throw new AccountLockedException("error: Unable to verify locked account: " + username);
			
			if(!encryptedPassword.equals(user.getEncryptedPassword()))
			{
				user.incrementFailure();
				
				if(user.failureCount >= 3)
					user.lockAccount(); 
			
				throw new PasswordIncorrectException("Cannot verify incorrect password.");
			}
		
		user.resetFailure();
		return true;
	}
	
	/**
	 * Checks for existence of a user in the Accounts list.
	 * Returns -1 if user doesn't exist. 
	 * 
	 * @param username user to be searched
	 * @return index of user in Accounts list.
	 */
	public int linearSearch(String username)
	{
		for(int index=0; index<Accounts.size();index++) 
		{
			UserAccount user = Accounts.get(index);
			if(username.equals(user.getUser()))
				return index;	
		}
		return -1;
	}
}
