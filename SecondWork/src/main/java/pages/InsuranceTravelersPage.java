package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceTravelersPage extends BasePage {
    private JavascriptExecutor executor;
    private Actions actions;

    @FindBy(xpath = "//h1[contains(text(),'Страхование путешественников')]")
    private WebElement title;

    @FindBy(xpath = "//ul/li/a/span")
    private WebElement buttonIssue;

    @FindBy(xpath = "//a[contains(text(),'Оформить сейчас')]")
    private WebElement buttonIssueNow;

    public InsuranceTravelersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        executor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public void selectIssue(String issue) {
        actions.moveToElement(buttonIssue)
                .moveToElement(driver.findElement(By.xpath("//span[contains(text(),'" + issue + "')]/parent::*")))
                .click().build().perform();
    }

    public void clickIssueNow() {
        executor.executeScript("arguments[0].click()", buttonIssueNow);
    }

}
