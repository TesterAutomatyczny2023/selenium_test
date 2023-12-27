import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class UploadFileTest extends BaseTest {
    @Test
    public void testUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement fileUpload = driver.findElement(By.cssSelector("input[type=file]"));

        File file = new File("files/data9.txt");

        fileUpload.sendKeys(file.getAbsolutePath());

        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText(),
                "File Uploaded!");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"uploaded-files\"]")).getText(),
                "data9.txt");

        Thread.sleep(2000);
    }
}
