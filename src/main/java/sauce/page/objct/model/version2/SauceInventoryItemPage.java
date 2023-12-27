package sauce.page.objct.model.version2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceInventoryItemPage extends SauceBasePage{

    @FindBy(css = "[id*=add-to-cart]")
    protected WebElement buttonAddToCart;
    @FindBy(className = "shopping_cart_link")
    protected WebElement cartLink;

    @FindBy(id = "back-to-products")
    protected WebElement backToProducts;
    public SauceInventoryItemPage(WebDriver driver) {
        super(driver);
    }

    public SauceInventoryItemPage addProductToCart() {
        buttonAddToCart.click();
        return this;
    }

    public SauceCartPage goToCart() {
        cartLink.click();
        return new SauceCartPage(driver);
    }

    public SauceInventoryPage backToInventory() {
        backToProducts.click();
        return new SauceInventoryPage(driver);
    }
}
