package sauce.page.objct.model.version2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceLoginPage extends SauceBasePage{
    @FindBy(id = "user-name")
    protected WebElement usernameElement;

    @FindBy(id = "user-name1")
    protected WebElement notExistElement;

    @FindBy(id = "password")
    protected WebElement passwordElement;

    @FindBy(id = "login-button")
    protected WebElement buttonElement;


    public SauceLoginPage(WebDriver driver) {
        super(driver);
    }

    public SauceLoginPage setUsername(String username) {
        usernameElement.sendKeys(username);
        return this;
    }

    public SauceLoginPage setPassword(String password) {

        passwordElement.sendKeys(password);
        return this;
    }

    public SauceInventoryPage submit() {

        buttonElement.click();
        return new SauceInventoryPage(driver);
    }

    public SauceInventoryPage login(String username, String password) {
        setUsername(username);
        setPassword(password);
        return submit();
    }

    public void notExists() {
        notExistElement.click();
    }
}
