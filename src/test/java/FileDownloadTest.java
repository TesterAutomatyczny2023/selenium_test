import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;



public class FileDownloadTest extends BaseTest{

    // Metoda do pobierania rozmiaru pliku
    private static long getFileSize(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.size(path);
    }
    @Test
    public void testFileDownloadTesttxt() throws InterruptedException, IOException {
    driver.get("https://the-internet.herokuapp.com/download");

    String name = "5mb script.xml";

    var fileToDownload = driver.findElement(By.cssSelector("[href='download/"+ name + "']"));
    fileToDownload.click();
   // Thread.sleep(2000);

    // Ścieżka do folderu, gdzie Chrome domyślnie zapisuje pobrane pliki
    String downloadFolderPath = System.getProperty("user.home") + "/Downloads";

    System.out.println(downloadFolderPath);
    String filePath = downloadFolderPath + "/" + name;
    File file = new File(filePath);
    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(100));
    wait.until( x -> file.exists());


    long fileSize = getFileSize(filePath);
        System.out.println(fileSize);
        Path path = Paths.get(filePath);
        Assert.assertEquals(Files.size(path), 5022630);
        log.info("Plik {} został ściągnięty. Wielkość pliku {}", filePath, Files.size(path));
        Files.delete(path);
        log.info("Plik {} został usunięty", filePath);

        Assert.assertFalse(Files.exists(path));
}
}
