package sauce.page.objct.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceInventoryPage {
    private final WebDriver driver;

    public SauceInventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstProductDetails() {
        WebElement product = driver.findElement(By.className("inventory_item_name"));
        product.click();
    }
}
