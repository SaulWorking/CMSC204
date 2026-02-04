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
		File userData = new File("accounts.txt");
		
		try(Scanner reader = new Scanner(userData)){
			while(reader.hasNextLine()) {
				String username = reader.next();
				String password = reader.next();
				password = Utilities.encryptPassword(password);
				UserAccount user = new UserAccount(username,password);
			}
		}
			
			
		
	}	

	public void addUser(String username, String encryptedPassword)throws DuplicateUserException,InvalidCommandException{
	
	}
	public void removeUser(String username)throws UserNotFoundException, InvalidCommandException{
	
	}
	public boolean verifyAccess(String username, String encryptedPassword)throws UserNotFoundException,  AccountLockedException, InvalidCommandException
	{
		return false;
	}
}
