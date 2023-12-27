import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class CookieFirstTest extends BaseTest{
    @Test
    public void getAllCookiesFromSiteDropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie cookie: cookies) {
            log.info("Ciasto o nazwie {} ma wartość {}",
                    cookie.getName(), cookie.getValue());
        }

        Cookie bucketCookie = driver.manage().getCookieNamed("optimizelyBuckets");
        String value = "%7B%7D";

        Assert.assertEquals(bucketCookie.getValue(), value);
     }

}
