package swiatPop;

import org.openqa.selenium.By;

public class MainPage extends BaseSwiat{
    public static void open() {
        driver.get("https://swiatroweru.com.pl");
        mainPage = new MainPage();
    }

    public void clickProductByName(String name) {
        driver.findElement(By.linkText(name)).click();
        productPage = new ProductPage();
    }
}
