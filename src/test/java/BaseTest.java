import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pl.tester.loger.MyFirstLogger;
import utils.ScreenshotUtil;

import java.io.IOException;

public class BaseTest {
    protected static WebDriver driver;
    public static final Logger log = LogManager.getLogger(BaseTest.class);
    private long startTime;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestResult myTest) {
        log.info("Test " + myTest.getMethod().getMethodName() + " started");
        startTime = System.currentTimeMillis();
    }

    @AfterMethod(alwaysRun = true)
    public void methodTearDown(ITestResult result) throws IOException {
        if(result.getStatus() != ITestResult.SUCCESS){
            String screenshotName = "screenshots/" + result.getName() + result.getEndMillis() + ".png";
            ScreenshotUtil.takeScreenshot(driver, screenshotName);
        }
        long endTime = System.currentTimeMillis();
        log.info("Test {} wykonał się w {}ms", result.getMethod().getMethodName(), endTime - startTime);
    }

    public void takeScreenshot(ChromeDriver driver, String screenshotName) throws IOException {
        ScreenshotUtil.takeScreenshot(driver, screenshotName);
    }

    @AfterClass(alwaysRun = true)
    public void classTearDown() {
        driver.quit();
    }
}
