import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DryLoginTest extends BaseTest {
    //Enter tomsmith for the username and SuperSecretPassword! for the password
    private static final String URL = "https://the-internet.herokuapp.com/login";
    private static final String SUCCESS_URL = "https://the-internet.herokuapp.com/secure";
    private static final String USER = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    By byUsername = By.id("username");
    By byPassword = By.id("password");
//    By bySubmit = By.cssSelector("button[type=submit]");
    By bySubmit = By.xpath("//button[@type='submit']");

    @Test
    public void validLoginTest() {
        driver.get(URL);

        WebElement username = driver.findElement(byUsername);
        WebElement password = driver.findElement(byPassword);
        WebElement submit = driver.findElement(bySubmit);

        username.sendKeys(USER);
        password.sendKeys(PASSWORD);

        submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), SUCCESS_URL);
    }

    @Test
    public void invalidLoginTest() {
        driver.get(URL);

        WebElement username = driver.findElement(byUsername);
        WebElement password = driver.findElement(byPassword);
        WebElement submit = driver.findElement(bySubmit);

        submit.click();

        Assert.assertEquals(driver.getCurrentUrl(), URL);
    }
}
