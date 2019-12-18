import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SberTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        if (System.getProperty("os.name").contains("Mac"))
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        else
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "https://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void insuranceTest() {
        Actions actions = new Actions(driver);
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        driver.get(baseUrl);
        actions.moveToElement(
                driver.findElement(By.xpath("//div//li/button/span[contains(text(),'Страхование')]/parent::*")))
                .click()
                .moveToElement(
                        driver.findElement(By.xpath("//div//li/a[contains(text(),'Страхование путешественников')]")))
                .click().build().perform();

        Assert.assertEquals("Страхование путешественников",
                driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]")).getText());
        driver.findElement(By.xpath("//span[contains(text(),'Оформить онлайн')]/parent::*")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
                driver.findElement(By.xpath("//a[contains(text(),'Оформить сейчас')]")));

        String newWindow = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow);

        driver.findElement(By.xpath("//div[contains(text(),'Минимальная')]/parent::*")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Оформить')]")).click();

        fillField(By.name("insured0_surname"), "IVANOV");
        fillField(By.name("insured0_name"), "IVAN");
        fillField(By.name("insured0_birthDate"), "01012000");

        fillField(By.name("surname"), "Петров");
        fillField(By.name("name"), "Петр");
        fillField(By.name("middlename"), "Петрович");
        fillField(By.name("birthDate"), "12121980");
        fillField(By.xpath("//input[@placeholder='Серия']"), "1111");
        fillField(By.xpath("//input[@placeholder='Номер']"), "222222");
        fillField(By.name("issueDate"), "08082008");
        fillField(By.name("issuePlace"), "УФМС России");

        Assert.assertEquals("IVANOV", driver.findElement(By.name("insured0_surname"))
                .getAttribute("value"));
        Assert.assertEquals("IVAN", driver.findElement(By.name("insured0_name"))
                .getAttribute("value"));
        Assert.assertEquals("01.01.2000", driver.findElement(By.name("insured0_birthDate"))
                .getAttribute("value"));
        Assert.assertEquals("Петров", driver.findElement(By.name("surname"))
                .getAttribute("value"));
        Assert.assertEquals("Петр", driver.findElement(By.name("name"))
                .getAttribute("value"));
        Assert.assertEquals("Петрович", driver.findElement(By.name("middlename"))
                .getAttribute("value"));
        Assert.assertEquals("12.12.1980", driver.findElement(By.name("birthDate"))
                .getAttribute("value"));
        Assert.assertEquals("1111", driver.findElement(By.xpath("//input[@placeholder='Серия']"))
                .getAttribute("value"));
        Assert.assertEquals("222222", driver.findElement(By.xpath("//input[@placeholder='Номер']"))
                .getAttribute("value"));
        Assert.assertEquals("08.08.2008", driver.findElement(By.name("issueDate"))
                .getAttribute("value"));
        Assert.assertEquals("УФМС России", driver.findElement(By.name("issuePlace"))
                .getAttribute("value"));

        driver.findElement(By.xpath("//span[contains(text(),'Продолжить')]")).click();
        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div[contains(text(),'Заполнены не все обязательные поля')]")).getText());
    }

    private void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
