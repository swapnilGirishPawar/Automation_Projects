package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions
	(
		features= {"src\\test\\resources\\1. login\\login.feature",
				   "src\\test\\resources\\2. searchProduct\\searchProduct.feature",
				   "src\\test\\resources\\3. addToCart\\addToCart.feature"
																				},
		
		glue = {"stepDefination"},
				monochrome = true,
		dryRun= false
	)

public class Test_Runner {
}
