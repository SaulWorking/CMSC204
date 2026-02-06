import java.util.Scanner;


import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class UserAccessManager
{
	private final boolean isLocked = true;
	private List<UserAccount> Accounts;
	
	public  void checkCommand(String userInput) throws InvalidCommandException{
		Scanner commandInput = new Scanner(System.in);
		String userCommand = "";
		
		String regex = "\\s+";

		String userInfo[] = userInput.split(regex);
		
		if(userInfo.length < 2 && !userInfo[0].equals("exit"))
				throw new InvalidCommandException("");
		
		String command = userInfo[0];
		String commandUsage = userInfo[1];
		
		switch(command) {
		
			case "add"->{
				System.out.println("Password:");
				userCommand = commandInput.nextLine();
				addUser(
				
			}case "remove"->{
				
			}
				
				
			
			
		}
		
		System.out.println("looks like you added  " + command + " " + commandUsage);
		
	}
	
	public static void main(String[] args) throws InvalidCommandException {
		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		
		while(!userInput.equals("exit")) {
			userInput = input.nextLine().trim();
			checkCommand(userInput);
		}
		
	}
	
	public UserAccessManager()
	{
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
	public void loadAccounts(String filename)throws FileNotFoundException
	{
		try 
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
		catch(FileNotFoundException e)
		{	
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Finished loading all users.");
		}
			
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
		try
		{
			if(username == null || username.equals("") || encryptedPassword == null || encryptedPassword.equals(""))
				throw new InvalidCommandException("Cannot add invalid user.");
					
			if(Accounts.contains(new UserAccount(username,encryptedPassword)))
				throw new DuplicateUserException("Cannot add duplicate user.");
			
			
		}
		catch(DuplicateUserException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidCommandException e) 
		{
			System.out.println(e.getMessage());
		}
				
		

				for(int  i =0; i<Accounts.size();i++) 
				{
					String dataUser = Accounts.get(i).getUser();
					if(username.compareTo(dataUser) < 0) 
					{
						Accounts.add(i,new UserAccount(username,encryptedPassword));
						break;
					}
				}	
			
				
				
			for(int i =0; i<Accounts.size();i++) 
			{
				System.out.print(Accounts.get(i).getUser() + " ");
			}
			System.out.println('\n');
		
	}
	
	

	/**
	 * This removes a given user from the UserAccessManager Accounts list.
	 * @param username
	 * @throws UserNotFoundException
	 * @throws InvalidCommandException
	 */
	public void removeUser(String username)throws UserNotFoundException, InvalidCommandException
	{
		if(username == null || username.equals(""))
			throw new InvalidCommandException("Enter a valid user to remove.");
		
		int userIndex = binarySearch(username);
		
		if(userIndex == -1)
			throw new UserNotFoundException("Unable to remove invalid user.");

		UserAccount accountToRemove = Accounts.get(userIndex);

		Accounts.remove(accountToRemove);
	}
	
	//use binary search for 
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
		
		try 
		{
			if(username == null || username.equals("") || encryptedPassword == null || encryptedPassword.equals(""))
				throw new InvalidCommandException("Cannot add invalid user.");
			
			int userIndex = binarySearch(username);
			
			if(userIndex == -1) 
				throw new UserNotFoundException("Unable to verify invalid user.");
			
			UserAccount user = Accounts.get(userIndex);
			
			if(user.checkStatus() == isLocked)
				throw new AccountLockedException("Unable to verify locked account.");
		}
		catch(InvalidCommandException e)
		{
				System.out.println(e.getMessage());
				return false;
		}
		catch(UserNotFoundException e)
		{
				System.out.println(e.getMessage());
				return false;	
		}
		catch(AccountLockedException e) 
		{
				System.out.println(e.getMessage());
				return false;
		}
		
		return true;
	}
	
	public int binarySearch(String username) {
		int low = 0;
		int high = Accounts.size() - 1;
		
		while(low<=high)
		{
			int middle = low +(high-low)/2;			
				UserAccount account = Accounts.get(middle);
				String dataUsername = account.getUser();
				
				if(dataUsername.equals(username)) 
				{	
					return middle;
				}
				else if(dataUsername.compareTo(username) < 0)
				{
					low = middle + 1;
				}				
				else 
				{
					high = middle - 1;
				}	
		}
		return -1;
	}

	
}
