package sauce.page.objct.model.version2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.object.model.BasePage;

public class SauceBasePage {
    protected final WebDriver driver;
    public static final Logger log = LogManager.getLogger(SauceBasePage.class);

    public SauceBasePage(WebDriver driver) {
        this.driver = driver;
        log.info("initElements");
        PageFactory.initElements(driver, this);
    }
}
