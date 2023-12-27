import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sauce.page.objct.model.version2.*;

import java.util.List;

public class SauceAddProductToCartPOMTest extends BaseTest{
    @Test
    public void addProductToCart() {
        //go to page
        driver.get("https://www.saucedemo.com/");
        //login
//        WebElement username = driver.findElement(By.id("user-name"));
//        WebElement password = driver.findElement(By.id("password"));
//        WebElement button = driver.findElement(By.id("login-button"));
//        username.sendKeys("standard_user");
//        password.sendKeys("secret_sauce");
//        button.click();

        SauceLoginPage loginPage = new SauceLoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.submit();

        //select first product details
//        WebElement product = driver.findElement(By.className("inventory_item_name"));
//        product.click();

        SauceInventoryPage inventoryPage = new SauceInventoryPage(driver);
        inventoryPage.selectFirstProductDetails();
        //add product to cart
//        WebElement buttonAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
//        buttonAddToCart.click();

        SauceInventoryItemPage inventoryItemPage = new SauceInventoryItemPage(driver);
        inventoryItemPage.addProductToCart();
        //go to cart
//        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
//        cartLink.click();
        inventoryItemPage.goToCart();
        //check cart has one product
//        List<WebElement> allProducts = driver.findElements(By.className("cart_item"));
        SauceCartPage cart = new SauceCartPage(driver);
        List<WebElement> allProducts = cart.getAllProducts();

        Assert.assertEquals(allProducts.size(), 1, "Powinien być jeden product w koszyku a jest " + allProducts.size());

    }
}
