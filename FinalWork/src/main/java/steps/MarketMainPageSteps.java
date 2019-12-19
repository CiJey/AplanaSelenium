package steps;

import org.junit.Assert;
import pages.MarketMainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketMainPageSteps {

    @Step("Выбран раздел \"{0}\"")
    public void selectMenuItem(String item) {
        new MarketMainPage().selectMenuItem(item);
    }

    @Step("Заголовок страницы: \"{0}\"")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new MarketMainPage().getPageTitle();
        Assert.assertTrue(String.format("Загловок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle),
                actualTitle.contains(expectedTitle));
    }

}
