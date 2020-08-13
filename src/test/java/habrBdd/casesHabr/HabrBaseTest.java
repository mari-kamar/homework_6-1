/*
package habrBdd.casesHabr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import habrBdd.utils.WebDriverFactory;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class HabrBaseTest {
    public static Logger logger = LogManager.getLogger(HabrBaseTest.class);
    public static WebDriver driver;
    public static WebDriverFactory factory = new WebDriverFactory();

    public static String browser = System.getProperty("browser");
    public static String options = System.getProperty("options");


    @BeforeAll
    public static void setup() {
        if (options == null) {
            driver = factory.createDriver(browser);
        } else {
            driver = factory.createDriver(browser, options);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void closedown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}
*/
