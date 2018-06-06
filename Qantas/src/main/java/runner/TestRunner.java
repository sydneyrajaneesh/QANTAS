package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "services" }, features = { "src/main/java/features" }, format = { "pretty",
		"html:target/site/cucumber-pretty", "json:target/cucumber.json" }, dryRun = false)

public class TestRunner {

}
