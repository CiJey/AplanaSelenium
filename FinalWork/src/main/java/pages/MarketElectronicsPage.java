package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketElectronicsPage extends MarketMainPage {

    @FindBy(xpath = "//h1[contains(text(),'Электроника')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[contains(text(),'Телевизоры')]")
    private WebElement menuItemTV;
    @FindBy(xpath = "//a[contains(text(),'Наушники')]")
    private WebElement menuItemHeadphones;

    public MarketElectronicsPage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getPageTitle() {
        return pageTitle.getText();
    }

    @Override
    public void selectMenuItem(String item) {
        switch (item) {
            case "Телевизоры":
                menuItemTV.click();
                break;
            case "Наушники":
                menuItemHeadphones.click();
                break;
            default:
                throw new AssertionError("Подраздел '" + item + "' не найден на странице!");
        }
    }

}
