package habrBdd.steps;

import com.example.demo.DemoApplication;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import habrBdd.pagesHabr.HabrAuthPage;
import habrBdd.pagesHabr.HabrMainPage;
import habrBdd.pagesHabr.HabrRegPage;
import habrBdd.pagesHabr.HabrUsersPage;
import habrBdd.utils.SpringConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = SpringConfiguration.class)
@SpringBootTest(
        classes = DemoApplication.class
)
public class BaseStep {

    @Autowired
    @Qualifier("chrome")
    WebDriver driver;

    static HabrMainPage habrMainPage;
    static HabrAuthPage habrAuthPage;
    static HabrRegPage habrRegPage;
    static HabrUsersPage habrUsersPage;

    @Before
    public void init(){
        driver.manage().window().maximize();
        habrMainPage = new HabrMainPage(driver);
        habrAuthPage = new HabrAuthPage(driver);
        habrRegPage = new HabrRegPage(driver);
        habrUsersPage = new HabrUsersPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
