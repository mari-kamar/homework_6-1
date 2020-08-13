package habrBdd.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import habrBdd.pagesHabr.HabrAuthPage;
import habrBdd.pagesHabr.HabrUsersPage;

public class HabrUsersStep {

    HabrUsersPage habrUsersPage = BaseStep.habrUsersPage;

    @And("open Users info")
    public void openUsersInfo() {
        habrUsersPage.openPersonalInfoFirstUser();
    }

    @Then("check rate")
    public void checkRate() {
        habrUsersPage.checkRateForUser();
    }

    @Then("rate status is visible")
    public void rateStatusIsVisible() {
        habrUsersPage.checkRateStatus();
    }
}
