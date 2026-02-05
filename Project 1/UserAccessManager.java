import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
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
			System.out.println("Loading attempt finished.");
		}
			
	}	
	//https://www.geeksforgeeks.org/dsa/binary-insertion-sort/
	/**How Does Binary insertion sort Work?

    In the binary insertion sort mode, we divide the same members into two subarrays - filtered and unfiltered. The first element of the same members is in the organized subarray, and all other elements are unplanned.
    Then we iterate from the second element to the last. In the repetition of the i-th, we make the current object our "key". This key is a feature that we should add to our existing list below.
    In order to do this, we first use a binary search on the sorted subarray below to find the location of an element larger than our key. Let's call this position “pos.” We then right shift all the elements from pos to 1 and created Array[pos] = key.

  
	 */
	
	/**Approach to implement Binary Insertion sort:
	*
	*			Iterate the array from the second element to the last element.
	*			Store the current element A[i] in a variable key.
	*			Find the position of the element just greater than A[i] in the subarray from A[0] to A[i-1] using binary search. Say this element is at index pos.
	*			Shift all the elements from index pos to i-1 towards the right.
	*			A[pos] = key.
    /
	
	
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
		
		// or add to array and then sort lowest to highest lexicographically.
	
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
		
		final boolean doesExist = false;
		int low =0;
		int high = Accounts.size() - 1;
		
		try {
			while(low<=high) 
			{
				int middle = low + (high-low)/2;
				UserAccount account = Accounts.get(middle);
				String dataUsername = account.getUser();
				
				if(dataUsername.equals(username)) 
				{	
					
					if(account.checkStatus() == isLocked)
						throw new AccountLockedException("Account is locked. Try again in a few hours.");
							
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
			
			if(!doesExist)
				throw new UserNotFoundException("Unfortunately, this given user does not exist.");
			
		}
		catch(AccountLockedException e) 
		{
			System.out.println(e.getMessage());
			return false;
		}
		catch(UserNotFoundException e) 
		{
			System.out.println(e.getMessage());
			return false;
		}
		
		
		return true;
	}
	
}
