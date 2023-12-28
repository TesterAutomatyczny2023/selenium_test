import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestTheInternetHeroku {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void OpenTheInternetHeroku() {
        driver.get("https://the-internet.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }

    @Test(enabled = false)
    public void LoginFailed() {
        driver.get("https://the-internet.herokuapp.com/login");
        //zanjdz pola do logowania
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement form = driver.findElement(By.id("login"));
        //wpisz nie prawidlowe dane
        username.sendKeys("tomsmith");
        password.sendKeys("ZleHaslo");
        //wyslij fomrularz
        form.submit();
        //sprawdz czy pokaze sie jeden z tekstów
        String xpathExpression = "//*[contains(text(), 'Your username is invalid!')]";
        xpathExpression = "//*[contains(text(), 'Your username is invalid!') or contains(text(), 'Your password is invalid!')]";
        // Użyj metody findElement z wyrażeniem XPath
        WebElement element = driver.findElement(By.xpath(xpathExpression));
        Assert.assertTrue(element.getText().equals("Your username is invalid!") ||
                element.getText().equals("Your password is invalid"));
        // Your username is invalid!
        // Your password is invalid!
    }
    @Test
    public void LoginSuccess() {
        driver.get("https://the-internet.herokuapp.com/login");
        //zanjdz pola do logowania
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement form = driver.findElement(By.id("login"));

        //wpisz nie prawidlowe dane
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        //wyslij fomrularz
        form.submit();

        //sprawdz strone na ktorej sie znajdujesz po logowaniu
        //https://the-internet.herokuapp.com/secure
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Assert.assertEquals(currentURL, "https://the-internet.herokuapp.com/secure");

        //sprawdz tekst
        // You logged into a secure area!
        String xpath = "//*[contains(text(), 'You logged into a secure area!')]";
        WebElement text = driver.findElement(By.xpath(xpath));
        System.out.println(text.getText());
        System.out.println("You logged into a secure area!");
        Assert.assertTrue(text.getText().contains("You logged into a secure area!"));
    }

    @Test
    public void ElementIsInvisbleWaitForShow(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button"));
        button.click();

        WebElement finish = driver.findElement(By.cssSelector("#finish"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(finish));
        Assert.assertTrue(finish.isDisplayed());
    }

    @Test
    public void ElementIsNotPresentWaitToBePresent(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button"));
        button.click();

        WebElement finish = driver.findElement(By.cssSelector("#finish"));
        Assert.assertTrue(finish.isDisplayed());
    }

    @Test
    public void dynamicEmlements() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement button = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toHide =  driver.findElement(By.cssSelector("#checkbox"));

        
        wait.until(ExpectedConditions.stalenessOf(toHide));
        Assert.assertThrows(StaleElementReferenceException.class, toHide::isDisplayed);

        WebElement buttonEnable = driver.findElement(By.cssSelector("form#input-example button"));
        buttonEnable.click();

        WebElement edit = driver.findElement(By.cssSelector("form#input-example input"));
        wait.until(ExpectedConditions.elementToBeClickable(edit));
        Assert.assertTrue(edit.isEnabled());






    }
}
