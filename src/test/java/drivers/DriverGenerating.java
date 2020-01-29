package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ResourceBundle;

public class DriverGenerating {

    public WebDriver generateDriver(){
        WebDriver driver;
        ResourceBundle config = ResourceBundle.getBundle("config");
        if(config.getString("browser").equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
            driver = new ChromeDriver();
        }else if(config.getString("browser").equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver");
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
            driver = new ChromeDriver();
        }
    //    driver.get(config.getString("appURL"));
        return driver;
    }

    public void closeDriver(WebDriver driver){
        driver.quit();
    }

}
