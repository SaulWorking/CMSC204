import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class UserAccessManager {
	private List<UserAccount> Accounts;
	
	public UserAccessManager() {
		Accounts = new ArrayList<>(); 
	}

	
	public void loadAccounts(String filename)throws FileNotFoundException{
		
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
