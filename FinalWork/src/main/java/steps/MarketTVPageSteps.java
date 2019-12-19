package steps;

import org.junit.Assert;
import pages.MarketTVPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketTVPageSteps {
    private String value;

    @Step("Заголовок страницы: \"{0}\"")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new MarketTVPage().getPageTitle();
        Assert.assertTrue(String.format("Загловок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle),
                actualTitle.contains(expectedTitle));
    }

    @Step("Количество элементов на странице: \"{0}\" или меньше")
    public void getCountOfElements(int expectedCount) {
        int actualCount = new MarketTVPage().getCountOfElements();
        Assert.assertTrue(String.format("Количество элементов на странице равно [%d]. Ожидалось - [%d]",
                actualCount, expectedCount),
                expectedCount >= actualCount);
    }

    @Step("Нажатие на кнопку \"{0}\" и выбор значения \"{1}\"")
    public void clickButtonAndChoseNumber(String buttonName, int value) {
        new MarketTVPage().clickButtonAndChoseNumber(buttonName, value);
    }

    @Step("Нажатие на кнопку \"{0}\"")
    public void clickButton(String buttonName) {
        new MarketTVPage().clickButton(buttonName);
    }

    @Step("Сохранено значение элемента № \"{0}\"")
    public void saveElementWithNumber(int number) {
        value = new MarketTVPage().getElementValue(number);
    }

    @Step("В поисковую строку введено сохраненное значение")
    public void enterSavedValueInSearching() {
        new MarketTVPage().enterSavedValueInSearching(value);
    }

    @Step("Элемент № \"{0}\" соответствует сохраненному значению")
    public void elementValueEqualsSavedValue(int number) {
        String foundedElement = new MarketTVPage().getElementValue(number);
        Assert.assertTrue(String.format("Значение сохраненного элемента - [%s]. Найденного - [%s]",
                value, foundedElement),
                value.contains(foundedElement));
    }
}
