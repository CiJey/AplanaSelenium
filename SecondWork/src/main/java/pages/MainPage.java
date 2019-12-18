package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private Actions actions;

    @FindBy(xpath = "//li[@class='lg-menu__item']")
    private WebElement menuItems;

    @FindBy(xpath = "//li[@class='lg-menu__sub-item']")
    private WebElement subMenuItems;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void selectMenuItem(String item) {
        actions.moveToElement(menuItems)
                .moveToElement(driver.findElement(By.xpath("//button/span[contains(text(),'" + item + "')]/parent::*")))
                .click().build().perform();
    }

    public void selectSubMenuItem(String item) {
        actions.moveToElement(subMenuItems)
                .moveToElement(driver.findElement(By.xpath("//a[contains(text(),'" + item + "')]")))
                .click().build().perform();
    }

}
