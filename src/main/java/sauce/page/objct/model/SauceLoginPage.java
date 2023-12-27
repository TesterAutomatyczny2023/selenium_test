package sauce.page.objct.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceLoginPage {
    private WebDriver driver;
    public SauceLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String standardUser) {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
    }

    public void setPassword(String secretSauce) {
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
    }

    public void submit() {
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
    }
}
