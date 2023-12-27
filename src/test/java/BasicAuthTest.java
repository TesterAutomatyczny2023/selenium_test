import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest{
    @Test
    public void testBasicAuth() throws InterruptedException {
        driver.get("https://admina:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);
        for( var window : driver.getWindowHandles() )
        {
            log.info(window);
        }
        log.info(driver.getWindowHandles().size());
    }
}
