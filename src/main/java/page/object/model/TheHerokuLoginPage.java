package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheHerokuLoginPage {
    By byUsername = By.id("username");
    By byPassword = By.id("password");
    //    By bySubmit = By.cssSelector("button[type=submit]");
    By bySubmit = By.xpath("//button[@type='submit']");
    private WebDriver driver;
    private static final String USER = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";

    public TheHerokuLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSubmit() {
        driver.findElement(bySubmit).click();
    }

    public TheHerokuLoginPage setUsername(String userName) {
        WebElement username = driver.findElement(byUsername);
        username.clear();
        username.sendKeys(userName);
        return this;
    }

    public TheHerokuLoginPage setPassword(String userName) {
        WebElement username = driver.findElement(byPassword);
        username.clear();
        username.sendKeys(userName);
        return this;
    }

    public void successfullLogin(String userName, String password) {
                 setUsername("tomsmith")
                .setPassword("SuperSecretPassword!")
                .clickSubmit();
    }




}
