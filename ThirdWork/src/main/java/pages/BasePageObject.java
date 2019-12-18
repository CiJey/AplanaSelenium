package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.BaseSteps;

public class BasePageObject {
    protected WebDriver driver = BaseSteps.getDriver();

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

}
