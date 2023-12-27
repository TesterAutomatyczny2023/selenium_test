package sauce.page.objct.model.version2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SauceCartPage extends SauceBasePage{

    @FindBy(className = "cart_item")
    protected List<WebElement> products;
    protected By byInventoryItemName = By.className("inventory_item_name");
    protected By byInventoryItemDescription = By.className("inventory_item_desc");
    protected By byCartQuantity = By.className("cart_quantity");
    protected By byItemPrice = By.className("inventory_item_price");
    protected By byRemoveButton = By.cssSelector("button[id*=remove]");
    private By byInventoryItemLink = By.cssSelector("a[id*=item]");

    public SauceCartPage(WebDriver driver){
        super(driver);

    }

    public List<WebElement> getAllProducts() {
        return products;
    }

    public List<ShopCartItem> getShopCartItems() {
        List<ShopCartItem> result = new ArrayList<>();
        for(var product: products) {
            ShopCartItem item = new ShopCartItem();
            item.setName(product.findElement(byInventoryItemName).getText());
            item.setDescription(product.findElement(byInventoryItemDescription).getText());
            item.setQuantity(Integer.parseInt(product.findElement(byCartQuantity).getText()));
            item.setPrice(Double.parseDouble(product.findElement(byItemPrice).getText().substring(1)));
            item.setRemoveButton(product.findElement(byRemoveButton));
            item.setInventoryItemLink(product.findElement(byInventoryItemLink));
            result.add(item);
        }
        return result;
    }
}
