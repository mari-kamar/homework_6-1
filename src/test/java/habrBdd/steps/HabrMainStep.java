package habrBdd.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import habrBdd.pagesHabr.HabrMainPage;

public class HabrMainStep{

    HabrMainPage habrMainPage = BaseStep.habrMainPage;

    @Given("I am on main page")
    public void iAmOnMainPage() {
        habrMainPage.open();
    }

    @Then("I see logo is visible")
    public void iSeeLogoIsVisible() {
        habrMainPage.getMainLogo().isDisplayed();
    }

    @When("I click auth button")
    public void iClickAuthButton() {
        habrMainPage.auth();
    }

    @When("I click change language button")
    public void iClickChangeLanguageButton() {
        habrMainPage.openLangPopup();
    }

    @Then("change language popup is visible")
    public void changeLanguagePopupIsVisible() {
        habrMainPage.showLangPopup();
    }

    @And("click english language")
    public void clickEnglishLanguage() {
        habrMainPage.clickEnglishRadio();
    }

    @And("click save settings button")
    public void clickSaveSettingsButton() {
        habrMainPage.clickSaveSettingsButton();
    }

    @Then("check title in english")
    public void checkTitleInEnglish() {
        habrMainPage.checkMainTitle();
    }

    @When("I click reg button")
    public void iClickRegButton() {
        habrMainPage.reg();
    }

    @When("I click on users link")
    public void iClickOnUsersLink() {
        habrMainPage.users();
    }

    @Then("I check a request")
    public void iCheckARequest() {
        habrMainPage.checkRequest();
    }

    @When("I make a request")
    public void iMakeARequest() {
        habrMainPage.search();
    }
}
