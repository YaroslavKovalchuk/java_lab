import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
@SelectClasses({CreateFileTest.class,MyClassTest.class,PersonTest.class})
public class AllTests {
}
