import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest extends BaseTest{
    @Test
    public void testDropdown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        List<WebElement> allOptions = dropdown.getOptions();
        System.out.println(allOptions);

        for(WebElement option : allOptions) {
            System.out.println(option.getText());
        }

       // dropdown.selectByVisibleText("Please select an option");
       // dropdown.selectByIndex(0);

        dropdown.selectByValue("1");
        dropdown.selectByIndex(2);

        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");

    }
}
