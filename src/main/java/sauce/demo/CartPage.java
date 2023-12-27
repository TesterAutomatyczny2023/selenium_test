package sauce.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    @FindBy(className = "cart_item")
    List<WebElement> products;

    private double total;



    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement>  getAllProducts() {
        return products;
    }

    public double getTotal() {
        total = 0;
        for( var cartItem : getAllCartItems()) {
            total += cartItem.getPrice();
        }
        return total;
    }

    public List<CartItem> getAllCartItems() {
        List<CartItem> cartItems = new ArrayList<>();
        for( var product : products ) {
            CartItem cartItem = new CartItem();
            cartItem.setDescription(product.findElement(By.className("inventory_item_desc")).getText());
            cartItem.setQuantity(Integer.parseInt( product.findElement(By.className("cart_quantity")).getText()));
            cartItem.setPrice(
                    Double.parseDouble(
                            product.findElement(By.className("inventory_item_price"))
                                    .getText()
                                    .substring(1)));
            cartItem.setLinkDetails(product.findElement(By.className("inventory_item_name")));
            cartItem.setButtonRemove(product.findElement(By.cssSelector("button[id*=remove]")));
            cartItems.add(cartItem);
        }
        return cartItems;
    }
}
