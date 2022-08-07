import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.LoginPage;
import stellarburgers.MainPage;
import stellarburgers.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private static final String BAD_REG_MESSAGE = "Ошибка регистрации";
    private static final String SHORT_PASS_MESSAGE = "Нет уведомления: 'Некорректный пароль'";

    MainPage mainPage;
    LoginPage loginPage = page(LoginPage.class);
    RegisterPage registerPage = page(RegisterPage.class);

    String name = RandomStringUtils.randomAlphabetic(7);
    String email = RandomStringUtils.randomAlphanumeric(5) + "@gmail.com";
    String password = RandomStringUtils.randomAlphanumeric(7);
    String shortPassword = RandomStringUtils.randomAlphanumeric(5);

    @Before
    public void prepareData() {
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = false;

        mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Позитивная проверка. Регистрация. Поля заполнены корректно")
    public void registrationWithCorrectData() {
        mainPage.clickAccountButtonHeader();
        loginPage.clickRegistrationLink();
        registerPage.registration(name, email, password);
        assertTrue(BAD_REG_MESSAGE, loginPage.enterButtonCheck());
    }

    @Test
    @Description("Негативная проверка. Регистрация. Количество символов в пароле менее 6")
    public void registrationWithShortPassword() {
        mainPage.clickAccountButtonHeader();
        loginPage.clickRegistrationLink();
        registerPage.registration(name, email, shortPassword);
        assertTrue(SHORT_PASS_MESSAGE, registerPage.badPassNoteCheck());
    }
}