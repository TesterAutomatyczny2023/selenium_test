package sauce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage extends BasePage{

    @FindBy(css = "[id*=add-to-cart]")
    protected WebElement buttonAddToCart;

    @FindBy(id = "back-to-products")
    protected WebElement inventoryLink;

    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }
    public InventoryItemPage addToCart() {
        buttonAddToCart.click();
        return this;
    }



    public InventoryPage goToInventory() {
        inventoryLink.click();
        return new InventoryPage(driver);
    }
}
