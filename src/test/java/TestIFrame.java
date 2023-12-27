import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIFrame extends BaseTest{
    @Test
    public void testIFrame() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iFrame = driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(iFrame);

        WebElement paragraph = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        paragraph.sendKeys("To jest test!");
        System.out.println(paragraph.getText());
        Thread.sleep(1000);

        Assert.assertEquals( paragraph.getText(), "Your content goes here.To jest test!");

    }

    @Test
    public void testFrame() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        System.out.println("test");
        System.out.println("url:" + driver.getCurrentUrl());
        System.out.println("title:"+ driver.getTitle());

       // WebElement frameLeft = driver.findElement(By.name("frame-left"));
        WebElement frameTop = driver.findElement(By.cssSelector("[name=frame-top]"));
        driver.switchTo().frame("frame-top");
        WebElement frameLeft = driver.findElement(By.cssSelector("[name=frame-left]"));
        driver.switchTo().frame(frameLeft);
        WebElement body1 = driver.findElement(By.tagName("body"));
        System.out.println("body:" + body1.getText());
        driver.switchTo().parentFrame();
        WebElement frameMiddle = driver.findElement(By.cssSelector("[name=frame-middle]"));
        driver.switchTo().frame(frameMiddle);
        WebElement middleBody = driver.findElement(By.tagName("body"));
        System.out.println("body:" + middleBody.getText());

        driver.switchTo().parentFrame();
        WebElement frameRight = driver.findElement(By.cssSelector("[name=frame-right]"));
        driver.switchTo().frame(frameRight);
        WebElement bodyRight = driver.findElement(By.tagName("body"));
        System.out.println("body:" + bodyRight.getText());

        driver.switchTo().defaultContent();
        WebElement frameBottom = driver.findElement(By.cssSelector("[name=frame-bottom]"));
        driver.switchTo().frame(frameBottom);
        WebElement bodyBottom = driver.findElement(By.tagName("body"));
        System.out.println("body:" + bodyBottom.getText());

        try {
            WebElement left = driver.findElement(By.xpath("/html/body"));
            System.out.println("text in body:"+ left.getText());
        }catch (Exception e) {}
        try{
            ///html/frameset/frame[1] /html/frameset/frame[1]
        WebElement frame1 = driver.findElement(By.xpath("/html/frameset/frame[1]"));
        WebElement frame2 = driver.findElement(By.xpath("/html/frameset/frame[1]"));
        WebElement frame = driver.findElement(By.cssSelector("html > frameset > frame:nth-child(1)"));
         //   Assert.assertEquals(frame1, frame);
          //  Assert.assertEquals(frame2, frame);
          //  System.out.println("Ten sam frame");
            System.out.println("dislplayed:" + frame.isDisplayed());
        System.out.println(frame2.getText());
        System.out.println(driver.getTitle());
        driver.switchTo().frame(frame2);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        WebElement body = driver.findElement(By.xpath("/html/body"));
            System.out.println(body.getText());
        //Assert.assertEquals(, "LEFT");
        }
        catch(Exception e){}
      //  Assert.assertEquals(driver.findElement(By.xpath("/html/body")), "LEFT");
     }
}
