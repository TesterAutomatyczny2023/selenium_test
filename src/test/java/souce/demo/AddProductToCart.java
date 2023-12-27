package souce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sauce.demo.*;

import java.util.List;

public class AddProductToCart extends BaseTest{

    private final String URL = "https://www.saucedemo.com/";
    @Test
    public void addProductToCart() {
        //go to page
        driver.get(URL);
        //login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce")
                 .selectFirstProduct()
                 .addToCart()
                 .goToInventory()
                 .selectProduct(1) //0 -pierwszy, 1 -drugi
                 .addToCart()
                 .goToInventory()
                 .selectProduct(2)
                 .addToCart()
                 .goToCart();

        //check cart has one product
        CartPage cart = new CartPage(driver);
        List<WebElement> allProducts = cart.getAllProducts();

        List<CartItem> cartItems = cart.getAllCartItems();
        for (CartItem cartItem : cartItems) {
            log.info(cartItem.getDescription());
            log.info(cartItem.getQuantity());
            log.info(cartItem.getPrice());
        }
        cartItems.get(2).remove();
        cartItems.get(1).goToDetails();
        cart.goToCart();

        log.info("suma zakupów w koszyku: " + cart.getTotal());


        Assert.assertEquals(allProducts.size(), 2, "Powinien być jeden product w koszyku a jest " + allProducts.size());
        Assert.assertEquals(cart.getTotal(), 39.98);
    }
}
