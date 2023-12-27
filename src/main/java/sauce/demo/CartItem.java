package sauce.demo;

import org.openqa.selenium.WebElement;

public class CartItem {
    private String description;
    private int quantity;
    private double price;

    private WebElement buttonRemove;
    private WebElement linkDetails;

    public void remove() {
        buttonRemove.click();
    }

    public void goToDetails() {
        linkDetails.click();
    }

     public void setButtonRemove(WebElement buttonRemove) {
        this.buttonRemove = buttonRemove;
    }

    public void setLinkDetails(WebElement linkDetails) {
        this.linkDetails = linkDetails;
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
