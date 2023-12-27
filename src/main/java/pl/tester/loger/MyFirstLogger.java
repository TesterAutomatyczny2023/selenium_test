package pl.tester.loger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyFirstLogger {

    private static final Logger log = LogManager.getLogger(MyFirstLogger.class);
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //tu jakaś operacja, która zajmuje dużo czasu, może test w Selenium ?  :)
        long endTime = System.currentTimeMillis();
        log.info("Upłyneło czasu {}ms ", endTime - startTime);


        log.info("To jest test");
        log.info("{} to {} sa dane", 10, 20);
    }
}
