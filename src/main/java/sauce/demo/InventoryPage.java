package sauce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends BasePage{
    @FindBy(className = "inventory_item_name")
    protected List<WebElement> allProducts;

    public InventoryPage(WebDriver driver) {
      super(driver);
    }

    public InventoryItemPage selectFirstProduct() {
        return selectProduct(0);
    }

    public InventoryItemPage selectProduct(int index) {
        allProducts.get(index).click();
        return new InventoryItemPage(driver);
    }


}
