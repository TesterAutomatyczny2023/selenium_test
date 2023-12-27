import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookieTest extends BaseTest{
    @Test
    public void showModalOnEntry() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/entry_ad");
        Thread.sleep(2000);

        var modalClose = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[3]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(modalClose));


        System.out.println("ciastka po wejściu na stronę");

        // Pobierz wszystkie ciasteczka
        Set<Cookie> cookies = driver.manage().getCookies();

        // Wyświetl informacje o ciasteczkach
        for (Cookie cookie : cookies) {
            System.out.println("Nazwa: " + cookie.getName() + ", Wartość: " + cookie.getValue());
        }


        modalClose.click();

        System.out.println("ciastka po zamknięciu modal--------------------------");

        Cookie cookieToSet = new Cookie("viewedOuibounceModal", "true");
        driver.manage().addCookie(cookieToSet);

        //driver.manage().deleteCookieNamed("viewedOuibounceModal");

        Cookie cookeToGet = driver.manage().getCookieNamed("viewedOuibounceModal");
        System.out.println("ciastko założone:");
        System.out.println(cookeToGet);

        // Pobierz wszystkie ciasteczka
        cookies = driver.manage().getCookies();

        // Wyświetl informacje o ciasteczkach
        for (Cookie cookie : cookies) {
            System.out.println("Nazwa: " + cookie.getName() + ", Wartość: " + cookie.getValue());
        }

        driver.navigate().refresh();

        Thread.sleep(2000);
    }

    @Test
    public void dontShowModalOnEntry() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        Cookie cookie = new Cookie("viewedOuibounceModal", "true");
        driver.manage().addCookie(cookie);


        driver.get("https://the-internet.herokuapp.com/entry_ad");
        Thread.sleep(2000);

    }
}
