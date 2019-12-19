package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void startScenario() {
        switch (properties.getProperty("browser")) {
            case "firefox":
                if (System.getProperty("os.name").contains("Mac"))
                    System.setProperty("webdriver.gecko.driver",
                            properties.getProperty("mac.webdriver.gecko.driver"));
                else if (System.getProperty("os.name").contains("Win"))
                    System.setProperty("webdriver.gecko.driver",
                            properties.getProperty("win.webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                if (System.getProperty("os.name").contains("Mac"))
                    System.setProperty("webdriver.chrome.driver",
                            properties.getProperty("mac.webdriver.chrome.driver"));
                else if (System.getProperty("os.name").contains("Win"))
                    System.setProperty("webdriver.chrome.driver",
                            properties.getProperty("win.webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @After
    public void afterMethod() {
        driver.quit();
    }

}
