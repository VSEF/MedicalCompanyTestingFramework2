package running;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin =  {"pretty"})
public class RunCukesTest {
}
//features= "src/test/features",