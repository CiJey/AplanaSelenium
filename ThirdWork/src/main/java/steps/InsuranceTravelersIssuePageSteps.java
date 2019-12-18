package steps;

import org.junit.Assert;
import pages.InsuranceTravelersIssuePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class InsuranceTravelersIssuePageSteps {

    @Step("Выбрана сумма страховой защиты - {0}")
    public void selectAmountOfInsurance(String amount) {
        new InsuranceTravelersIssuePage().selectAmountOfInsurance(amount);
    }

    @Step("Выполнено нажатие на кнопку {0}")
    public void clickButtonIssue(String button) {
        new InsuranceTravelersIssuePage().clickButtonIssue();
    }

    @Step("Заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach(this::fillField);
    }

    @Step("Поле {0} заполняется значением {1}")
    public void fillField(String fieldName, String value) {
        new InsuranceTravelersIssuePage().fillField(fieldName, value);
    }

    @Step("Поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value) {
        String actual = new InsuranceTravelersIssuePage().getFillField(field);
        Assert.assertEquals(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual, value);
    }

    @Step("Поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach(this::checkFillField);
    }

    @Step("Выполено нажатие на {0}")
    public void clickButtonContinue(String button) {
        new InsuranceTravelersIssuePage().clickButtonContinue();
    }

    @Step("Появилось сообщение: {0}")
    public void checkAlertFillFields(String alert) {
        String actualAlert = new InsuranceTravelersIssuePage().getAlertFillFields();
        Assert.assertEquals(actualAlert, alert);
    }
}
