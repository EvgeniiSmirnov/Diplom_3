package stellarburgers;

import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Позитивная проверка. Проверяем переход к разделу 'Булки'")
    public void activationBunsTabTest() {
        mainPage.clickFillingsTab();
        mainPage.clickBunsTab();
        mainPage.bunsTabSelectedCheck();
    }

    @Test
    @Description("Позитивная проверка. Проверяем переход к разделу 'Соусы'")
    public void activationSouseTabTest() {
        mainPage.clickFillingsTab();
        mainPage.clickSauceTab();
        mainPage.sauceTabSelectedCheck();
    }

    @Test
    @Description("Позитивная проверка. Проверяем переход к разделу 'Соусы'")
    public void activationFillingsTabTest() {
        mainPage.clickSauceTab();
        mainPage.clickFillingsTab();
        mainPage.fillingsTabSelectedCheck();
    }
}