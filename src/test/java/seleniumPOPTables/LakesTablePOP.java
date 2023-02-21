package seleniumPOPTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;


public class LakesTablePOP extends BasePage{
    Map<String, LakePO> lakes = new HashMap<>();
    public static void openPage() {
        driver.get("http://qac.com.pl/tables.html");
        lakesTablePOP = new LakesTablePOP();
    }

    public LakesTablePOP() {
        readLakes();
    }

    private void readLakes() {
        List<WebElement> lakesWE = driver.findElements(By.cssSelector("#main table tbody tr"));
        for (WebElement row : lakesWE) {
            String name = row.findElement(By.cssSelector("td:first-of-type")).getText();
            String area = row.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
            String country = row.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
            int lp = Integer.parseInt(row.findElement(By.cssSelector("th")).getText());
            lakes.put(name, new LakePO(name, country, area, lp));

        }
    }

    public String getLakeAreaByName(String name) {
        List<WebElement> lakes = driver.findElements(By.cssSelector("#main table tbody tr"));
        for(WebElement row : lakes) {
            if (row.findElement(By.cssSelector("td:first-of-type")).getText().equals(name)) {
                return row.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
            }
        }
        return null;
    }

    public String getLakeCountryByName(String name) {
        List<WebElement> lakes = driver.findElements(By.cssSelector("#main table tbody tr"));

        for(WebElement row : lakes) {
            if (row.findElement(By.cssSelector("td:first-of-type")).getText().equals(name)) {
                return row.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
            }
        }
        return null;
    }

    public LakePO getLakeByName(String name) {
        return lakes.get(name);
    }
}
