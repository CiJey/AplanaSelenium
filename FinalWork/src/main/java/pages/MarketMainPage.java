package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketMainPage extends BasePageObject {
    private JavascriptExecutor executor;
    private Actions actions;

    @FindBy(xpath = "//span[text()='Маркет']")
    private WebElement pageTitle;

    @FindBy(xpath = "//span[contains(text(),'Электроника')]")
    private WebElement menuItemElectronics;

    @FindBy(xpath = "//span[contains(text(),'Все фильтры')]/parent::a")
    private WebElement buttonAllFilters;

    @FindBy(id = "header-search")
    private WebElement searchInputField;
    @FindBy(xpath = "//button/*[contains(text(),'Найти')]/parent::*")
    private WebElement buttonSearch;

    public MarketMainPage() {
        PageFactory.initElements(driver, this);
        executor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void selectMenuItem(String item) {
        switch (item) {
            case "Электроника":
                menuItemElectronics.click();
                break;
            default:
                throw new AssertionError("Пункт меню '" + item + "' не найден на странице!");
        }
    }

    public void clickButtonAndChoseNumber(String buttonName, int value) {
        switch (buttonName) {
            case "Показывать по":
                WebElement buttonShowCount = driver.findElement(
                        By.xpath("//button/span[contains(text(),'Показывать по')]/parent::*"));
                actions.moveToElement(buttonShowCount).perform();
                try {
                    buttonShowCount.click();
                    WebElement element1 = driver.findElement(By.xpath("//div/span[contains(text(),'Показывать по "
                            + value + "')]/parent::*"));
                    actions.moveToElement(element1).perform();
                    element1.click();
                } catch (Exception e) {
                    clickButtonAndChoseNumber(buttonName, value);
                }
                break;
            default:
                throw new AssertionError("Кнопка '" + buttonName + "' не найдена на странице!");
        }
    }

    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Все фильтры":
                executor.executeScript("arguments[0].click()", buttonAllFilters);
                break;
            case "Найти":
                executor.executeScript("arguments[0].click()", buttonSearch);
                break;
            default:
                throw new AssertionError("Кнопка '" + buttonName + "' не найдена на странице!");
        }
    }

    public void enterSavedValueInSearching(String value) {
        searchInputField.sendKeys(value);
    }

    //Not realized
    public int getCountOfElements() {
        System.out.println("MarketMainPage");
        return 0;
    }

    public String getElementValue(int number) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(
                By.xpath("//div[contains(@class,'n-snippet-list')]/div[" + number +
                        "]//h3/a"));
        actions.moveToElement(element).perform();
        return element.getText();
    }
}
