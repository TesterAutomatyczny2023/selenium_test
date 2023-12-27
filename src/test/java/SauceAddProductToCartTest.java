import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceAddProductToCartTest extends BaseTest{

    @Test
    public void addProductToCart() {
        //go to page
        driver.get("https://www.saucedemo.com/");
        //login
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        button.click();
        //select first product details
        WebElement product = driver.findElement(By.className("inventory_item_name"));
        product.click();
        //add product to cart
        WebElement buttonAddToCart = driver.findElement(By.cssSelector("[id*=add-to-cart]"));
        buttonAddToCart.click();
        //go to cart
        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();
        //check cart has one product
        List<WebElement> allProducts = driver.findElements(By.className("cart_item"));

        Assert.assertEquals(allProducts.size(), 1, "Powinien być jeden product w koszyku a jest " + allProducts.size());

    }
}
