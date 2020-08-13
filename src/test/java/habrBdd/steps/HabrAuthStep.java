package habrBdd.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import habrBdd.pagesHabr.HabrAuthPage;


public class HabrAuthStep{

    HabrAuthPage habrAuthPage = BaseStep.habrAuthPage;

    @Then("auth title is visible")
    public void authTitleIsVisible() {
        habrAuthPage.checkAuthTitleIsVisible();
    }

    @And("write email and password")
    public void writeEmailAndPassword() {
        habrAuthPage.insertLoginAndPassword();
    }

    @And("click enter button")
    public void clickEnterButton() {
        habrAuthPage.clickSubmitButton();
    }

    @Then("check warnings")
    public void checkWarnings() {
        habrAuthPage.checkButtonIsVisible();
    }

    @Then("auth button is visible")
    public void authButtonIsVisible() {
        habrAuthPage.checkAuthButtonIsVisible();
    }
}
