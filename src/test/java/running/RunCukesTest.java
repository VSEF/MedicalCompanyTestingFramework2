package running;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/fatures", plugin =  {"pretty","html:target/html", "json:cucumber.json"})
public class RunCukesTest {
}
//glue = "src/test/java/homepage_steps/"