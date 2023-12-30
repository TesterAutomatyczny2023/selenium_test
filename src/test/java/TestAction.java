import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.meta.Exclusive;
import java.awt.*;
import java.time.Duration;

public class TestAction extends BaseTest{

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"//*[@id='content']/div/div[1]/div/h5", "//*[@id='content']/div/div[1]/img"},
                {"//*[@id='content']/div/div[2]/div/h5", "//*[@id='content']/div/div[2]/img"},
                {"//*[@id='content']/div/div[3]/div/h5", "//*[@id='content']/div/div[3]/img"},
        };
    }

    @Test(dataProvider = "testData")
    public void testHoverOnHeroku(String captionXPath, String imageXPath) {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement caption = driver.findElement(By.xpath(captionXPath));
        Assert.assertFalse(caption.isDisplayed());
        WebElement image = driver.findElement(By.xpath(imageXPath));
        Actions builder = new Actions(driver);
        builder.moveToElement(image).perform();
        Assert.assertTrue(caption.isDisplayed());
    }


    @Test(enabled = false)
    public void testSlider() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement caption = driver.findElement(By.xpath("//*[@id='range']"));
        Assert.assertEquals("0", caption.getText());

        WebElement slider = driver.findElement(By.xpath("//*[@id='content']/div/div/input"));
        Actions builder = new Actions(driver);
        System.out.println(slider.getLocation().getX());
        System.out.println(slider.getLocation().getY());
        builder.moveToElement(slider).clickAndHold().moveByOffset(50, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(40, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(30, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(20, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(10, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(1, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(0, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(-1, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(-2, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(-10, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(-20, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(-30, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(-40, 0).release().perform();
        builder.moveToElement(slider).clickAndHold().moveByOffset(-50, 0).release().perform();
//        builder.moveToElement(slider).clickAndHold().moveToLocation (33 + 20, 164).release().perform();

        Assert.assertEquals("3", caption.getText());
    }

    @Test(enabled = false)
    public void testExitIntentOnTheInternetHeroku() throws AWTException {
        driver.get("https://the-internet.herokuapp.com/exit_intent");
        WebElement window = driver.findElement(By.xpath("//*[@id=\"ouibounce-modal\"]/div[2]/div[1]/h3"));
        Assert.assertFalse(window.isDisplayed());

        Actions builder = new Actions(driver);
//        builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/h3"))).moveByOffset(0, -1).build().perform();
//        builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/h3"))).moveByOffset(0, -55).build().perform();
//        builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/h3"))).moveByOffset(600, -56).build().perform();

        Robot robot = new Robot();
        robot.mouseMove(600,0);

//        builder.moveToLocation(600, 0).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(window));
        //Assert.assertTrue(window.isDisplayed());

    }

    @Test(groups = "drag and drop", priority = 1)
    public void testDragAndDropOnTheInternetHeroku() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement firstElement = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement secondElement = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));

        Actions builder = new Actions(driver);
        builder.clickAndHold(firstElement).moveToElement(secondElement).release().perform();

        Assert.assertTrue(secondElement.getText().equals("A"));
    }

    @Test(dependsOnMethods = "testDragAndDropOnTheInternetHeroku", groups = "drag and drop", priority = 2)
    public void testDragAndDropOnTheInternetHerokuPartTwo() {
        //driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement firstElement = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement secondElement = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));

        Actions builder = new Actions(driver);
        builder.clickAndHold(secondElement).moveToElement(firstElement).release().perform();

        Assert.assertTrue(secondElement.getText().equals("B"));
    }
}
