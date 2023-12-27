package sauce.page.objct.model.version2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SauceInventoryPage extends SauceBasePage{

    public SauceInventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_item_name")
    protected List<WebElement> inventoryItems;

    public SauceInventoryItemPage selectFirstProductDetails() {
        selectProduct(0);
//        WebElement product = driver.findElement(By.className("inventory_item_name"));
//        product.click();
        return new  SauceInventoryItemPage(driver);
    }

    public SauceInventoryItemPage selectProduct(int i) {
        inventoryItems.get(i).click();
        return new SauceInventoryItemPage(driver);
    }
}
