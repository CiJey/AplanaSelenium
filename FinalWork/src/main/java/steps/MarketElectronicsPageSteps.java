package steps;

import org.junit.Assert;
import pages.MarketElectronicsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketElectronicsPageSteps {

    @Step("Выбран раздел \"{0}\"")
    public void selectMenuItem(String item) {
        new MarketElectronicsPage().selectMenuItem(item);
    }

    @Step("Заголовок страницы: \"{0}\"")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new MarketElectronicsPage().getPageTitle();
        Assert.assertTrue(String.format("Загловок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle),
                actualTitle.contains(expectedTitle));
    }

}
