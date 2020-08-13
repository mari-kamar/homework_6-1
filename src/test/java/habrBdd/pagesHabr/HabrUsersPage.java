package habrBdd.pagesHabr;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class HabrUsersPage extends HabrBasePage {

    private Actions actions = new Actions(driver);
    private By searchUserField = By.xpath("//*[@id=\"people_suggest\"]");
    //private WebElement firstUserInList = driver.findElements(By.xpath("//ul[@id='peoples']/li[contains(@class, 'content-list__item_users')]/div/div/div/a")).get(0);
    //private WebElement firstUserInListLink = driver.findElement(By.xpath("//ul[@id='peoples']/li[contains(@class, 'content-list__item_users')]/div/div/div/a[1]"));

    public HabrUsersPage(WebDriver driver) {
        super(driver);
    }

    public HabrUsersPage search(String myUserSearch) {
        driver.findElement(searchUserField).sendKeys(myUserSearch);
        logger.info("Search page HABR is open");
        return this;
    }

    public HabrUsersPage openPersonalInfoFirstUser() {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='peoples']/li[contains(@class, 'content-list__item_users')]/div/div/div/a[1]")));
        WebElement firstUserInListLink = driver.findElement(By.xpath("//ul[@id='peoples']/li[contains(@class, 'content-list__item_users')]/div/div/div/a[1]"));
        actions.click(firstUserInListLink).build().perform();
        //actions.click(firstUserInList).build().perform();
        return this;
    }

    public HabrUsersPage checkRateForUser() {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a")));
        WebElement firstRate = driver.findElement(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a"));
        String firstRateText = firstRate.getText();
        Assert.assertEquals(firstRateText, "1–й");
        return this;
    }

    public HabrUsersPage checkRateStatus() {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'user-info__stats-item stacked-counter') and (@title='Рейтинг пользователя')]")));
        WebElement userRate = driver.findElement(By.xpath("//a[contains(@class, 'user-info__stats-item stacked-counter') and (@title='Рейтинг пользователя')]"));
        Assert.assertTrue(userRate.isDisplayed());
        return this;
    }
}
