package stellarburgers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest {

    private static final String BAD_AUTH_MESSAGE = "Ошибка авторизации";
    private static final String CONSTRUCTOR_CANT_OPEN_MESSAGE = "Не получилось открыть констрктор";
    private static final String email = "fatmorty007@gmail.com";
    private static final String password = "123123";

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    AccountPage accountPage = page(AccountPage.class);

    @Before
    public void prepareData() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = false;

        mainPage.clickAccountButtonHeader();
        loginPage.login(email, password);
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Позитивная проверка. Юзер авторизован. Переход по кнопке 'Личный кабинет'")
    public void openAccountPageTest() {
        mainPage.clickAccountButtonHeader();
        assertTrue(BAD_AUTH_MESSAGE, accountPage.explainTextCheck());
    }

    @Test
    @Description("Позитивная проверка. Юзер авторизован. Переход из личного кабинета в конструктор по кнопке 'Конструктор'")
    public void clickConstructorButtonTest() {
        mainPage.clickAccountButtonHeader();
        mainPage.clickConstructorButton();
        assertTrue(CONSTRUCTOR_CANT_OPEN_MESSAGE, mainPage.makeOrderButtonCheck());
    }

    @Test
    @Description("Позитивная проверка. Юзер авторизован. Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void clickLogoTest() {
        mainPage.clickAccountButtonHeader();
        mainPage.clickStellarBurgersLogo();
        assertTrue(CONSTRUCTOR_CANT_OPEN_MESSAGE, mainPage.makeOrderButtonCheck());
    }
}