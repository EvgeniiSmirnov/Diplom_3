package stellarburgers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends HeaderPage {

    // поля Имя и email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private ElementsCollection nameAndEmailFields;

    // поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement fieldPassword;

    // кнопка 'Зарегистрироваться'
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    // уведомление 'Некорректный пароль'
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement errorPasswordNote;

    // кнопка 'Войти'
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginButton;

    @Step("Регистрация пользователя")
    public void registration(String name, String email, String password) {
        nameAndEmailFields.get(0).setValue(name);
        nameAndEmailFields.get(1).setValue(email);
        fieldPassword.setValue(password);
        registrationButton.click();
    }

    @Step("Проверяем уведомление 'Некорректный пароль'")
    public boolean badPassNoteCheck() {
        return errorPasswordNote.isDisplayed();
    }

    @Step("Кликаем кнопку 'Войти' на странице регистрации")
    public void clickLoginButton() {
        loginButton.click();
    }
}