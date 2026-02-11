package stepdefines;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
	@CucumberOptions(
	        features = "src/test/resources/Feature/amazonshop.feature",
	        glue = {"stepdefines"},
	        plugin = {"pretty", "html:target/cucumber-reports"},
	        monochrome = true
	)
public class run_test_amazon extends AbstractTestNGCucumberTests{

}
