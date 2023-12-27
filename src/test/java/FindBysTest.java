import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FindBysTest extends BaseTest{

    @FindAll({@FindBy(tagName = "a"), @FindBy(className = "google-link") })
    List<WebElement> links;
    @Test
    public void testFindBys() {
        PageFactory.initElements(driver, this);
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/findbys.html");

        log.info("links text = {}", links.stream().map(WebElement::getText).toList());


        Assert.assertEquals(links.size(), 3);

    }
}
