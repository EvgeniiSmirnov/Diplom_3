package stellarburgers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends HeaderPage {

    // поля Имя и email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    public static ElementsCollection nameAndEmailFields;

    // поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public static SelenideElement fieldPassword;

    // кнопка 'Зарегистрироваться'
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    public static SelenideElement registrationButton;

    @Step("Регистрация пользователя")
    public void registration(String name, String email, String password) {
        nameAndEmailFields.get(0).setValue(name);
        nameAndEmailFields.get(1).setValue(email);
        fieldPassword.setValue(password);
        registrationButton.click();
    }

    // уведомление 'Некорректный пароль'
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    public static SelenideElement errorPasswordNote;

    @Step("Проверяем уведомление 'Некорректный пароль'")
    public boolean badPassNoteCheck() {
        return errorPasswordNote.isDisplayed();
    }

    // кнопка 'Войти'
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public static SelenideElement loginButton;

    @Step("Кликаем кнопку 'Войти' на странице регистрации")
    public void clickLoginButton() {
        loginButton.click();
    }
}