package pl.tester.loger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileDownload {

    public static void main(String[] args) {
        String fileUrl = "https://the-internet.herokuapp.com/download/data9.txt";
        String savePath = "files/data9.txt";

        try {
            downloadFile(fileUrl, savePath);
            System.out.println("Plik został pomyślnie pobrany.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadFile(String fileUrl, String savePath) throws IOException {
        URL url = new URL(fileUrl);

        // Otwórz połączenie URL
        try (InputStream in = url.openStream()) {
            // Zapisz zawartość do pliku
            Path outputPath = Path.of(savePath);
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
