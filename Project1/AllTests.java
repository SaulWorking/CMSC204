import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CommandLineIntegrationTests.class, UserAccessManagerGFATest.class, UserAccessManagerPublicTest.class,
		UserAccessManagerStudentTest.class })
public class AllTests {

}
