import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestSite {
    WebDriver driver;
    @AfterTest
    public void TearDown() {
        driver.quit();
    }
    @Test
    public void testChromeDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        Assert.assertEquals(driver.getTitle(), "Web form");
        driver.quit();
    }

    @Test
    public void testFirefoxDriver() {
        driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        Assert.assertEquals(driver.getTitle(), "Web form");
        driver.quit();
    }

    @Test(enabled = false)
    public void testEdgeDriver() {
        driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        Assert.assertEquals(driver.getTitle(), "Web form");
       driver.quit();
    }
}
