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
    private SelenideElement accountButton;

    // кнопка 'Оформить заказ'
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;

    // текст в разделе 'Булки'
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunText;

    // раздел 'Булки'
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/..")
    private SelenideElement bunsTab;

    // текст в разделе 'Соусы'
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceText;

    // раздел 'Соусы'
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/..")
    private SelenideElement sauceTab;

    // текст в разделе 'Начинки'
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsText;

    // раздел 'Начинки'
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/..")
    private SelenideElement fillingsTab;

    @Step("Кликаем кнопку 'Войти в аккаунт'")
    public void clickAccountButton() {
        accountButton.click();
    }

    @Step("Проверяем видимость кнопки 'Оформить заказ'")
    public boolean makeOrderButtonCheck() {
        return makeOrderButton.shouldBe(visible).isDisplayed();
    }

    @Step("Кликаем на раздел 'Булки'")
    public void clickBunsTab() {
        bunText.click();
    }

    @Step("Проверяем, что раздел 'Булки' активен")
    public void bunsTabSelectedCheck() {
        bunsTab.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Кликаем на раздел 'Соусы'")
    public void clickSauceTab() {
        sauceText.click();
    }

    @Step("Проверяем, что раздел 'Соусы' активен")
    public void sauceTabSelectedCheck() {
        sauceTab.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Кликаем на раздел 'Начинки'")
    public void clickFillingsTab() {
        fillingsText.click();
    }

    @Step("Проверяем, что раздел 'Начинки' активен")
    public void fillingsTabSelectedCheck() {
        fillingsTab.shouldHave(cssClass("tab_tab_type_current__2BEPc"));
    }

}