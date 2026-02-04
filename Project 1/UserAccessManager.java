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

	
	public void loadAccounts(String filename)throws FileNotFoundException{
		File userData = new File(filename);
		
		try(Scanner reader = new Scanner(userData)){
			while(reader.hasNextLine()) {
				String username = reader.next();
				String password = reader.next();
				password = Utilities.encryptPassword(password);
				UserAccount user = new UserAccount(username,password);
			}
		}
			
	}	
	/**
	 * 
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
	
	//remove user has O(n) complexity
	public void removeUser(String username)throws UserNotFoundException, InvalidCommandException
	{
		if(!Accounts.contains(username))
			throw new UserNotFoundException("User does not exist in database.");
		
		Accounts.remove(username);
	}
	//use binary search for verificfation
	//checks account for lock
	public boolean verifyAccess(String username, String encryptedPassword)throws UserNotFoundException,  AccountLockedException, InvalidCommandException
	{
		int low =0;
		int high = Accounts.size() - 1;
		
		while(low<=high) {
			int middle = low + (low+high)/2;
			
			
		}
		
		
		return false;
	}
}
