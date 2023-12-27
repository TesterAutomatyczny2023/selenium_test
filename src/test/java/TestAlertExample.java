import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAlertExample extends BaseTest{
    @Test
    public void testAlertExample() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html");
        WebElement button = driver.findElement(By.id("alert"));
        button.click();

        Alert alert = driver.switchTo().alert();
        // Thread.sleep(1000); //tylko w celach testowych, usunać
        Assert.assertEquals(alert.getText(), "cheese");

        alert.accept();
    }

    @Test
    public void testPrompt() {
        driver.get("https://www.selenium.dev/selenium/web/alerts.html");
        WebElement button = driver.findElement(By.id("prompt"));

        WebElement text = driver.findElement(By.id("text"));
        Assert.assertEquals( text.getText(), "");

        button.click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("To jest test prompt");
        alert.accept();

        Assert.assertEquals(text.getText(), "To jest test prompt");

    }
}
