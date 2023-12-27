package page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = new ChromeDriver();
    }
}
