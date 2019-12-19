package steps;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ScenarioSteps {
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private InsuranceTravelersPageSteps insuranceTravelersPageSteps = new InsuranceTravelersPageSteps();
    private InsuranceTravelersIssuePageSteps insuranceTravelersIssuePageSteps = new InsuranceTravelersIssuePageSteps();
    final Set<String> oldWindowsSet = BaseSteps.getDriver().getWindowHandles();

    @Когда("^выбран пункт меню \"(.*)\"$")
    public void selectMenuItem(String item) {
        mainPageSteps.selectMenuItem(item);
    }

    @Когда("^выбран подпункт \"(.*)\"$")
    public void selectSubMenuItem(String item) {
        mainPageSteps.selectSubMenuItem(item);
    }

    @Тогда("^заголовок страницы - \"(.*)\"$")
    public void checkPageTitle(String title) {
        insuranceTravelersPageSteps.checkPageTitle(title);
    }

    @Когда("^выбран пункт \"(.*)\"$")
    public void selectIssue(String issue) {
        insuranceTravelersPageSteps.selectIssue(issue);
    }

    @Когда("^выполнено нажатие на кнопку \"(.*)\"$")
    public void clickIssueNow(String buttonName) {
        switch (buttonName) {
            case "Оформить сейчас":
                insuranceTravelersPageSteps.clickIssueNow(buttonName);
                break;
            case "Оформить":
                insuranceTravelersIssuePageSteps.clickButtonIssue(buttonName);
                break;
            case "Продолжить":
                insuranceTravelersIssuePageSteps.clickButtonContinue(buttonName);
                break;
            default:
                throw new AssertionError("Кнопка " + buttonName + " не найдена на странице!");
        }
    }

    @Тогда("^произошло переключение на открывшуюся вкладку$")
    public void switchToNewTab() {
        String newWindow = (
                new WebDriverWait(BaseSteps.getDriver(), 10))
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );
        BaseSteps.getDriver().switchTo().window(newWindow);
    }

    @Когда("^выбрана \"(.*)\" сумма страхования$")
    public void selectAmountOfInsurance(String amount) {
        insuranceTravelersIssuePageSteps.selectAmountOfInsurance(amount);
    }

    @Когда("^заполняются поля:$")
    public void fillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(insuranceTravelersIssuePageSteps::fillField);
    }

    @Тогда("^значения полей равны:$")
    public void checkFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(insuranceTravelersIssuePageSteps::checkFillField);
    }

    @Тогда("^появилось сообщение \"(.*)\"$")
    public void checkAlertFillFields(String alert) {
        insuranceTravelersIssuePageSteps.checkAlertFillFields(alert);
    }

}
