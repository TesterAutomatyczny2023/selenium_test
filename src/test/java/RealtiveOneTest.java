import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RealtiveOneTest extends BaseTest{

    @DataProvider(name="buttons")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"button1", "Tekst dla przycisku 1"},
                {"button2", "Tekst dla przycisku 2"},
                {"button3", "Tekst dla przycisku 3"},
        };
    }
    @Test(dataProvider = "buttons")
    public void relativeOneTest(String button, String text) throws InterruptedException {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativetwo.html");
        WebElement button1 = driver.findElement(By.id(button));
        log.info("id = button1, {}",  button1.getText());

        WebElement div1 = driver.findElement(RelativeLocator.with(By.tagName("div")).below(button1));
       // WebElement div2 = driver.findElement( RelativeLocator.with(By.tagName("div")).above(div1));
        log.info("div pod button 1 i jego tekst = {}", div1.getText());
        log.info(div1.isDisplayed());
        Assert.assertEquals(div1.getText(), text);

        button1.click();

//        WebElement div2 = driver.findElement(RelativeLocator.with(By.tagName("div")).below(button1));
//        log.info("div pod przyciskiem button1 i jego tekst = {}", div2.getText());
//        log.info(div2.isDisplayed());
//        Thread.sleep(2000);

        button1.click();

//        Thread.sleep(2000);
//        log.info(div2.isDisplayed());


     //   log.info(div2.getText());


    }

    @Test
    public void formBelowTest() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");
        WebElement email = driver.findElement(By.id("email"));

        WebElement password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(email));
        log.info(password.getText());
        log.info(password.isDisplayed());
        log.info(password.getAttribute("id"));


    }

    @Test
    public void formBelowBelowTest() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");
        WebElement email = driver.findElement(By.id("email"));

        WebElement password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(email));
        log.info(password.getText());
        log.info(password.isDisplayed());
        log.info(password.getAttribute("id"));

        WebElement cancel = driver.findElement(RelativeLocator.with(By.tagName("button")).below(password));
        log.info("cancel = {}", cancel.getText() );

        WebElement login = driver.findElement(RelativeLocator.with(By.tagName("button")).toLeftOf(cancel));
        log.info("login = {}", login.getText());

    }

    @Test
    public void formAboveTest() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");
        WebElement password = driver.findElement(By.id("password"));

        WebElement email = driver.findElement(RelativeLocator.with(By.tagName("input")).above(password));
        log.info(email.getText());
        log.info(email.isDisplayed());
        log.info(email.getAttribute("id"));


    }

    @Test
    public void rightOfTest() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");
        WebElement login = driver.findElement(By.className("login-button"));
        WebElement cancel = driver.findElement(RelativeLocator.with(By.tagName("button")).toRightOf(login));
        log.info(cancel.getText());
    }

    @Test
    public void leftOfTest() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativeform.html");
        WebElement cancel = driver.findElement(By.className("cancel-button"));
        WebElement login = driver.findElement(RelativeLocator.with(By.tagName("button")).toLeftOf(cancel));
        log.info(login.getText());
    }

    @Test
    public void buttonsTest() {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/relativebuttons.html");
        WebElement middle = driver.findElement(By.id("middle"));

        //up

        WebElement up = driver.findElement(RelativeLocator.with(By.tagName("button")).above(middle));
        up.click();
        Assert.assertEquals(up.getText(), "2");
        //down
        WebElement down = driver.findElement(RelativeLocator.with(By.tagName("button")).below(middle));
        down.click();
        Assert.assertEquals(down.getText(), "8");
        //left

        //right

        //up-left

        //up-right

        //down-left
        WebElement downLeft = driver.findElement(RelativeLocator.with(By.tagName("button")).below(middle).toLeftOf(middle));
        downLeft.click();
        Assert.assertEquals(downLeft.getText(), "7");

        //down-right
        WebElement downRight = driver.findElement(RelativeLocator.with(By.tagName("button")).below(middle).toRightOf(middle));
        downRight.click();
        Assert.assertEquals(downRight.getText(), "9");
    }
}
