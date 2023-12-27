package heroku.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TheHerokuAppLoginPage {
    private final WebDriver driver;
    By byUsername = By.id("username");
    By byPassword = By.id("password");
    By bySubmit = By.cssSelector("button[type=submit]");

    public TheHerokuAppLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPassword(String pass) {
        WebElement passwordElement = driver.findElement(byPassword);
        passwordElement.sendKeys(pass);
    }

    public void setUserName(String user) {
        WebElement userElement = driver.findElement(byUsername);
        userElement.sendKeys(user);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(bySubmit);
        submit.click();
    }
}
