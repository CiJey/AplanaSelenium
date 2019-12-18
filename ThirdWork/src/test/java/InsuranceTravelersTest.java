import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.InsuranceTravelersIssuePageSteps;
import steps.InsuranceTravelersPageSteps;
import steps.MainPageSteps;

import java.util.HashMap;
import java.util.Set;

public class InsuranceTravelersTest extends BaseSteps {
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private InsuranceTravelersPageSteps insuranceTravelersPageSteps = new InsuranceTravelersPageSteps();
    private InsuranceTravelersIssuePageSteps insuranceTravelersIssuePageSteps = new InsuranceTravelersIssuePageSteps();

    HashMap<String, String> testData = new HashMap<>();

    @Title("Страхование путешественников")
    @Test
    public void insuranceTravelersTest() {
        final Set<String> oldWindowsSet = BaseSteps.getDriver().getWindowHandles();

        testData.put("Застрахованные Фамилия", "IVANOV");
        testData.put("Застрахованные Имя", "IVAN");
        testData.put("Застрахованные Дата рождения", "01012000");
        testData.put("Страхователь Фамилия", "Петров");
        testData.put("Страхователь Имя", "Петр");
        testData.put("Страхователь Отчество", "Петрович");
        testData.put("Страхователь Дата рождения", "12121980");
        testData.put("Страхователь Серия паспорта", "1111");
        testData.put("Страхователь Номер паспорта", "222222");
        testData.put("Страхователь Дата выдачи", "08082008");
        testData.put("Страхователь Место выдачи", "УФМС России");

        mainPageSteps.selectMenuItem("Страхование");
        mainPageSteps.selectSubMenuItem("Страхование путешественников");

        insuranceTravelersPageSteps.checkPageTitle("Страхование путешественников");
        insuranceTravelersPageSteps.selectIssue("Оформить онлайн");
        insuranceTravelersPageSteps.clickIssueNow("Оформить сейчас");
        String newWindow = (new WebDriverWait(BaseSteps.getDriver(), 10))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        BaseSteps.getDriver().switchTo().window(newWindow);

        insuranceTravelersIssuePageSteps.selectAmountOfInsurance("Минимальная");
        insuranceTravelersIssuePageSteps.clickButtonIssue("Оформить");
        insuranceTravelersIssuePageSteps.fillFields(testData);
        testData.replace("Застрахованные Дата рождения", "01.01.2000");
        testData.replace("Страхователь Дата рождения", "12.12.1980");
        testData.replace("Страхователь Дата выдачи", "08.08.2008");
        insuranceTravelersIssuePageSteps.checkFillFields(testData);
        insuranceTravelersIssuePageSteps.clickButtonContinue("Продолжить");
        insuranceTravelersIssuePageSteps.checkAlertFillFields("Заполнены не все обязательные поля");
    }

}
