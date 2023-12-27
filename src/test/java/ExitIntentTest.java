import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class ExitIntentTest extends BaseTest{
    @Test
    public void exitIntentTest() throws AWTException, InterruptedException {
        driver.get("https://the-internet.herokuapp.com/exit_intent");

//        Actions actions = new Actions(driver);
//        actions.moveToLocation(0, 0).perform();

        WebElement modalTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]"));
        Assert.assertFalse(modalTitle.isDisplayed());

        //actions.moveByOffset(0, -1).perform();

        Robot robot = new Robot();
        robot.mouseMove(600, 0);
        Thread.sleep(2000);

        Assert.assertTrue(modalTitle.isDisplayed());
    }
}
