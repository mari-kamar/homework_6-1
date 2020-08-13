package habrBdd.pagesHabr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HabrRegPage extends HabrBasePage{

    private By regTitle = By.xpath("//div[contains(text(),'Регистрация')]");
    private By regButton = By.xpath("//fieldset//div[contains(@class, 'form__buttons s-buttons')]//button[@name = 'go']");

    public HabrRegPage(WebDriver driver) {
        super(driver);
    }

    public void checkRegTitleIsVisible() {
        driver.findElement(regTitle).isDisplayed();
    }

    public void checkRegButtonIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//fieldset//div[contains(@class, 'form__buttons s-buttons')]//button[@name = 'go']")));
        driver.findElement(regButton).isDisplayed();
    }

}
