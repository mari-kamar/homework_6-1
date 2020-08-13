package habrBdd.pagesHabr;

import cucumber.api.java.hu.Ha;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest()
public class HabrAuthPage extends HabrBasePage{

    private By authTitle = By.xpath("//div[contains(text(),'Вход')]");

    private By emailField = By.xpath("//input[@type='email'] ");

    private By passwordField = By.xpath("//input[@type='password'] ");

    private By submitButton = By.xpath("//div[contains(@class, 's-buttons')]//button[@type='submit'] ");

    private By emailError = By.xpath("//div[contains(., 'Введите корректный e-mail') and @class='s-error']");



    public HabrAuthPage(WebDriver driver) {
        super(driver);
    }

    public void checkAuthTitleIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Вход')]")));
        driver.findElement(authTitle).isDisplayed();
    }

    public void insertLoginAndPassword() {
        driver.findElement(emailField).sendKeys("test");
        driver.findElement(passwordField).sendKeys("password");
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void checkButtonIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(., 'Введите корректный e-mail') and @class='s-error']")));
        driver.findElement(emailError).isDisplayed();
    }

    public void checkAuthButtonIsVisible() {
        driver.findElement(submitButton).isDisplayed();
    }
}
