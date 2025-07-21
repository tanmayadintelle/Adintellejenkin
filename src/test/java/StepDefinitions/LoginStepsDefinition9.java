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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
//import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition9 {
	static WebDriver driver;
	
	@SuppressWarnings("deprecation")

@Given("User logs in and navigate to digital page to import data")
public void user_logs_in_and_navigate_to_digital_page() throws InterruptedException, IOException {
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
			    String downloadDir = "digitaloutputscbf\\" + timestamp;

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
			    
			    String excelFilePath = "DigitalproImportData.xlsx";  // Path to your Excel file
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
		        
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        wait.until(ExpectedConditions.invisibilityOfElementLocated(
		            By.className("cdk-overlay-backdrop")));

		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("appIframeAgency"));
		        WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
			    
				
			    //Client selection
			    
			   
		     
		        }
}
	 String extractedValue = "";
@When("User imports new data for digital")
public void user_createsnewjob_and_addsacampaign() throws InterruptedException, FileNotFoundException, IOException {
	String excelFilePath = "DigitalproImportData.xlsx";  // Path to your Excel file
    FileInputStream file = new FileInputStream(new File(excelFilePath));
    try (Workbook workbook = new XSSFWorkbook(file)) {
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		Row row = sheet.getRow(1);
	 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src, 'newjob.svg')]")));
//    JavascriptExecutor jszoom = (JavascriptExecutor) driver;
//    jszoom.executeScript("document.body.style.zoom='50%'");
    WebElement imgElement = driver.findElement(By.xpath("//img[contains(@src, 'newjob.svg')]"));
    imgElement.click();

 // Now you can find and click inside the iframe
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container-d\"]/div/div[1]")));
    WebElement digitalElement = driver.findElement(By.xpath("//*[@id=\"container-d\"]/div/div[1]"));
    digitalElement.click();
 // Scroll into view if needed
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-select\"]/div[3]/div/div/div[2]")));
    WebElement importfromexcel = driver.findElement(By.xpath("//*[@id=\"action-dialog-select\"]/div[3]/div/div/div[2]"));
    importfromexcel.click();
    //waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-estimate-import/div[2]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/i")));
//    WebElement clientnamedropdown = driver.findElement(By.xpath("/html/body/app-root/app-estimate-import/div[2]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/i"));
//    clientnamedropdown.click();
//    WebElement inputContainer = driver.findElement(By.cssSelector(".mat-form-field-infix"));
//    inputContainer.click();
    
    System.out.println("Select Client");   
    WebElement arrowDiv = wait.until(ExpectedConditions.elementToBeClickable(
    		
    	    By.cssSelector("div.selectdecorate.card-icon")));

    	// Scroll element into view
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrowDiv);

    	// Click using JavaScript if normal click sometimes fails
    	try {
    	    arrowDiv.click();
    	} catch (Exception e) {
    	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", arrowDiv);
    	}

    String clientname = row.getCell(2).getStringCellValue();
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-input-2\"]")));
    WebElement clientnamesearchoption = driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]"));
    clientnamesearchoption.sendKeys(clientname);
    
    waitload.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mat-radio-outer-circle")));
    List<WebElement> radios = driver.findElements(By.cssSelector("div.mat-radio-outer-circle"));
    WebElement firstRadio = radios.get(0);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstRadio);
    System.out.println("Select Brand");
 // Wait until at least one arrow button is clickable
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.selectdecorate.card-icon")));

    // Find all matching arrow buttons
    List<WebElement> arrowButtons = driver.findElements(By.cssSelector("div.selectdecorate.card-icon"));

    // Check if the next arrow button exists
    int nextIndex = 1;  // zero-based index: 0 is first, 1 is second
    if (arrowButtons.size() > nextIndex) {
        WebElement nextArrow = arrowButtons.get(nextIndex);
        
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextArrow);
        
        // Try normal click, fallback to JS click if needed
        try {
            nextArrow.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextArrow);
        }
    } else {
        System.out.println("Next arrow button not found");
    }

    String brandname = row.getCell(3).getStringCellValue();
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-input-3\"]")));
    WebElement brandnamesearchoption = driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]"));
    brandnamesearchoption.sendKeys(brandname);
    
    By radioSelector = By.cssSelector("div.mat-radio-outer-circle");
    waitload.until(ExpectedConditions.elementToBeClickable(radioSelector));
    WebElement firstRadio1 = driver.findElements(radioSelector).get(0);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstRadio1);

    System.out.println("Select Type");
    
    WebElement typeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("mat-select-1")));

 // Scroll into view and click the dropdown
 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typeDropdown);
 Thread.sleep(300); // slight delay if needed for animation

 try {
     typeDropdown.click(); // try normal click
 } catch (Exception e) {
     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", typeDropdown); // fallback
 }

 // Wait for dropdown options to be visible
 WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(
     By.xpath("//mat-option[1]"))); // or use: //mat-option[.='Create new Plan'] if exact text known
 firstOption.click();
   
 
 System.out.println("Change the jobname of default template and rename it to current date and time and upload the doc");
 
 String filePath = "New_Digital_Import_Sample_Pro.xlsx"; // Update this

 FileInputStream fis = new FileInputStream(filePath);
 Workbook workbook1 = new XSSFWorkbook(fis);
 Sheet sheet1 = workbook1.getSheetAt(0);

 Row row1 = sheet1.getRow(3); // B4 -> row 4 (index 3)
 if (row1 == null) {
     row1 = sheet1.createRow(3);
 }

 Cell cell = row1.getCell(1); // Column B -> index 1
 if (cell == null) {
     cell = row1.createCell(1);
 }

 String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
 cell.setCellValue("Sanity " + timestamp);

 fis.close();

 // Write changes to file
 FileOutputStream fos = new FileOutputStream(filePath);
 workbook1.write(fos);
 workbook1.close();
 fos.close();

 WebElement uploadInput = driver.findElement(By.cssSelector("input[type='file'][name='avatar']"));
 uploadInput.sendKeys(new File(filePath).getAbsolutePath());

 // Optional: Submit or check upload success
 // driver.findElement(By.id("uploadBtn")).click(); // if there's a submit button

 // Done
 System.out.println("File updated and uploaded successfully.");
 
 waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-estimate-import/div[2]/div/div/div[1]/div/div[2]/div[6]/div/span/button")));
 WebElement validatebutton = driver.findElement(By.xpath("/html/body/app-root/app-estimate-import/div[2]/div/div/div[1]/div/div[2]/div[6]/div/span/button"));
 validatebutton.click();
 
//Wait for and click the Save button
waitload.until(ExpectedConditions.elementToBeClickable(
  By.xpath("//*[@id=\"mat-dialog-2\"]/app-dig-confirm/div/div/div/div/div/div/div[2]/div[1]/div/div/button")));
WebElement savebutton = driver.findElement(By.xpath("//*[@id=\"mat-dialog-2\"]/app-dig-confirm/div/div/div/div/div/div/div[2]/div[1]/div/div/button"));
savebutton.click();
System.out.println("Clicked Save button");

//Add a short wait to let UI update before extracting job name
Thread.sleep(3000); // adjust if needed based on real UI speed

System.out.println("Saving job name");
waitload.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.breadcrumbs-active")));
WebElement spanElement = driver.findElement(By.cssSelector("span.breadcrumbs-active"));
String breadcrumbText = spanElement.getText().trim();
System.out.println("Full Extracted Text: " + breadcrumbText);

//Extract content within parentheses using regex
Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
Matcher matcher = pattern.matcher(breadcrumbText);
if (matcher.find()) {
  extractedValue = matcher.group(1); // this gets the content inside the first pair of parentheses
}

System.out.println("Extracted Value from Brackets: " + extractedValue);

//Wait before clicking home navigation
Thread.sleep(2000); // Optional pause before navigation
waitload.until(ExpectedConditions.elementToBeClickable(
  By.xpath("/html/body/app-root/div/div/div/main/div/app-d-dashboard/div/div[1]/div/div[1]/span[1]")));
WebElement homeNavigationButton = driver.findElement(
  By.xpath("/html/body/app-root/div/div/div/main/div/app-d-dashboard/div/div[1]/div/div[1]/span[1]"));
homeNavigationButton.click();
System.out.println("Navigated to Home");

//Add delay to allow dashboard to load
Thread.sleep(10000);

  Thread.sleep(10000);
    }
	
    }

@And("User merges data into existing data")
public void user_createsestimate_withoutputs() throws InterruptedException, FileNotFoundException, IOException {
	String excelFilePath = "DigitalproImportData.xlsx";  // Path to your Excel file
    FileInputStream file = new FileInputStream(new File(excelFilePath));
    try (Workbook workbook = new XSSFWorkbook(file)) {
		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		Row row = sheet.getRow(1);
	 WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src, 'newjob.svg')]")));
//    JavascriptExecutor jszoom = (JavascriptExecutor) driver;
//    jszoom.executeScript("document.body.style.zoom='50%'");
    WebElement imgElement1 = driver.findElement(By.xpath("//img[contains(@src, 'newjob.svg')]"));
    imgElement1.click();

 // Now you can find and click inside the iframe
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container-d\"]/div/div[1]")));
    WebElement digitalElement1 = driver.findElement(By.xpath("//*[@id=\"container-d\"]/div/div[1]"));
    digitalElement1.click();
 // Scroll into view if needed
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-select\"]/div[3]/div/div/div[2]")));
    WebElement importfromexcel1 = driver.findElement(By.xpath("//*[@id=\"action-dialog-select\"]/div[3]/div/div/div[2]"));
    importfromexcel1.click();
    Thread.sleep(2000);
    System.out.println("Select Client");

    WebElement arrowDivClient = wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("div.selectdecorate.card-icon")));

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrowDivClient);

    try {
        arrowDivClient.click();
    } catch (Exception e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", arrowDivClient);
    }

    String clientname = row.getCell(2).getStringCellValue();
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-input-2\"]")));
    WebElement clientnamesearchoption = driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]"));
    clientnamesearchoption.clear(); // Optional: clear existing text
    clientnamesearchoption.sendKeys(clientname);

    waitload.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mat-radio-outer-circle")));
    List<WebElement> clientRadios = driver.findElements(By.cssSelector("div.mat-radio-outer-circle"));
    WebElement clientFirstRadio = clientRadios.get(0);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clientFirstRadio);

    System.out.println("Select Brand");

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.selectdecorate.card-icon")));
    List<WebElement> arrowButtons = driver.findElements(By.cssSelector("div.selectdecorate.card-icon"));
    int brandIndex = 1; // index for Brand arrow
    if (arrowButtons.size() > brandIndex) {
        WebElement brandArrow = arrowButtons.get(brandIndex);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandArrow);
        try {
            brandArrow.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", brandArrow);
        }
    } else {
        System.out.println("Next arrow button not found");
    }

    String brandname = row.getCell(3).getStringCellValue();
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-input-3\"]")));
    WebElement brandnamesearchoption = driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]"));
    brandnamesearchoption.clear();
    brandnamesearchoption.sendKeys(brandname);

    By brandRadioSelector = By.cssSelector("div.mat-radio-outer-circle");
    waitload.until(ExpectedConditions.elementToBeClickable(brandRadioSelector));
    WebElement brandFirstRadio = driver.findElements(brandRadioSelector).get(0);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", brandFirstRadio);

    System.out.println("Select Type");

    WebElement typeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("mat-select-1")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typeDropdown);
    Thread.sleep(300);

    try {
        typeDropdown.click();
    } catch (Exception e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", typeDropdown);
    }

    WebElement secondOption = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//mat-option[2]"))); // Use text if dynamic order is risky
    secondOption.click();

    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.selectdecorate.card-icon")));
    List<WebElement> arrowButtons1 = driver.findElements(By.cssSelector("div.selectdecorate.card-icon"));

    int typeIndex = 2; // index for the third arrow (0 = first, 1 = second, 2 = third)

    if (arrowButtons1.size() > typeIndex) {
        WebElement typeArrow = arrowButtons1.get(typeIndex);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", typeArrow);
        try {
            typeArrow.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", typeArrow);
        }
    } else {
        System.out.println("Third arrow button not found");
    }
    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-input-5\"]")));
    WebElement plannamesearchoption = driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]"));
    plannamesearchoption.clear(); // Optional: clear existing text
    plannamesearchoption.sendKeys(extractedValue);
    Thread.sleep(10000);
    By brandRadioSelector1 = By.cssSelector("div.mat-radio-outer-circle");
    waitload.until(ExpectedConditions.elementToBeClickable(brandRadioSelector1));
    WebElement firstRadio1 = driver.findElements(brandRadioSelector1).get(0);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstRadio1);
    Thread.sleep(10000);
    String filePath = "New_Digital_Import_Sites_Sample_Template_import data.xlsx";
    WebElement uploadInput = driver.findElement(By.cssSelector("input[type='file'][name='avatar']"));
    uploadInput.sendKeys(new File(filePath).getAbsolutePath());
    Thread.sleep(10000);
    // Optional: Submit or check upload success
    // driver.findElement(By.id("uploadBtn")).click(); // if there's a submit button

    // Done
    
    
 // Wait and click the Validate button
 // Wait and click the Validate button
    waitload.until(ExpectedConditions.elementToBeClickable(
        By.xpath("/html/body/app-root/app-estimate-import/div[2]/div/div/div[1]/div/div[2]/div[6]/div/span/button")));
    WebElement validateButton = driver.findElement(
        By.xpath("/html/body/app-root/app-estimate-import/div[2]/div/div/div[1]/div/div[2]/div[6]/div/span/button"));
    Thread.sleep(10000);
    validateButton.click();
    System.out.println("Clicked Validate button");

    // Wait and click the Save button in confirmation dialog
    waitload.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//*[@id=\"mat-dialog-3\"]/app-dig-confirm/div/div/div/div/div/div/div[2]/div[1]/div/div/button/span")));
    Thread.sleep(10000);
    WebElement saveButton = driver.findElement(
        By.xpath("//*[@id=\"mat-dialog-3\"]/app-dig-confirm/div/div/div/div/div/div/div[2]/div[1]/div/div/button/span"));
    saveButton.click();
    System.out.println("Clicked Save button");
    Thread.sleep(10000);
    // ✅ Wait dynamically until breadcrumb contains expected text format like "(PLN/...)"
 // Major wait: Wait until breadcrumb contains expected pattern (e.g. contains "PLN/")
    System.out.println("Waiting for breadcrumb to be ready and contain 'PLN/'...");
    waitload.until(driver -> {
        try {
            WebElement breadcrumb = driver.findElement(By.cssSelector("span.breadcrumbs-active"));
            String text = breadcrumb.getText().trim();
            return text.contains("PLN/") || text.matches(".*\\(.*\\d{4}.*\\).*");
        } catch (Exception e) {
            return false;
        }
    });
    Thread.sleep(1000); // small buffer after major wait

    // Extract breadcrumb text
    WebElement spanElement = driver.findElement(By.cssSelector("span.breadcrumbs-active"));
    String breadcrumbText = spanElement.getText().trim();
    System.out.println("Full Extracted Text: " + breadcrumbText);

    // Wait for paginator label to appear
    WebElement paginatorLabel1 = waitload.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("div.mat-mdc-paginator-range-label")));
    Thread.sleep(1000); // ensure rendering is done
    String labelText = paginatorLabel1.getText().trim();
    System.out.println("Paginator Text: " + labelText);

    // Final pause before moving to next step
    Thread.sleep(3000);

    // Optional final wait before next steps
    Thread.sleep(3000);


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


@Then("Close the chrom3e Browse3rrr")
public void close_the_chrom3e_browse3r() {
    // Write code here that turns the phrase above into concrete actions
   driver.quit();
}





}