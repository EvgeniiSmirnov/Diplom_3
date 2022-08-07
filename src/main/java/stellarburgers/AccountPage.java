package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class AccountPage extends HeaderPage {

    // текст с подсказкой
    @FindBy(how = How.XPATH, using = ".//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    public static SelenideElement explainText;

    @Step("Проверяем видимость подсказки")
    public boolean explainTextCheck() {
        return explainText.shouldBe(visible).isDisplayed();
    }

    // кнопка 'Выход'
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    public static SelenideElement exitButton;

    @Step("Кликаем кнопку 'Выход'")
    public void clickExitButton() {
        exitButton.click();
    }
}