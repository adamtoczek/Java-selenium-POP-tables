import org.testng.annotations.Test;
import swiatPop.MainPage;

import static org.testng.Assert.assertEquals;
import static swiatPop.BaseSwiat.*;

public class SwiatTest extends BaseTest{

    @Test
    public void verifyBasketCounts() {
        MainPage.open();
        mainPage.clickProductByName("Propel Advanced Disc 1 M");
        productPage.clickAddToBasket();
        goHome();
        mainPage.clickProductByName("Wkładka antyprzebiciowa 50mm");
        productPage.clickAddToBasket();
        goHome();
        mainPage.clickProductByName("Torba na ramę na smartfon");
        productPage.clickAddToBasket();
        openBasket();
        basketPage.getBasketItem("Wkładka antyprzebiciowa 50mm").changeQty(5);
        basketPage.clickPrzelicz();
        assertEquals(basketPage.getTotalQty(), 7);

    }
}
