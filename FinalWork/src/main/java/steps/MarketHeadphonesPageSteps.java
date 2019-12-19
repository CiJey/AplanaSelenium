package steps;

import org.junit.Assert;
import pages.MarketHeadphonesPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketHeadphonesPageSteps {
    private String value;

    @Step("Заголовок страницы: \"{0}\"")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new MarketHeadphonesPage().getPageTitle();
        Assert.assertTrue(String.format("Загловок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle),
                actualTitle.contains(expectedTitle));
    }

    @Step("Количество элементов на странице: \"{0}\" или меньше")
    public void getCountOfElements(int expectedCount) {
        int actualCount = new MarketHeadphonesPage().getCountOfElements();
        Assert.assertTrue(String.format("Количество элементов на странице равно [%d]. Ожидалось - [%d]",
                actualCount, expectedCount),
                expectedCount >= actualCount);
    }

    @Step("Нажатие на кнопку \"{0}\" и выбор значения \"{1}\"")
    public void clickButtonAndChoseNumber(String buttonName, int value) {
        new MarketHeadphonesPage().clickButtonAndChoseNumber(buttonName, value);
    }

    @Step("Нажатие на кнопку \"{0}\"")
    public void clickButton(String buttonName) {
        new MarketHeadphonesPage().clickButton(buttonName);
    }

    @Step("Сохранено значение элемента № \"{0}\"")
    public void saveElementWithNumber(int number) {
        value = new MarketHeadphonesPage().getElementValue(number);
    }

    @Step("В поисковую строку введено сохраненное значение")
    public void enterSavedValueInSearching() {
        new MarketHeadphonesPage().enterSavedValueInSearching(value);
    }

    @Step("Элемент № \"{0}\" соответствует сохраненному значению")
    public void elementValueEqualsSavedValue(int number) {
        String foundedElement = new MarketHeadphonesPage().getElementValue(number);
        Assert.assertTrue(String.format("Значение сохраненного элемента - [%s]. Найденного - [%s]",
                value, foundedElement),
                value.contains(foundedElement));
    }
}
