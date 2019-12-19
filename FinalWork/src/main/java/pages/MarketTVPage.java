package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketTVPage extends MarketMainPage {

    @FindBy(xpath = "//h1[contains(text(),'Телевизоры')]")
    private WebElement pageTitle;

    public MarketTVPage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getPageTitle() {
        return pageTitle.getText();
    }

    @Override
    public int getCountOfElements() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElements(
                By.xpath("//div[contains(@class,'n-snippet-list')]/div[contains(@class,'n-snippet-card2')]"))
                .size();
    }
}
