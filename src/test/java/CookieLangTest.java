import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class CookieLangTest extends BaseTest{
    @Test
    public void testLangCookie() throws InterruptedException {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/index.html");

        Cookie lang = new Cookie("lang", "PL");

        driver.manage().addCookie(lang);

        System.out.println(driver.manage().getCookieNamed("lang").getValue());
        Thread.sleep(2000);

        driver.navigate().refresh();

        System.out.println(driver.manage().getCookieNamed("lang").getValue());
        Thread.sleep(2000);

        lang = new Cookie("lang", "EN");

        driver.manage().addCookie(lang);

        driver.navigate().refresh();

        System.out.println(driver.manage().getCookieNamed("lang").getValue());
        Thread.sleep(2000);

        lang = new Cookie("lang", "DE");

        driver.manage().addCookie(lang);

        driver.navigate().refresh();

        System.out.println(driver.manage().getCookieNamed("lang").getValue());
        Thread.sleep(2000);

        driver.manage().deleteCookie(lang);

        driver.navigate().refresh();

        System.out.println(driver.manage().getCookieNamed("lang"));
        Thread.sleep(2000);


    }

    @Test
    public void testFavorite() throws InterruptedException {
        driver.get("https://testerautomatyczny2023.github.io/CookieTesting/favorite.html");

        Cookie cookie = new Cookie("favorite", "Shrek United");
        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        Thread.sleep(4000);
    }
}
