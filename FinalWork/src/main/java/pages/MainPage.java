package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePageObject {

    @FindBy(xpath = "//a[contains(text(),'Маркет')]")
    private WebElement menuItemMarket;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String item) {
        if ("Маркет".equals(item)) {
            menuItemMarket.click();
        }
    }
}
