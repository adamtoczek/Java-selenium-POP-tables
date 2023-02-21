import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import seleniumPOPTables.BasePage;
import seleniumPOPTables.LakesTablePOP;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class SeleniumTest extends BaseTest{

    @Test
    public void testTable() {
        driver.get("http://qac.com.pl/tables.html");

        List<WebElement> lakes = driver.findElements(By.cssSelector("#main table tbody tr"));

        //Erie
        for(WebElement row : lakes) {
            if (row.findElement(By.cssSelector("td:first-of-type")).getText().equals("Erie")) {
                assertEquals(row.findElement(By.cssSelector("td:nth-of-type(2)")).getText(), "25 612");
                break;
            }
        }

        for(WebElement row : lakes) {
            if (row.findElement(By.cssSelector("td:first-of-type")).getText().equals("Winnipeg")) {
                assertEquals(row.findElement(By.cssSelector("td:nth-of-type(3)")).getText(), "Kanada");
                break;
            }
        }
    }

    @Test
    public void verifyLakesPOP() {
        LakesTablePOP.openPage();
        assertEquals(BasePage.lakesTablePOP.getLakeAreaByName("Erie"), "25 612");
        assertEquals(BasePage.lakesTablePOP.getLakeCountryByName("Winnipeg"), "Kanada");

        assertEquals(BasePage.lakesTablePOP.getLakeByName("Erie").getArea(), "25 612");
        assertEquals(BasePage.lakesTablePOP.getLakeByName("Winnipeg").getCountry(), "Kanada");

        assertNull(BasePage.lakesTablePOP.getLakeByName("Sniardwy"));
    }

}
