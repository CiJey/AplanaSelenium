package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketFiltersPage extends MarketMainPage {

    @FindBy(xpath = "//h1[contains(text(),'Все фильтры')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//span[contains(text(),'Показать подходящие')]/parent::*")
    private WebElement buttonShowFiltered;

    @FindBy(name = "glf-pricefrom-var")
    private WebElement inputFieldPriceFrom;

    private void manufacturer(List<String> values) {
        for (String s : values) {
            driver.findElement(
                    By.xpath("//label[text()='" + s + "']/parent::*"))
                    .click();
        }
    }

    public MarketFiltersPage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getPageTitle() {
        return pageTitle.getText();
    }

    @Override
    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Показать подходящие":
                buttonShowFiltered.click();
                break;
            default:
                throw new AssertionError("Кнопка '" + buttonName + "' не найдена на странице!");
        }
    }

    public void fillField(String field, String value) {
        switch (field) {
            case "Цена, от":
                fillField(inputFieldPriceFrom, value);
                break;
            default:
                throw new AssertionError("Поле '" + field + "' не найдено на странице!");
        }
    }

    public void fillField(String field, List<String> values) {
        switch (field) {
            case "Производитель":
                manufacturer(values);
                break;
            default:
                throw new AssertionError("Поле '" + field + "' не найдено на странице!");
        }
    }

}
