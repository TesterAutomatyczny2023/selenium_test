import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sauce.page.objct.model.version2.*;

import java.util.List;

public class SauceAddProductToCartPOMv2Test extends BaseTest{
    @Test
    public void addProductToCart() throws InterruptedException {
        //go to page
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage loginPage = new SauceLoginPage(driver);
        //List<WebElement> allProducts =

        loginPage.login("standard_user","secret_sauce" )
                 .selectFirstProductDetails()
                 .addProductToCart()
                 .backToInventory()
                 .selectProduct(1)
                 .addProductToCart()
                 .goToCart();
        //         .getAllProducts();
        SauceCartPage cart = new SauceCartPage(driver);
        List<WebElement> allProducts = cart.getAllProducts();
        //check cart has one product
        Assert.assertEquals(allProducts.size(), 2, "Powinien być jeden product w koszyku a jest " + allProducts.size());
        //loginPage.notExists();
        List<ShopCartItem> items = cart.getShopCartItems();
        items.get(1).clickRemoveButton();
        items = cart.getShopCartItems();  
        double sum = items.stream().mapToDouble(ShopCartItem::getPrice).sum();
        items.stream().forEach( item ->
            log.info("{} cena produktu {}", item.getName(), item.getPrice())
        );
        log.info("suma cen produktów w koszyku:{}", sum);

        items.get(0).clickInventoryItemLink();

       

    }
}
