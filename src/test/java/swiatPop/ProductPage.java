package swiatPop;

import org.openqa.selenium.By;

public class ProductPage extends BaseSwiat {
    public ProductPage clickAddToBasket() {
        driver.findElement(By.id("addtobasket_button")).click();
        return this;
    }
}
