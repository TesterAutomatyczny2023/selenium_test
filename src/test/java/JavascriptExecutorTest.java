import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JavascriptExecutorTest extends BaseTest{
    @Test
    public void testInfiniteScroll() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        WebElement div = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]"));
        Thread.sleep(2000);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", div);
        Thread.sleep(2000);
    }

    @Test
    public void disableButton() throws InterruptedException {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/disabledbutton.html");
        WebElement button = driver.findElement(By.xpath("//*[@id='myButton']"));
        button.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled');", button);
        button.click();

        Alert alert = driver.switchTo().alert();
        String expected = "Kliknięto przycisk!";
        Assert.assertEquals( alert.getText(), expected);

    }

    @Test
    public void noButton() throws InterruptedException {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/nobutton.html");
        WebElement total = driver.findElement(By.xpath("//*[@id=\"totalAmount\"]"));
        Assert.assertEquals(total.getText(), "");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("calculateTotal()");

        Thread.sleep(2000);

        Assert.assertNotEquals(total.getText(), "");

        List<WebElement> prices = driver.findElements(By.cssSelector(".price"));

        Assert.assertEquals(prices.size(), 3);
        double totalAmount = 0;
        for(WebElement price : prices) {
            totalAmount += Double.parseDouble(price.getText());
        }
        log.info(totalAmount);
        Assert.assertEquals(totalAmount, Double.parseDouble(total.getText()));

    }
}
