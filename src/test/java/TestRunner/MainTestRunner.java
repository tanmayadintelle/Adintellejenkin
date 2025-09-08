package TestRunner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.io.File;

public class MainTestRunner {

    public static void main(String[] args) {
        // Run full suite first
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{CucumberTestRunner.class});
        testng.addListener(tla);
        testng.run();

        // Check if rerun.txt exists and has content
        File rerunFile = new File("target/rerun.txt");
        if (rerunFile.exists() && rerunFile.length() > 0) {
            System.out.println("Failed scenarios detected, rerunning failed scenarios...");

            TestNG rerunTestNG = new TestNG();
            rerunTestNG.setTestClasses(new Class[]{FailedTestRunner.class});
            rerunTestNG.run();
        }
    }
}
