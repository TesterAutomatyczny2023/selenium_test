package sauce.page.objct.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceInventoryItemPage {
    private final WebDriver driver;

    public SauceInventoryItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        WebElement buttonAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        buttonAddToCart.click();
    }

    public void goToCart() {
        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();
    }
}
