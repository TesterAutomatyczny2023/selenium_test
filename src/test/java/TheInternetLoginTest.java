import heroku.page.object.model.TheHerokuAppLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.model.TheHerokuLoginPage;


public class TheInternetLoginTest extends BaseTest{
    @Test
    public void successLoginTest() {
        driver.get("https://the-internet.herokuapp.com/login");

        String user = "tomsmith";
        String pass = "SuperSecretPassword!";


        TheHerokuAppLoginPage loginPage = new TheHerokuAppLoginPage(driver);
        loginPage.setUserName(user);
        loginPage.setPassword(pass);
        loginPage.clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(),  "https://the-internet.herokuapp.com/secure");


    }
}
