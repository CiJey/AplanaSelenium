package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class BasePageObject {
    protected WebDriver driver;

    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        driver = BaseSteps.getDriver();
    }

    public void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

}
