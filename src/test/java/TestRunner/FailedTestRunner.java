package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "@target/rerun.txt",  // rerun file from previous run
    glue = {"StepDefinitions"},
    plugin = {"pretty", "html:target/rerun-report.html"},
    monochrome = true
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
}
