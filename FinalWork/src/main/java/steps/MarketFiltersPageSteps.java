package steps;

import org.junit.Assert;
import pages.MarketFiltersPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class MarketFiltersPageSteps {

    @Step("Заголовок страницы: \"{0}\"")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new MarketFiltersPage().getPageTitle();
        Assert.assertTrue(String.format("Загловок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle),
                actualTitle.contains(expectedTitle));
    }

    @Step("Нажатие на кнопку \"{0}\"")
    public void clickButton(String buttonName) {
        new MarketFiltersPage().clickButton(buttonName);
    }

    @Step("Поле \"{0}\" заполненое значением \"{1}\"")
    public void fillField(String fieldName, String value) {
        new MarketFiltersPage().fillField(fieldName, value);
    }

    @Step("В подразделе \"{0}\" выбраны значения \"{1}\"")
    public void fillField(String filedName, List<String> values) {
        new MarketFiltersPage().fillField(filedName, values);
    }
}
