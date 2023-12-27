package sauce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    protected WebElement username;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(id = "login-button")
    protected WebElement submit;

    public LoginPage(WebDriver driver) {
      super(driver);
    }

    public LoginPage setUsername(String user) {
        username.clear();
        username.sendKeys(user);
        return this;
    }

    public LoginPage setPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
        return this;
    }

    public void clickSubmit() {
        submit.click();
    }

    public InventoryPage login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSubmit();
        return new InventoryPage(driver);
    }
}
