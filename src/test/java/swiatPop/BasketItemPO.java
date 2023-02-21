package swiatPop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasketItemPO {
    String name;
    WebElement qty;


    public BasketItemPO(WebElement row) {
        this.name = parseName(row.findElement(By.cssSelector("td:nth-of-type(2)")).getText());
        this.qty = row.findElement(By.cssSelector("input"));
    }
    private String parseName(String text){
        String[] tmp = text.split("\n");
        return tmp[1];
    }

    public void changeQty(int n) {
        qty.clear();
        qty.sendKeys(""+n);
    }
    public String getName() {
        return name;
    }

    public int getQty() {
        return Integer.parseInt(qty.getAttribute("value"));
    }
}
