import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class UserAccessManager {
	private List<UserAccount> Accounts;
	
	public UserAccessManager() {
		Accounts = new ArrayList<>(); 
	}

	/*
	 * This method loads all user accounts from a txt file. This the file's format.
	 * User, EncrpytedPassword
	 * User, EncrpytedPassword
	 * 
	 * @param filename 
	 * @throws FileNotFoundException
	 */
	public void loadAccounts(String filename)throws FileNotFoundException{
		try {		
			File dataFile= new File(filename);
			Scanner reader = new Scanner(dataFile);
			
			while(reader.hasNextLine()) {
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
		}catch(FileNotFoundException e) {	
			System.out.println(e.getMessage());
		}finally {
			System.out.println("finished loading accounts.");
		}
			
	}	
	/**
	 * This method adds users to the the UserAccessManager Accounts list.
	 * 
	 * @param username
	 * @param encryptedPassword
	 * @throws DuplicateUserException
	 * @throws InvalidCommandException
	 */
	public void addUser(String username, String encryptedPassword)throws DuplicateUserException,InvalidCommandException
	{
		
		//use binary sort to insert username alphabetically
		if(Accounts.contains(username))
			throw new DuplicateUserException("Username already taken.");
		
		Accounts.add(new UserAccount(username,encryptedPassword));
	}

	/**
	 * This removes a given user from the UserAccessManager Accounts list.
	 * @param username
	 * @throws UserNotFoundException
	 * @throws InvalidCommandException
	 */
	public void removeUser(String username)throws UserNotFoundException, InvalidCommandException
	{
		if(!Accounts.contains(username))
			throw new UserNotFoundException("User does not exist in database.");
		
		Accounts.remove(username);
	}
	//use binary search for verificfation
	//checks account for lock
	
	/**
	 *
	 * @param username
	 * @param encryptedPassword
	 * @return Returns the access status of the user.
	 * @throws UserNotFoundException
	 * @throws AccountLockedException
	 * @throws InvalidCommandException
	 */
	public boolean verifyAccess(String username, String encryptedPassword)throws UserNotFoundException,  AccountLockedException, InvalidCommandException
	{
		boolean canAccess = false;
		int low =0;
		int high = Accounts.size() - 1;
		
		while(low<=high) {
			int middle = low + (low+high)/2;
			
			
		}
		
		
		return canAccess;
	}
}
