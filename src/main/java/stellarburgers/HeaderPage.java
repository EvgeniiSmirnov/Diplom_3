package stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage {

    // кнопка хэдера 'Личный кабинет'
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement accountButtonHeader;

    // кнопка 'Конструктор'
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    // лого
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgersLogo;

    @Step("Кликаем кнопку хэдера 'Личный кабинет'")
    public void clickAccountButtonHeader() {
        accountButtonHeader.click();
    }

    @Step("Кликаем кнопку 'Конструктор'")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    @Step("Кликаем лого Stellar Burgers")
    public void clickStellarBurgersLogo() {
        stellarBurgersLogo.click();
    }
}
