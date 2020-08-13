package habrBdd.steps;

import cucumber.api.java.en.Then;
import habrBdd.pagesHabr.HabrRegPage;

public class HabrRegStep {
    HabrRegPage habrRegPage = BaseStep.habrRegPage;

    @Then("reg title is visible")
    public void regTitleIsVisible() {
        habrRegPage.checkRegTitleIsVisible();
    }

    @Then("reg button is visible")
    public void regButtonIsVisible() {
        habrRegPage.checkRegButtonIsVisible();
    }
}
