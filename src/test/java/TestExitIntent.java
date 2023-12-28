import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.Collections;

public class TestExitIntent extends BaseTest{

    private static void simulateExit(){
        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");

        Sequence actions = new Sequence(mouse, 0)
                .addAction(mouse.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 600, -1));

        ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));
    }
    private static void simulateExitIntent(WebDriver driver) {
        // Zakłada, że exit intent zostanie aktywowany poprzez przewinięcie strony w dół
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }
    @Test( enabled = false)
    public void testExitIntent() throws InterruptedException, AWTException {
        driver.get("https://the-internet.herokuapp.com/exit_intent");

//        simulateExitIntent(driver);
        Robot robot = new Robot();
        robot.mouseMove(600, 0);

        Actions actions = new Actions(driver);
        actions.moveToLocation(600, -1).perform();
        actions.moveByOffset(0, -1).perform();

        simulateExit();

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.className("modal")).isDisplayed());
    }
}
