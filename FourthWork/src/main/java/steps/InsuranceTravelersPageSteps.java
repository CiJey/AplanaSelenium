package steps;

import org.junit.Assert;
import pages.InsuranceTravelersPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceTravelersPageSteps {

    @Step("Заголовок страницы - {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new InsuranceTravelersPage().getTitle();
        Assert.assertTrue(String.format("Заголовок - [%s]. Ожидалось - [%s]", actualTitle, expectedTitle),
                actualTitle.contains(expectedTitle));
    }

    @Step("Выбран пункт {0}")
    public void selectIssue(String issue) {
        new InsuranceTravelersPage().selectIssue(issue);
    }

    @Step("Выполнено нажатие на {0}")
    public void clickIssueNow(String issue) {
        new InsuranceTravelersPage().clickIssueNow();
    }

}
