package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceTravelersIssuePage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(),'Выберите сумму страховой защиты')]/following-sibling::div/div/div")
    private WebElement amountOfInsurance;

    @FindBy(xpath = "//span[contains(text(),'Оформить')]")
    private WebElement buttonIssue;

    @FindBy(name = "insured0_surname")
    private WebElement insuredSurname;
    @FindBy(name = "insured0_name")
    private WebElement insuredName;
    @FindBy(name = "insured0_birthDate")
    private WebElement insuredBirthDate;

    @FindBy(name = "surname")
    private WebElement surname;
    @FindBy(name = "name")
    private WebElement name;
    @FindBy(name = "middlename")
    private WebElement middlename;
    @FindBy(name = "birthDate")
    private WebElement birthDate;
    @FindBy(xpath = "//input[@placeholder='Серия']")
    private WebElement passportSeries;
    @FindBy(xpath = "//input[@placeholder='Номер']")
    private WebElement passportNumber;
    @FindBy(name = "issueDate")
    private WebElement issueDate;
    @FindBy(name = "issuePlace")
    private WebElement issuePlace;

    @FindBy(xpath = "//span[contains(text(),'Продолжить')]")
    private WebElement buttonContinue;

    @FindBy(xpath = "//div[contains(text(),'Заполнены не все обязательные поля')]")
    private WebElement alertNotAllFieldsAreFilled;

    public InsuranceTravelersIssuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectAmountOfInsurance(String amount) {
        amountOfInsurance.findElement(By.xpath(".//div[contains(text(),'" + amount + "')]/parent::*"));
    }

    public void clickButtonIssue() {
        buttonIssue.click();
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Застрахованные Фамилия":
                fillField(insuredSurname, value);
                break;
            case "Застрахованные Имя":
                fillField(insuredName, value);
                break;
            case "Застрахованные Дата рождения":
                fillField(insuredBirthDate, value);
                break;
            case "Страхователь Фамилия":
                fillField(surname, value);
                break;
            case "Страхователь Имя":
                fillField(name, value);
                break;
            case "Страхователь Отчество":
                fillField(middlename, value);
                break;
            case "Страхователь Дата рождения":
                fillField(birthDate, value);
                break;
            case "Страхователь Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Страхователь Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Страхователь Дата выдачи":
                fillField(issueDate, value);
                break;
            case "Страхователь Место выдачи":
                fillField(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице!");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Застрахованные Фамилия":
                return insuredSurname.getAttribute("value");
            case "Застрахованные Имя":
                return insuredName.getAttribute("value");
            case "Застрахованные Дата рождения":
                return insuredBirthDate.getAttribute("value");
            case "Страхователь Фамилия":
                return surname.getAttribute("value");
            case "Страхователь Имя":
                return name.getAttribute("value");
            case "Страхователь Отчество":
                return middlename.getAttribute("value");
            case "Страхователь Дата рождения":
                return birthDate.getAttribute("value");
            case "Страхователь Серия паспорта":
                return passportSeries.getAttribute("value");
            case "Страхователь Номер паспорта":
                return passportNumber.getAttribute("value");
            case "Страхователь Дата выдачи":
                return issueDate.getAttribute("value");
            case "Страхователь Место выдачи":
                return issuePlace.getAttribute("value");
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице!");
        }
    }

    public void clickButtonContinue() {
        buttonContinue.click();
    }

    public String getAlertFillFields() {
        return alertNotAllFieldsAreFilled.getText();
    }

}
