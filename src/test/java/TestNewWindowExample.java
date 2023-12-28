import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNewWindowExample extends BaseTest{
    @Test(enabled = false)
    public void testNewWindow() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));

        button.click();
        button.click();
        button.click();

        Thread.sleep(1000);

        String mainWindow = driver.getWindowHandle();

        for(String handle : driver.getWindowHandles()) {
            if( !handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                driver.close();

            }
        }
       // Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/windows/new");

    }
}
