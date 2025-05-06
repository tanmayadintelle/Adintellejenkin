package runner;

import org.testng.TestNG;

public class MainRunner {
	public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { TestRunner.CucumberTestRunner.class }); // Point to the correct runner
        testng.run();
    }
}
