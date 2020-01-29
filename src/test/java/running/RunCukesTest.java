package running;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/running", glue = "steps", plugin =  {"pretty","html:target/html", "json:cucumber.json"})
public class RunCukesTest {
}
