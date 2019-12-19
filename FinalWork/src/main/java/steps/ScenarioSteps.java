package steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

import java.util.List;

public class ScenarioSteps {
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private MarketMainPageSteps marketMainPageSteps = new MarketMainPageSteps();
    private MarketElectronicsPageSteps marketElectronicsPageSteps = new MarketElectronicsPageSteps();
    private MarketTVPageSteps marketTVPageSteps = new MarketTVPageSteps();
    private MarketHeadphonesPageSteps marketHeadphonesPageSteps = new MarketHeadphonesPageSteps();
    private MarketFiltersPageSteps marketFiltersPageSteps = new MarketFiltersPageSteps();

    @Когда("^выбран пункт меню главной страницы \"(.*)\"$")
    public void stepSelectMainPageMenuItem(String item) {
        mainPageSteps.selectMenuItem(item);
    }

    @Тогда("^заголовок страницы \"(.*)\" равен:$")
    public void stepCheckPageTitle(String title) {
        switch (title) {
            case "Маркет":
                marketMainPageSteps.checkPageTitle(title);
                break;
            case "Электроника":
                marketElectronicsPageSteps.checkPageTitle(title);
                break;
            case "Телевизоры":
                marketTVPageSteps.checkPageTitle(title);
                break;
            case "Наушники":
                marketHeadphonesPageSteps.checkPageTitle(title);
                break;
            case "Все фильтры":
                marketFiltersPageSteps.checkPageTitle(title);
                break;
            default:
                throw new AssertionError("Заголовок " + title + " не найден на странице!");
        }
    }

    @Когда("^выбран раздел страницы Маркета - \"(.*)\"$")
    public void stepSelectMarketPageMenuItem(String item) {
        marketMainPageSteps.selectMenuItem(item);
    }

    @Когда("^выбран раздел \"(.*)\" страницы \"(.*)\"$")
    public void stepSelectMarketElectronicsPageMenuItem(String item, String pageName) {
        switch (pageName) {
            case "Электроника":
                marketElectronicsPageSteps.selectMenuItem(item);
                break;
            default:
                throw new AssertionError("Страница " + pageName + " не найдена!");
        }
    }

    @Когда("^на странице \"(.*)\" выполнено нажатие на кнопку \"(.*)\" и выбрано значение \"(.*)\"$")
    public void stepClickButtonAndChoseNumber(String pageName, String buttonName, int value) {
        switch (pageName) {
            case "Телевизоры":
                marketTVPageSteps.clickButtonAndChoseNumber(buttonName, value);
                break;
            case "Наушники":
                marketHeadphonesPageSteps.clickButtonAndChoseNumber(buttonName, value);
                break;
            default:
                throw new AssertionError("Кнопка " + buttonName + " не найдена на странице!");
        }
    }

    @Когда("^выполнено нажатие на кнопку \"(.*)\" на странице \"(.*)\"$")
    public void stepClickButton(String buttonName, String pageName) {
        switch (pageName) {
            case "Телевизоры":
                marketTVPageSteps.clickButton(buttonName);
                break;
            case "Наушники":
                marketHeadphonesPageSteps.clickButton(buttonName);
                break;
            case "Все фильтры":
                marketFiltersPageSteps.clickButton(buttonName);
                break;
            default:
                throw new AssertionError("Кнопка " + buttonName + " не найдена на странице!");
        }
    }

    @Когда("^поле \"(.*)\" заполнено значением \"(.*)\"$")
    public void stepFillField(String fieldName, String value) {
        marketFiltersPageSteps.fillField(fieldName, value);
    }

    @Когда("^в разделе \"(.*)\" выбраны значения \"(.*)\"$")
    public void stepFillField(String fieldName, List<String> values) {
        marketFiltersPageSteps.fillField(fieldName, values);
    }

    @Тогда("^количество элементов на странице \"(.*)\" должно быть меньше или равно \"(.*)\"$")
    public void stepGetCountOfElements(String pageName, int expectedCount) {
        switch (pageName) {
            case "Телевизоры":
                marketTVPageSteps.getCountOfElements(expectedCount);
                break;
            case "Наушники":
                marketHeadphonesPageSteps.getCountOfElements(expectedCount);
                break;
            default:
                throw new AssertionError("Страница " + pageName + " не найдена!");
        }
    }

    @Когда("^сохранено значение элемента № \"(.*)\" на странице \"(.*)\"$")
    public void stepSaveElementValue(int number, String pageName) {
        switch (pageName) {
            case "Телевизоры":
                marketTVPageSteps.saveElementWithNumber(number);
                break;
            case "Наушники":
                marketHeadphonesPageSteps.saveElementWithNumber(number);
                break;
            default:
                throw new AssertionError("Страница " + pageName + " не найдена!");
        }
    }

    @Когда("^в поисковую строку на странице \"(.*)\" введено сохраненное значение$")
    public void stepEnterSavedValueInSearching(String pageName) {
        switch (pageName) {
            case "Телевизоры":
                marketTVPageSteps.enterSavedValueInSearching();
                break;
            case "Наушники":
                marketHeadphonesPageSteps.enterSavedValueInSearching();
                break;
            default:
                throw new AssertionError("Страница " + pageName + " не найдена!");
        }
    }

    @Тогда("^значение элемента № \"(.*)\" на странице \"(.*)\" соответствует сохраненному значению$")
    public void stepElementValueEqualsSavedValue(int number, String pageName) {
        switch (pageName) {
            case "Телевизоры":
                marketTVPageSteps.elementValueEqualsSavedValue(number);
                break;
            case "Наушники":
                marketHeadphonesPageSteps.elementValueEqualsSavedValue(number);
                break;
            default:
                throw new AssertionError("Страница " + pageName + " не найдена!");
        }
    }
}
