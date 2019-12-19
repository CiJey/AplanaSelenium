package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPageSteps {

    @Step("Выбран пункто меню {0}")
    public void selectMenuItem(String item) {
        new MainPage().selectMenuItem(item);
    }

    @Step("Выбран подпункт {0}")
    public void selectSubMenuItem(String item) {
        new MainPage().selectSubMenuItem(item);
    }

}
