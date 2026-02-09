import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UserAccessManager manager = new UserAccessManager();
		Scanner scanner = new Scanner(System.in);
		String userInput = "";
		
		userInput = scanner.nextLine().trim();

		
		while(!userInput.equals("exit")){
			checkCommand(scanner, userInput,manager);
			userInput = scanner.nextLine();

		}
		
	}
	

	public static void checkCommand(Scanner scan, String userInput, UserAccessManager manager) {
		String regex = "\\s+";
		String userInfo[] = userInput.split(regex);
		

		try {
			if(userInfo.length < 2) {				
				throw new InvalidCommandException("Invalid Command");
			}
			String command = userInfo[0];
			String commandSpecification = userInfo[1];
				switch(command){

					case "add"->{
						System.out.print("Password: ");
						String password = scan.nextLine().trim();
						manager.addUser(commandSpecification,Utilities.encryptPassword(password));
						System.out.println("password Added.");
					}
						
					case "verify"->{
						System.out.print("Password: ");
						String password = scan.nextLine().trim();
						manager.verifyAccess(commandSpecification, Utilities.encryptPassword(password));
							System.out.println("Access verified");							
					}
					
					case "remove"->{
						manager.removeUser(commandSpecification);
						System.out.println(commandSpecification + " has been removed.");
					}
					
					case "load" ->{						
						manager.loadAccounts(commandSpecification);
					}
					
					default -> {						
						throw new InvalidCommandException("Invalid Command");
					}
		
				}	
			}catch(InvalidCommandException e) {
				System.out.println(e.getMessage());
			}catch(DuplicateUserException e) {				
				System.out.println(e.getMessage());
			}catch(PasswordIncorrectException e) {				
				System.out.println(e.getMessage());
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (AccountLockedException e) {
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
	}	

}
