

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserAccessManagerStudentTest {
	UserAccessManager manager1;
	UserAccessManager manager2;

	@BeforeEach
	void setUp() throws Exception {
		manager1 = new UserAccessManager();		
		manager2 = new UserAccessManager();

	}

	@AfterEach
	void tearDown() throws Exception {
		manager1 = null;
		manager2 = null;
	}

	@Test
	void testAddUser() {
		 assertThrows(InvalidCommandException.class,() -> 	manager1.addUser(null, null));
 		 assertThrows(InvalidCommandException.class,() -> 	manager1.addUser("", ""));
 		 try {
			manager1.addUser("hacker",Utilities.encryptPassword("fatherpro"));
		} catch (DuplicateUserException | InvalidCommandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("invalid command/duplicate user");
		}
 		 assertDoesNotThrow(() ->{
 			 manager1.verifyAccess("hacker", Utilities.encryptPassword("fatherpro"));
 		 });

 		 assertThrows(DuplicateUserException.class,() -> manager1.addUser("hacker", "sleepy"));
	}

	@Test
	void testRemoveUser() {
 		 assertDoesNotThrow(() ->{
			 manager1.addUser("toBeRemoved", Utilities.encryptPassword("remover"));
			 manager1.removeUser("toBeRemoved");
		  });
 		 
 		 assertThrows(UserNotFoundException.class,() -> manager1.verifyAccess("toBeRemoved",Utilities.encryptPassword("remover")));
	}

	@Test
	void testVerifyAccess() {
			try {
				manager1.addUser("dad",Utilities.encryptPassword("GoodPassword"));
				
			} catch (DuplicateUserException | InvalidCommandException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0; i<3; i++) {
				assertThrows(PasswordIncorrectException.class,() -> manager1.verifyAccess("dad", Utilities.encryptPassword("BadPassword")));
			}
	
			assertThrows(AccountLockedException.class,() -> manager1.verifyAccess("dad", Utilities.encryptPassword("aiw")));

		
	}

}
