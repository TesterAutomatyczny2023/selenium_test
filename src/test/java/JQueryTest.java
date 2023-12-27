import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class JQueryTest extends BaseTest{
    @Test
    public void jqueryTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("alert('Hello, World!');");
//        Thread.sleep(2000);

        WebElement element = driver.findElement(By.id("exampleElement"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        WebElement menuEnabled = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/ul/li[2]/a"));

        Actions action = new Actions(driver);
        action.moveToElement(menuEnabled).perform();

        //Thread.sleep(2000);
        WebElement menuDownload = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/ul/li[2]/ul/li[1]/a"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(menuDownload));

        action.moveToElement(menuDownload).perform();

        WebElement menuPdf = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/ul/li[2]/ul/li[1]/ul/li[1]/a"));
        wait.until(ExpectedConditions.visibilityOf(menuPdf));

        action.moveToElement(menuPdf).perform();
        menuPdf.click();

        Thread.sleep(2000);

    }
}
