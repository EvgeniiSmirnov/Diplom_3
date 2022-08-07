package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PassRecoveryPage extends HeaderPage {

    // ссылка 'Войти'
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    public static SelenideElement loginLink;

    @Step("Кликаем ссылку 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        loginLink.click();
    }
}