import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.LoginPage;
import stellarburgers.MainPage;
import stellarburgers.PassRecoveryPage;
import stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    private static final String BAD_AUTH_MESSAGE = "Ошибка авторизации";

    private static final String email = "fatmorty007@gmail.com";
    private static final String password = "123123";

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegisterPage registerPage = page(RegisterPage.class);
    PassRecoveryPage passRecoveryPage = page(PassRecoveryPage.class);

    @Before
    public void prepareData() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = false;
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Позитивная проверка. Логин по кнопке 'Войти в аккаунт'")
    public void loginAccountButtonMainPage() {
        mainPage.clickAccountButton();
        loginPage.login(email, password);
        assertTrue(BAD_AUTH_MESSAGE, mainPage.makeOrderButtonCheck());
    }

    @Test
    @Description("Позитивная проверка. Логин по кнопке 'Личный кабинет'")
    public void loginAccountButtonHeader() {
        mainPage.clickAccountButtonHeader();
        loginPage.login(email, password);
        assertTrue(BAD_AUTH_MESSAGE, mainPage.makeOrderButtonCheck());
    }

    @Test
    @Description("Позитивная проверка. Логин через кнопку в форме регистрации")
    public void loginButtonRegistrationPage() {
        mainPage.clickAccountButtonHeader();
        loginPage.clickRegistrationLink();
        registerPage.clickLoginButton();
        loginPage.login(email, password);
        assertTrue(BAD_AUTH_MESSAGE, mainPage.makeOrderButtonCheck());
    }

    @Test
    @Description("Позитивная проверка. Логин через кнопку в форме восстановления пароля")
    public void loginButtonRecoveryPage() {
        mainPage.clickAccountButtonHeader();
        loginPage.clickPassRecoveryLink();
        passRecoveryPage.clickLoginLink();
        loginPage.login(email, password);
        assertTrue(BAD_AUTH_MESSAGE, mainPage.makeOrderButtonCheck());
    }
}