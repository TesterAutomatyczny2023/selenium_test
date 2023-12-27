import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestAlert extends BaseTest{
    private String pageAddress = "https://the-internet.herokuapp.com/javascript_alerts";
    private By byInfo = By.xpath("//*[@id=\"result\"]");
    private By byButton = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");

    private By byButtonAlertConfirm = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");

    private By byButtonAlertPrompt = By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
    @Test
    public void testAlert() throws IOException, InterruptedException {
        driver.get(pageAddress);
        WebElement info = driver.findElement(byInfo);
        WebElement button = driver.findElement(byButton);
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

      //  takeScreenshot((ChromeDriver) driver, "alert_screenshot.jpg");
        Alert alert = driver.switchTo().alert();
      //  Thread.sleep(1000);
        alert.accept();

        driver.switchTo().defaultContent();

        Assert.assertEquals(info.getText(), "You successfully clicked an alert");
    }

    @Test
    public void testAlertChoiceAccept() throws IOException, InterruptedException {
        driver.get(pageAddress);
        WebElement info = driver.findElement(byInfo);
        WebElement button = driver.findElement(byButtonAlertConfirm);
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        //  takeScreenshot((ChromeDriver) driver, "alert_screenshot.jpg");
        Alert alert = driver.switchTo().alert();
        //  Thread.sleep(1000);
        alert.accept();

        driver.switchTo().defaultContent();

        Assert.assertEquals(info.getText(), "You clicked: Ok");
    }

    @Test
    public void testAlertChoiceCancel() throws IOException, InterruptedException {
        driver.get(pageAddress);
        WebElement info = driver.findElement(byInfo);
        WebElement button = driver.findElement(byButtonAlertConfirm);
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        //  takeScreenshot((ChromeDriver) driver, "alert_screenshot.jpg");
        Alert alert = driver.switchTo().alert();
        //  Thread.sleep(1000);
        alert.dismiss();

        driver.switchTo().defaultContent();

        Assert.assertEquals(info.getText(), "You clicked: Cancel");
    }

    @Test
    public void testAlertPrompt() throws IOException, InterruptedException {
        driver.get(pageAddress);
        WebElement info = driver.findElement(byInfo);
        WebElement button = driver.findElement(byButtonAlertPrompt);
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        //  takeScreenshot((ChromeDriver) driver, "alert_screenshot.jpg");
        Alert alert = driver.switchTo().alert();
        //  Thread.sleep(1000);
        alert.sendKeys("Moja odpowiedź");
        alert.accept();

        driver.switchTo().defaultContent();

        Assert.assertEquals(info.getText(), "You entered: Moja odpowiedź");
    }

    @Test
    public void testAlertPromptCancel() throws IOException, InterruptedException {
        driver.get(pageAddress);
        WebElement info = driver.findElement(byInfo);
        WebElement button = driver.findElement(byButtonAlertPrompt);
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        //  takeScreenshot((ChromeDriver) driver, "alert_screenshot.jpg");
        Alert alert = driver.switchTo().alert();
        //  Thread.sleep(1000);
        alert.sendKeys("Moja odpowiedź");
        alert.dismiss();

      //  driver.switchTo().defaultContent();


        Assert.assertEquals(info.getText(), "You entered: null");
    }


}
