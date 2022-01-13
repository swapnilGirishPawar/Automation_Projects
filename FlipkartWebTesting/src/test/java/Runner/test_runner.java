package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions
(
		features = {"\\src\\test\\resources\\Login\\Login.feature"},
		glue= {"StepDefination"},
		dryRun= true
)

public class test_runner {

}
