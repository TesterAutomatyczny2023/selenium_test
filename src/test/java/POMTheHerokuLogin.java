import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.model.TheHerokuLoginPage;

public class POMTheHerokuLogin extends BaseTest{

    @Test
    public void sucessfullLoginTest() {
        driver.get("https://the-internet.herokuapp.com/login");

        TheHerokuLoginPage loginPage = new TheHerokuLoginPage(driver);

        loginPage.successfullLogin("tomsmith", "SuperSecretPassword!");

//        loginPage.setUsername("username");
//        loginPage.setPassword("password");
//        loginPage.clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");

    }

}
