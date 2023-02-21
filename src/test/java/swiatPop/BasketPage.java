package swiatPop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumPOPTables.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BaseSwiat {
    List<BasketItemPO> pozycjeKoszyka = new ArrayList<>();


    public BasketPage() {
        readBasketItems();
    }

    private void readBasketItems() {
        List<WebElement> rows =  driver.findElements(By.cssSelector("#basket_container form table tr"));
        for (WebElement row : rows) {
            if (row.findElements(By.cssSelector("td")).size()==5) {
                pozycjeKoszyka.add(new BasketItemPO(row));
            }
        }

    }

    public BasketItemPO getBasketItem(String name) {
        for(BasketItemPO item : pozycjeKoszyka) {
            if (item.getName().equals(name))
                return item;
        }
        return null;
    }

    public void clickPrzelicz() {
        driver.findElement(By.cssSelector("input[name=\"B1\"]")).click();
        basketPage = new BasketPage();
    }

    public int getTotalQty() {
        int sum = 0;
        for (BasketItemPO item : pozycjeKoszyka)
            sum += item.getQty();
        return sum;
    }
}
