import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.object.model.TheHerokuAddAndRemoveElementsPage;

public class TheInternetHerokuAddAndRemoveElementsTest extends BaseTest{
    @Test
    public void addAndRemoveElements() {

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        TheHerokuAddAndRemoveElementsPage page = new TheHerokuAddAndRemoveElementsPage(driver);
        page.addElement();
        Assert.assertEquals(page.getElementCount(), 1);

        page.addElement();
        Assert.assertEquals(page.getElementCount(), 2);

        page.addElement(100);
        Assert.assertEquals(page.getElementCount(),102);
    }
}
