package sauce.page.objct.model.version2;

import org.openqa.selenium.WebElement;

public class ShopCartItem {
    private String name;
    private String description;
    private int quantity;
    private double price;

    private WebElement inventoryItemLink;
    private WebElement removeButton;

    public void clickInventoryItemLink() {
        inventoryItemLink.click();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void setInventoryItemLink(WebElement inventoryItemLink) {
        this.inventoryItemLink = inventoryItemLink;
    }

    public void setRemoveButton(WebElement removeButton) {
        this.removeButton = removeButton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
