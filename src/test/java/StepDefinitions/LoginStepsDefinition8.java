package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Optional;
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
import java.util.Locale;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition8 {
	static WebDriver driver;
	
	@SuppressWarnings("deprecation")

@Given("User logs in and navigate to digital page for cbf")
public void user_logs_in_and_navigate_to_digital_page() throws InterruptedException, IOException {
    // Write code here that turns the phrase above into concrete actions
		   // Write code here that turns the phrase above into concrete actions
				ChromeOptions options = new ChromeOptions();
			    // Create a HashMap for preferences
//				ChromeOptions options = new ChromeOptions();
	//		options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
//				options.addArguments("--disable-gpu");
//				options.addArguments("--no-sandbox");
//				options.addArguments("--disable-dev-shm-usage");

			    HashMap<String, Object> prefs = new HashMap<>();    
			    // Block notifications by setting the preference value to 2 (block)
			    prefs.put("profile.default_content_setting_values.notifications", 2); 
			    // Add preferences to Chrome options
			    options.setExperimentalOption("prefs", prefs);
			    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			    String downloadDir = "D:\\fd\\btladintelleautomation\\digitaloutputscbf\\" + timestamp;

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
			    
			    String excelFilePath = "D:\\fd\\btladintelleautomation\\DigitalproCBF.xlsx";  // Path to your Excel file
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
					passwordField.sendKeys("Citi5bank$1234567");
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
		        
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        wait.until(ExpectedConditions.invisibilityOfElementLocated(
		            By.className("cdk-overlay-backdrop")));

		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("appIframeAgency"));
		        WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
			    
				waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src, 'newjob.svg')]")));
			    JavascriptExecutor jszoom = (JavascriptExecutor) driver;
		        jszoom.executeScript("document.body.style.zoom='100%'");
		        WebElement imgElement = driver.findElement(By.xpath("//img[contains(@src, 'newjob.svg')]"));
		        js.executeScript("arguments[0].scrollIntoView(true);", imgElement); // Scrolls to the element
		        js.executeScript("arguments[0].focus();", imgElement);              // Focuses the element
		        js.executeScript("arguments[0].click();", imgElement); 

		     // Now you can find and click inside the iframe
		        waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container-d\"]/div/div[1]")));
			    WebElement digitalElement = driver.findElement(By.xpath("//*[@id=\"container-d\"]/div/div[1]"));
			    digitalElement.click();
		     // Scroll into view if needed
			    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-select\"]/div[3]/div/div/div[1]/div[2]/div/div[1]/div")));
			    WebElement createmanuallyElement = driver.findElement(By.xpath("//*[@id=\"action-dialog-select\"]/div[3]/div/div/div[1]/div[2]/div/div[1]/div"));
			    createmanuallyElement.click();
			    //Client selection
			    
			   
		     
		        }
}

@When("User creates a new job and adds a campaign for cbf")
public void user_createsnewjob_and_addsacampaign() throws InterruptedException, FileNotFoundException, IOException {
	String excelFilePath = "D:\\fd\\btladintelleautomation\\DigitalproCBF.xlsx";  // Path to your Excel file
    FileInputStream file = new FileInputStream(new File(excelFilePath));
    try (Workbook workbook = new XSSFWorkbook(file)) {
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		Row row = sheet.getRow(1);
	 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    JavascriptExecutor js = (JavascriptExecutor) driver;
 // Wait for the Client dropdown input to be ready
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select-client\"]/div/div[1]/ng-select/div")));

    // Format Excel values to preserve spaces and formatting
    DataFormatter formatter = new DataFormatter();
    String Client = formatter.formatCellValue(row.getCell(2));
    String Brand = formatter.formatCellValue(row.getCell(3));

    // ---- Select Client ----
    WebElement ClientField = waitload.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//*[@id='select-client']/div/div[1]/ng-select/div/div/div[2]/input")));
    Thread.sleep(2000);
    js.executeScript("arguments[0].scrollIntoView(true);", ClientField); // Scrolls to the element
    js.executeScript("arguments[0].focus();", ClientField);   
    ClientField.click();
    ClientField.sendKeys(Keys.ENTER);
    ClientField.sendKeys(Client);
    Thread.sleep(2000);
    ClientField.clear();
    ClientField.sendKeys(Keys.ENTER);
    ClientField.sendKeys(Client);
	 WebElement BrandField = waitload.until(ExpectedConditions.elementToBeClickable(
	         By.xpath("//*[@id='select-client']/div/div[2]/ng-select/div/div/div[2]/input")));
	 js.executeScript("arguments[0].scrollIntoView(true);", BrandField); // Scrolls to the element
	    js.executeScript("arguments[0].focus();", BrandField);
	 BrandField.click();
	 Thread.sleep(2000);
	 BrandField.clear();
	 BrandField.sendKeys(Keys.ENTER);
	 BrandField.sendKeys(Brand);
	 BrandField.sendKeys(Keys.ENTER);
	 Thread.sleep(2000);
//	 BrandField.sendKeys(Brand);
//	 BrandField.sendKeys(Keys.ENTER);
//	 WebElement brandFirstOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ng-option")));
//	 brandFirstOption.click();
	 Thread.sleep(2000);
	 // ---- Click Next Button ----
	 WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
	         By.cssSelector("body > app-root > div > div > div > main > div > app-create-job-digi > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
	 js.executeScript("arguments[0].scrollIntoView(true);", nextButton); // Scrolls to the element
 	 js.executeScript("arguments[0].focus();", nextButton);
 	 js.executeScript("arguments[0].click();", nextButton);
	// nextButton.click();

		Thread.sleep(4000);
		String JobName = row.getCell(4).getStringCellValue(); 	
		//waitload.until(ExpectedConditions.elementToBeClickable(By.name("JobName")));
	    WebElement JobNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("JobName")));
	    
	    js.executeScript("arguments[0].scrollIntoView(true);", JobNameField);
	    // Scrolls to the element
	    js.executeScript("arguments[0].focus();", JobNameField);              // Focuses the element
	    JobNameField.clear();
	    JobNameField.sendKeys(JobName);
	    
	    WebElement jobdatecalendar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"deliveryDate\"]/div/div/mat-datepicker-toggle/button/span[3]")));
		jobdatecalendar.click();
        String jobDateFromExcelday = row.getCell(5).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
        String jobDateFromExcelmonth = row.getCell(6).toString().trim();
        String jobDateFromExcelyear = row.getCell(7).toString().trim(); 
        selectDateFromCalendar(driver, wait, jobDateFromExcelday, jobDateFromExcelmonth, jobDateFromExcelyear);
        Thread.sleep(5000);
        
        WebElement jobdatecalendar1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"create-job\"]/div[3]/div[3]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button/span[3]")));
		jobdatecalendar1.click();
		  String jobperiodFromExcelday1 = row.getCell(8).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
	        String jobperiodFromExcelmonth1 = row.getCell(9).toString().trim();
	        String jobperiodFromExcelyear1 = row.getCell(10).toString().trim(); 
	        selectDateFromCalendar(driver, wait, jobperiodFromExcelday1, jobperiodFromExcelmonth1, jobperiodFromExcelyear1);
	 
			  String jobperiodFromExcelday2 = row.getCell(11).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
		        String jobperiodFromExcelmonth2 = row.getCell(12).toString().trim();
		        String jobperiodFromExcelyear2 = row.getCell(13).toString().trim(); 
		        selectDateFromCalendar(driver, wait, jobperiodFromExcelday2, jobperiodFromExcelmonth2, jobperiodFromExcelyear2);
	        Thread.sleep(5000);
	        
	        WebElement nextbutton02 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job-digi > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			nextbutton02.click();
			
			WebElement radioButton = driver.findElement(By.xpath(
				    "//div[contains(@class, 'flow-title') and contains(text(), 'Client Billing First')]/following::input[@type='radio'][1]"
				));
				radioButton.click();


		     
	        WebElement billingformatdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ng-select-container")));
	        billingformatdropdown.click();
	        String billingFormat = row.getCell(14).getStringCellValue();
	        WebElement billingformatdropdownoption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'ng-option')]//span[contains(text(),'" + billingFormat + "')]")));
	        billingformatdropdownoption.click();     
	        
	        String currencyname = row.getCell(15).getStringCellValue();
	        WebElement currencyDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ng-select-container') and .//div[contains(text(),'Select Currency')]]")));
	        currencyDropdown.click();
	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + currencyname + "')]")));
	        option.click();
	        
	        WebElement nextbutton03 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job-digi > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			nextbutton03.click();
			
			WebElement nextbutton04 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job-digi > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			nextbutton04.click();
	        System.out.print("Add Campaign for Manual FLow");
	     // Wait for Add Campaign icon and click it using JavaScript
	        WebElement addCampaignIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//img[contains(@src, 'add-compaign.svg')]")));
	        js.executeScript("arguments[0].click();", addCampaignIcon);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                By.cssSelector(".modal-backdrop, .overlay, .loader")));
	        // Wait for Close icon and click it normally
	        WebElement closeIcon = wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("img[src='./assets/img/svg/close-cross.svg']")));
	        closeIcon.click();
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                By.cssSelector(".modal-backdrop, .overlay, .loader")));
	        // Wait again for Add Campaign icon and click it using JavaScript
	        WebElement addCampaignIcon1 = wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//img[contains(@src, 'add-compaign.svg')]")));
	        js.executeScript("arguments[0].click();", addCampaignIcon1);
	        Thread.sleep(3000);
	    	    String platformtype = row.getCell(16).getStringCellValue();
	        	WebElement platformtypefield = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[1]/div[1]/ng-select/div/div/div[2]/input")));
	        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[1]/div[1]/ng-select/div/div/div[2]/input")));
	        	platformtypefield.click();
	        	platformtypefield.sendKeys(Keys.ENTER);
	        	platformtypefield.clear();
		    	   
	        	platformtypefield.sendKeys(platformtype);
	        	platformtypefield.sendKeys(Keys.ENTER);
	        	Thread.sleep(2000);
	        	String platform = row.getCell(17).getStringCellValue();
	        	WebElement platformfield = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[1]/div[2]/ng-select/div/div/div[2]/input")));
	        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[1]/div[2]/ng-select/div/div/div[2]/input")));
	        	js.executeScript("arguments[0].click();", platformfield);
	        	platformfield.clear();		    	   
	        	platformfield.sendKeys(platform);
	        	Thread.sleep(2000);
	        	platformfield.sendKeys(Keys.ENTER);
	     
	        	
	        	
	        	WebElement nextbutton09 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));
	        	js.executeScript("arguments[0].scrollIntoView(true);", nextbutton09); // Scrolls to the element
	        	js.executeScript("arguments[0].focus();", nextbutton09);   
	        	nextbutton09.click();
	        	
				WebElement nextbutton090 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));
				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton090); // Scrolls to the element
	        	js.executeScript("arguments[0].focus();", nextbutton090);  
				nextbutton090.click();
				
	        	Thread.sleep(2000);
	        	// Read the category value from Excel (and trim to avoid trailing spaces)
				String category = row.getCell(18).getStringCellValue().trim();
				System.out.println("Category from Excel: " + category);

				// Open the dropdown
				WebElement categoryFieldContainer = wait.until(ExpectedConditions.elementToBeClickable(
				    By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[1]/ng-select/div")
				));
				categoryFieldContainer.click();

				// Wait for the input field and send the category text
				WebElement categoryInput = wait.until(ExpectedConditions.elementToBeClickable(
				    By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[1]/ng-select/div/div/div[2]/input")
				));
				categoryInput.clear();
				categoryInput.click();
				categoryInput.sendKeys(category);

				// Retry loop to avoid stale elements
				boolean matched = false;

				System.out.println("Dropdown options:");
				for (int retry = 0; retry < 3 && !matched; retry++) {
				    try {
				        // Wait explicitly for the options to be visible on each retry
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ng-option")));

				        List<WebElement> options = driver.findElements(By.cssSelector("div.ng-option"));

				        for (WebElement optionz : options) {
				            String text = optionz.getText().trim();
				            System.out.println("Option: " + text);

				            if (text.equalsIgnoreCase(category)) {
				                // Ensure the element is clickable before clicking
				                wait.until(ExpectedConditions.elementToBeClickable(optionz)).click();
				                matched = true;
				                break;
				            }
				        }
				    } catch (org.openqa.selenium.StaleElementReferenceException e) {
				        System.out.println("Caught StaleElementReferenceException. Retrying...");
				        Thread.sleep(500); // Pause before retrying
				    }				}

				if (!matched) {
				    throw new RuntimeException("No matching Category option found for: " + category);
				}
				categoryInput.sendKeys(Keys.ENTER);

	        	String campaignname = row.getCell(19).getStringCellValue();
	        	WebElement campaignnamefield = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[2]/input")));
	        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[2]/input")));
	        	js.executeScript("arguments[0].scrollIntoView(true);", campaignnamefield); // Scrolls to the element
	        	js.executeScript("arguments[0].focus();", campaignnamefield);   
	        	js.executeScript("arguments[0].click();", campaignnamefield);
	        	campaignnamefield.clear();		    	   
	        	campaignnamefield.sendKeys(campaignname);
	        	campaignnamefield.sendKeys(Keys.ENTER);
	        	Thread.sleep(2000);
	        	WebElement nextbutton05 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span")));
	        	js.executeScript("arguments[0].scrollIntoView(true);", nextbutton05); // Scrolls to the element
	        	//js.executeScript("arguments[0].focus();", nextbutton05);   
	        	nextbutton05.click();
				//js.executeScript("document.body.style.zoom='90%'");
				Thread.sleep(5000);
				WebElement nextbutton06 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));
				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton06); // Scrolls to the element
	        	//js.executeScript("arguments[0].focus();", nextbutton06);
				nextbutton06.click();
				Thread.sleep(2000);
				String buytype = formatter.formatCellValue(row.getCell(20)).trim();
				System.out.println("Buy Type from Excel: " + buytype);

				// First, click "Next" button multiple times to ensure dropdown is ready
				for (int i = 0; i < 2; i++) {
				    try {
				        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(
				            By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));
				        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn); // Scrolls to the element
			        	js.executeScript("arguments[0].focus();", nextBtn);
				        js.executeScript("arguments[0].click();", nextBtn);
				        Thread.sleep(1000);
				        System.out.println("✅ Clicked 'Next' button - attempt " + (i + 1));
				    } catch (Exception e) {
				        System.out.println("⚠️ Could not click 'Next' button on attempt " + (i + 1) + ": " + e.getMessage());
				    }
				}

				// Now open the Buy Type dropdown
				WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ng-select-container")));
				js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
				//js.executeScript("arguments[0].scrollIntoView(true);", dropdown); // Scrolls to the element
				js.executeScript("arguments[0].focus();", dropdown);   
				dropdown.click(); // Only click — no typing
				System.out.println("🟡 Dropdown clicked, waiting for options...");

				// Wait for options to appear
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.ng-option")));

				List<WebElement> options = driver.findElements(By.cssSelector("div.ng-option"));
				boolean matchedd = false;

				System.out.println("🟢 Options visible: " + options.size());
				for (WebElement optioni : options) {
				    String optionText = optioni.getText().trim();
				    System.out.println("➡️ Option: " + optionText);

				    if (optionText.equalsIgnoreCase(buytype)) {
				        js.executeScript("arguments[0].click();", optioni); // JS click to avoid intercept
				        System.out.println("✅ Selected Buy Type: " + buytype);
				        matchedd = true;
				        break;
				    }
				}

				if (!matchedd) {
				    throw new RuntimeException("❌ Buy Type '" + buytype + "' not found in dropdown options.");
				}
				String quantity = row.getCell(21).getStringCellValue();
				WebElement quantityfield = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[2]/input")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[2]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", quantityfield);
				js.executeScript("arguments[0].focus();", quantityfield);

				js.executeScript("arguments[0].click();", quantityfield);
				quantityfield.clear();		   	   
				quantityfield.sendKeys(quantity);


				String clientrate = row.getCell(22).getStringCellValue();
				WebElement clientratefield = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[3]/div[1]/input")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[3]/div[1]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", clientratefield);
				js.executeScript("arguments[0].focus();", clientratefield);

				js.executeScript("arguments[0].click();", clientratefield);
				clientratefield.clear();		    	   
				clientratefield.sendKeys(clientrate);


				WebElement vendorratefield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[4]/div[1]/input")));

				

				vendorratefield.click();


				WebElement yestoclientratechanges = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"vailidateRate\"]/div[3]/div/div/span[2]")));

				js.executeScript("arguments[0].scrollIntoView(true);", yestoclientratechanges);
				js.executeScript("arguments[0].focus();", yestoclientratechanges);

				yestoclientratechanges.click();
				try {
	        	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-pane")));
	        	    System.out.println("✅ Overlay is gone. Safe to click Submit.");
	        	} catch (TimeoutException e) {
	        	    System.out.println("⚠️ Overlay still visible after wait, proceeding anyway.");
	        	}

				WebElement nextbutton07 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));

				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton07);
				js.executeScript("arguments[0].focus();", nextbutton07);

				nextbutton07.click();

				Thread.sleep(2000);
				WebElement nextbutton08 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));

				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton08);
				js.executeScript("arguments[0].focus();", nextbutton08);

				nextbutton08.click();

				Thread.sleep(2000);


				String vendorNameRaw = formatter.formatCellValue(row.getCell(24));
				String vendorName = vendorNameRaw.replace('\u00A0', ' ').trim();
				System.out.println("🔍 Excel input: [" + vendorNameRaw + "]");
				System.out.println("✅ Cleaned vendorName: [" + vendorName + "]");

				// 2️⃣ Locate and open the dropdown input
				WebElement vendorInput = wait.until(ExpectedConditions.elementToBeClickable(
				    By.cssSelector("div.ng-select-container div.ng-input input")
				));
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", vendorInput);
				vendorInput.click();
				Thread.sleep(300);

				// ✅ Inject full string (with spaces) and dispatch events
				js.executeScript(
				    "arguments[0].value = arguments[1];" +
				    "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
				    "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				    vendorInput, vendorName
				);

				System.out.println("✍️ Injected vendor name via JS: [" + vendorName + "]");

				int retryCount = 0;
				int maxRetries = 5;
				boolean selected = false;

				while (retryCount < maxRetries && !selected) {
				    try {
				        // Clear previous text
				        vendorInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				        vendorInput.sendKeys(Keys.DELETE);
				        Thread.sleep(300);

				        // Step 1: Type small prefix to trigger dropdown
				        vendorInput.sendKeys(vendorName.substring(0, 2));
				        Thread.sleep(800);

				        // Step 2: Wait for dropdown options to appear
				        wait.until(ExpectedConditions.visibilityOfElementLocated(
				            By.cssSelector(".ng-dropdown-panel .ng-option")
				        ));

				        // Step 3: Select first option
				        vendorInput.sendKeys(Keys.ARROW_DOWN);
				        Thread.sleep(300);
				        vendorInput.sendKeys(Keys.ENTER);
				        Thread.sleep(500);

				        // Step 4: Check if selection stuck
				        // More reliable way to check selected value:
				        WebElement selectedTextElem = driver.findElement(By.cssSelector("div.ng-select .ng-value span"));
				        String selectedValue = selectedTextElem.getText().trim();

				        if (selectedValue.equalsIgnoreCase(vendorName)) {
				            selected = true;
				            System.out.println("✅ Successfully selected: " + selectedValue);
				        } else {
				            retryCount++;
				            System.out.println("🔁 Retry #" + retryCount + " — Selection mismatch, retrying...");
				        }

				    } catch (Exception e) {
				        retryCount++;
				        System.out.println("⚠️ Exception in retry #" + retryCount + ": " + e.getMessage());
				        Thread.sleep(500);
				    }
				}

				if (!selected) {
				    System.out.println("❌ Vendor selection failed after " + maxRetries + " attempts.");
				}

				// ADD CAMPAIGN button
				WebElement addCampaignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'ADD CAMPAIGN')]")));

				js.executeScript("arguments[0].scrollIntoView(true);", addCampaignButton);
				js.executeScript("arguments[0].focus();", addCampaignButton);

				addCampaignButton.click();
				System.out.println("✅ 'ADD CAMPAIGN' button clicked.");

				Thread.sleep(5000);

				WebElement addCampaignIcon3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@src, 'add-compaign.svg')]")));

				js.executeScript("arguments[0].scrollIntoView(true);", addCampaignIcon3);
				js.executeScript("arguments[0].focus();", addCampaignIcon3);

				js.executeScript("arguments[0].click();", addCampaignIcon3);

				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop, .overlay, .spinner, .cdk-overlay-backdrop")));

				WebElement closeIcon2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/close-cross.svg']")));

				js.executeScript("arguments[0].scrollIntoView(true);", closeIcon2);
				js.executeScript("arguments[0].focus();", closeIcon2);

				js.executeScript("arguments[0].click();", closeIcon2);

				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop, .overlay, .spinner, .cdk-overlay-backdrop")));


				// Integration add campaign
				System.out.print("Integration add campaign");

				WebElement addCampaignIcon2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@src, 'add-compaign.svg')]")));

				js.executeScript("arguments[0].scrollIntoView(true);", addCampaignIcon2);
				js.executeScript("arguments[0].focus();", addCampaignIcon2);

				js.executeScript("arguments[0].click();", addCampaignIcon2);

				Thread.sleep(2000);

				WebElement nextbutton8 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));

				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton8);
				js.executeScript("arguments[0].focus();", nextbutton8);
				js.executeScript("arguments[0].click();", nextbutton8);

				Thread.sleep(5000);

				String platformtype1 = row.getCell(25).getStringCellValue().trim();
				System.out.println("Platform Type from Excel: [" + platformtype1 + "]");

				WebElement platformtypefield1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[1]/div[1]/ng-select/div/div/div[2]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", platformtypefield1);
				js.executeScript("arguments[0].focus();", platformtypefield1);

				js.executeScript("arguments[0].click();", platformtypefield1); 
				platformtypefield1.clear();
				platformtypefield1.sendKeys(platformtype1);

				Thread.sleep(1000);

				platformtypefield1.sendKeys(Keys.ENTER);
				System.out.println("✅ Platform type '" + platformtype1 + "' selected.");

				Thread.sleep(2000);

				String platform1 = row.getCell(26).getStringCellValue();
				WebElement platformfield1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[1]/div[2]/ng-select/div/div/div[2]/input")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[1]/div[2]/ng-select/div/div/div[2]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", platformfield1);
				js.executeScript("arguments[0].focus();", platformfield1);

				js.executeScript("arguments[0].click();", platformfield1);
				platformfield1.clear();
				platformfield1.sendKeys(platform1);

				Thread.sleep(2000);

				platformfield1.sendKeys(Keys.ENTER);

				String account = row.getCell(27).getStringCellValue();
				WebElement accountfield1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[1]/ng-select/div/div/div[2]/input")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[1]/ng-select/div/div/div[2]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", accountfield1);
				js.executeScript("arguments[0].focus();", accountfield1);

				js.executeScript("arguments[0].click();", accountfield1);
				accountfield1.clear();		    	   
				accountfield1.sendKeys(account);
				Thread.sleep(2000);
				accountfield1.sendKeys(Keys.ENTER);

				String adaccount = row.getCell(28).getStringCellValue();
				WebElement adaccountfield1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[2]/ng-select/div/div/div[2]/input")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[2]/ng-select/div/div/div[2]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", adaccountfield1);
				//js.executeScript("arguments[0].focus();", adaccountfield1);

				//js.executeScript("arguments[0].click();", adaccountfield1);
				adaccountfield1.clear();		    	   
				adaccountfield1.sendKeys(adaccount);
				
				adaccountfield1.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				String category1 = row.getCell(29).getStringCellValue().trim();
				System.out.println("📥 Category from Excel: " + category1);

				try {
				    WebElement categoryInput1 = wait.until(ExpectedConditions.elementToBeClickable(
				        By.xpath("//div[@class='ng-select-container' and .//div[contains(@class, 'ng-placeholder') and text()='Select Campaign Category']]//input[@aria-autocomplete='list']")
				    ));

				    js.executeScript("arguments[0].scrollIntoView(true);", categoryInput1);
				    js.executeScript("arguments[0].focus();", categoryInput1);

				    js.executeScript("arguments[0].click();", categoryInput1); 
				    categoryInput1.clear();
				    categoryInput1.sendKeys(category1);

				    Thread.sleep(1500);  // Wait for dropdown options to appear

				    List<WebElement> options1 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				        By.cssSelector("div.ng-option")
				    ));

				    boolean matched1 = false;
				    for (WebElement option1 : options1) {
				        String text = option1.getText().trim();
				        System.out.println("➡️ Option: " + text);
				        if (text.equalsIgnoreCase(category1)) {
				            js.executeScript("arguments[0].scrollIntoView(true);", option1);
				            js.executeScript("arguments[0].focus();", option1);
				            option1.click();
				            matched1 = true;
				            System.out.println("✅ Selected Category: " + text);
				            break;
				        }
				    }

				    if (!matched1) {
				        throw new RuntimeException("❌ Category not found in dropdown: " + category1);
				    }

				} catch (Exception e) {
				    System.out.println("❌ Exception while selecting category: " + e.getMessage());
				    throw e;
				}


		         
		         
//		         
//		         String category1 = row.getCell(29).getStringCellValue().trim();
//		         System.out.println("Category from Excel: " + category1);
//
//		         // Click on the dropdown container to open it
//		         WebElement categoryDropdown = wait.until(ExpectedConditions.elementToBeClickable(
//		             By.cssSelector("div[aria-haspopup='listbox'] input[aria-autocomplete='list']")
//		         ));
//		         js.executeScript("arguments[0].scrollIntoView(true);", categoryDropdown);
//		         categoryDropdown.click();
//
//		         // Clear any prefilled input and type the desired category
//		         categoryDropdown.clear();
//		         categoryDropdown.sendKeys(category1);
//
//		         Thread.sleep(1000); // Wait for the options to load
//
//		         boolean matched1 = false;
//
//		         // Retry loop in case of stale elements
//		         for (int attempt = 0; attempt < 3 && !matched1; attempt++) {
//		             try {
//		                 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.ng-option")));
//		                 List<WebElement> options1 = driver.findElements(By.cssSelector("div.ng-option"));
//
//		                 System.out.println("Dropdown options:");
//		                 for (WebElement option1 : options1) {
//		                     String text = option1.getText().trim();
//		                     System.out.println("➡️ Option: " + text);
//
//		                     if (text.equalsIgnoreCase(category1)) {
//		                         wait.until(ExpectedConditions.elementToBeClickable(option1)).click();
//		                         System.out.println("✅ Selected category: " + category1);
//		                         matched1 = true;
//		                         break;
//		                     }
//		                 }
//		             } catch (StaleElementReferenceException e) {
//		                 System.out.println("⚠️ Stale element, retrying... Attempt " + (attempt + 1));
//		                 Thread.sleep(500);
//		             }
//		         }
//
//		         if (!matched) {
//		             throw new RuntimeException("❌ No matching Category option found for: " + category1);
//		         }

		        
				String campaignname1 = row.getCell(30).getStringCellValue();
				WebElement campaignnamefield1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[3]/div[2]/input")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[3]/div[2]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", campaignnamefield1);
				js.executeScript("arguments[0].focus();", campaignnamefield1);

				js.executeScript("arguments[0].click();", campaignnamefield1);
				campaignnamefield1.clear();		    	   
				campaignnamefield1.sendKeys(campaignname1);
				campaignnamefield1.sendKeys(Keys.ENTER);
				Thread.sleep(2000);

				Thread.sleep(2000);
				WebElement nextbutton0511 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span")));
				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton0511);
				js.executeScript("arguments[0].focus();", nextbutton0511);
				js.executeScript("arguments[0].click();", nextbutton0511); 

				//js.executeScript("document.body.style.zoom='90%'");
				Thread.sleep(2000);

				WebElement nextbutton061 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));
				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton061);
				js.executeScript("arguments[0].focus();", nextbutton061);
				js.executeScript("arguments[0].click();", nextbutton061); 
				Thread.sleep(2000);

				String buytype2 = formatter.formatCellValue(row.getCell(31)).trim();
				System.out.println("Buy Type from Excel: " + buytype2);
				
				// Click "Next" button multiple times to ensure dropdown readiness
				for (int i = 0; i < 2; i++) {
				    try {
				        WebElement nextBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
				            By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));
				        js.executeScript("arguments[0].scrollIntoView(true);", nextBtn1);
				        js.executeScript("arguments[0].focus();", nextBtn1);
				        js.executeScript("arguments[0].click();", nextBtn1);
				        Thread.sleep(2000);
				        Thread.sleep(1000);
				        System.out.println("✅ Clicked 'Next' button - attempt " + (i + 1));
				    } catch (Exception e) {
				        System.out.println("⚠️ Could not click 'Next' button on attempt " + (i + 1) + ": " + e.getMessage());
				    }
				}
				Thread.sleep(2000);
				// Open Buy Type dropdown
				WebElement dropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ng-select-container")));
				js.executeScript("arguments[0].scrollIntoView(true);", dropdown1);
			//	js.executeScript("arguments[0].focus();", dropdown1);
				dropdown1.click();
				System.out.println("🟡 Dropdown clicked, waiting for options...");
				Thread.sleep(2000);
				// Wait for options to appear
				//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.ng-option")));
				
				List<WebElement> options2 = driver.findElements(By.cssSelector("div.ng-option"));
				boolean matchedd2 = false;

				System.out.println("🟢 Options visible: " + options2.size());
				for (WebElement optioni2 : options2) {
				    String optionText = optioni2.getText().trim();
				    System.out.println("➡️ Option: " + optionText);

				    if (optionText.equalsIgnoreCase(buytype2)) {
				      //  js.executeScript("arguments[0].scrollIntoView(true);", optioni2);
				       // js.executeScript("arguments[0].focus();", optioni2);
				        js.executeScript("arguments[0].click();", optioni2);
				       // optioni2.click();
				        System.out.println("✅ Selected Buy Type: " + buytype2);
				        matchedd2 = true;
				        break;
				    }
				}

				if (!matchedd2) {
				    throw new RuntimeException("❌ Buy Type '" + buytype2 + "' not found in dropdown options.");
				}

				String quantity1 = row.getCell(32).getStringCellValue();
				WebElement quantityfield1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[2]/input")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[2]/div[2]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", quantityfield1);
				js.executeScript("arguments[0].focus();", quantityfield1);

				js.executeScript("arguments[0].click();", quantityfield1);
				quantityfield1.clear();		   	   
				quantityfield1.sendKeys(quantity1);

				String clientrate1 = row.getCell(33).getStringCellValue();
				WebElement clientratefield1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[3]/div[1]/input")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[3]/div[1]/input")));

				js.executeScript("arguments[0].scrollIntoView(true);", clientratefield1);
				js.executeScript("arguments[0].focus();", clientratefield1);

				js.executeScript("arguments[0].click();", clientratefield1);
				clientratefield1.clear();		    	   
				clientratefield1.sendKeys(clientrate1);

				WebElement vendorratefield1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-offcanvas-panel/div[2]/app-campaign-new/div/div[2]/div[1]/div[4]/div[1]/input")));
				
				vendorratefield1.click();

				WebElement yestoclientratechanges1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"vailidateRate\"]/div[3]/div/div/span[2]")));
				js.executeScript("arguments[0].scrollIntoView(true);", yestoclientratechanges1);
				js.executeScript("arguments[0].focus();", yestoclientratechanges1);
				yestoclientratechanges1.click();

				WebElement nextbutton071 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));
				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton071);
				js.executeScript("arguments[0].focus();", nextbutton071);
				nextbutton071.click();

				WebElement nextbutton081 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > ngb-offcanvas-panel > div.offcanvas-body > app-campaign-new > div > div:nth-child(2) > div:nth-child(2) > div > span.submit-button.ng-star-inserted")));
				js.executeScript("arguments[0].scrollIntoView(true);", nextbutton081);
				js.executeScript("arguments[0].focus();", nextbutton081);
				nextbutton081.click();

				Thread.sleep(2000);

				// Clean vendor name with non-breaking space replaced
				String vendorNameRaw1 = formatter.formatCellValue(row.getCell(35));
				String vendorName1 = vendorNameRaw1.replace('\u00A0', ' ').trim();
				System.out.println("🔍 Excel input: [" + vendorNameRaw1 + "]");
				System.out.println("✅ Cleaned vendorName: [" + vendorName1 + "]");

				// Locate and open the dropdown input
				WebElement vendorInput1 = wait.until(ExpectedConditions.elementToBeClickable(
				    By.cssSelector("div.ng-select-container div.ng-input input")
				));
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", vendorInput1);
				vendorInput1.click();
				Thread.sleep(300);

				// Inject full string (with spaces) and dispatch events
				js.executeScript(
				    "arguments[0].value = arguments[1];" +
				    "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
				    "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
				    vendorInput1, vendorName1
				);

				System.out.println("✍️ Injected vendor name via JS: [" + vendorName1 + "]");

				int retryCount1 = 0;
				int maxRetries1 = 5;
				boolean selected1 = false;

				while (retryCount1 < maxRetries1 && !selected1) {
				    try {
				        // Clear previous input text
				        vendorInput1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				        vendorInput1.sendKeys(Keys.DELETE);
				        Thread.sleep(300);

				        // Step 1: Type small prefix to trigger dropdown
				        vendorInput1.sendKeys(vendorName1.substring(0, 2));
				        Thread.sleep(800);

				        // Step 2: Wait for dropdown options to appear
				        wait.until(ExpectedConditions.visibilityOfElementLocated(
				            By.cssSelector(".ng-dropdown-panel .ng-option")
				        ));

				        // Step 3: Select first option
				        vendorInput1.sendKeys(Keys.ARROW_DOWN);
				        Thread.sleep(300);
				        vendorInput1.sendKeys(Keys.ENTER);
				        Thread.sleep(500);

				        // Step 4: Check if selection stuck
				        WebElement selectedTextElem1 = driver.findElement(By.cssSelector("div.ng-select .ng-value span"));
				        String selectedValue1 = selectedTextElem1.getText().trim();

				        if (selectedValue1.equalsIgnoreCase(vendorName1)) {
				            selected1 = true;
				            System.out.println("✅ Successfully selected vendor1: " + selectedValue1);
				        } else {
				            retryCount1++;
				            System.out.println("🔁 Retry #" + retryCount1 + " — Vendor1 selection mismatch, retrying...");
				        }

				    } catch (Exception e) {
				        retryCount1++;
				        System.out.println("⚠️ Exception in retry #" + retryCount1 + ": " + e.getMessage());
				        Thread.sleep(500);
				    }
				}

				if (!selected1) {
				    System.out.println("❌ Vendor1 selection failed after " + maxRetries1 + " attempts.");
				}
				Thread.sleep(2000);
				// Wait for ADD CAMPAIGN button, scroll and click
				WebElement addCampaignButton1 = wait.until(ExpectedConditions.elementToBeClickable(
				    By.xpath("//span[contains(text(),'ADD CAMPAIGN')]")
				));
				js.executeScript("arguments[0].scrollIntoView(true);", addCampaignButton1);
				js.executeScript("arguments[0].focus();", addCampaignButton1);
				addCampaignButton1.click();
				System.out.println("✅ 'ADD CAMPAIGN' button clicked.");

				Thread.sleep(10000);

    }
	
    }

@And("User creates estimate with outputs for cbf")
public void user_createsestimate_withoutputs() throws InterruptedException, FileNotFoundException, IOException {
	String excelFilePath = "D:\\fd\\btladintelleautomation\\DigitalproCBF.xlsx";  // Path to your Excel file
    FileInputStream file = new FileInputStream(new File(excelFilePath));
    try (Workbook workbook = new XSSFWorkbook(file)) {
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		Row row = sheet.getRow(1);
	 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    JavascriptExecutor js = (JavascriptExecutor) driver;
	System.out.println("Navigating to Client docs page");
	WebElement clientdocsButton = wait.until(ExpectedConditions.elementToBeClickable(
	         By.cssSelector("body > app-root > div > div > div > main > div > app-d-dashboard > div > div:nth-child(2) > div > div > div:nth-child(3)")));
	js.executeScript("arguments[0].scrollIntoView(true);", clientdocsButton); // Scrolls to the element
	js.executeScript("arguments[0].focus();", clientdocsButton);              // Focuses the element
	js.executeScript("arguments[0].click();", clientdocsButton); 
	
	System.out.println("Navigated to client docs page and Estimate Creation process is started");
	 WebElement createEstimateButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src*='butt-create-estimate.svg']")));
	// js.executeScript("arguments[0].scrollIntoView(true);", createEstimateButton);
	 js.executeScript("arguments[0].scrollIntoView(true);", createEstimateButton); // Scrolls to the element
		js.executeScript("arguments[0].focus();", createEstimateButton);              // Focuses the element
		js.executeScript("arguments[0].click();", createEstimateButton);
	 
	 WebElement selectallestimateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"planning-est\"]/div/table/thead/tr/th[1]/input")));
	 js.executeScript("arguments[0].scrollIntoView(true);", selectallestimateButton); // Scrolls to the element
	 js.executeScript("arguments[0].focus();", selectallestimateButton);              // Focuses the element
	 js.executeScript("arguments[0].click();", selectallestimateButton); 
	 
	  js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/AdditionalLineItems.svg']")));
	    WebElement imageadl = driver.findElement(By.cssSelector("img[src='./assets/img/svg/AdditionalLineItems.svg']"));
	    js.executeScript("arguments[0].scrollIntoView(true);", imageadl); // Scrolls to the element
		 js.executeScript("arguments[0].focus();", imageadl);              // Focuses the element
		 js.executeScript("arguments[0].click();", imageadl); 
	      Thread.sleep(2000);
	      String itemtype = row.getCell(36).toString();
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[3]/div/table/tr/td[2]/ng-select/div/div/div[2]/input")));
		  WebElement itemtypes = driver.findElement(By.xpath("//*[@id=\"selection1\"]/div[3]/div/table/tr/td[2]/ng-select/div/div/div[2]/input"));
		    js.executeScript("arguments[0].scrollIntoView(true);", itemtypes); // Scrolls to the element
			 js.executeScript("arguments[0].focus();", itemtypes);              // Focuses the element
			 js.executeScript("arguments[0].click();", itemtypes); 
		  itemtypes.sendKeys(Keys.ENTER);
		  itemtypes.sendKeys(itemtype);
		  itemtypes.sendKeys(Keys.ENTER);
		  itemtypes.sendKeys(Keys.ENTER);
		  String description = row.getCell(37).toString();
		  wait.until(ExpectedConditions.elementToBeClickable(By.name("adddescription")));
		  WebElement descriptions = driver.findElement(By.name("adddescription"));
		  js.executeScript("arguments[0].scrollIntoView(true);", descriptions); // Scrolls to the element
			 js.executeScript("arguments[0].focus();", descriptions);              // Focuses the element
			 js.executeScript("arguments[0].click();", descriptions); 
		  descriptions.clear();
		  descriptions.sendKeys(description);
		  descriptions.sendKeys(Keys.ENTER);
		  String amount = row.getCell(38).toString();
		  wait.until(ExpectedConditions.elementToBeClickable(By.name("lineitemAmount")));
		  WebElement amounts = driver.findElement(By.name("lineitemAmount"));
		  js.executeScript("arguments[0].scrollIntoView(true);", amounts); // Scrolls to the element
			 js.executeScript("arguments[0].focus();", amounts);              // Focuses the element
			 js.executeScript("arguments[0].click();", amounts); 
		  amounts.sendKeys(amount);
		  amounts.sendKeys(Keys.ENTER);
		//  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selection1 > div.row.ng-star-inserted > div > table > tr > td:nth-child(8) > span")));
		  WebElement row1 = driver.findElement(By.cssSelector("#selection1 > div.row.ng-star-inserted > div > table > tr > td:nth-child(8) > span"));
		 // JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView(true);", row1);
		  js.executeScript("arguments[0].focus();", row1); // Optional
		  js.executeScript("arguments[0].click();", row1);

		  System.out.println("Added additional line item");
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		  driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
		  Thread.sleep(5000);   
		   
		  WebElement estimatedatecalendarButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='billdate']/div/div/mat-datepicker-toggle/button/span[3]")));
		  js.executeScript("arguments[0].scrollIntoView(true);", estimatedatecalendarButton); // Scrolls to the element
			 js.executeScript("arguments[0].focus();", estimatedatecalendarButton);              // Focuses the element
			 js.executeScript("arguments[0].click();", estimatedatecalendarButton); 
		  
	        String jobDateFromExcelday = row.getCell(39).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
	        String estimatedatecalendarButtonmonthFromExcel = row.getCell(40).toString().trim();
	        String estimatedatecalendarButtonyearFromExcel = row.getCell(41).toString().trim(); 
	        selectDateFromCalendar(driver, wait, jobDateFromExcelday, estimatedatecalendarButtonmonthFromExcel, estimatedatecalendarButtonyearFromExcel);
		  //System.out.println("📅 Date to click: " + estimatedatecalendarButtondateFromExcel);
		  WebDriverWait dateWait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		  WebElement dateElement = dateWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'mat-calendar-body-cell-content') and normalize-space(text())='" + estimatedatecalendarButtondateFromExcel + "']")));
//		  dateElement.click();
//		  System.out.println("✅ Clicked date: " + estimatedatecalendarButtondateFromExcel);
		
		  

			String jobperiodFromExcelday2 = row.getCell(11).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
		  String etaxtemplate = row.getCell(42).toString();
		  WebElement estimatetaxtemplate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[1]/div[2]/ng-select/div/div/div[3]/input")));
		  js.executeScript("arguments[0].scrollIntoView(true);", estimatetaxtemplate); // Scrolls to the element
			js.executeScript("arguments[0].focus();", estimatetaxtemplate);              // Focuses the element
			//js.executeScript("arguments[0].click();", estimatetaxtemplate);
		  estimatetaxtemplate.sendKeys(etaxtemplate);
		  estimatetaxtemplate.sendKeys(Keys.ENTER);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		  String printformat = row.getCell(43).toString();
		  WebElement printformatelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[6]/div[1]/ng-select/div/div/div[3]/input")));
		  js.executeScript("arguments[0].scrollIntoView(true);", printformatelement); // Scrolls to the element
			js.executeScript("arguments[0].focus();", printformatelement);  
		  printformatelement.sendKeys(printformat);
		  printformatelement.sendKeys(Keys.ENTER);
		  
		  String documentname = row.getCell(44).toString();
		  WebElement documentnameelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[6]/div[2]/input")));
		  js.executeScript("arguments[0].scrollIntoView(true);", documentnameelement); // Scrolls to the element
			js.executeScript("arguments[0].focus();", documentnameelement);  
		  documentnameelement.sendKeys(documentname);
		  documentnameelement.sendKeys(Keys.ENTER);
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		  driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		  driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
		  
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		  driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
		  
		  System.out.println("Estimate is Created, Downloading Outputs for unapproved estimate");		
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
       	  Thread.sleep(2000);  // Let modal appear
       	WebElement pint = wait.until(ExpectedConditions.elementToBeClickable(
       		    By.xpath("//span[@class='submit-button' and text()='Print']")));

       		//JavascriptExecutor js = (JavascriptExecutor) driver;
       		js.executeScript("arguments[0].scrollIntoView(true);", pint);
       		js.executeScript("arguments[0].focus();", pint); // Optional
       		js.executeScript("arguments[0].click();", pint);
			 Thread.sleep(5000); 
			 System.out.println("PDF download should be complete now.");
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);  // Let modal appear
			 WebElement radioBtn = driver.findElement(By.cssSelector("input[type='radio'][value='Excel'][name='DocumentType']"));
			 js.executeScript("arguments[0].scrollIntoView(true);", radioBtn); // Scrolls to the element
			 js.executeScript("arguments[0].focus();", radioBtn);              // Focuses the element
			 js.executeScript("arguments[0].click();", radioBtn); 
			 wait.until(ExpectedConditions.elementToBeClickable(
			         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
			 Thread.sleep(2000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);
			 WebElement billformatdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ng-select-container")));
			 billformatdropdown.click();
			 WebElement input = wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector(".ng-input input")));
	        
	         js.executeScript("arguments[0].scrollIntoView(true);", input); // Scrolls to the element
	         js.executeScript("arguments[0].focus();", input);  
	         input.clear();// Focuses the element
	        // js.executeScript("arguments[0].click();", element); 
	         input.sendKeys("Old Format");
	         WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ng-option') and normalize-space()='Old Format']")));
	         js.executeScript("arguments[0].scrollIntoView(true);", option); // Scrolls to the element
	         js.executeScript("arguments[0].focus();", option);              // Focuses the element
	         
	         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
	         
	         System.out.println("Approving Estimate");
	         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
	         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-approve.svg']"))).click();
	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-approval\"]/div[4]/div/div/span[1]"))).click();
	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-approval\"]/div[5]/div/div/span[2]"))).click();
	         
	         System.out.println("Estimate is Approved, Downloading Outputs for approved estimate");		
	         By iconSelector = By.cssSelector("img[src='./assets/img/svg/action_icon.svg']");
	      WebElement actionbuttonIcon = null;
	      int attempts = 0;
	      while (attempts < 2) {
	          try {
	              actionbuttonIcon = wait.until(ExpectedConditions.presenceOfElementLocated(iconSelector));
	              wait.until(ExpectedConditions.elementToBeClickable(actionbuttonIcon));
	              actionbuttonIcon.click(); // This is where it was failing
	              break; // success
	          } catch (StaleElementReferenceException e) {
	              attempts++;
	              if (attempts == 2) {
	                  throw new RuntimeException("StaleElementReferenceException even after retry");
	              }
	          }
	      }
			  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
	       	  Thread.sleep(2000);  // Let modal appear
	       	WebElement pint1 = wait.until(ExpectedConditions.elementToBeClickable(
	       		    By.xpath("//span[@class='submit-button' and text()='Print']")));

	       		//JavascriptExecutor js = (JavascriptExecutor) driver;
	       		js.executeScript("arguments[0].scrollIntoView(true);", pint1);
	       		js.executeScript("arguments[0].focus();", pint1); // Optional but sometimes helpful
	       		js.executeScript("arguments[0].click();", pint1);
				 Thread.sleep(5000); 
				 System.out.println("PDF download should be complete now.");
				 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
				 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
				 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
				 Thread.sleep(2000);  // Let modal appear
				 WebElement radioBtn1 = driver.findElement(By.cssSelector("input[type='radio'][value='Excel'][name='DocumentType']"));
				
				 js.executeScript("arguments[0].scrollIntoView(true);", radioBtn1); // Scrolls to the element
				 js.executeScript("arguments[0].focus();", radioBtn1);              // Focuses the element
				 js.executeScript("arguments[0].click();", radioBtn1); //radioBtn1.click();
				 wait.until(ExpectedConditions.elementToBeClickable(
				         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
				 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
				 Thread.sleep(2000);
				 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
				 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
				 Thread.sleep(2000);
				 WebElement billformatdropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ng-select-container")));
				 js.executeScript("arguments[0].scrollIntoView(true);", billformatdropdown1); // Scrolls to the element
				 js.executeScript("arguments[0].focus();", billformatdropdown1);              // Focuses the element
				 js.executeScript("arguments[0].click();", billformatdropdown1); 
				
				 WebElement input1 = wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector(".ng-input input")));
		         
		         js.executeScript("arguments[0].scrollIntoView(true);", input1); // Scrolls to the element
		         js.executeScript("arguments[0].focus();", input1);              // Focuses the element
		         js.executeScript("arguments[0].click();", input1); 
		         input1.clear();
		         input1.sendKeys("Old Format");
		         WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ng-option') and normalize-space()='Old Format']")));
		         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option1);
		         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
		         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
	       
    }
}

@And("User sends for billing and creates client bill for cbf")
public void user_createspo_withoutputs() throws InterruptedException, FileNotFoundException, IOException {
	
	String excelFilePath = "DigitalproCBF.xlsx";  // Path to your Excel file
	    FileInputStream file = new FileInputStream(new File(excelFilePath));
	    try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			Row row = sheet.getRow(1);
		 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
				
		Actions actions = new Actions(driver);
		for (int i = 0; i < 5; i++) {
		    actions.sendKeys(Keys.PAGE_UP).perform();
		}
		js.executeScript("window.scrollTo(0, 0)");
	
		System.out.println("Creating Client Bill");
		
		WebElement clientDocspage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-d-dashboard/div/div[2]/div/div/div[3]")));
		clientDocspage.click();
		
		WebElement generateBill = driver.findElement(By.xpath("//img[contains(@src, 'butt-generate-bill.svg')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", generateBill);
		Thread.sleep(3000);
		WebElement selectEstimate = wait.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//*[@id='selection1']/div[2]/div/ng-select/div/div/div[2]/input")));
			selectEstimate.click();
			Thread.sleep(3000);
			// Send keys to search or open options
			selectEstimate.sendKeys(Keys.ARROW_DOWN); // Try opening the dropdown this way
			Thread.sleep(3000); // Slight wait for options to render (or replace with wait for option element)

			// Option 1: Press Enter to select the first one
			selectEstimate.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		WebElement selectallcheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"activation\"]/div/table/thead/tr/th[1]/input")));
		selectallcheckbox.click();
		
		WebElement nextButtonclientbill1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		nextButtonclientbill1.click();
		
		
		
		
		
		WebElement nextButtonclientbill3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		nextButtonclientbill3.click();
		
		WebElement nextButtonclientbill4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		nextButtonclientbill4.click();
		
		WebElement nextButtonclientbill5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		nextButtonclientbill5.click();
		
		WebElement nextButtonclientbill6 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		nextButtonclientbill6.click();
		
		WebElement nextButtonclientbill7 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		nextButtonclientbill7.click();
		
		System.out.println("Client Bill Created, Downloading Client Bill Outputs now");
			
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bill-to-client\"]/table/tbody/tr/td[7]/span[1]/img"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
	 	  Thread.sleep(2000);  // Let modal appear
			 wait.until(ExpectedConditions.elementToBeClickable(
			         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
			 Thread.sleep(5000); 
			 System.out.println("PDF download should be complete now.");
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bill-to-client\"]/table/tbody/tr/td[7]/span[1]/img"))).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);  // Let modal appear
			 WebElement radioBtn = driver.findElement(By.cssSelector("input[type='radio'][value='Excel'][name='DocumentType']"));
			 radioBtn.click();
			 wait.until(ExpectedConditions.elementToBeClickable(
			         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
			 Thread.sleep(2000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bill-to-client\"]/table/tbody/tr/td[7]/span[1]/img"))).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);
			 WebElement billformatdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ng-select-container")));
			 billformatdropdown.click();
			 WebElement input = wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector(".ng-input input")));
	       input.clear();
	       input.sendKeys("Old Format");
	       WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ng-option') and normalize-space()='Old Format']")));
	       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
	       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
	}
	
}



@And("User creates po with outputs for cbf")
public void user_createsvendorbill() throws InterruptedException, FileNotFoundException, IOException {
	String excelFilePath = "DigitalproCBF.xlsx";  // Path to your Excel file
    FileInputStream file = new FileInputStream(new File(excelFilePath));
    try (Workbook workbook = new XSSFWorkbook(file)) {
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		Row row = sheet.getRow(1);
	 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    JavascriptExecutor js = (JavascriptExecutor) driver;
	System.out.println("Navigating to Vendor docs page");
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
	js.executeScript("window.scrollTo(0, 0)");
	Actions actions = new Actions(driver);
	for (int i = 0; i < 5; i++) {
	    actions.sendKeys(Keys.PAGE_UP).perform();
	}
	  
	WebElement vendordocsButton = wait.until(ExpectedConditions.elementToBeClickable(
	         By.cssSelector("body > app-root > div > div > div > main > div > app-d-dashboard > div > div:nth-child(2) > div > div > div:nth-child(4)")));
	vendordocsButton.click();	
	
	
	System.out.println("Navigated to vendor docs page and PO Creation process is started");
	 WebElement createPOButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src*='butt-issue-po.svg']")));
	 js.executeScript("arguments[0].scrollIntoView(true);", createPOButton);
	 createPOButton.click();
	 for (int i = 0; i < 5; i++) {
		    actions.sendKeys(Keys.PAGE_UP).perform();
		}
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
	    DataFormatter formatter1 = new DataFormatter();
	 String vendorNameRaw1 = formatter1.formatCellValue(row.getCell(24));
		String vendorName1 = vendorNameRaw1.replace('\u00A0', ' ').trim();
		System.out.println("🔍 Excel input: [" + vendorNameRaw1 + "]");
		System.out.println("✅ Cleaned vendorName: [" + vendorName1 + "]");

		// 2️⃣ Locate and open the dropdown input
		WebElement vendorInput = wait.until(ExpectedConditions.elementToBeClickable(
		    By.cssSelector("div.ng-select-container div.ng-input input")
		));
		js.executeScript("arguments[0].scrollIntoView(true);", vendorInput);
		vendorInput.click();
		vendorInput.clear();

		// 3️⃣ Forcefully set the full string with JS to preserve spaces
		js.executeScript(
		    "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));",
		    vendorInput, vendorName1
		);

		// 4️⃣ Log the value after JS injection for confirmation
		String afterJS = vendorInput.getAttribute("value");
		System.out.println("✍️ After JS, input shows: [" + afterJS + "]");

		// 5️⃣ Pause briefly to allow dropdown options to populate
		Thread.sleep(1000);

		// 6️⃣ Press ENTER to select the first matching item
		vendorInput.sendKeys(Keys.ENTER);
		//vendorInput.sendKeys(Keys.ENTER);
//		WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
//			    By.cssSelector(".ng-dropdown-panel .ng-option")
//			));
//			firstOption.click();
		System.out.println("✅ Sent ENTER — hopefully selected: [" + afterJS + "]");
		
		WebElement selectallpo = wait.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//*[@id=\"planning\"]/div/table/thead/tr/th[1]/input")
			));
		selectallpo.click();
		 String poamount = row.getCell(45).toString();
		  wait.until(ExpectedConditions.elementToBeClickable(By.name("rate")));
		  WebElement poamounts = driver.findElement(By.name("rate"));
		  poamounts.clear();
		  poamounts.sendKeys(poamount);
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-digital-issue-po > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted"))).click();
		  String etaxtemplate = row.getCell(46).toString();
		  WebElement estimatetaxtemplate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div/div[1]/ng-select/div/div/div[3]/input")));
		  estimatetaxtemplate.sendKeys(etaxtemplate);
		  estimatetaxtemplate.sendKeys(Keys.ENTER);
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-digital-issue-po > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-digital-issue-po > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted"))).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-digital-issue-po > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted"))).click();
		  System.out.println("PO created, Downloading outputs for unapproved status now");
		  By iconSelector1 = By.cssSelector("img[src='./assets/img/svg/action_icon.svg']");
	      WebElement actionbuttonIcon1 = null;
	      int attempts1 = 0;
	      while (attempts1 < 2) {
	          try {
	              actionbuttonIcon1 = wait.until(ExpectedConditions.presenceOfElementLocated(iconSelector1));
	              wait.until(ExpectedConditions.elementToBeClickable(actionbuttonIcon1));
	              actionbuttonIcon1.click(); // This is where it was failing
	              break; // success
	          } catch (StaleElementReferenceException e) {
	              attempts1++;
	              if (attempts1 == 2) {
	                  throw new RuntimeException("StaleElementReferenceException even after retry");
	              }
	          }
	      }
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
       	  Thread.sleep(2000);  // Let modal appear
			 wait.until(ExpectedConditions.elementToBeClickable(
			         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
			 Thread.sleep(5000); 
			 System.out.println("PDF download should be complete now.");
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);  // Let modal appear
			 WebElement radioBtn = driver.findElement(By.cssSelector("input[type='radio'][value='Excel'][name='DocumentType']"));
			 radioBtn.click();
			 wait.until(ExpectedConditions.elementToBeClickable(
			         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
			 Thread.sleep(2000);
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);
			 WebElement billformatdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ng-select-container")));
			 billformatdropdown.click();
			 WebElement input = wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector(".ng-input input")));
	         input.clear();
	         input.sendKeys("Old Format");
	         WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ng-option') and normalize-space()='Old Format']")));
	         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
	         System.out.println("Approving Estimate");
	         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
	         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-approve.svg']"))).click();
	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-approval\"]/div[3]/div/div/table/tr/td[1]/span"))).click();
	         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-approval\"]/div[5]/div/div/span[2]"))).click();
	         
	         System.out.println("PO is Approved, Downloading Outputs for approved PO");		
	         By iconSelector = By.cssSelector("img[src='./assets/img/svg/action_icon.svg']");
	      WebElement actionbuttonIcon = null;
	      int attempts = 0;
	      while (attempts < 2) {
	          try {
	              actionbuttonIcon = wait.until(ExpectedConditions.presenceOfElementLocated(iconSelector));
	              wait.until(ExpectedConditions.elementToBeClickable(actionbuttonIcon));
	              actionbuttonIcon.click(); // This is where it was failing
	              break; // success
	          } catch (StaleElementReferenceException e) {
	              attempts++;
	              if (attempts == 2) {
	                  throw new RuntimeException("StaleElementReferenceException even after retry");
	              }
	          }
	      }
			  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
	       	  Thread.sleep(2000);  // Let modal appear
				 wait.until(ExpectedConditions.elementToBeClickable(
				         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
				 Thread.sleep(5000); 
				 System.out.println("PDF download should be complete now.");
				 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
				 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
				 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
				 Thread.sleep(2000);  // Let modal appear
				 WebElement radioBtn1 = driver.findElement(By.cssSelector("input[type='radio'][value='Excel'][name='DocumentType']"));
				 radioBtn1.click();
				 wait.until(ExpectedConditions.elementToBeClickable(
				         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
				 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
				 Thread.sleep(2000);
				 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
				 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
				 Thread.sleep(2000);
				 WebElement billformatdropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ng-select-container")));
				 billformatdropdown1.click();
				 WebElement input1 = wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector(".ng-input input")));
		         input1.clear();
		         input1.sendKeys("Old Format");
		         WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'ng-option') and normalize-space()='Old Format']")));
		         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option1);
		         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
		         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
		  
    } 	
 }

@Then("User creates vendor bill for cbf")
public void user_createsclientbill() throws InterruptedException, FileNotFoundException, IOException {
	String excelFilePath = "DigitalproCBF.xlsx";  // Path to your Excel file
    FileInputStream file = new FileInputStream(new File(excelFilePath));
    try (Workbook workbook = new XSSFWorkbook(file)) {
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		Row row = sheet.getRow(1);
	 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    JavascriptExecutor js = (JavascriptExecutor) driver;
	System.out.println("Creating vendor bill for Manual flow");
	Actions actions = new Actions(driver);
	for (int i = 0; i < 5; i++) {
	    actions.sendKeys(Keys.PAGE_UP).perform();
	}
	js.executeScript("window.scrollTo(0, 0)");
    
	By logbillsvgSelector = By.cssSelector("img[src='./assets/img/svg/Log-bill-digi.svg']");
	WebElement logbillsvgImage = wait.until(ExpectedConditions.elementToBeClickable(logbillsvgSelector));
	logbillsvgImage.click();
	By manualSvgSelector = By.cssSelector("img[src='./assets/img/svg/Manual.svg']");
	WebElement manualSvg = wait.until(ExpectedConditions.elementToBeClickable(manualSvgSelector));
	manualSvg.click();
	
	DataFormatter formatter = new DataFormatter();
	String vendorNameRaw = formatter.formatCellValue(row.getCell(24));
	String vendorName = vendorNameRaw.replace('\u00A0', ' ').trim();
	System.out.println("🔍 Excel input: [" + vendorNameRaw + "]");
	System.out.println("✅ Cleaned vendorName: [" + vendorName + "]");

	// 2️⃣ Locate and open the dropdown input
	WebElement vendorInput = wait.until(ExpectedConditions.elementToBeClickable(
	    By.xpath("//*[@id=\"selection1\"]/div[2]/div[1]/div[1]/div[1]/ng-select/div/div/div[2]/input")
	));
	js.executeScript("arguments[0].scrollIntoView(true);", vendorInput);
	vendorInput.click();
	vendorInput.clear();

	// 3️⃣ Forcefully set the full string with JS to preserve spaces
	js.executeScript(
	    "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));",
	    vendorInput, vendorName
	);

	// 4️⃣ Log the value after JS injection for confirmation
	String afterJS = vendorInput.getAttribute("value");
	System.out.println("✍️ After JS, input shows: [" + afterJS + "]");

	// 5️⃣ Pause briefly to allow dropdown options to populate
	Thread.sleep(1000);

	// 6️⃣ Press ENTER to select the first matching item
	vendorInput.sendKeys(Keys.ENTER);
	System.out.println("✅ Sent ENTER — hopefully selected: [" + afterJS + "]");
	
	WebElement ngSelectInput = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//*[@id='selection1']/div[2]/div[1]/div[1]/div[2]/ng-select/div/div/div[3]/input")
		));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ngSelectInput);
		ngSelectInput.click();
		

		// Small pause to allow dropdown to render
		Thread.sleep(500);  // Or use WebDriverWait with expected conditions for better practice

		// Wait for dropdown options to become visible
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		    By.cssSelector(".ng-dropdown-panel .ng-option")
		));

		boolean clicked = false;
		for (WebElement option : options) {
		    String text = option.getText().trim();
		    if (!text.isEmpty()) {
		        System.out.println("✅ Selecting option: " + text);
		        try {
		            option.click();
		        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
		            // Fallback: JS click if regular click fails
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
		        }
		        clicked = true;
		        break;
		    }
		}

		if (!clicked) {
		    System.out.println("⚠️ No option was clicked - options may not be interactable.");
		}
		ngSelectInput.sendKeys(Keys.ENTER);
		  String vendorbillmonth = row.getCell(47).toString();
		  WebElement vendorbillmonthelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[2]/div[1]/div[2]/div[1]/ng-select/div/div/div[3]/input")));
		  vendorbillmonthelement.sendKeys(vendorbillmonth);
		  vendorbillmonthelement.sendKeys(Keys.ENTER);
		  
		  String vendorbillyear = row.getCell(48).toString();
		  WebElement vendorbillyearelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[2]/div[1]/div[2]/div[2]/ng-select/div/div/div[3]/input")));
		  vendorbillyearelement.sendKeys(vendorbillyear);
		  vendorbillyearelement.sendKeys(Keys.ENTER);
		
		  String vendorbillnumber = row.getCell(49).toString();
		  WebElement vendorbillnumberelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[2]/div[1]/div[3]/div[1]/input")));
		  vendorbillnumberelement.sendKeys(vendorbillnumber);
		 
//		  
//		  String vendorbillamount = row.getCell(49).toString();
//		  WebElement vendorbillamountelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[2]/div[1]/div[4]/div[1]/input")));
//		  vendorbillamountelement.sendKeys(vendorbillamount);
		
		  //*[@id="selection1"]/div[2]/div[1]/div[3]/div[1]/input
		  WebElement estimatedatecalendarButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"billdate\"]/div/div/mat-datepicker-toggle/button/span[3]")));
		  estimatedatecalendarButton.click();
		    String vendorbillday = row.getCell(50).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
	        String vendirbillmonth = row.getCell(51).toString().trim();
	        String vendorbillyear1 = row.getCell(52).toString().trim(); 
	        selectDateFromCalendar(driver, wait, vendorbillday, vendirbillmonth, vendorbillyear1);
	        
	        Thread.sleep(2000);
	        String vendorbillamount = row.getCell(53).toString();
			WebElement vendorbillamountelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[2]/div[1]/div[4]/div[1]/input")));
			vendorbillamountelement.clear();
			vendorbillamountelement.sendKeys(vendorbillamount);
		
			
			
			WebElement estimatedatecalendarButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ReceivedDate\"]/div/div/mat-datepicker-toggle/button/span[3]")));
			  estimatedatecalendarButton1.click();
			    String billrecievedday = row.getCell(55).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
		        String billrecievedmonth = row.getCell(56).toString().trim();
		        String billrecievedyear = row.getCell(57).toString().trim(); 
		        selectDateFromCalendar(driver, wait, billrecievedday, billrecievedmonth, billrecievedyear);
		        
		    	WebElement estimatedatecalendarButton2= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"billdate\"]/div/div/mat-datepicker-toggle/button/span[3]")));
				estimatedatecalendarButton2.click();
				String billday = row.getCell(58).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
			    String billmonth = row.getCell(59).toString().trim();
			    String billyear = row.getCell(60).toString().trim(); 
			    selectDateFromCalendar(driver, wait, billday, billmonth, billyear);
			        
			    WebElement estimatedatecalendarButton3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"DueDate\"]/div/div/mat-datepicker-toggle/button/span[3]")));
				estimatedatecalendarButton3.click();
				String paymentdueday = row.getCell(61).toString().trim().split("\\.")[0]; // e.g., "12/06/2025"
			    String paymentduemonth = row.getCell(62).toString().trim();
			    String paymentdueyear = row.getCell(63).toString().trim(); 
			    selectDateFromCalendar(driver, wait, paymentdueday, paymentduemonth, paymentdueyear);
			    Thread.sleep(2000);
			    String billtype = row.getCell(64).toString();
				  WebElement billtypeelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[2]/div[1]/div[6]/div[2]/ng-select/div/div/div[3]/input")));
				  billtypeelement.click();
				  billtypeelement.sendKeys(billtype);
				  billtypeelement.sendKeys(Keys.ENTER);
		        
				  WebElement nextButton0001 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
				  nextButton0001.click();
				  
				  WebElement selectallcampaignverification = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"planning-log-m\"]/div/table/thead/tr[2]/th[1]/input")));
				  selectallcampaignverification.click();
				  
				//*[@id="planning-log-m"]/div/table/thead/tr[2]/th[1]/input
				  
				  WebElement nextButton0002 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
				  nextButton0002.click();
				  
				  WebElement nextButton0003 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
				  nextButton0003.click();
				  
				  WebElement nextButton0004 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
				  nextButton0004.click();
			
				  
				  WebElement validateib = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"VaildateIB\"]/div[3]/div/div/span[2]")));
				  validateib.click();
				  
				  Thread.sleep(2000);
				  System.out.println("Creating vendor bill for Integrated flow");
				  Thread.sleep(2000);
				  WebElement campaignspage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-d-dashboard/div/div[2]/div/div/div[2]")));
				  campaignspage.click();
				  Thread.sleep(2000);
				  WebElement activationtab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2-link\"]/span")));
				  activationtab.click(); 
				  Thread.sleep(2000);
				  WebElement integrationtab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2\"]/div/app-activation/div[2]/div[2]")));
				  integrationtab.click();
				  Thread.sleep(2000);
				  WebElement linktabb1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2\"]/div/app-activation/div[3]/div[2]")));
				  linktabb1.click();
				  Thread.sleep(2000);
				  Thread.sleep(2000);
				  WebElement unlinktab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2\"]/div/app-activation/div[3]/div[1]")));
				  unlinktab.click();
				  Thread.sleep(2000);
//				  WebElement linktabb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2\"]/div/app-activation/div[3]/div[2]")));
//				  linktabb.click();
//				  Thread.sleep(2000);
				  Thread.sleep(2000);
				  WebElement linktab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"activation\"]/div[1]/table/tbody/tr/td[1]/span")));
				  linktab.click(); 
				  
				   
				  Thread.sleep(2000);
				  
				  WebElement intaccount1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"section1\"]/div/div[1]/div[1]/ng-select/div/div/div[2]/input")));
				  String account2 = row.getCell(27).getStringCellValue();
				  intaccount1.sendKeys(account2);
				  intaccount1.sendKeys(Keys.ENTER);
				  Thread.sleep(2000);
				  String adaccount3 = row.getCell(28).getStringCellValue();  // e.g., "IN_Carlelo_INR_GUR"

				// Step 1: Get all dropdowns on the page
				List<WebElement> dropdowns = driver.findElements(By.cssSelector(".ng-select-container"));

				// Step 2: Click the second dropdown (index 1, since it's 0-based)
				WebElement targetDropdown = dropdowns.get(1); // use get(0) for the first, get(1) for second, etc.
				targetDropdown.click();

				// Step 3: Wait for the options to be visible
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-option-label")));

				// Step 4: Select the matching option from the list
				List<WebElement> optionl = driver.findElements(By.cssSelector(".ng-option-label"));
				for (WebElement option : optionl) {
				    if (option.getText().trim().equals(adaccount3)) {
				        option.click();
				        break;
				    }
				}		
				Thread.sleep(2000);
				  WebElement nextButton0011 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#section1 > div > div:nth-child(2) > div > div > span.submit-button")));
				  nextButton0011.click();
				  Thread.sleep(2000);
				  WebElement radioaccid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-link-campaign/div/div[2]/div/div[3]/div/mat-sidenav-content/div/div[1]/table/tbody/tr/td[1]/input")));
				  radioaccid.click();
				  Thread.sleep(2000);
				  
				  WebElement nextButton0012 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-estimate > div:nth-child(4) > div > div > span.submit-button")));
				  nextButton0012.click();
				  Thread.sleep(2000);
				  WebElement linkButton0012 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"client-estimate-review\"]/div[3]/div/div/span[2]")));
				  linkButton0012.click();
				  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
			         Thread.sleep(2000);
				  WebElement vendordocsButton1 = wait.until(ExpectedConditions.elementToBeClickable(
					         By.cssSelector("body > app-root > div > div > div > main > div > app-d-dashboard > div > div:nth-child(2) > div > div > div:nth-child(4)")));
					vendordocsButton1.click();
					Thread.sleep(2000);
				  By logbillsvgSelector1 = By.cssSelector("img[src='./assets/img/svg/Log-bill-digi.svg']");
					WebElement logbillsvgImage1 = wait.until(ExpectedConditions.elementToBeClickable(logbillsvgSelector1));
					logbillsvgImage1.click();
					Thread.sleep(2000);
					By integratedSvgSelector = By.cssSelector("img[src='./assets/img/svg/Intergeted.svg']");
					WebElement integratedSvg = wait.until(ExpectedConditions.elementToBeClickable(integratedSvgSelector));
					integratedSvg.click();
					Thread.sleep(2000);
					 WebElement intvendor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[1]/div[1]/ng-select/div/div/div[2]/input")));
					 intvendor.sendKeys(vendorName);
					 intvendor.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 WebElement intplatformtype = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[1]/div[2]/ng-select/div/div/div[2]/input")));
					 String platformtype2 = row.getCell(26).getStringCellValue().trim();
					 intplatformtype.sendKeys(platformtype2);
					 intplatformtype.sendKeys(Keys.ENTER);
					 
					 Thread.sleep(2000);
					 WebElement intaccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[1]/div[3]/ng-select/div/div/div[2]/input")));
					 String account1 = row.getCell(27).getStringCellValue();
					 intaccount.sendKeys(account1);
					 intaccount.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 WebElement adaccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[1]/div[4]/ng-select/div/div/div[2]/input")));
					 String adaccount1 = row.getCell(28).getStringCellValue();
					 adaccount.sendKeys(adaccount1);
					 adaccount.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 WebElement billmonth2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[1]/div[5]/table/tr/td[1]/ng-select/div/div/div[3]/input")));
					 String billmonth1 = row.getCell(65).getStringCellValue();
					 billmonth2.clear();
					 billmonth2.sendKeys(billmonth1);
					 billmonth2.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 WebElement year1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[1]/div[5]/table/tr/td[2]/ng-select/div/div/div[3]/input")));
					 String billyear1 = row.getCell(66).getStringCellValue();
					 year1.clear();
					 year1.sendKeys(billyear1);
					 year1.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 
					 WebElement fetchBillIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src*='FeatchBill.svg']")));
					 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fetchBillIcon);
					 fetchBillIcon.click();
					 Thread.sleep(2000);
					 WebElement nextButton0009 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill-intergrated > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
					 nextButton0009.click();
					 Thread.sleep(2000);
					 
					 WebElement tax1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div/div[1]/div[4]/div[2]/ng-select/div/div/div[2]/input")));
					 String billtax1 = row.getCell(46).getStringCellValue();
					 tax1.clear();
					 tax1.sendKeys(billtax1);
					 tax1.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 WebElement nextButton0013 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill-intergrated > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
					  nextButton0013.click();
					  Thread.sleep(2000);
					  WebElement nextButton0015 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill-intergrated > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
					  nextButton0015.click();
					  Thread.sleep(2000);
					  WebElement nextButton0016 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill-intergrated > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
					  nextButton0016.click();
					  Thread.sleep(2000);
					  WebElement nextButton0014 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-log-bill-intergrated > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
					  nextButton0014.click();
					  Thread.sleep(2000);
			  
   }
    }

@And("User does reverse flow till it unlinks the integrated campaign for cbf")
public void user_Unlinks_integrated_campaign() throws IOException, InterruptedException {
	String excelFilePath = "DigitalproCBF.xlsx";  // Path to your Excel file
    FileInputStream file = new FileInputStream(new File(excelFilePath));
    try (Workbook workbook = new XSSFWorkbook(file)) {
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		Row row = sheet.getRow(1);
	 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    JavascriptExecutor js = (JavascriptExecutor) driver;
			
	Actions actions = new Actions(driver);
	for (int i = 0; i < 5; i++) {
	    actions.sendKeys(Keys.PAGE_UP).perform();
	}
	js.executeScript("window.scrollTo(0, 0)");
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")));
    Thread.sleep(2000);
    WebElement clientDocspage1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-d-dashboard/div/div[2]/div/div/div[3]")));
    js.executeScript("arguments[0].scrollIntoView(true);", clientDocspage1); // Scrolls to the element
	js.executeScript("arguments[0].focus();", clientDocspage1);
	js.executeScript("arguments[0].click();", clientDocspage1);
	Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bill-to-client\"]/table/tbody/tr/td[7]/span[1]/img"))).click();
	 Thread.sleep(2000);
//	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	 try {
	     // Step 1: Cancel current action
	     WebElement cancelIcon = wait.until(ExpectedConditions.elementToBeClickable(
	         By.cssSelector("img[src='./assets/img/svg/action-cancel.svg']")));
	     cancelIcon.click();

	     // Confirm dialog
	     WebElement confirmCancel = wait.until(ExpectedConditions.elementToBeClickable(
	         By.xpath("//*[@id='dialog-delete']/div[3]/div/div/span[2]")));
	     confirmCancel.click();

	     // Step 2: Click Vendor Docs section
	     WebElement vendordocsButton1 = wait.until(ExpectedConditions.elementToBeClickable(
	         By.cssSelector("body > app-root > div > div > div > main > div > app-d-dashboard > div > div:nth-child(2) > div > div > div:nth-child(4)")));
	     vendordocsButton1.click();

	     // Step 3: Loop to delete 2 vendor bills
	     for (int i = 0; i < 2; i++) {
	         try {
	             // Get current list of action icons
	             List<WebElement> actionIcons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	                 By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));

	             if (actionIcons.size() < 1) {
	                 System.out.println("No vendor bills found at iteration " + i);
	                 break;
	             }

	             int beforeCount = actionIcons.size();
	             WebElement targetIcon = actionIcons.get(beforeCount - 1);

	             // Scroll into view and click action icon
	             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetIcon);
	             wait.until(ExpectedConditions.elementToBeClickable(targetIcon)).click();

	             // Click delete icon
	             WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(
	                 By.cssSelector("img[src='./assets/img/svg/action-delete.svg']")));
	             deleteBtn.click();

	             // Click "Yes" in confirmation dialog
	             WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(
	                 By.xpath("//*[@id='dialog-delete']/div[3]/div/div/span[2]")));
	             yesBtn.click();

	             // Wait until number of action icons decreases
	             wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
	                 By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"), beforeCount));

	             System.out.println("Vendor bill deleted successfully at iteration " + (i + 1));

	         } catch (StaleElementReferenceException e) {
	             System.out.println("Stale element at iteration " + i + ", retrying...");
	             i--; // retry same iteration
	         } catch (Exception e) {
	             System.out.println("Unexpected error at iteration " + i + ": " + e.getMessage());
	             e.printStackTrace();
	             break; // optional: exit loop on critical failure
	         }
	     }

	     // Final cleanup: Wait for overlays to disappear
	     try {
	         wait.until(ExpectedConditions.invisibilityOfElementLocated(
	             By.cssSelector(".modal-backdrop, .overlay, .spinner, .cdk-overlay-backdrop")));
	     } catch (Exception e) {
	         System.out.println("No overlay, proceeding...");
	     }

	 } catch (Exception e) {
	     System.out.println("Critical failure in vendor bill deletion: " + e.getMessage());
	     e.printStackTrace();
	 }

	    // Optional short wait between deletions
	    Thread.sleep(2000);
	    WebElement campaignspage1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-d-dashboard/div/div[2]/div/div/div[2]")));
//		  campaignspage1.click();
		  js.executeScript("arguments[0].scrollIntoView(true);", campaignspage1); // Scrolls to the element
      	//js.executeScript("arguments[0].focus();", campaignspage1);
		  campaignspage1.click();
		  Thread.sleep(2000);
		  WebElement activationtab1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2-link\"]/span")));
		  js.executeScript("arguments[0].scrollIntoView(true);", activationtab1); // Scrolls to the element
	      	//js.executeScript("arguments[0].focus();", campaignspage1);
		  activationtab1.click();
		  Thread.sleep(2000);
		  WebElement integrationtab1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2\"]/div/app-activation/div[2]/div[2]")));
		  js.executeScript("arguments[0].scrollIntoView(true);", integrationtab1); // Scrolls to the element
	      	//js.executeScript("arguments[0].focus();", campaignspage1);
		  integrationtab1.click();
		  Thread.sleep(2000);
		  WebElement linktabb2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2\"]/div/app-activation/div[3]/div[2]")));
		  linktabb2.click();
		  
		  Thread.sleep(2000);
		  WebElement unlinktab1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2\"]/div/app-activation/div[3]/div[1]")));
		  unlinktab1.click();
		  Thread.sleep(2000);
		  
		  WebElement linktabb3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab2\"]/div/app-activation/div[3]/div[2]")));
		  linktabb3.click();
		  Thread.sleep(2000);
		  WebElement unlinkaction = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"activation\"]/div[1]/table/tbody/tr/td[1]/span")));
		  unlinkaction.click();
		  Thread.sleep(2000);
		  WebElement unlinkyes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-unlink\"]/div[3]/div/div/span[2]")));
		  unlinkyes.click();
		  Thread.sleep(2000);
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
//public void selectDayFromCalendar1(WebDriver driver, WebDriverWait wait, String day) {
public void forceClickDate(WebDriver driver, WebDriverWait wait, String day) {
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("mat-calendar")));

        // XPath to locate ANY day, even disabled
        String xpath = "//mat-calendar//td//button[span[normalize-space(text())='" + Integer.parseInt(day) + "']]";

        List<WebElement> dateButtons = driver.findElements(By.xpath(xpath));
        if (dateButtons.isEmpty()) {
            System.out.println("❌ Date '" + day + "' not found in current calendar view.");
            return;
        }

        WebElement dayButton = dateButtons.get(0);

        // Remove 'disabled' and 'aria-disabled' using JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled'); arguments[0].removeAttribute('aria-disabled');", dayButton);

        // Click using JS
        js.executeScript("arguments[0].click();", dayButton);
        System.out.println("✅ Forced click on date: " + day);

    } catch (Exception e) {
        System.err.println("❌ Error clicking date '" + day + "': " + e.getMessage());
    }
}




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


@Then("Close the chrom3e Browse3rr for cbf")
public void close_the_chrom3e_browse3r() {
    // Write code here that turns the phrase above into concrete actions
   
}





}