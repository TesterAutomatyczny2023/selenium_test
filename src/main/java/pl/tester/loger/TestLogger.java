package pl.tester.loger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {

    private static final Logger logger = LogManager.getFormatterLogger(TestLogger.class);

    public static void main(String[] args) {
        int data = 2023;
        double bigNumber = Double.MAX_VALUE;
        logger.debug("dane w postaci string %s i tu też %s", data, bigNumber);
        logger.debug("Tu wstawiam dane kilka razy podajac ich kolejnosc %2$s with birthday %1$s %1$s,%1$s", data, bigNumber);
        logger.debug("tu używam przecinka do odzielenia kolejnych wartości liczby (w polskiej notacji będą to spacje) %,d", Integer.MAX_VALUE);
        logger.debug("a tu ograniczamy liczbe do 2 miejsc po przecinku %.2f", Math.PI);
        logger.debug("-----------------------------------------------------");
        int year = 2023;
        logger.info("Witaj w roku {}! Najlepszym roku do nauki Selenium!", year);

        // Logowanie poziomu TRACE
        logger.trace("To jest wiadomość logowana na poziomie TRACE.");

        // Logowanie poziomu DEBUG
        logger.debug("To jest wiadomość logowana na poziomie DEBUG.");

        // Logowanie poziomu INFO
        logger.info("To jest wiadomość logowana na poziomie INFO.");

        // Logowanie poziomu WARN
        logger.warn("To jest wiadomość logowana na poziomie WARN.");

        // Logowanie poziomu ERROR
        logger.error("To jest wiadomość logowana na poziomie ERROR.");

        // Logowanie poziomu FATAL
        logger.fatal("To jest wiadomość logowana na poziomie FATAL.");
    }
}
