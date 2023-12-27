import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SelectMultipleTest extends BaseTest{

    @DataProvider(name="selectMultiple")
    public Object[][] selectMultiple() {
        return new Object[][]{
                {0, "emmental"},
                {1, "roquefort"},
                {2, "parmigiano"},
                {3, "cheddar"}
        };
    }

    @Test(dataProvider = "selectMultiple")
    public void testSingleChoice(int index, String value) {
        driver.get("https://www.selenium.dev/selenium/web/formSelectionPage.html");
        WebElement multi = driver.findElement(By.id("multi"));
        WebElement button = driver.findElement(By.cssSelector("input[name='showselected']"));
        WebElement result = driver.findElement(By.id("result"));

        Select select = new Select(multi);
        select.deselectAll();

        select.selectByIndex(index);
        button.click();
        Assert.assertEquals(result.getText(), value);
    }
    @Test
    public void testSelectMultiple() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/formSelectionPage.html");

        WebElement multi = driver.findElement(By.id("multi"));
        WebElement button = driver.findElement(By.cssSelector("input[name='showselected']"));
        WebElement result = driver.findElement(By.id("result"));

        Select select = new Select(multi);
        select.selectByIndex(0);
        Thread.sleep(1000);
        select.selectByIndex(1);
        Thread.sleep(1000);
        select.deselectByIndex(0);
        Thread.sleep(1000);
//        for(var option: select.getOptions()) {
//            option.click();
//            Thread.sleep(1000);
//        }

    }
}
