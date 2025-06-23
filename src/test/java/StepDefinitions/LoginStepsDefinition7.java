package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
import java.util.Locale;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition7 {
	static WebDriver driver;
	
	@SuppressWarnings("deprecation")

@Given("User logs in and navigate to digital page")
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
			    String downloadDir = "D:\\fd\\btladintelleautomation\\reports\\" + timestamp;

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
			    
			    String excelFilePath = "D:\\fd\\btladintelleautomation\\Digitalpro.xlsx";  // Path to your Excel file
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
		        
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        wait.until(ExpectedConditions.invisibilityOfElementLocated(
		            By.className("cdk-overlay-backdrop")));

		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("appIframeAgency"));
		        WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
			    
				waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src, 'newjob.svg')]")));
//			    JavascriptExecutor jszoom = (JavascriptExecutor) driver;
//		        jszoom.executeScript("document.body.style.zoom='50%'");
		        WebElement imgElement = driver.findElement(By.xpath("//img[contains(@src, 'newjob.svg')]"));
		        imgElement.click();

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

@When("User creates a new job and adds a campaign")
public void user_createsnewjob_and_addsacampaign() throws InterruptedException, FileNotFoundException, IOException {
	String excelFilePath = "D:\\fd\\btladintelleautomation\\Digitalpro.xlsx";  // Path to your Excel file
    FileInputStream file = new FileInputStream(new File(excelFilePath));
    try (Workbook workbook = new XSSFWorkbook(file)) {
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		Row row = sheet.getRow(1);
	 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    JavascriptExecutor js = (JavascriptExecutor) driver;
	 waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select-client\"]/div/div[1]/ng-select/div")));
	    WebElement selectClientDropdown = driver.findElement(By.xpath("//*[@id=\"select-client\"]/div/div[1]/ng-select/div"));
	    selectClientDropdown.click();
	    
	    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select-client\"]/div/div[1]/ng-select/div/div/div[2]/input")));
	    String Client = row.getCell(2).getStringCellValue();
	    WebElement ClientField = driver.findElement(By.xpath("//*[@id=\"select-client\"]/div/div[1]/ng-select/div/div/div[2]/input"));
	   
	    ClientField.clear();
	    
		ClientField.sendKeys(Client);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clientfirstOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ng-option")));
		clientfirstOption.click();
	
		waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select-client\"]/div/div[2]/ng-select/div")));
	    WebElement selectBrandDropdown = driver.findElement(By.xpath("//*[@id=\"select-client\"]/div/div[2]/ng-select/div"));
	    selectBrandDropdown.click();
	    
	    String Brand = row.getCell(3).getStringCellValue();
	    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select-client\"]/div/div[2]/ng-select/div/div/div[2]/input")));
	    WebElement BrandField = driver.findElement(By.xpath("//*[@id=\"select-client\"]/div/div[2]/ng-select/div/div/div[2]/input"));
	   
	    BrandField.clear();
	    
	    BrandField.sendKeys(Brand);
	   
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement brandfirstOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ng-option")));
		brandfirstOption.click();
		
		WebElement nextbutton01 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job-digi > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		nextbutton01.click();
		
		String JobName = row.getCell(4).getStringCellValue();
		waitload.until(ExpectedConditions.elementToBeClickable(By.name("JobName")));
	    WebElement JobNameField = driver.findElement(By.name("JobName"));
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
	        
  Thread.sleep(10000);
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


@Then("Close the chrom3e Browse3rr")
public void close_the_chrom3e_browse3r() {
    // Write code here that turns the phrase above into concrete actions
   driver.quit();
}





}