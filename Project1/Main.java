import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, DuplicateUserException, InvalidCommandException {
		UserAccessManager manager = new UserAccessManager();
		manager.loadAccounts("accounts.txt");
		manager.addUser("aaaabbab", Utilities.encryptPassword("Hi"));
		manager.addUser("aaaabbab", Utilities.encryptPassword("Hi"));
		
		Scanner input = new Scanner(System.in);
		String userInput = "";

		do {
			System.out.println("input");
			userInput = input.nextLine().trim();
			
		
		}while(!userInput.equals("exit"));

		input.close();
		
		System.out.println("end");
				

	}

}
