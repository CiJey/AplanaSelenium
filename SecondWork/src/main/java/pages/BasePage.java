package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

}
