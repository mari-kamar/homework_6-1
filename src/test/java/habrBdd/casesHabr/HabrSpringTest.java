package habrBdd.casesHabr;

import com.example.demo.DemoApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import habrBdd.pagesHabr.HabrMainPage;
import habrBdd.pagesHabr.HabrNewsPage;
import habrBdd.pagesHabr.HabrPostsPage;

@SpringBootTest(
        classes = DemoApplication.class
)
public class HabrSpringTest {
    public static Logger logger = LogManager.getLogger(HabrSpringTest.class);

    @Autowired
    @Qualifier("chrome")
    WebDriver driver;

    // Проверка, что логотип отображается на главной странице
    @Test
    public void habrTest1() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();

        Assert.assertTrue(habrMainPage.getMainLogo().isDisplayed());
        logger.info("Отображается логотип сайта");
    }

    // Проверка, что при переходе на страницу Авторизации есть заголовок "Вход"
    @Test
    public void habrTest2() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .auth();

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Вход')]")));
        WebElement authTitle = driver.findElement(By.xpath("//div[contains(text(),'Вход')]"));
        Assert.assertEquals(authTitle.getText(), "Вход");
        logger.info("Отображается заголовок Вход");
    }

    // Проверка, что на странице авторизации есть кнопка Вход
    @Test
    public void habrTest3() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .auth();

        WebElement enterButton = driver.findElement(By.xpath("//button[@name = 'go']"));
        Assert.assertTrue(enterButton.isDisplayed());
        logger.info("Отображается кнопка Вход");
    }

    // Проверка, что при переходе на страницу Регистрации есть заголовок "Регистрация"
    @Test
    public void habrTest4() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .reg();

        WebElement regTitle = driver.findElement(By.xpath("//div[contains(text(),'Регистрация')]"));
        Assert.assertEquals(regTitle.getText(), "Регистрация");
        logger.info("Отображается заголовок Регистрация");
    }

    // Проверка, что на странице Регистрации отображается кнопка Регистрация
    @Test
    public void habrTest5() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .reg();

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'registration_button']")));
        WebElement registrationButton = driver.findElement(By.xpath("//button[@id = 'registration_button']"));
        Assert.assertTrue(registrationButton.isDisplayed());
        logger.info("Отображается кнопка Регистрация");
    }

    // Проверка, что при переходе на страницу поиска значение value в поле поиска, совпадает с введенным на главной странице
    @Test
    public void habrTes6() {
        String myText = "maven";
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .search();

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'search-field__input')]")));
        String xpath = "//input[contains(@value,'" + myText + "')]";
        WebElement searchText = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(searchText.getAttribute("value"), myText);
        logger.info("Поиск работает");
    }

    // Проверка, что в списке есть пользователь, которого искали
    @Test
    public void habrTest7() {
        String myUserSearch = "oldadmin";
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .users()
                .search(myUserSearch);

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'list-snippet__username')]")));
        String xpath = "//*[contains(@class, 'list-snippet__username')]/a[contains(@class,'list-snippet__nickname') and contains(text(), '" + myUserSearch + "')]";
        WebElement userText = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(userText.getText(), myUserSearch);
        logger.info("Найден пользователь, которого искали");
    }

    //Проверка открытия попапа смены языка
    @Test
    public void habrTest8() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .openLangPopup();

        Assert.assertTrue(habrMainPage.showLangPopup().isDisplayed());
        logger.info("Отображается попап смены языка");
    }

    //Проверка, что отображается кнопка сохранения настроек
    @Test
    public void habrTest9() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .openLangPopup();

        WebElement saveSettingsButton = driver.findElement(By.xpath("//div[@class='form__footer form__footer_lang-settings']"));
        Assert.assertTrue(saveSettingsButton.isDisplayed());
        logger.info("Отображается кнопка сохранения настроек выбора языка");
    }

    //Проверка заголовка статьи
    @Test
    public void habrTest10() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        HabrNewsPage habrNewsPage = habrMainPage.open()
                .news()
                .openFirstArticle();

        WebElement titleNews = driver.findElement(By.xpath("//h2[contains(@class, 'post__title')]"));
        String textTitleNews = titleNews.getText();
        Assert.assertEquals(habrNewsPage.getTitleNewsFirst(), textTitleNews);
        logger.info("Отображается заголовок статьи по которому переходили");
    }

    // Проверка, что первый в списке пользователь с рейтингом 1
    @Test
    public void habrTes11() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .users()
                .openPersonalInfoFirstUser();

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a")));
        WebElement firstRate = driver.findElement(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a"));
        String firstRateText = firstRate.getText();
        Assert.assertEquals(firstRateText, "1–й");
        logger.info("Отображается рейтинг первого в списке пользователя");
    }

    // Проверка, что отображается рейтинг у зарегестированного пользователя
    @Test
    public void habrTest12() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .users()
                .openPersonalInfoFirstUser();

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'user-info__stats-item stacked-counter') and (@title='Рейтинг пользователя')]")));
        WebElement userRate = driver.findElement(By.xpath("//a[contains(@class, 'user-info__stats-item stacked-counter') and (@title='Рейтинг пользователя')]"));
        Assert.assertTrue(userRate.isDisplayed());
        logger.info("Отображается рейтинг пользователя");
    }

    // Проверка открытия первого поста
    @Test
    public void habrTest13() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        HabrPostsPage habrPostsPage = habrMainPage.open()
                .posts()
                .openFirstPost();

        WebElement titlePost = driver.findElement(By.xpath("//h1[contains(@class, 'post__title')]"));
        String textTitlePost = titlePost.getText();
        Assert.assertEquals(habrPostsPage.getTitlePostFirst(), textTitlePost);
        logger.info("Открытие первого в списке поста");
    }

    // Проверка открытия страницы информации об авторе первого поста
    @Test
    public void habrTest14() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .posts()
                .openPostAuthor();

        WebElement rate = driver.findElement(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a"));
        Assert.assertTrue(rate.isEnabled());
        logger.info("Отображается страница информации автора первого поста из списка");
    }

    // Проверка наличия приглашения у автора
    @Test
    public void habrTest15() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .posts()
                .openPostAuthor();

        WebElement invite = driver.findElement(By.xpath("//p[@class = 'profile-section__invited']"));
        Assert.assertTrue(invite.isDisplayed());
        logger.info("Отображается приглашение у автора");
    }

    @AfterEach
    public void closedown() {
        System.out.println("\nCLOSEDOWN");
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}