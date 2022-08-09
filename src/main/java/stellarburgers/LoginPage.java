package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage extends HeaderPage {

    // поле ввода email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement fieldEmail;

    // поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement fieldPassword;

    // кнопка 'Войти'
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    // ссылка 'Зарегистрироваться'
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registrationLink;

    // ссылка 'Восстановить пароль'
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement passRecoveryLink;

    @Step("Проверяем видимость кнопки 'Войти' на странице авторизации")
    public boolean enterButtonCheck() {
        return enterButton.shouldBe(visible).isDisplayed();
    }

    @Step("Логиним юзера")
    public void login(String email, String password) {
        fieldEmail.setValue(email);
        fieldPassword.setValue(password);
        enterButton.click();
    }

    @Step("Кликаем ссылку 'Зарегистрироваться' на странице авторизации")
    public void clickRegistrationLink() {
        registrationLink.click();
    }

    @Step("Кликаем ссылку 'Восстановить пароль' на странице авторизации")
    public void clickPassRecoveryLink() {
        passRecoveryLink.click();
    }

}