import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UserAccessManager manager = new UserAccessManager();
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		
		while(!userInput.equals("exit")){
			userInput = scanner.nextLine();
			System.out.println(userInput);
			checkCommand(userInput,manager);
			System.out.println("Bruh");
		}
		
		scanner.close();
	}
	

	public static void checkCommand(String userInput, UserAccessManager manager) {
		Scanner scan = new Scanner(System.in);
		String regex = "\\s+";
		String userInfo[] = userInput.split(regex);
		

		try {
			if(userInfo.length < 2)
				throw new InvalidCommandException("");
			
			String command = userInfo[0];
			String commandSpecification = userInfo[1];
				switch(command){

					case "add"->{
						System.out.println("Password:");
						String password = scan.next();
						manager.addUser(commandSpecification,Utilities.encryptPassword(password));
				
					}
				
					case "verify"->{
						System.out.println("Password:");
						String password = scan.next();
						manager.verifyAccess(commandSpecification, password);
				
					}
					
					case "load" ->{
						manager.loadAccounts(commandSpecification);
					}
		
				}	
			}catch(InvalidCommandException e) {
				System.out.println(e.getMessage());
			}catch(DuplicateUserException e) {				
				System.out.println("duplicate");
			}catch(PasswordIncorrectException e) {				
				System.out.println("Incorrect Password");
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (AccountLockedException e) {
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
		
		
		
		
	}	

}
