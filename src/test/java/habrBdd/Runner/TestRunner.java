package habrBdd.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/html", "json:target/cucumber/json/cucumber.json", "pretty"},
        monochrome = true,
        features = "src/test/java/habrBdd/featuresHabr/habrMain.feature",
        glue = {"habrBdd/steps"}
)
public class TestRunner {
}
