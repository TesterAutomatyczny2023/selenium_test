import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIFrameExample extends BaseTest{
    @Test
    public void testIFrameExample() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(iFrame);

        WebElement paragraph = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        paragraph.sendKeys("Wpisujemy nowy tekst");

        Assert.assertEquals(paragraph.getText(), "Your content goes here.Wpisujemy nowy tekst");
    }
}
