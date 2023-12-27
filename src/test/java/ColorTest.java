import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ColorTest extends BaseTest{
    @Test
    public void colorTest() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement h3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        String hexColor = Color.fromString(h3.getCssValue("color")).asHex();
        Assert.assertEquals(hexColor, "#222222");
        //#222222
    }
}
