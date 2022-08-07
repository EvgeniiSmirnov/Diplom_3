import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.AccountPage;
import stellarburgers.LoginPage;
import stellarburgers.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LogoutTest {

    private static final String BAD_LOGOUT_MESSAGE = "Не получилось выйти из личного кабинета";

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

    @Test
    @Description("Позитивная проверка. Выход по кнопке 'Выйти' в личном кабинете")
    public void logoutTest() {
        mainPage.clickAccountButtonHeader();
        accountPage.clickExitButton();
        assertTrue(BAD_LOGOUT_MESSAGE, loginPage.enterButtonCheck());
    }
}