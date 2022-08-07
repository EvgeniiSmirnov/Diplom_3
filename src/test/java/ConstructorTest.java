import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Test;
import stellarburgers.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Позитивная проверка. Проверяем переход к разделу 'Булки'")
    public void activationBunsTabTest() throws InterruptedException {
        mainPage.clickFillingsTab();
        Thread.sleep(3000);
        mainPage.clickBunsTab();
        Thread.sleep(3000);
        mainPage.bunsTabSelectedCheck();
    }

    @Test
    @Description("Позитивная проверка. Проверяем переход к разделу 'Соусы'")
    public void activationSouseTabTest() throws InterruptedException {
        mainPage.clickFillingsTab();
        Thread.sleep(3000);
        mainPage.clickSauceTab();
        Thread.sleep(3000);
        mainPage.sauceTabSelectedCheck();
    }

    @Test
    @Description("Позитивная проверка. Проверяем переход к разделу 'Соусы'")
    public void activationFillingsTabTest() throws InterruptedException {
        mainPage.clickSauceTab();
        Thread.sleep(3000);
        mainPage.clickFillingsTab();
        Thread.sleep(3000);
        mainPage.fillingsTabSelectedCheck();
    }
}
