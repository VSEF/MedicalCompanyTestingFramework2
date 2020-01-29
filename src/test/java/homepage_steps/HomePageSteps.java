package homepage_steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.DriverGenerating;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ResourceBundle;
import java.util.Set;

public class HomePageSteps {
    DriverGenerating driverGenerating = new DriverGenerating();
    WebDriver driver;
    ResourceBundle config = ResourceBundle.getBundle("config");
    String parentWindow;

    @When("^User enter URL - \"([^\"]*)\"$")
    public void user_enter_URL(String arg1) throws Throwable {
        driver=driverGenerating.generateDriver();
        driver.get(arg1);
        driver.manage().window().maximize();
    }

    @Then("^User should be on Home Page$")
    public void user_should_be_on_Home_Page() throws Throwable {
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(config.getString("appURL")));
    }

    @Then("^The Home Page title should be - \"([^\"]*)\"$")
    public void theHomePageTitleShouldBe(String arg0) throws Throwable {
       Assert.assertTrue(driver.getTitle().contains(arg0));
    }

    @And("^User closed Browser$")
    public void userClosedBrowser() {
        driverGenerating.closeDriver(driver);
    }

    @When("^Click on tab \"([^\"]*)\"$")
    public void click_on_tab(String arg1) throws Throwable {
       driver.findElement(By.xpath("//body/div[@class='main-menu']/div[@class='container']/ul[@class='menu']/li[2]/a[1]")).click();
    }

    @When("^Click on company logo$")
    public void click_on_company_logo() throws Throwable {
        driver.findElement(By.xpath("//header[@class='compensate-for-scrollbar']//img[2]")).click();
    }

    @When("^User click on address locator$")
    public void user_click_on_address_locator() throws Throwable {
        driver.findElement(By.xpath("//a[contains(text(),'.49/4')]")).click();
    }

    @Then("^User should be on Contact Page$")
    public void user_should_be_on_Contact_Page() throws Throwable {
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.novamed.online/contact"));
    }

    @Then("^Shopping cart should be empty$")
    public void shoppingCartShouldBeEmpty() throws Throwable {
        Assert.assertTrue(String.valueOf(driver.findElement(By.className("empty"))), true);
    }

    @When("^Click on button \"([^\"]*)\"$")
    public void click_on_button(String arg1) throws Throwable {
        driver.findElement(By.xpath("//a[@class='btn-modal btn_metrika']")).click();
        Thread.sleep(10000);
    }

    @Then("^Page for request a call back is opened$")
    public void page_for_request_a_call_back_is_opened() throws Throwable {
        Set<String> handles = driver.getWindowHandles();
        for(String handle:handles){
            if(handle.equalsIgnoreCase(parentWindow)){
                driver.switchTo().window(handle);
                Assert.assertTrue(driver.getTitle().contains("Medesk"));

            }
        }

    }

}
