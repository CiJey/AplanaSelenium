import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    public Properties properties = TestProperties.getInstance().getProperties();


    @Before
    public void setUp() {
        switch (properties.getProperty("browser")){
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
