package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;

public class MainPage extends HeaderPage {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    // кнопка 'Войти в аккаунт'
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    public static SelenideElement accountButton;

    @Step("Кликаем кнопку 'Войти в аккаунт'")
    public void clickAccountButton() {
        accountButton.click();
    }

    // кнопка 'Оформить заказ'
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public static SelenideElement makeOrderButton;

    @Step("Проверяем видимость кнопки 'Оформить заказ'")
    public boolean makeOrderButtonCheck() {
        return makeOrderButton.shouldBe(visible).isDisplayed();
    }

    @Step("Кликаем кнопку 'Оформить заказ'")
    public void clickMakeOrderButton() {
        makeOrderButton.click();
    }

    // текст в разделе 'Булки'
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    public static SelenideElement bunText;

    // раздел 'Булки'
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/..")
    public static SelenideElement bunsTab;

    @Step("Кликаем на раздел 'Булки'")
    public void clickBunsTab() {
        bunText.click();
    }

    @Step("Проверяем, что раздел 'Булки' активен")
    public void bunsTabSelectedCheck() {
        bunsTab.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    // текст в разделе 'Соусы'
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    public static SelenideElement sauceText;

    // раздел 'Соусы'
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/..")
    public static SelenideElement sauceTab;

    @Step("Кликаем на раздел 'Соусы'")
    public void clickSauceTab() {
        sauceText.click();
    }

    @Step("Проверяем, что раздел 'Соусы' активен")
    public void sauceTabSelectedCheck() {
        sauceTab.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    // текст в разделе 'Начинки'
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    public static SelenideElement fillingsText;

    // раздел 'Начинки'
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/..")
    public static SelenideElement fillingsTab;

    @Step("Кликаем на раздел 'Начинки'")
    public void clickFillingsTab() {
        fillingsText.click();
    }

    @Step("Проверяем, что раздел 'Начинки' активен")
    public void fillingsTabSelectedCheck() {
        fillingsTab.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

}