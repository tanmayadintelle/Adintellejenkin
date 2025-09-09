package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        "src/test/resources/Features/BTLPROSanity.feature",
        "src/test/resources/Features/master.feature",
        "src/test/resources/Features/NewDigitalPROImportData.feature",
        "src/test/resources/Features/Press2.0PROSanity.feature",
        "src/test/resources/Features/ReportsonmyjobspagePRO.feature",
        "src/test/resources/Features/NewDigitalPROSanityCBF.feature",
        "src/test/resources/Features/NewDigitalPROSanityVBF.feature",
        "src/test/resources/Features/BillTransfer.feature",
        "src/test/resources/Features/FincoTransfer.feature",
        "src/test/resources/Features/TallyTransfer.feature"
    },
    glue = {"StepDefinitions"},
    plugin = {
        "pretty",
        "html:target/htmlreport.html",
        "json:target/cucumber.json"
    },
    monochrome = true
    // Remove or set tag properly
    // tags = "@Sanity"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
