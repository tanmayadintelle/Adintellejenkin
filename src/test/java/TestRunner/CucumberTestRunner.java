package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(tags="",features= {"src/test/resources/Features/master.feature"},glue= {"StepDefinitions"},plugin= {"pretty","html:target/htmlreport.html"},  monochrome = true)

public class CucumberTestRunner extends AbstractTestNGCucumberTests{	 
	


}
