package kyPointTest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/default-cucumber-reports"
        },
        features = {"src/test/resources/Features"},
        glue = {"kyPointTest/stepDef"},
        dryRun = false,
        tags ="@login"
)
public class CukesRunner {
}
