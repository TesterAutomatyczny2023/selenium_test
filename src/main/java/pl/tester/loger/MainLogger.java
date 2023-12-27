package pl.tester.loger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLogger {
    private static final Logger logger = LogManager.getLogger(MainLogger.class);

    public static void main(String[] args) {
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
