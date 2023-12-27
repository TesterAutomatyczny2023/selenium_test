import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestSelect extends BaseTest{
    @Test
    public void testSelect() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement select = driver.findElement(By.id("dropdown"));

        Select select1 = new Select(select);
        System.out.println(select1.getOptions());

        select1.selectByIndex(1);
        Thread.sleep(2000);
        select1.selectByValue("2");
        Thread.sleep(2000);
        select1.selectByVisibleText("Option 1");
        Thread.sleep(2000);

    }
}
