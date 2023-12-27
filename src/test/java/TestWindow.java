import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWindow extends BaseTest{
    @Test
    public void testNewWindow() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String mainWindowHandle = driver.getWindowHandle();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        button.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

//        Assert.assertEquals(driver.getTitle(), "The Internet");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/windows/new");
        driver.close();
        Thread.sleep(1000);
        //powrót do poprzedenigo okna
        driver.switchTo().window(mainWindowHandle);
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/windows");

    }

    @Test
    public void testAuth() {
        driver.get("https://the-internet.herokuapp.com/");
        // //*[@id="content"]/ul/li[3]/a
        var link = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[3]/a"));
        var mainWindowHandle = driver.getWindowHandle();
        link.click();
        for(var handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

    }

    @Test
    public void basicAuth() throws InterruptedException {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(1000);

    }
}
