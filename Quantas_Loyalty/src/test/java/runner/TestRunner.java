package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:test-output" }, glue = { "servicelayer" }, features = {
		"src/test/bdd_scenarios" }, dryRun = false)

public class TestRunner {

}


