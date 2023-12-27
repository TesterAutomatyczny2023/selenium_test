package sauce.page.objct.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SauceCartPage {
    private final WebDriver driver;

    public SauceCartPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(By.className("cart_item"));
    }
}
