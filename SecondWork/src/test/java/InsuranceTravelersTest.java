import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InsuranceTravelersIssuePage;
import pages.InsuranceTravelersPage;
import pages.MainPage;

import java.util.Set;

public class InsuranceTravelersTest extends BaseTest {

    @Test
    public void insuranceTravelersTest() {
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        driver.get("https://www.sberbank.ru/ru/person");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectSubMenuItem("Страхование путешественников");

        InsuranceTravelersPage insuranceTravelersPage = new InsuranceTravelersPage(driver);
        Assert.assertEquals("Страхование путешественников",
                insuranceTravelersPage.getTitle());
        insuranceTravelersPage.selectIssue("Оформить онлайн");
        insuranceTravelersPage.clickIssueNow();
        String newWindow = (new WebDriverWait(driver, 10))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        driver.switchTo().window(newWindow);

        InsuranceTravelersIssuePage insuranceTravelersIssuePage = new InsuranceTravelersIssuePage(driver);
        insuranceTravelersIssuePage.selectAmountOfInsurance("Минимальная");
        insuranceTravelersIssuePage.clickButtonIssue();
        insuranceTravelersIssuePage.fillField("Застрахованные Фамилия", "IVANOV");
        insuranceTravelersIssuePage.fillField("Застрахованные Имя", "IVAN");
        insuranceTravelersIssuePage.fillField("Застрахованные Дата рождения", "01012000");
        insuranceTravelersIssuePage.fillField("Страхователь Фамилия", "Петров");
        insuranceTravelersIssuePage.fillField("Страхователь Имя", "Петр");
        insuranceTravelersIssuePage.fillField("Страхователь Отчество", "Петрович");
        insuranceTravelersIssuePage.fillField("Страхователь Дата рождения", "12121980");
        insuranceTravelersIssuePage.fillField("Страхователь Серия паспорта", "1111");
        insuranceTravelersIssuePage.fillField("Страхователь Номер паспорта", "222222");
        insuranceTravelersIssuePage.fillField("Страхователь Дата выдачи", "08082008");
        insuranceTravelersIssuePage.fillField("Страхователь Место выдачи", "УФМС России");

        Assert.assertEquals("IVANOV",
                insuranceTravelersIssuePage.getFillField("Застрахованные Фамилия"));
        Assert.assertEquals("IVAN",
                insuranceTravelersIssuePage.getFillField("Застрахованные Имя"));
        Assert.assertEquals("01.01.2000",
                insuranceTravelersIssuePage.getFillField("Застрахованные Дата рождения"));
        Assert.assertEquals("Петров",
                insuranceTravelersIssuePage.getFillField("Страхователь Фамилия"));
        Assert.assertEquals("Петр",
                insuranceTravelersIssuePage.getFillField("Страхователь Имя"));
        Assert.assertEquals("Петрович",
                insuranceTravelersIssuePage.getFillField("Страхователь Отчество"));
        Assert.assertEquals("12.12.1980",
                insuranceTravelersIssuePage.getFillField("Страхователь Дата рождения"));
        Assert.assertEquals("1111",
                insuranceTravelersIssuePage.getFillField("Страхователь Серия паспорта"));
        Assert.assertEquals("222222",
                insuranceTravelersIssuePage.getFillField("Страхователь Номер паспорта"));
        Assert.assertEquals("08.08.2008",
                insuranceTravelersIssuePage.getFillField("Страхователь Дата выдачи"));
        Assert.assertEquals("УФМС России",
                insuranceTravelersIssuePage.getFillField("Страхователь Место выдачи"));

        insuranceTravelersIssuePage.clickButtonContinue();
        Assert.assertEquals("Заполнены не все обязательные поля",
                insuranceTravelersIssuePage.getAlertFillFields());
    }

}
