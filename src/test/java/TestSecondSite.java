import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSecondSite {
    WebDriver webDriver = new FirefoxDriver();
    @Test
    public void test() {
       webDriver.get("https://the-internet.herokuapp.com/key_presses");
       WebElement input = webDriver.findElement(By.cssSelector("#target"));
       input.sendKeys("drzewo");
       Assert.assertEquals(input.getAttribute("value"), "drzewo");
       WebElement textField = webDriver.findElement(By.cssSelector("#result"));
       Assert.assertEquals(textField.getText(), "You entered: O");
       webDriver.quit();
    }
}
