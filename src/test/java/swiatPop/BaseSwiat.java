package swiatPop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseSwiat {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static ProductPage productPage;
    public static BasketPage basketPage;

    static public void goHome() {
        driver.findElement(By.cssSelector("#navtopdefault li:first-of-type")).click();
        mainPage = new MainPage();
    }

    static public void openBasket() {
        driver.findElement(By.cssSelector("#basket_link>a")).click();
        basketPage = new BasketPage();
    }
}
