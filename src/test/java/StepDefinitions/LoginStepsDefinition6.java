package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Map;
//import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition6 {
	static WebDriver driver;
	
	@SuppressWarnings("deprecation")

@Given("User logs in and navigate to reports page")
public void user_logs_in_and_navigate_to_reports_page() throws InterruptedException, IOException {
    // Write code here that turns the phrase above into concrete actions
		   // Write code here that turns the phrase above into concrete actions
				ChromeOptions options = new ChromeOptions();
			    // Create a HashMap for preferences
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless=new");
//				options.addArguments("--window-size=1920,1080");
//				options.addArguments("--disable-gpu");
//				options.addArguments("--no-sandbox");
//				options.addArguments("--disable-dev-shm-usage");

			    HashMap<String, Object> prefs = new HashMap<>();    
			    // Block notifications by setting the preference value to 2 (block)
			    prefs.put("profile.default_content_setting_values.notifications", 2); 
			    // Add preferences to Chrome options
			    options.setExperimentalOption("prefs", prefs);
			    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			    String downloadDir = "reports\\" + timestamp;

			    File downloadFolder = new File(downloadDir);
			    if (!downloadFolder.exists()) {
			        downloadFolder.mkdirs(); // ✅ Create the folder if not there
			    }
			    Map<String, Object> prefs1 = new HashMap<>();
			    prefs1.put("profile.default_content_setting_values.notifications", 2);
			    prefs1.put("download.default_directory", downloadDir); // ✅ Your download path
			    prefs1.put("plugins.always_open_pdf_externally", true);
			    prefs1.put("download.prompt_for_download", false); 
			    prefs1.put("directory_upgrade", true);             
			    prefs1.put("safebrowsing.enabled", true);          
			    options.setExperimentalOption("prefs", prefs1);
			    driver =new ChromeDriver(options);
			    System.out.print("WebDriver initalized");
			    driver.get("https://pro.adintelle.com/v7/login"); 
			    System.out.print("Website opened");
			    driver.manage().window().maximize();
			    
			    String excelFilePath = "Reportsmyjobspage.xlsx";  // Path to your Excel file
		        FileInputStream file = new FileInputStream(new File(excelFilePath));
		        try (Workbook workbook = new XSSFWorkbook(file)) {
					Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
					Row row = sheet.getRow(1); // Get the second row (0-indexed));
					WebDriverWait waitload2 = new WebDriverWait(driver, Duration.ofSeconds(60));
					  
				    waitload2.until(ExpectedConditions.elementToBeClickable(By.name("username")));
					// Step 3: Find the form fields on the webpage and fill them with data from Excel
					
					WebElement usernameField = driver.findElement(By.name("username")); // Replace with actual ID
					
					usernameField.sendKeys("tanmay.nayak");
					
				    driver.findElement(By.name("acceptTerms")).click();
				    waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identify_user_button_text_active\"]")));
				    driver.findElement(By.xpath("//*[@id=\"identify_user_button_text_active\"]")).click();
				    
				    WebDriverWait waitload1 = new WebDriverWait(driver, Duration.ofSeconds(60));
				    WebDriverWait waitloadz = new WebDriverWait(driver, Duration.ofSeconds(10));
					   
				    waitload1.until(ExpectedConditions.elementToBeClickable(By.name("password")));
				    
					WebElement passwordField = driver.findElement(By.name("password")); 
					passwordField.sendKeys("Citi5bank$123456");
					waitload1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login_button_text_active\"]")));
					driver.findElement(By.xpath("//*[@id=\"login_button_text_active\"]")).click();
				    Thread.sleep(3000);
				    
				 // Initialize the WebDriverWait with a timeout of 10 seconds k
				 // Define the XPath to locate the element
				    String warningDialogButtonXpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span";

			        // Find the elements matching the XPath
			        List<WebElement> warningButtonList = driver.findElements(By.xpath(warningDialogButtonXpath));

			        // Check if the element is present
			        if (!warningButtonList.isEmpty()) {
			        	WebDriverWait waitload22 = new WebDriverWait(driver, Duration.ofSeconds(60));
						  
					    waitload22.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span")));
			            // If the element is found, click on it
			            warningButtonList.get(0).click();
			            System.out.println("Warning button clicked.");
			        }
			        Thread.sleep(4000);
//				    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span")).click();
			       // waitload1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/images/icons/close.png']"))).click();
			        try {
			            WebElement closeImg = waitloadz.until(
			                ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/images/icons/close.png']"))
			            );
			            closeImg.click();
			        } catch (TimeoutException e) {
			            // Element not found or not clickable within the timeout - continue silently
			            System.out.println("Close icon not clickable or not present. Continuing...");
			        }
				    WebDriverWait waitload23 = new WebDriverWait(driver, Duration.ofSeconds(60));
					  
				    waitload23.until(ExpectedConditions.elementToBeClickable(By.className("show_collapse_icon")));
				    WebElement elementarrow = driver.findElement(By.className("show_collapse_icon"));
			        elementarrow.click();
			        
			        System.out.println("Logged in");
			        //WebDriverWait waitid = new WebDriverWait(driver, Duration.ofSeconds(60));
			        List<WebElement> icons = driver.findElements(
			        	    By.xpath("//*[name()='svg']/*[name()='path' and contains(@d, 'M17.8059')]")
			        	);

			        	// Check if icon exists
			        	if (!icons.isEmpty()) {
			        	    WebElement icon = icons.get(0);
			        	    icon.click();
			        	    System.out.println("SVG icon clicked.");
			        	} else {
			        	    System.out.println("SVG icon not found. Continuing without clicking.");
			        	}
		        }
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        wait.until(ExpectedConditions.invisibilityOfElementLocated(
		            By.className("cdk-overlay-backdrop")));

		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("appIframeAgency"));

		     // Now you can find and click inside the iframe
		     WebElement reportsIcon = wait.until(ExpectedConditions.elementToBeClickable(
		         By.cssSelector("img[title='Reports'][src*='Btl-Reports.svg']")));

		     // Scroll into view if needed
		     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reportsIcon);

		     reportsIcon.click();
		     System.out.println("Inside Reports page");
		     
		     
		     

}

@When("User downloads status reports")
public void user_downloads_status_reports() throws InterruptedException, FileNotFoundException, IOException {
	 String excelFilePath = "Reportsmyjobspage.xlsx";  // Path to your Excel file

	    // Open workbook and file input stream with try-with-resources for auto-close
	    try (FileInputStream file = new FileInputStream(new File(excelFilePath));
	         Workbook workbook = new XSSFWorkbook(file)) {

	        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
	        Row row = sheet.getRow(1); // 2nd row (index 1) for date input
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	WebElement statusReportsSpan = wait.until(ExpectedConditions.elementToBeClickable(
	    By.xpath("//span[text()='Status Reports']")));
	statusReportsSpan.click();
	Thread.sleep(3000);
	new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
	WebElement digitalElement = wait.until(ExpectedConditions.elementToBeClickable(
	    By.xpath("//div[@class='row activity-box-text']//div[normalize-space(text())='Digital']")));
	digitalElement.click();
	   new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("isCheckAll")));
	WebElement checkbox = driver.findElement(By.id("isCheckAll"));
	checkbox.click();
	   new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
	String calendarToggleXPath = "/html/body/app-root/div/div/div/main/div/app-reports-type/div/div[2]/div/div[4]/div/div[1]/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button/span[3]";
    driver.findElement(By.xpath(calendarToggleXPath)).click();
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);

    // Read date parts from Excel
    String startDay = row.getCell(0).toString().trim().split("\\.")[0];
    String startMonth = row.getCell(1).toString().trim();
    String startYear = row.getCell(2).toString().trim();

    String endDay = row.getCell(3).toString().trim().split("\\.")[0];
    String endMonth = row.getCell(4).toString().trim();
    String endYear = row.getCell(5).toString().trim();

    // Select start date
    selectDateFromCalendar(driver, wait, startDay, startMonth, startYear);

    // Select end date
    selectDateFromCalendar(driver, wait, endDay, endMonth, endYear);
    //JavascriptExecutor js = (JavascriptExecutor) driver;

 // Wait for overlays to disappear or be hidden
 new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> {
     List<WebElement> overlays = d.findElements(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
     for (WebElement overlay : overlays) {
         if (overlay.isDisplayed()) return false;
     }
     return true;
 });

    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
    WebElement applyFilterButton = wait.until(ExpectedConditions.elementToBeClickable(
    	    By.xpath("//span[text()='Apply Filter' and contains(@class, 'submit-button')]")
    	));
    	applyFilterButton.click();
    	   new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    	WebElement applyFilterButton1 = wait.until(ExpectedConditions.elementToBeClickable(
    		    By.xpath("//span[text()='Apply Filter' and contains(@class, 'submit-button')]")
    		));
    		applyFilterButton1.click();
    		   new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    		
    		
    		int startIndex = 2; // start at third checkbox (0-based)
    		int endIndex = 4;   // till fifth checkbox
    		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));

    		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
    		
    		for (int i = startIndex; i <= endIndex && i < checkboxes.size(); i++) {
    		    WebElement checkboxi = checkboxes.get(i);
    		    if (!checkboxi.isSelected()) {
    		    	
    		    	new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
    		    	Thread.sleep(2000);
    		        checkboxi.click();
    		    }
    		}
    		new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
    		Thread.sleep(4000);
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'submit-button') and contains(text(),'Generate')]"))).click();
    		Thread.sleep(4000);
    		
    		int attempts = 0;
    		while (attempts < 10) {
    		    try {
    		        WebElement element = driver.findElement(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
    		        if (element.isDisplayed()) {
    		            element.click();
    		        }
    		        break;
    		    } catch (StaleElementReferenceException e) {
    		        attempts++;
    		    }
    		}

    		new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(
    			    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
    		
    		 Thread.sleep(3000);
    		   

    		    	String fromDate = startYear + "-" + getMonthNumber(startMonth) + "-" + startDay;
    		    	String toDate = endYear + "-" + getMonthNumber(endMonth) + "-" + endDay;
    		    	String finalName = "StatusReport_" + "Digital" + "_" + fromDate + "_to_" + toDate;

    		    	// Locate latest folder
    		    	String reportFolderRoot = "D:\\fd\\btladintelleautomation\\reports";
    		    	File latestFolder = getLatestReportFolder(reportFolderRoot);

    		    	if (latestFolder != null) {
    		    	    renameFileInFolder(latestFolder, finalName);
    		    	} else {
    		    	    System.out.println("❌ Could not locate report folder.");
    		    	}
    		    	Thread.sleep(3000);
    		try {
                WebElement btlElement = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='row activity-box-text']//div[normalize-space(text())='BTL']")));
                btlElement.click();
                new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
            } catch (StaleElementReferenceException e) {
                WebElement btlElement = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@class='row activity-box-text']//div[normalize-space(text())='BTL']")));
                btlElement.click();
            }

            wait.until(ExpectedConditions.elementToBeClickable(By.id("isCheckAll")));
            WebElement checkbox1 = driver.findElement(By.id("isCheckAll"));
            checkbox1.click();
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
         // Read activity names from Excel (e.g., "MIX,CLIX")
            String activityCellValue = row.getCell(6).toString().trim(); // Assuming cell 6 holds activity names
            String[] activitiesToSelect = activityCellValue.split(",");

            // Normalize and trim activity names
            Set<String> targetActivities = Arrays.stream(activitiesToSelect)
                    .map(String::trim)
                    .map(String::toUpperCase)
                    .collect(Collectors.toSet());
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.embed-box")));
            // Find all activity boxes
            List<WebElement> activityBoxes = driver.findElements(By.cssSelector("div.embed-box"));

            // Loop over activity boxes and click based on name match
            for (WebElement box : activityBoxes) {
                try {
                    WebElement labelElement = box.findElement(By.cssSelector(".activity-box-text > div"));
                    String activityName = labelElement.getText().trim().toUpperCase();

                    if (targetActivities.contains(activityName)) {
                        WebElement checkbox00 = box.findElement(By.cssSelector("input[type='checkbox']"));
                        if (!checkbox00.isSelected()) {
                            checkbox00.click();
                            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Could not process activity box: " + e.getMessage());
                }
            }
            
           


            // Calendar toggle
            String calendarToggleXPath1 = "/html/body/app-root/div/div/div/main/div/app-reports-type/div/div[2]/div/div[6]/div/div[1]/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button/span[3]";
            driver.findElement(By.xpath(calendarToggleXPath1)).click();
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
            // Read dates from Excel
            

            // Select calendar dates
            selectDateFromCalendar(driver, wait, startDay, startMonth, startYear);
            selectDateFromCalendar(driver, wait, endDay, endMonth, endYear);
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> {
                List<WebElement> overlays = d.findElements(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
                for (WebElement overlay : overlays) {
                    try {
                        if (overlay.isDisplayed()) {
                            return false;
                        }
                    } catch (StaleElementReferenceException e) {
                        // Element went stale — ignore and recheck next time
                        return false; 
                    }
                }
                return true;
            });

            // Apply filter twice
            WebElement applyFilterButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Apply Filter' and contains(@class, 'submit-button')]")));
            applyFilterButton2.click();
           
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
         

            // Select checkboxes 3rd to 5th
        
            // Click Generate
            List<WebElement> checkboxeslast = driver.findElements(By.cssSelector("input[type='checkbox']"));

            int total = checkboxeslast.size();
            if (total >= 2) {
                for (int i = total - 2; i < total; i++) {
                    WebElement checkboxo = checkboxeslast.get(i);
                    if (!checkboxo.isSelected()) {
                    	Thread.sleep(2000);
                    	   new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
                        checkboxo.click();
                        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
                    }
                }
            } else {
                System.out.println("Less than two checkboxes available.");
            }
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
            Thread.sleep(4000);
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(@class,'submit-button') and contains(text(),'Generate')]"))).click();
            int attempts1 = 0;
            while (attempts1 < 10) {
                try {
                    WebElement element = driver.findElement(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
                    if (element.isDisplayed()) {
                        element.click();
                    }
                    break;
                } catch (StaleElementReferenceException e) {
                    attempts1++;
                }
            }
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
        		    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
           
           
            //all reports
            
          
                int attempts2 = 0;
                while (attempts2 < 10) {
                    try {
                        WebElement element = driver.findElement(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
                        if (element.isDisplayed()) {
                            element.click();
                        }
                        break;
                    } catch (StaleElementReferenceException e) {
                        attempts1++;
                    }
                }

                new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
        			    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));

           	 Thread.sleep(3000);
  		   

		    	String fromDate1 = startYear + "-" + getMonthNumber(startMonth) + "-" + startDay;
		    	String toDate1 = endYear + "-" + getMonthNumber(endMonth) + "-" + endDay;
		    	String finalName1 = "StatusReport_" + "BTL" + "_" + fromDate1 + "_to_" + toDate1;

		    	// Locate latest folder
		    	String reportFolderRoot1 = "reports";
		    	File latestFolder1 = getLatestReportFolder(reportFolderRoot1);

		    	if (latestFolder1 != null) {
		    	    renameFileInFolder(latestFolder1, finalName1);
		    	    
		    	} else {
		    	    System.out.println("❌ Could not locate report folder.");
		    	}
		    	Thread.sleep(3000);
            	 wait.until(ExpectedConditions.elementToBeClickable(
                         By.xpath("//*[@id=\"statusReport\"]/div[1]/div/div/span[1]"))).click();
                 new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
                 
        }
    }


    // If needed, click outside or confirm to close the calendar (depends on UI)


@When("User downloads sales register")
public void user_downloads_sales_register() throws IOException, InterruptedException {
	 String excelFilePath = "Reportsmyjobspage.xlsx";  // Path to your Excel file

	    // Open workbook and file input stream with try-with-resources for auto-close
	    try (FileInputStream file = new FileInputStream(new File(excelFilePath));
	         Workbook workbook = new XSSFWorkbook(file)) {

	        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
	        Row row = sheet.getRow(1); // 2nd row (index 1) for date input
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	WebElement statusReportsSpan = wait.until(ExpectedConditions.elementToBeClickable(
	    By.xpath("//span[text()='Sales Register']")));
	statusReportsSpan.click();
	Thread.sleep(3000);
	new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
	
	String activityCellValue = row.getCell(7).toString().trim(); // Assuming cell 6 holds activity names
    String[] activitiesToSelect = activityCellValue.split(",");

    Set<String> targetActivities = Arrays.stream(activitiesToSelect)
            .map(String::trim)
            .map(String::toUpperCase)
            .collect(Collectors.toSet());

    Set<String> selectedActivities = new HashSet<>();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    boolean morePages = true;

    while (morePages && !selectedActivities.containsAll(targetActivities)) {
        List<WebElement> activityBoxes = driver.findElements(By.cssSelector("div.embed-box"));

        for (WebElement box : activityBoxes) {
            try {
                WebElement labelElement = box.findElement(By.cssSelector(".activity-box-text > div"));
                String activityName = labelElement.getText().trim().toUpperCase();

                if (targetActivities.contains(activityName) && !selectedActivities.contains(activityName)) {
                    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", box);
                    Thread.sleep(300);
                    WebElement checkbox = box.findElement(By.cssSelector("input[type='checkbox']"));
                    if (!checkbox.isSelected()) {
                        checkbox.click();
                    }
                    selectedActivities.add(activityName);
                    System.out.println("Selected: " + activityName);
                }
            } catch (Exception e) {
                System.out.println("Error processing activity box: " + e.getMessage());
            }
        }

        // Break if all found
        if (selectedActivities.containsAll(targetActivities)) {
            break;
        }

        // Try clicking forward arrow
        try {
            // Use the full XPath you provided
            WebElement forwardArrow = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-reports-sales-register/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]/span/img"));

            // Scroll it into view (important)
            js.executeScript("arguments[0].scrollIntoView(true);", forwardArrow);

            // Click it using JavaScript (safer than .click())
            js.executeScript("arguments[0].click();", forwardArrow);

            // Give time for the UI to update and show new activities
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println("⚠️ Forward arrow not clickable or not found: " + e.getMessage());
            morePages = false;
        }
    }

    // Final check
    for (String expected : targetActivities) {
        if (!selectedActivities.contains(expected)) {
            System.out.println(" Could not find or select activity: " + expected);
        }
    }
    String startDay1 = row.getCell(8).toString().trim().split("\\.")[0];
    String startMonth1 = row.getCell(9).toString().trim();
    String startYear1 = row.getCell(10).toString().trim();

    String endDay1 = row.getCell(11).toString().trim().split("\\.")[0];
    String endMonth1 = row.getCell(12).toString().trim();
    String endYear1 = row.getCell(13).toString().trim();

    
    String calendarToggleXPath1 = "/html/body/app-root/div/div/div/main/div/app-reports-sales-register/div/div[2]/div/div[4]/div/div[1]/div/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button/span[3]";
    driver.findElement(By.xpath(calendarToggleXPath1)).click();
    selectDateFromCalendar(driver, wait, startDay1, startMonth1, startYear1);
    selectDateFromCalendar(driver, wait, endDay1, endMonth1, endYear1);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> {
        List<WebElement> overlays = d.findElements(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
        for (WebElement overlay : overlays) {
            if (overlay.isDisplayed()) return false;
        }
        return true;
    });
    Thread.sleep(3000);
    // Apply filter twice
    WebElement applyFilterButton2 = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text()='Apply Filter' and contains(@class, 'submit-button')]")));
    applyFilterButton2.click();
    Thread.sleep(5000);
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    Thread.sleep(5000);
    JavascriptExecutor jslo = (JavascriptExecutor) driver;
    jslo.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

    int total = checkboxes.size();
    if (total > 0) {
        WebElement lastCheckbox = checkboxes.get(total - 1);
        if (!lastCheckbox.isSelected()) {
            Thread.sleep(4000);
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
            Thread.sleep(5000);
            lastCheckbox.click();
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
        }
    } else {
        System.out.println("No checkboxes available.");
    }

    Thread.sleep(4000);
    wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(@class,'submit-button') and contains(text(),'Generate')]"))).click();
    
 // Build new filename
    
    int attempts = 0;
    while (attempts < 2) {
        try {
            WebElement element = driver.findElement(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
            if (element.isDisplayed()) {
                element.click();
            }
            break;
        } catch (StaleElementReferenceException e) {
            attempts++;
        }
    }
    wait.until(ExpectedConditions.invisibilityOfElementLocated(
    	    By.cssSelector(".cdk-overlay-backdrop, .mat-datepicker-content, .loading-spinner")
    	));
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(
		    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
    Thread.sleep(3000);
    //for all sales activities
    String activityNameForFile = Arrays.stream(activitiesToSelect)
    	    .map(String::trim)
    	    .map(a -> a.replaceAll("[^a-zA-Z0-9]", "_"))
    	    .collect(Collectors.joining("_"));
    
    	String fromDate = startYear1 + "-" + getMonthNumber(startMonth1) + "-" + startDay1;
    	String toDate = endYear1 + "-" + getMonthNumber(endMonth1) + "-" + endDay1;
    	String finalName = "SalesRegister_" + activityNameForFile + "_" + fromDate + "_to_" + toDate;

    	// Locate latest folder
    	String reportFolderRoot = "reports";
    	File latestFolder = getLatestReportFolder(reportFolderRoot);

    	if (latestFolder != null) {
    	    renameFileInFolder(latestFolder, finalName);
    	} else {
    	    System.out.println("❌ Could not locate report folder.");
    	}

    	Thread.sleep(3000);
    
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-reports-sales-register/div/div[1]/div/div/span[1]"))).click();
    Thread.sleep(3000);
    WebElement statusReportsSpan1 = wait.until(ExpectedConditions.elementToBeClickable(
    	    By.xpath("//span[text()='Sales Register']")));
    	statusReportsSpan1.click();
   
    // Apply filter twice
    WebElement applyFilterButton3 = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text()='Apply Filter' and contains(@class, 'submit-button')]")));
    applyFilterButton3.click();
   
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    List<WebElement> checkboxes1 = driver.findElements(By.cssSelector("input[type='checkbox']"));

    int total2= checkboxes1.size();
    if (total2 > 0) {
        WebElement lastCheckbox = checkboxes1.get(total2 - 1);
        if (!lastCheckbox.isSelected()) {
            Thread.sleep(2000);
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
            lastCheckbox.click();
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
        }
    } else {
        System.out.println("No checkboxes available.");
    }

    Thread.sleep(4000);
    wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(@class,'submit-button') and contains(text(),'Generate')]"))).click();
    int attempts1 = 0;
    while (attempts1 < 2) {
        try {
            WebElement element = driver.findElement(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
            if (element.isDisplayed()) {
                element.click();
            }
            break;
        } catch (StaleElementReferenceException e) {
            attempts1++;
        }
    }

    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(
		    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
    Thread.sleep(3000);
  	String fromDate1 = startYear1 + "-" + getMonthNumber(startMonth1) + "-" + startDay1;
	String toDate1 = endYear1 + "-" + getMonthNumber(endMonth1) + "-" + endDay1;
	String finalName1 = "SalesReport_" + "Allmediums" + "_" + fromDate1 + "_to_" + toDate1;

	// Locate latest folder
	String reportFolderRoot1 = "reports";
	File latestFolder1 = getLatestReportFolder(reportFolderRoot1);

	if (latestFolder1 != null) {
	    renameFileInFolder(latestFolder1, finalName1);
	} else {
	    System.out.println("❌ Could not locate report folder.");
	}
	Thread.sleep(4000);
    
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/div/div/div/main/div/app-reports-sales-register/div/div[1]/div/div/span[1]"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-reports-sales-register/div/div[1]/div/div/span[1]"))).click();
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    
 

    // Write code here that turns the phrase above into concrete actions
	    }
}
@Then("User downloads purchase register")
public void user_downloads_purchase_register() throws FileNotFoundException, IOException, InterruptedException {
	 String excelFilePath = "Reportsmyjobspage.xlsx";  // Path to your Excel file

	    // Open workbook and file input stream with try-with-resources for auto-close
	    try (FileInputStream file = new FileInputStream(new File(excelFilePath));
	         Workbook workbook = new XSSFWorkbook(file)) {

	        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
	        Row row = sheet.getRow(1); // 2nd row (index 1) for date input
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	WebElement statusReportsSpan = wait.until(ExpectedConditions.elementToBeClickable(
	    By.xpath("//span[text()='Purchase Register']")));
	statusReportsSpan.click();
	Thread.sleep(3000);
	String activityCellValue = row.getCell(14).toString().trim(); // Assuming cell 6 holds activity names
    String[] activitiesToSelect = activityCellValue.split(",");

    Set<String> targetActivities = Arrays.stream(activitiesToSelect)
            .map(String::trim)
            .map(String::toUpperCase)
            .collect(Collectors.toSet());

    Set<String> selectedActivities = new HashSet<>();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    boolean morePages = true;

    while (morePages && !selectedActivities.containsAll(targetActivities)) {
        List<WebElement> activityBoxes = driver.findElements(By.cssSelector("div.embed-box"));

        for (WebElement box : activityBoxes) {
            try {
                WebElement labelElement = box.findElement(By.cssSelector(".activity-box-text > div"));
                String activityName = labelElement.getText().trim().toUpperCase();

                if (targetActivities.contains(activityName) && !selectedActivities.contains(activityName)) {
                    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", box);
                    Thread.sleep(300);
                    WebElement checkbox = box.findElement(By.cssSelector("input[type='checkbox']"));
                    if (!checkbox.isSelected()) {
                        checkbox.click();
                    }
                    selectedActivities.add(activityName);
                    System.out.println("Selected: " + activityName);
                }
            } catch (Exception e) {
                System.out.println("Error processing activity box: " + e.getMessage());
            }
        }

        // Break if all found
        if (selectedActivities.containsAll(targetActivities)) {
            break;
        }

        // Try clicking forward arrow
        try {
            // Use the full XPath you provided
            WebElement forwardArrow = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-reports-purchase-register/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[3]/span/img"));

            // Scroll it into view (important)
            js.executeScript("arguments[0].scrollIntoView(true);", forwardArrow);

            // Click it using JavaScript (safer than .click())
            js.executeScript("arguments[0].click();", forwardArrow);

            // Give time for the UI to update and show new activities
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(" Forward arrow not clickable or not found: " + e.getMessage());
            morePages = false;
        }
    }

    // Final check
    for (String expected : targetActivities) {
        if (!selectedActivities.contains(expected)) {
            System.out.println(" Could not find or select activity: " + expected);
        }
    }
    String startDay1 = row.getCell(15).toString().trim().split("\\.")[0];
    String startMonth1 = row.getCell(16).toString().trim();
    String startYear1 = row.getCell(17).toString().trim();

    String endDay1 = row.getCell(18).toString().trim().split("\\.")[0];
    String endMonth1 = row.getCell(19).toString().trim();
    String endYear1 = row.getCell(20).toString().trim();

    
    String calendarToggleXPath1 = "/html/body/app-root/div/div/div/main/div/app-reports-purchase-register/div/div[2]/div/div[4]/div/div/div/div/div[1]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button/span[3]";
    driver.findElement(By.xpath(calendarToggleXPath1)).click();
    selectDateFromCalendar(driver, wait, startDay1, startMonth1, startYear1);
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    Thread.sleep(3000);
    selectDateFromCalendar(driver, wait, endDay1, endMonth1, endYear1);
    Thread.sleep(3000);
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> {
        List<WebElement> overlays = d.findElements(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
        for (WebElement overlay : overlays) {
            if (overlay.isDisplayed()) return false;
        }
        return true;
    });
    // Apply filter twice
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ModalOBPrinting")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingModalClientBill")));
    WebElement applyFilterButton2 = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text()='Apply Filter' and contains(@class, 'submit-button')]")));

    int maxRetries = 5;
    int attempts = 0;
    boolean clicked = false;

    while (attempts < maxRetries && !clicked) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyFilterButton2);
            Thread.sleep(500);  // short wait after scroll
            applyFilterButton2.click();
            clicked = true;
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, retrying... attempt: " + (attempts + 1));
            Thread.sleep(1000);  // wait a bit before retrying
            attempts++;
        }
    }

    if (!clicked) {
        throw new RuntimeException("Failed to click Apply Filter button after " + maxRetries + " attempts");
    }

    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ModalOBPrinting")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingModalClientBill")));
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    
    Thread.sleep(3000);
    List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

    

    int total = checkboxes.size();
    if (total >= 2) {
        WebElement secondLastCheckbox = checkboxes.get(total - 2);
        WebElement lastCheckbox = checkboxes.get(total - 1);

        if (!secondLastCheckbox.isSelected()) {
        	 new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
            waitUntilClickableAndClick(secondLastCheckbox);
        }

        if (!lastCheckbox.isSelected()) {
        	 new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
            waitUntilClickableAndClick(lastCheckbox);
        }

    } else {
        System.out.println("Less than 2 checkboxes available.");
    }

    // Reusable method
  


    Thread.sleep(4000);
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(@class,'submit-button') and contains(text(),'Generate')]"))).click();
   
    
    int attempts2 = 0;
    while (attempts2 < 3) {
        try {
            List<WebElement> snackbars = driver.findElements(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
            if (!snackbars.isEmpty()) {
                WebElement element = snackbars.get(0);
                if (element.isDisplayed()) {
                    element.click();
                }
            }
            break; // success
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale element detected, retrying...");
            attempts2++;
        } catch (Exception e) {
            System.out.println("Some other error: " + e.getMessage());
            break;
        }
    }


    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(
		    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
    Thread.sleep(3000);
    String activityNameForFile = Arrays.stream(activitiesToSelect)
    	    .map(String::trim)
    	    .map(a -> a.replaceAll("[^a-zA-Z0-9]", "_"))
    	    .collect(Collectors.joining("_"));

    	String fromDate = startYear1 + "-" + getMonthNumber(startMonth1) + "-" + startDay1;
    	String toDate = endYear1 + "-" + getMonthNumber(endMonth1) + "-" + endDay1;
    	String finalName = "PurchaseRegister_" + activityNameForFile + "_" + fromDate + "_to_" + toDate;

    	// Locate latest folder
    	String reportFolderRoot = "reports";
    	File latestFolder = getLatestReportFolder(reportFolderRoot);

    	if (latestFolder != null) {
    	    renameFileInFolder(latestFolder, finalName);
    	} else {
    	    System.out.println("❌ Could not locate report folder.");
    	}
    	Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html/body/app-root/div/div/div/main/div/app-reports-purchase-register/div/div[1]/div/div/span[1]"))).click();
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);	
    Thread.sleep(3000);
    //for all purchase
   
    WebElement statusReportsSpan1 = wait.until(ExpectedConditions.elementToBeClickable(
    	    By.xpath("//span[text()='Purchase Register']")));
    	statusReportsSpan1.click();
    // Write code here that turns the phrase above into concrete actions
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ModalOBPrinting")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingModalClientBill")));
        WebElement applyFilterButton3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Apply Filter' and contains(@class, 'submit-button')]")));

        int maxRetries1 = 5;
        int attempts21 = 0;
        boolean clicked1 = false;

        while (attempts21 < maxRetries && !clicked1) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyFilterButton3);
                Thread.sleep(500);  // short wait after scroll
                applyFilterButton3.click();
                clicked1 = true;
            } catch (ElementClickInterceptedException e) {
                System.out.println("Click intercepted, retrying... attempt: " + (attempts21 + 1));
                Thread.sleep(1000);  // wait a bit before retrying
                attempts21++;
            }
        }

        if (!clicked1) {
            throw new RuntimeException("Failed to click Apply Filter button after " + maxRetries1 + " attempts");
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ModalOBPrinting")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingModalClientBill")));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
        
        Thread.sleep(3000);
        List<WebElement> checkboxes1 = driver.findElements(By.cssSelector("input[type='checkbox']"));

        

        int total2 = checkboxes1.size();
        if (total2 >= 2) {
            WebElement secondLastCheckbox = checkboxes1.get(total2 - 2);
            WebElement lastCheckbox = checkboxes1.get(total2 - 1);

            if (!secondLastCheckbox.isSelected()) {
            	 new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
                waitUntilClickableAndClick(secondLastCheckbox);
            }

            if (!lastCheckbox.isSelected()) {
            	 new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
                waitUntilClickableAndClick(lastCheckbox);
            }

        } else {
            System.out.println("Less than 2 checkboxes available.");
        }

        // Reusable method
      


        Thread.sleep(4000);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class,'submit-button') and contains(text(),'Generate')]"))).click();
        int attempts3 = 0;
        while (attempts3 < 3) {
            try {
                List<WebElement> snackbars = driver.findElements(By.cssSelector(".cdk-overlay-pane, .mat-mdc-snack-bar-label"));
                if (!snackbars.isEmpty()) {
                    WebElement element = snackbars.get(0);
                    if (element.isDisplayed()) {
                        element.click();
                    }
                }
                break; // success
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element detected, retrying...");
                attempts3++;
            } catch (Exception e) {
                System.out.println("Some other error: " + e.getMessage());
                break;
            }
        }


        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver1 -> true);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
    		    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
    	
    	
    	
        Thread.sleep(3000);
      	String fromDate1 = startYear1 + "-" + getMonthNumber(startMonth1) + "-" + startDay1;
    	String toDate1 = endYear1 + "-" + getMonthNumber(endMonth1) + "-" + endDay1;
    	String finalName1 = "PurchaseRegister_" + "Allmediums" + "_" + fromDate1 + "_to_" + toDate1;

    	// Locate latest folder
    	String reportFolderRoot1 = "reports";
    	File latestFolder1 = getLatestReportFolder(reportFolderRoot1);

    	if (latestFolder1 != null) {
    	    renameFileInFolder(latestFolder1, finalName1);
    	} else {
    	    System.out.println("❌ Could not locate report folder.");
    	}
    	Thread.sleep(3000);
    	
    	
    	
    	
    	  wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("/html/body/app-root/div/div/div/main/div/app-reports-purchase-register/div/div[1]/div/div/span[1]"))).click();
}
}
@Then("Close the chrom3e Browse3r")
public void close_the_chrom3e_browse3r() {
    // Write code here that turns the phrase above into concrete actions
   driver.quit();
}
private void waitUntilClickableAndClick(WebElement checkbox) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
}

public void selectJobDate(WebDriver driver, WebDriverWait wait, String dateStr) throws InterruptedException {
    // Format: "dd/MM/yyyy"
    String[] parts = dateStr.split("/");
    String day = parts[0];
    String month = parts[1];
    String year = parts[2];

    // Step 1: Click calendar toggle
    WebElement calendarButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//input[@name='jobDate']/following-sibling::div//button")
    ));
    calendarButton.click();

    // Step 2: Convert month to string abbreviation (e.g., "06" -> "JUN")
    String[] monthNames = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", 
                            "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
    String monthName = monthNames[Integer.parseInt(month) - 1];

    // Step 3: Navigate to correct month/year
    while (true) {
        WebElement monthYearLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[@aria-hidden='true' and contains(text(),'')]")
        ));
        String current = monthYearLabel.getText().trim(); // e.g., "JUN 2025"

        if (current.equalsIgnoreCase(monthName + " " + year)) {
            break;
        }

        String[] currentParts = current.split(" ");
        int currentMonth = monthToNumber(currentParts[0]);
        int currentYear = Integer.parseInt(currentParts[1]);
        int targetMonth = Integer.parseInt(month);
        int targetYear = Integer.parseInt(year);

        if (currentYear > targetYear || (currentYear == targetYear && currentMonth > targetMonth)) {
            // Click previous
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'mat-calendar-previous-button')]"))).click();
        } else {
            // Click next
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'mat-calendar-next-button')]"))).click();
        }

        Thread.sleep(300);
    }

    // Step 4: Click the day using aria-label
    String targetDateLabel = String.format("%02d/%02d/%s", Integer.parseInt(day), Integer.parseInt(month), year);
    String xpath = "//td/button[@aria-label='" + targetDateLabel + "']";

    WebElement dayButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    dayButton.click();
    System.out.println("Selected date: " + targetDateLabel);
}

// Helper method: converts month name to number
public static int monthToNumber(String monthName) {
    switch (monthName.toUpperCase()) {
        case "JAN": return 1;
        case "FEB": return 2;
        case "MAR": return 3;
        case "APR": return 4;
        case "MAY": return 5;
        case "JUN": return 6;
        case "JUL": return 7;
        case "AUG": return 8;
        case "SEP": return 9;
        case "OCT": return 10;
        case "NOV": return 11;
        case "DEC": return 12;
        default: throw new IllegalArgumentException("Invalid month name: " + monthName);
    }
}


public void selectDateFromCalendar(WebDriver driver, WebDriverWait wait, String day, String month, String year) throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-calendar")));

    // XPath locators
    By monthYearLocator = By.xpath("//span[contains(@class, 'mdc-button__label')]/span[@aria-hidden='true']");
    By nextButtonLocator = By.xpath("//mat-calendar//button[contains(@class,'mat-calendar-next-button')]");
    By prevButtonLocator = By.xpath("//mat-calendar//button[contains(@class,'mat-calendar-previous-button')]");

    // Navigate to correct month/year
    while (true) {
        WebElement monthYearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearLocator));
        String currentMonthYear = monthYearElement.getText().trim(); // e.g., "MARCH 2025"

        if (currentMonthYear.equalsIgnoreCase(month + " " + year)) {
            System.out.println("Reached target month/year: " + currentMonthYear);
            break;
        }

        String[] parts = currentMonthYear.split(" ");
        int currentMonthNum = monthToNumber(parts[0]);
        int currentYearNum = Integer.parseInt(parts[1]);
        int targetMonthNum = monthToNumber(month);
        int targetYearNum = Integer.parseInt(year);

        if (currentYearNum > targetYearNum || (currentYearNum == targetYearNum && currentMonthNum > targetMonthNum)) {
            wait.until(ExpectedConditions.elementToBeClickable(prevButtonLocator)).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator)).click();
        }

        Thread.sleep(300); // Let calendar refresh
    }

    // Robust date selection XPath
    String dayXPath = "//mat-calendar//td//span[normalize-space(text())='" + Integer.parseInt(day) + "']";

    try {
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXPath)));
        dayElement.click();
        System.out.println("Selected day: " + day + " " + month + " " + year);
    } catch (TimeoutException e) {
        System.err.println("Could not select day: " + day + " — element might be disabled or not visible.");
        throw e;
    }
}


public File getLatestReportFolder(String parentFolderPath) {
    File parentDir = new File(parentFolderPath);
    File[] directories = parentDir.listFiles(File::isDirectory);

    if (directories == null || directories.length == 0) {
        System.out.println("❌ No subfolders found.");
        return null;
    }

    return Arrays.stream(directories)
            .max(Comparator.comparingLong(File::lastModified))
            .orElse(null);
}

public void renameFileInFolder(File folder, String newNamePrefix) throws InterruptedException {
    File[] files = folder.listFiles();

    if (files == null || files.length == 0) {
        System.out.println("❌ No files found in folder: " + folder.getAbsolutePath());
        return;
    }

    for (File file : files) {
        if (file.isFile()) {
            String ext = file.getName().substring(file.getName().lastIndexOf("."));
            Thread.sleep(1000);
            File renamedFile = new File(folder, newNamePrefix + ext);
            if (file.renameTo(renamedFile)) {
                System.out.println("✅ Renamed to: " + renamedFile.getName());
                Thread.sleep(1000);
            } else {
                System.out.println("❌ Failed to rename: " + file.getName());
                Thread.sleep(1000);
            }
        }
    }
}


    // Now select the day (date) from calendar
    // Angular Material days are buttons with aria-label "dd/mm/yyyy" or the day number as text in span inside button
public String getMonthNumber(String monthName) {
    Map<String, String> monthMap = new HashMap<>();
    monthMap.put("jan", "01");
    monthMap.put("feb", "02");
    monthMap.put("mar", "03");
    monthMap.put("apr", "04");
    monthMap.put("may", "05");
    monthMap.put("jun", "06");
    monthMap.put("jul", "07");
    monthMap.put("aug", "08");
    monthMap.put("sep", "09");
    monthMap.put("oct", "10");
    monthMap.put("nov", "11");
    monthMap.put("dec", "12");

    String lower = monthName.toLowerCase().trim();
    return monthMap.getOrDefault(lower, "00"); // "00" is a fallback if input is invalid
}





}