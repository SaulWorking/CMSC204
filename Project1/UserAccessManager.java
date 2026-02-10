import java.util.Scanner;


import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class UserAccessManager
{
	private final boolean isLocked = true;
	private List<UserAccount> Accounts;
	

	public UserAccessManager()
	{
		Accounts = new ArrayList<>(); 
	}

	/*
	 * This method loads all user accounts from a .txt file. This the file's format.
	 * User, EncrpytedPassword
	 * User, EncrpytedPassword
	 * 
	 * @param filename 
	 * @throws FileNotFoundException
	 */
	public void loadAccounts(String filename)throws FileNotFoundException
	{
			File dataFile= new File(filename);
			if(!dataFile.exists())
				throw new FileNotFoundException("Unable to load invalid file");
			
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
	 * @param username
	 * @param encryptedPassword
	 * @throws DuplicateUserException
	 * @throws InvalidCommandException
	 */
	public void addUser(String username, String encryptedPassword)throws DuplicateUserException,InvalidCommandException
	{	
		if(username == null || username.isEmpty() || encryptedPassword == null || encryptedPassword.isEmpty())
			throw new InvalidCommandException("Cannot add invalid user.");
		
		for(UserAccount user : Accounts)
		{
			if(user.getUser().equals(username))
			{
				throw new DuplicateUserException("Cannot add duplicate user.");
			}
		}
		Accounts.add(new UserAccount(username,encryptedPassword));
	}
	
	

	/**
	 * This removes a given user from the UserAccessManager Accounts list.
	 * 
	 * @param username
	 * @throws UserNotFoundException
	 * @throws InvalidCommandException
	 */
	public void removeUser(String username)throws UserNotFoundException, InvalidCommandException
	{
		if(username == null || username.isEmpty())
			throw new InvalidCommandException("Enter a valid user to remove.");
			
		int userIndex = linearSearch(username);
		
		if(userIndex == -1)
			throw new UserNotFoundException("Unable to remove invalid user.");
		
		Accounts.remove(userIndex);
	}
	
	//use binary search for 
	//checks account for lock
																																
	/**
	 * Checks if a given password and username is valid in the Accounts list.
	 *
	 * @param username
	 * @param encryptedPassword
	 * @return Returns the access status of the user.
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
				throw new AccountLockedException("error: Unable to verify locked account.");
			
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
