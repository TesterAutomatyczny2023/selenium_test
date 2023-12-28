import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCssValue extends BaseTest{
    @Test
    public void testCss() {
        driver.get("https://the-internet.herokuapp.com/inputs");

        var h1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/h3"));

        System.out.println(h1.getCssValue("color"));
        System.out.println(Color.fromString(h1.getCssValue("color")).asHex());
        System.out.println(h1.getCssValue("font-size"));
        System.out.println(h1.getCssValue("width"));
        System.out.println(h1.getCssValue("height"));
        System.out.println(h1.getCssValue("background-color"));
        System.out.println(h1.getCssValue("background"));
    }

    private static String colorAsHex(String color) {
        return Color.fromString(color).asHex();
    }


    @Test(priority = 1)
    public void testColorOfInfoIsRed() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));

        submit.click();

        WebElement flash = driver.findElement(By.id("flash"));

        Assert.assertTrue(flash.isDisplayed());
        String actualColor = flash.getCssValue("background-color");
        System.out.println(actualColor);
        String actualColorHex = Color.fromString(actualColor).asHex();
        System.out.println(actualColorHex);
        String backgroundColorHex = "#c60f13";
        Assert.assertEquals(actualColorHex,backgroundColorHex);
        System.out.println(colorAsHex(flash.getCssValue("border-color")));
        System.out.println(colorAsHex(flash.getCssValue("color")));
    }

    @Test(dependsOnMethods = "testColorOfInfoIsRed", priority = 2)
    public void testColorOfSuccessLoginGreen() {
        WebElement login = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        String user = "tomsmith";
        String pass = "SuperSecretPassword!";

        login.sendKeys(user);
        password.sendKeys(pass);

        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));
        submit.click();

        WebElement flash = driver.findElement(By.id("flash"));
        String color = Color.fromString(flash.getCssValue("background-color")).asHex();
        System.out.println(color);
        System.out.println(colorAsHex(flash.getCssValue("border-color")));
        System.out.println(colorAsHex(flash.getCssValue("color")));
    }

    @Test( enabled = false)
    public void clickJacker() {
        driver.get("https://www.selenium.dev/selenium/web/click_jacker.html");
        WebElement clickMe = driver.findElement(By.xpath("/html/body/div/div[2]"));
        System.out.println(colorAsHex(clickMe.getCssValue("background-color")));
        clickMe.click();
        System.out.println(colorAsHex(clickMe.getCssValue("background-color")));
    }


}
