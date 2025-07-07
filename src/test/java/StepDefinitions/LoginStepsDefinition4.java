package StepDefinitions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
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

import com.google.common.io.Files;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition4 {
	static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("User completes BTL pro sanity flow")
	public void user_is_on_login_page() throws IOException, InterruptedException {

	    // Write code here that turns the phrase above into concrete actions
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--start-maximized");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");
		
		options.addArguments("--headless=new");  // use new headless mode
		options.addArguments("--window-size=1920,1080");  // set resolution
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
	    // Create a HashMap for preferences
	    HashMap<String, Object> prefs = new HashMap<>();    
	    // Block notifications by setting the preference value to 2 (block)
	    prefs.put("profile.default_content_setting_values.notifications", 2); 
	    // Add preferences to Chrome options
	    options.setExperimentalOption("prefs", prefs);
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String downloadDir = "D:\\fd\\btladintelleautomation\\BTLoutputs\\" + timestamp;

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
	    
	    String excelFilePath = "D:\\fd\\btladintelleautomation\\Book2.xlsx";  // Path to your Excel file
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			Row row = sheet.getRow(1); // Get the second row (0-indexed));
			WebDriverWait waitload2 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.name("username")));
			// Step 3: Find the form fields on the webpage and fill them with data from Excel
			
			WebElement usernameField = driver.findElement(By.name("username")); // Replace with actual ID
			
			usernameField.sendKeys("tanmay.nayak");
			 String Quantity = row.getCell(6).toString();
		    driver.findElement(By.name("acceptTerms")).click();
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identify_user_button_text_active\"]")));
		    driver.findElement(By.xpath("//*[@id=\"identify_user_button_text_active\"]")).click();
		    
		    WebDriverWait waitload1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
			   
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
//		    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span")).click();
		    
		    WebDriverWait waitload23 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
		    waitload23.until(ExpectedConditions.elementToBeClickable(By.className("show_collapse_icon")));
		    WebElement elementarrow = driver.findElement(By.className("show_collapse_icon"));
	        elementarrow.click();
	        
	        System.out.println("Logged in");
	        WebDriverWait waitid = new WebDriverWait(driver, Duration.ofSeconds(60));
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
	        WebElement iframe = waitid.until(ExpectedConditions.presenceOfElementLocated(By.id("appIframeAgency"))); 
	        Thread.sleep(2000);// Replace with your iframe ID
	        driver.switchTo().frame(iframe);
//		    driver.switchTo().frame("appIframeAgency"); 
	        System.out.println("Inside iframe");// Replace with the correct iframe ID
		    WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
		    
		  
//		    JavascriptExecutor jszoom = (JavascriptExecutor) driver;
//	        jszoom.executeScript("document.body.style.zoom='50%'");
		    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"planning\"]/div/table/thead/tr/th[1]")));
		    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/newjob.svg']")));
//		    JavascriptExecutor jsif = (JavascriptExecutor) driver;
//	        jsif.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", iframe);
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/newjob.svg']")).click();
		    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-new-job/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[1]/span/img")));
		    System.out.println("Inside New Job activity");
		    Thread.sleep(3000);
		    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-new-job/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[1]/span/img")));
		    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-new-job/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[1]/span/img")).click();
		    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div[1]/div/div/div[1]/ng-select/div/div/div[2]/input")));
		    Thread.sleep(3000);
		    String Client = row.getCell(17).toString();
		    WebElement ClientField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div[1]/div/div/div[1]/ng-select/div/div/div[2]/input"));
		   
		    ClientField.clear();
		    
			ClientField.sendKeys(Client);
		
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div/div/table/tr/td")));
			driver.findElement(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div/div/table/tr/td")).click();
			//ClientField.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			waitload.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div[2]/div/div/div[1]/ng-select/div/div/div[2]/input")));
			String Team = row.getCell(15).toString();
		    WebElement TeamField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div[2]/div/div/div[1]/ng-select/div/div/div[2]/input"));
			TeamField.clear();
			TeamField.sendKeys(Team);
			driver.findElement(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div/div/table/tr/td")).click();
				//ClientField.sendKeys(Keys.TAB);
			waitload.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div[2]/div/div/div[2]/ng-select/div/div/div[2]/input")));
			String Userlocation = row.getCell(16).toString();
			WebElement UserlocationField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div[2]/div/div/div[2]/ng-select/div/div/div[2]/input"));
			
			UserlocationField.clear();
			UserlocationField.sendKeys(Userlocation);
			driver.findElement(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div/div/table/tr/td")).click();
					//ClientField.sendKeys(Keys.TAB);
			waitload.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div[1]/div/div/div[2]/ng-select/div/div/div[2]/input")));
				
			String Brand = row.getCell(18).toString();
		    WebElement BrandField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div[1]/div/div/div[2]/ng-select/div/div/div[2]/input"));
		    
		    BrandField.clear();
			BrandField.sendKeys(Brand);
			driver.findElement(By.xpath("/html/body/ng-dropdown-panel/div/div[2]/div/div/table/tr/td")).click();
			BrandField.sendKeys(Keys.TAB);
			BrandField.sendKeys(Keys.ENTER);
			waitload.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[1]/input")));		
			String Jobname = row.getCell(19).toString();
		    WebElement jobnameField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[1]/input"));
		    
		    jobnameField.clear();
			jobnameField.sendKeys(Jobname);
			
			jobnameField.sendKeys(Keys.TAB);
			jobnameField.sendKeys(Keys.ENTER);
			waitload.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			
			
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[3]/div/div/mat-datepicker-toggle/button/span[3]")));		
			WebElement calendarButton111 = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[3]/div/div/mat-datepicker-toggle/button/span[3]"));
			calendarButton111.click();
		
			// Read the value "10" from the Excel sheet (ensure this is the exact value)
			String dateFromExcel11 = row.getCell(45).toString().trim();

			// Remove decimal point if any (e.g., convert "10.0" to "10")
			dateFromExcel11 = dateFromExcel11.split("\\.")[0];
			// Output for debugging: Make sure that the correct date value is being read
			System.out.println("Date to click: " + dateFromExcel11);
			
			// Ensure the calendar is visible and wait until the "10" element is clickable
			WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(100));
			WebElement dateElement119 = wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'" + dateFromExcel11 + "')]")));
			dateElement119.click();
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();			
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[1]/input")));								
			String targetearning = row.getCell(46).toString();
		    WebElement targetearningField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[1]/input"));
		    
		    targetearningField.clear();
		    targetearningField.sendKeys(targetearning);
		    targetearningField.sendKeys(Keys.TAB);
		    targetearningField.sendKeys(Keys.ENTER);
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[2]/input")));
			String targetmargin = row.getCell(47).toString();
		    WebElement targetmarginField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[2]/input"));
		    Thread.sleep(2000);
		    targetmarginField.clear();
		    targetmarginField.sendKeys(targetmargin);
		    targetmarginField.sendKeys(Keys.TAB);
			targetmarginField.sendKeys(Keys.ENTER);
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[3]/textarea")));
			String objective = row.getCell(48).toString();
		    WebElement objectiveField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[3]/textarea"));
		    objectiveField.clear();
		    objectiveField.sendKeys(objective);
		    objectiveField.sendKeys(Keys.TAB);
		    objectiveField.sendKeys(Keys.ENTER);
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			Thread.sleep(2000); 
		    WebElement calendarButton = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[2]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button/span[3]"));
			calendarButton.click();

			// Read the value "10" from the Excel sheet (ensure this is the exact value)
			String dateFromExcel = row.getCell(20).toString().trim();

			// Remove decimal point if any (e.g., convert "10.0" to "10")
			dateFromExcel = dateFromExcel.split("\\.")[0];
			// Output for debugging: Make sure that the correct date value is being read
			System.out.println("Date to click: " + dateFromExcel);
			Thread.sleep(2000);
			// Ensure the calendar is visible and wait until the "10" element is clickable
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + dateFromExcel + "')]")));
			
			dateElement.click();
					
			// Extract the date from Excel (ensure it's trimmed and without decimals)
			String dateFromExcel1 = row.getCell(21).toString().trim();

			// Remove any decimal point if present (e.g., convert "20.0" to "20")
			dateFromExcel1 = dateFromExcel1.split("\\.")[0].trim();

			// Debugging: Print the date to ensure it is correct
			System.out.println("Date to click: " + dateFromExcel1);

			// Construct XPath dynamically based on the date extracted from Excel
			String dynamicXPath = "//*[@id='mat-datepicker-0']/div/mat-month-view/table/tbody//span[contains(text(),'" + dateFromExcel1 + "')]";

			// Wait for the date element (matching the date extracted from Excel) to become clickable
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement dateElement1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));

			// Click the date element
			dateElement1.click();
			
			
			
			wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/add-attachment.svg']")));
			
			
			 WebElement createjobattach = driver.findElement(By.xpath("//img[@src='./assets/img/svg/add-attachment.svg']"));
			 createjobattach.click();
			 WebElement fileInput = driver.findElement(By.id("file"));

		       
		     String filePath = "C:\\Users\\Dipti\\Desktop\\automation file upload\\sig.png";  

		     fileInput.sendKeys(filePath);
		     
		     By elementXpath = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-add-attachment/form/div/div[5]/div/div/span[2]");

		     try {
		         // Wait until it's clickable
		         WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(elementXpath));
		         
		         
		         try {
		        	 try {
		        		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		        		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-global-overlay-wrapper")));
		        		} catch (Exception ignored) {
		        		    // If not present, ignore
		        		}
		        	 
		        	 wait.until(ExpectedConditions.elementToBeClickable(element));
		        	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		             element.click(); // Try normal click
		         } catch (ElementClickInterceptedException e) {
		             System.out.println("Normal click failed, trying JS click due to intercept...");
		             ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); // JS fallback
		         }
		     } catch (TimeoutException e) {
		         System.out.println("Element was not clickable even after waiting: " + elementXpath);
		         // Optional: take screenshot or throw error
		     }

		    Thread.sleep(5000);
			wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		     
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td.job-title-text")));
			wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td.job-title-text")));
			System.out.println("Modify created job");
			
			
			 WebElement jobTitleElement = driver.findElement(By.cssSelector("td.job-title-text"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", jobTitleElement);
		     String jobTitle = jobTitleElement.getText();
		     wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-dashboard/div/div[1]/div/div/span[1]")));
			 driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-dashboard/div/div[1]/div/div/span[1]")).click();
			
			
			String jobname = jobTitle; // Third column (Searchfield)
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-home/div/div[6]/app-jobs-component/div/div[1]/div/div[1]/input")));
			// Step 3: Find the form fields on the webpage and fill them with data from Excel
			WebElement searchField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-home/div/div[6]/app-jobs-component/div/div[1]/div/div[1]/input")); // Replace with actual ID
			
			searchField.sendKeys(jobname);
			Thread.sleep(2000); 
			WebElement actiondashboard = wait1.until(
				    ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action_icon.svg']"))
				);
				actiondashboard.click();
			 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/icon-edit.svg']")));
			 WebElement editjob = driver.findElement(By.xpath("//img[@src='./assets/img/svg/icon-edit.svg']"));
	         editjob.click();
	         
	         wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[1]/input"))); 
	     	String Jobnamee = row.getCell(49).toString();
		    WebElement jobnameFieldd = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[1]/input"));
		    
		    jobnameFieldd.clear();
			jobnameFieldd.sendKeys(Jobnamee);
			
			jobnameFieldd.sendKeys(Keys.TAB);
			jobnameFieldd.sendKeys(Keys.ENTER);
			
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[3]/div/div/mat-datepicker-toggle/button/span[3]"))); 
			WebElement calendarButton1111 = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[3]/div/div/mat-datepicker-toggle/button/span[3]"));
			calendarButton1111.click();
			
			// Read the value "10" from the Excel sheet (ensure this is the exact value)
			String dateFromExcel111 = row.getCell(52).toString().trim();

			// Remove decimal point if any (e.g., convert "10.0" to "10")
			dateFromExcel111 = dateFromExcel111.split("\\.")[0];
			// Output for debugging: Make sure that the correct date value is being read
			System.out.println("Date to click: " + dateFromExcel111);
			
			// Ensure the calendar is visible and wait until the "10" element is clickable
			WebDriverWait wait111 = new WebDriverWait(driver, Duration.ofSeconds(60));
			WebElement dateElement1199 = wait111.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'" + dateFromExcel11 + "')]")));
			dateElement1199.click();
			//driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[1]/input"))); 
			String targetearningg = row.getCell(53).toString();
		    WebElement targetearningFieldd = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[1]/input"));
		    targetearningFieldd.clear();
		    targetearningFieldd.sendKeys(targetearningg);
		    targetearningFieldd.sendKeys(Keys.TAB);
		    targetearningFieldd.sendKeys(Keys.ENTER);
		    //driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[2]/input"))); 
			String targetmarginn = row.getCell(54).toString();
		    WebElement targetmarginFieldd = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[2]/input"));
		    
		    targetmarginFieldd.clear();
		    targetmarginFieldd.sendKeys(targetmarginn);
		    targetmarginFieldd.sendKeys(Keys.TAB);
			targetmarginFieldd.sendKeys(Keys.ENTER);
			//driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[3]/textarea")));
			String objectivee = row.getCell(55).toString();
		    WebElement objectiveFieldd = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[3]/div[3]/textarea"));
		    
		    objectiveFieldd.clear();
		    objectiveFieldd.sendKeys(objectivee);
		    objectiveFieldd.sendKeys(Keys.TAB);
		    objectiveFieldd.sendKeys(Keys.ENTER);
		    //driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[2]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button/span[3]")));
		    WebElement calendarButtonn = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-create-job/div/div[5]/div/div/div/div[2]/div[2]/mat-form-field/div[1]/div[2]/div[2]/mat-datepicker-toggle/button/span[3]"));
			calendarButtonn.click();
			JavascriptExecutor jsk = (JavascriptExecutor) driver;
			jsk.executeScript("document.querySelector('.cdk-overlay-backdrop').style.display='none';");
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			
		String dateFromExcellp = row.getCell(50).toString().trim();
        dateFromExcellp = dateFromExcellp.split("\\.")[0];  // Clean up any decimals (e.g., "10.0" becomes "10")

        // Step 4: Output for debugging, check which date we are selecting
        System.out.println("Date to click (First): " + dateFromExcellp);

        // Step 5: Use JavaScript to select the date directly by XPath
        String dateXPath = "//mat-calendar//span[contains(text(), '" + dateFromExcellp + "')]";
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXPath)));
        WebElement dateElementr = driver.findElement(By.xpath(dateXPath));
        
        // Using JavaScript to click the date element
        jsk.executeScript("arguments[0].click();", dateElementr);
          // Sleep for 2 seconds after clicking

        // Step 6: Extract the second date from Excel (ensure it's trimmed and without decimals)
        String dateFromExcel2 = row.getCell(51).toString().trim();
        dateFromExcel2 = dateFromExcel2.split("\\.")[0].trim();

        // Step 7: Debugging: Print the second date to ensure it's correct
        System.out.println("Date to click (Second): " + dateFromExcel2);

        // Step 8: Use JavaScript to select the second date directly by XPath
        String dateXPath2 = "//mat-calendar//span[contains(text(), '" + dateFromExcel2 + "')]";
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXPath2)));
        WebElement dateElement2 = driver.findElement(By.xpath(dateXPath2));

        // Using JavaScript to click the second date element
        jsk.executeScript("arguments[0].click();", dateElement2);
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/add-attachment.svg']")));
			
			
			
			 WebElement createjobattachh = driver.findElement(By.xpath("//img[@src='./assets/img/svg/add-attachment.svg']"));
			 createjobattachh.click();
			 WebElement fileInputt = driver.findElement(By.id("file"));

		       
			// Path to the file you want to upload
			 String filePathh = "C:\\Users\\Dipti\\Desktop\\automation file upload\\sig.png";

			 // Upload the file
			 fileInputt.sendKeys(filePathh);

			 // Use a safer relative XPath for the upload/confirm button
			 By uploadButton = By.xpath("//app-add-attachment//span[contains(text(),'Upload')]");

			 try {
			     // Wait for the button to be clickable
			     WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(uploadButton));

			     // Scroll the element into view (important for headless mode)
			     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			     Thread.sleep(300);  // Allow layout to stabilize

			     try {
			         // Try normal click
			         element.click();
			     } catch (ElementClickInterceptedException e) {
			         // Fallback to JS click if normal click fails
			         System.out.println("Normal click failed, trying JavaScript click...");
			         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			     }

			 } catch (TimeoutException e) {
			     System.out.println("Upload button not clickable.");
			     // Optional: Take screenshot for debugging
			   
			 }

			 Thread.sleep(5000);  // Wait for the upload to complete (adjust if needed)

			System.out.println("Job modified, navigating to add new activites"); 
			Thread.sleep(4000);		
			wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
			
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-create-job > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			WebDriverWait waitload3 = new WebDriverWait(driver, Duration.ofSeconds(60));
		    waitload3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(2)")));
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(2)")).click();
		    Thread.sleep(2000);
		   
		    JavascriptExecutor jslo = (JavascriptExecutor) driver;
	        jslo.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	        try {
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
	        } catch (Exception ignored) {}
	        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/addactivity.svg']")));
	        try {
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
	        } catch (Exception ignored) {}
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/addactivity.svg']")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-autocomplete='list']")));
		    WebElement inputField = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		    Thread.sleep(2000);
		    inputField.click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    String activity = row.getCell(3).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[2]/input")));
		    WebElement activityField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[2]/input")); // Replace with actual ID
		    Thread.sleep(2000);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activityField);
			activityField.sendKeys(activity);
		    activityField.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    String remark = row.getCell(4).toString();
		    WebElement remarkField = driver.findElement(By.name("description"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", remarkField);
			remarkField.sendKeys(remark);
			remarkField.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();	
			
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
		    String HSN = row.getCell(5).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input")));
		    WebElement HSNField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HSNField);
			HSNField.sendKeys(HSN);
		    HSNField.sendKeys(Keys.ENTER);
		    String qtyValue = row.getCell(6).toString();

		    try {
		        // Step 1: Wait for overlays to disappear
		        try {
		            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		        } catch (Exception ignored) {}

		        // Step 2: Ensure the field exists in the DOM
		        WebElement qtyField = wait.until(
		            ExpectedConditions.presenceOfElementLocated(By.name("quantity")));

		        // Step 3: Scroll it into view
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", qtyField);
		        Thread.sleep(300);

		        // Optional highlight for debugging
		        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid blue'", qtyField);

		        // Step 4: Wait until it's clickable
		        wait.until(ExpectedConditions.elementToBeClickable(qtyField));

		        // Step 5: Interact with it
		        qtyField.clear();
		        qtyField.sendKeys(qtyValue);
		        qtyField.sendKeys(Keys.ENTER);

		        // Step 6: Click elsewhere to trigger blur/save
		        driver.findElement(By.xpath("//*[@id='action-dialog-delete']/div")).click();

		    } catch (TimeoutException te) {
		        System.out.println("❌ Quantity field not clickable");
		       
		    }
			Thread.sleep(6000);
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			String Rate = row.getCell(7).toString();//*[@id="action-dialog-delete"]/div/table/tr/td[8]/input
			System.out.println("Rate is"+Rate);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='action-dialog-delete']/div/table/tr/td[8]/input")));
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='action-dialog-delete']/div/table/tr/td[8]/input")));
		    WebElement RateField = driver.findElement(By.xpath("//*[@id='action-dialog-delete']/div/table/tr/td[8]/input"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RateField);

		    RateField.clear();
			RateField.sendKeys(Rate);
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
//		    RateField.sendKeys(Keys.ENTER);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		    
		    System.out.println("Added activity");
		    Thread.sleep(8000);
		 
	        

	        // Get all elements with the activeAction class
	        List<WebElement> editButtons = driver.findElements(By.xpath("//table/tbody//img[contains(@src, 'edit.svg')]"));
	        
	        

	     // Check if the list is not empty and click on the last "Edit" button
	     if (!editButtons.isEmpty()) {
	         WebElement lastEditButton = editButtons.get(editButtons.size() - 1);

	         // Scroll the last "Edit" button into view
	         
	         js.executeScript("arguments[0].scrollIntoView(true);", lastEditButton);
	         
	         // Ensure the element is clickable
	         WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(60));
	         try {
	             wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	             wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
	         } catch (Exception ignored) {}
	         wait12.until(ExpectedConditions.elementToBeClickable(lastEditButton));

	         // Click the last "Edit" button
	         lastEditButton.click();
	         System.out.println("Clicked on the last 'Edit' button.");
	     } else {
	         System.out.println("No 'Edit' buttons found.");
	     }
		    
		    
	     
	     
	     
	     	Thread.sleep(2000);
		    String activity1 = row.getCell(22).toString();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[3]/input")));
		    WebElement activityField1 = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[3]/input")); // Replace with actual ID
			activityField1.clear();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activity1);
			activityField1.sendKeys(activity1);
		    activityField1.sendKeys(Keys.ENTER);
		    activityField1.sendKeys(Keys.TAB);
		    //driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    Thread.sleep(2000);
		    String remark1mod = row.getCell(23).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
		    WebElement remarkField1mod = driver.findElement(By.name("description"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", remarkField1mod);
		    remarkField1mod.clear();
			remarkField1mod.sendKeys(remark1mod);
			remarkField1mod.sendKeys(Keys.TAB);
			
			//driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();

			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			//wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[3]/input"))).click();
		    String HSNmod = row.getCell(24).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input")));
		    WebElement HSNFieldmod = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HSNFieldmod);
		    HSNFieldmod.clear();		    
			HSNFieldmod.sendKeys(HSNmod);
		    HSNFieldmod.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		    String Quantity1mod = row.getCell(25).toString();	    
		    WebElement QuantityFieldmod = driver.findElement(By.name("quantity"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QuantityFieldmod);
		    QuantityFieldmod.clear();
			QuantityFieldmod.sendKeys(Quantity1mod);
		    QuantityFieldmod.sendKeys(Keys.ENTER);
		    QuantityFieldmod.sendKeys(Keys.TAB);
		    //driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		  
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
			String Ratemod = row.getCell(26).toString();
		    WebElement RateFieldmod = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[8]/input"));
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[8]/input")));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Ratemod);

		    RateFieldmod.clear();

		    RateFieldmod.clear();
			RateFieldmod.sendKeys(Ratemod);
		    RateFieldmod.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		    
		    
		    

		    
		    System.out.println("Activty modified");
		    Thread.sleep(4000);
		    WebDriverWait waitload5 = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    waitload5.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/add-cost.svg']")));
		    JavascriptExecutor jsl = (JavascriptExecutor) driver;
	        WebElement element = driver.findElement(By.xpath("//img[@src='./assets/img/svg/add-cost.svg']"));

	        // Scroll to the element
	        jsl.executeScript("arguments[0].scrollIntoView(true);", element);

	        // Click the element
	        element.click();
	        
//		    driver.findElement(By.xpath("//*[@id=\"newActivitydiv\"]/div[2]/span/img")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    String subactivity = row.getCell(8).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[2]/ng-select/div/div/div[2]/input")));
		    WebElement subactivityField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[2]/ng-select/div/div/div[2]/input"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subactivityField);// Replace with actual ID
			subactivityField.sendKeys(subactivity);
		    subactivityField.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[4]/ng-select/div/div/div[2]/input")));
		    String vendor = row.getCell(9).toString();
		    WebElement vendorfield = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[4]/ng-select/div/div/div[2]/input")); // Replace with actual ID
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vendorfield);
			vendorfield.sendKeys(vendor);
		    vendorfield.sendKeys(Keys.ENTER);
		    
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    String remark1 = row.getCell(10).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
		    WebElement remarkField1 = driver.findElement(By.name("description"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", remarkField1);
			remarkField1.sendKeys(remark1);
			remarkField1.sendKeys(Keys.TAB);
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[11]/span[2]")));
			driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[11]/span[2]")).click();
			Thread.sleep(2000);
		    String HSN1 = row.getCell(11).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[7]/ng-select/div/div/div[3]/input")));
		    WebElement HSNField1 = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[7]/ng-select/div/div/div[3]/input"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HSNField1);
			HSNField1.sendKeys(HSN1);
		    HSNField1.sendKeys(Keys.ENTER);//*[@id=\"action-dialog-delete\"]/div/table/tr/td[7]/ng-select/div/div/div[3]/input
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		    String Quantity11 = row.getCell(12).toString();
		    WebElement QuantityField1 = driver.findElement(By.name("quantity"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QuantityField1);
			QuantityField1.sendKeys(Quantity11);
		    QuantityField1.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("Rate")));
			String Rate1 = row.getCell(13).toString();
		    WebElement RateField1 = driver.findElement(By.name("Rate"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RateField1);
		    RateField1.clear();
			RateField1.sendKeys(Rate1);
		    RateField1.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[11]/span[2]")));
		    
		    
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[11]/span[2]")).click();
		    Thread.sleep(2000);
		    JavascriptExecutor jso = (JavascriptExecutor) driver;
	        jso.executeScript("window.scrollBy(0, -1000)");
			Thread.sleep(2000);
			System.out.println("Added sub-activity");
			
			Thread.sleep(5000);
			List<WebElement> modifyButtons = driver.findElements(By.xpath("//*[@id='outer-agency']/div/table/tbody/tr/td[7]/span/span[1]/img"));

			// Check if the list is not empty and click on the last "Modify" button
			if (!modifyButtons.isEmpty()) {
			    // Get the last "Modify" button from the list
			    WebElement lastModifyButton = modifyButtons.get(modifyButtons.size() - 1);

			    // Scroll the last "Modify" button into view
			    
			    js.executeScript("arguments[0].scrollIntoView(true);", lastModifyButton);

			    // Ensure the element is clickable
			    WebDriverWait wait05 = new WebDriverWait(driver, Duration.ofSeconds(60));
			    try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			    wait05.until(ExpectedConditions.elementToBeClickable(lastModifyButton));

			    // Click the last "Modify" button
			    lastModifyButton.click();
			    System.out.println("Clicked on the last 'Modify' button.");
			} else {
			    System.out.println("No 'Modify' buttons found.");
			}
			  Thread.sleep(2000);
			  
			  
			  
			  //MOdify subactivity starts here
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(2) > ng-select > div > div > div.ng-input > input[type=text]")));
			  String subactivitymod = row.getCell(27).toString();
			  WebElement subactivityFieldmod = driver.findElement(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(2) > ng-select > div > div > div.ng-input > input[type=text]"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subactivitymod);
			  subactivityFieldmod.sendKeys(subactivitymod);
			  subactivityFieldmod.clear();
			  subactivityFieldmod.sendKeys(Keys.ENTER);
			  Thread.sleep(2000);
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(4) > ng-select > div > div > div.ng-input > input[type=text]")));
			  String vendormod = row.getCell(28).toString();
			  WebElement vendorfieldmod = driver.findElement(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(4) > ng-select > div > div > div.ng-input > input[type=text]"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vendorfieldmod);
			  vendorfieldmod.clear();
			  vendorfieldmod.sendKeys(vendormod);
			  vendorfieldmod.sendKeys(Keys.ENTER);
			  Thread.sleep(2000);
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
			  String remark1mods = row.getCell(29).toString();
			  WebElement remarkField1mods = driver.findElement(By.name("description"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", remarkField1mods);
			  remarkField1mods.clear();
			  remarkField1mods.sendKeys(remark1mods);
			  remarkField1mods.sendKeys(Keys.TAB);
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(7) > ng-select > div > div > div.ng-input > input[type=text]")));
			  String HSN1mods = row.getCell(30).toString();
			  WebElement HSNField1mods = driver.findElement(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(7) > ng-select > div > div > div.ng-input > input[type=text]"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HSNField1mods);
			  HSNField1mods.clear();
			  HSNField1mods.sendKeys(HSN1mods);
			  HSNField1mods.sendKeys(Keys.ENTER);
			  Thread.sleep(2000);
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
			  String Quantity11mods = row.getCell(31).toString();
			  WebElement QuantityField1mods = driver.findElement(By.name("quantity"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QuantityField1mods);
			  QuantityField1mods.clear();
			  Thread.sleep(2000);		 
			  QuantityField1mods.sendKeys(Quantity11mods);
			  QuantityField1mods.sendKeys(Keys.ENTER);
			  Thread.sleep(2000);
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("Rate")));
			  String Rate1mods = row.getCell(32).toString();
			  WebElement RateField1mods = driver.findElement(By.name("Rate"));
			  Thread.sleep(2000);
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RateField1mods);
			  RateField1mods.clear();
			  RateField1mods.sendKeys(Rate1mods);
			  RateField1mods.sendKeys(Keys.ENTER);
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(11) > span.submit-button.ng-star-inserted")));
			  driver.findElement(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(11) > span.submit-button.ng-star-inserted")).click();
			  Thread.sleep(2000);

			  JavascriptExecutor jsol = (JavascriptExecutor) driver;
			  jsol.executeScript("window.scrollBy(0, -1000)");
			  Thread.sleep(2000);

			  System.out.println("Modified sub-activity");
	
			    System.out.println("Activities and sub-activities added and modified");
			
			
			
			    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(3)")));
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(3)")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-create-estimate.svg']")).click();
		    
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[1]/div/mat-sidenav-content/div/div/table/thead/tr/th[1]/input")).click();
		    
		

		   
		    
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[1]/div/mat-sidenav-content/div/div/table/thead/tr/th[1]/input")).click();
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		    WebDriverWait waitload61 = new WebDriverWait(driver, Duration.ofSeconds(60));	
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    waitload61.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/AdditionalLineItems.svg']")));
		    WebElement imageadl = driver.findElement(By.cssSelector("img[src='./assets/img/svg/AdditionalLineItems.svg']"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imageadl);
		    imageadl.click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		      Thread.sleep(2000);
		      wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[3]/div/table/tr/td[2]/ng-select/div/div/div[2]/input")));
		      String itemtype = row.getCell(33).toString();
			  WebElement itemtypes = driver.findElement(By.xpath("//*[@id=\"selection1\"]/div[3]/div/table/tr/td[2]/ng-select/div/div/div[2]/input"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", itemtypes);
			  itemtypes.sendKeys(Keys.ENTER);
			  itemtypes.sendKeys(itemtype);
			  itemtypes.sendKeys(Keys.ENTER);
			  itemtypes.sendKeys(Keys.ENTER);
			  
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("adddescription")));
			  String description = row.getCell(34).toString();
			  WebElement descriptions = driver.findElement(By.name("adddescription"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptions);
			  descriptions.clear();
			  descriptions.sendKeys(description);
			  descriptions.sendKeys(Keys.ENTER);
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("lineitemAmount")));
			  String amount = row.getCell(35).toString();
			  WebElement amounts = driver.findElement(By.name("lineitemAmount"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", amounts);
			  
			  amounts.sendKeys(amount);
			  amounts.sendKeys(Keys.ENTER);
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selection1 > div.row.ng-star-inserted > div > table > tr > td:nth-child(8) > span")));
			  driver.findElement(By.cssSelector("#selection1 > div.row.ng-star-inserted > div > table > tr > td:nth-child(8) > span")).click();
			  Thread.sleep(5000); 
			  
			  System.out.println("Added additional line item");
		  JavascriptExecutor jszoomi = (JavascriptExecutor) driver;
		     jszoomi.executeScript("document.body.style.zoom='75%'");
			     Thread.sleep(1000);
			     try {
			         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			     } catch (Exception ignored) {}
			     WebElement activityfromestimate = driver.findElement(By.xpath("//img[@src='./assets/img/svg/addactivity.svg']"));
			  activityfromestimate.click();
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
		    
		    //Addactivityinsideest
			  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/ng-select/div/div/div[2]/input")));
		    String activityinest = row.getCell(36).toString();
		   
		    WebElement activityFieldinest = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			
		    Thread.sleep(2000);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", activityFieldinest);
			activityFieldinest.sendKeys(activityinest);
		    activityFieldinest.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div:nth-child(3) > div > div > span")));
		    driver.findElement(By.cssSelector("#action-dialog-delete > div:nth-child(3) > div > div > span")).click();
			
			
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[2]/div/div[1]/div[3]/div[1]/div/ng-select/div/div/div[2]/input")));
		    String HSNinest = row.getCell(38).toString();
		    WebElement HSNFieldinest = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[2]/div/div[1]/div[3]/div[1]/div/ng-select/div/div/div[2]/input"));    
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HSNFieldinest);
		    HSNFieldinest.sendKeys(HSNinest);
		    HSNFieldinest.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("Rate")));
			String Rateinest = row.getCell(40).toString();
		    WebElement RateFieldinest = driver.findElement(By.name("Rate"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RateFieldinest);
		    RateFieldinest.clear();
			RateFieldinest.sendKeys(Rateinest);
		    RateFieldinest.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		    String Quantity1inest = row.getCell(39).toString();
		    WebElement QuantityFieldinest = driver.findElement(By.name("quantity"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QuantityFieldinest);
			QuantityFieldinest.sendKeys(Quantity1inest);
		    QuantityFieldinest.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("description")));
		    String remarkinest = row.getCell(37).toString();
		    WebElement remarkFieldinest = driver.findElement(By.name("description"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", remarkFieldinest);
		    remarkFieldinest.clear();
			remarkFieldinest.sendKeys(remarkinest);
			
			driver.findElement(By.cssSelector("#action-dialog-delete > div:nth-child(3) > div > div > span")).click();
			
			Thread.sleep(2000);
			 
		 
			 		    
		    System.out.println("Added activity inside estimate");
		    
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
			driver.findElement(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
			//driver.findElement(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
			driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]")));
			WebElement calendarButton1 = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]"));
			calendarButton1.click();
			
			// Read the value "10" from the Excel sheet (ensure this is the exact value)
			String dateFromExcel110 = row.getCell(41).toString().trim();

			// Remove decimal point if any (e.g., convert "10.0" to "10")
			dateFromExcel110 = dateFromExcel110.split("\\.")[0];
			// Output for debugging: Make sure that the correct date value is being read
			System.out.println("Date to click: " + dateFromExcel110);
			Thread.sleep(2000);
			// Ensure the calendar is visible and wait until the "10" element is clickable
			WebDriverWait wait112 = new WebDriverWait(driver, Duration.ofSeconds(60));
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			WebElement dateElement110 = wait112.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'" + dateFromExcel110 + "')]")));
			
			dateElement110.click();
			
			
			
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			String docname = row.getCell(42).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[4]/div/input")));
		    WebElement docnames = driver.findElement(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[4]/div/input"));
		    
		    docnames.clear();
			docnames.sendKeys(docname);
		    docnames.sendKeys(Keys.ENTER);
		    
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
			String header = row.getCell(43).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[5]/div/textarea")));
		    WebElement headers = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[5]/div/textarea"));
		    
		    headers.clear();
			headers.sendKeys(header);
		    headers.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
			String footer = row.getCell(44).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[6]/div/textarea")));
		    WebElement footers = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[6]/div/textarea"));
		    footers.clear();
			footers.sendKeys(footer);
		    footers.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    
		    WebDriverWait waitloadeditestimateaction = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    waitloadeditestimateaction.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
		    Thread.sleep(2000);
		    WebDriverWait waitloadeditestimate = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    waitloadeditestimate.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg//modify-icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg//modify-icon.svg']")).click();
		    Thread.sleep(2000);
		    
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {} 
		    String remarkmodestimate = row.getCell(56).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("Description")));
		    WebElement remarkFieldmodestimate = driver.findElement(By.name("Description"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", remarkFieldmodestimate);
		    remarkFieldmodestimate.clear();
			remarkFieldmodestimate.sendKeys(remarkmodestimate);
			remarkFieldmodestimate.sendKeys(Keys.TAB);
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
		    String HSNmodestimate = row.getCell(57).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"planning\"]/div/table/tbody/tr[1]/td[6]/ng-select/div/div/div[3]/input")));
		    WebElement HSNFieldmodestimate = driver.findElement(By.xpath("//*[@id=\"planning\"]/div/table/tbody/tr[1]/td[6]/ng-select/div/div/div[3]/input"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HSNFieldmodestimate);
		    HSNFieldmodestimate.clear();
			HSNFieldmodestimate.sendKeys(HSNmodestimate);
		    HSNFieldmodestimate.sendKeys(Keys.ENTER);
		   
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    String Quantity1modestimate = row.getCell(58).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("qty")));
		    WebElement QuantityFieldmodestimate = driver.findElement(By.name("qty"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QuantityFieldmodestimate);
		    QuantityFieldmodestimate.clear();
			QuantityFieldmodestimate.sendKeys(Quantity1modestimate);
		    QuantityFieldmodestimate.sendKeys(Keys.ENTER);
		    //driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			Thread.sleep(2000);
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			String Ratemodestimate = row.getCell(59).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.name("rate")));
		    WebElement RateFieldmodestimate = driver.findElement(By.name("rate"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RateFieldmodestimate);
		    Thread.sleep(2000);
		    RateFieldmodestimate.clear();
			RateFieldmodestimate.sendKeys(Ratemodestimate);
		    RateFieldmodestimate.sendKeys(Keys.ENTER);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='client-estimate']/table/tbody/tr/td[4]/span[1]")));
		    WebElement elementToClick = driver.findElement(By.xpath("//*[@id='client-estimate']/table/tbody/tr/td[4]/span[1]"));
		    elementToClick.click();
		    
		   
			  
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
			  String descriptionsmodest = row.getCell(61).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("adddescription")));
			  WebElement descriptionsmodestimate = driver.findElement(By.name("adddescription"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptionsmodestimate);
			  descriptionsmodestimate.clear();
			  descriptionsmodestimate.sendKeys(descriptionsmodest);
			  descriptionsmodestimate.sendKeys(Keys.ENTER);
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  String amountmodestimate = row.getCell(62).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("lineitemAmount")));
			  WebElement amountsmodestimate = driver.findElement(By.name("lineitemAmount"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", amountsmodestimate);
			  amountsmodestimate.clear();
			  amountsmodestimate.sendKeys(amountmodestimate);
			  amountsmodestimate.sendKeys(Keys.ENTER); 
			  
			  
			 
			  WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  WebElement elementToClick12 = wait12.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selection1 > div:nth-child(3) > div > table > tr > td:nth-child(8) > span")));
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  // Click on the element
			  elementToClick12.click();
			  WebElement elementToClick13 = wait12.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));

			  // Click on the element
			  elementToClick13.click();
			  try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]")));
			  WebElement calendarButton11 = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calendarButton11);
			  calendarButton11.click();
				
				// Read the value "10" from the Excel sheet (ensure this is the exact value)
				String dateFromExcel1110 = row.getCell(63).toString().trim();

				// Remove decimal point if any (e.g., convert "10.0" to "10")
				dateFromExcel1110 = dateFromExcel1110.split("\\.")[0];
				// Output for debugging: Make sure that the correct date value is being read
				System.out.println("Date to click: " + dateFromExcel1110);
				Thread.sleep(2000);
				// Ensure the calendar is visible and wait until the "10" element is clickable
				WebDriverWait wait1112 = new WebDriverWait(driver, Duration.ofSeconds(60));
				 try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				WebElement dateElement1210 = wait1112.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'" + dateFromExcel1110 + "')]")));
				
				dateElement1210.click();
				
				
				
				String docnamee = row.getCell(64).toString();
				 try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[4]/div/input")));
			    WebElement docnamees = driver.findElement(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[4]/div/input"));
			    docnamees.clear();
				docnamees.sendKeys(docnamee);
			    docnamees.sendKeys(Keys.ENTER);
			    
				
				String headerr = row.getCell(65).toString();
				 try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[5]/div/textarea")));
			    WebElement headerrs = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[5]/div/textarea"));
			    
			    headerrs.clear();
				headerrs.sendKeys(headerr);
			    headerrs.sendKeys(Keys.ENTER);
			    
			    try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
				String footerr = row.getCell(66).toString();
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[6]/div/textarea")));
			    WebElement footerrs = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[6]/div/textarea"));
			    footerrs.clear();
				footerrs.sendKeys(footerr);
			    footerrs.sendKeys(Keys.ENTER);
			    try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
				    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
				    try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
				    try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
				    try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
				    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
				    
				    WebDriverWait waitloadeditestimateactionn = new WebDriverWait(driver, Duration.ofSeconds(60));			   
				    try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				    waitloadeditestimateactionn.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
				    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
				    try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/recordPO.svg']")));
			  
				    
				    WebElement recordPO = driver.findElement(By.xpath("//img[@src='./assets/img/svg/recordPO.svg']"));

				 // Click on the image element
				    recordPO.click();
				    Thread.sleep(2000);
					String contractno = row.getCell(67).toString();
					 try {
					        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
					        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
					    } catch (Exception ignored) {}
					wait1.until(ExpectedConditions.elementToBeClickable(By.name("ContractNo")));
				    WebElement contractnumber = driver.findElement(By.name("ContractNo"));
				    
				   
				    contractnumber.clear();
				    contractnumber.sendKeys(contractno);
				    contractnumber.sendKeys(Keys.ENTER);
				    
				    try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
					String PONumber = row.getCell(68).toString();
					wait1.until(ExpectedConditions.elementToBeClickable(By.name("PONumber")));
				    WebElement PONumbers = driver.findElement(By.name("PONumber"));
				    
				    PONumbers.clear();
				    PONumbers.sendKeys(PONumber);
				    PONumbers.sendKeys(Keys.ENTER);
				    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-record-po-details/div/div[3]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]")));
		    
					 WebElement calendarButton111101 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-record-po-details/div/div[3]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]"));
						calendarButton111101.click();
						
						jsk.executeScript("document.querySelector('.cdk-overlay-backdrop').style.display='none';");
						
						// Read the value "10" from the Excel sheet (ensure this is the exact value)
						String dateFromExcel111001 = row.getCell(69).toString().trim();
						
						// Remove decimal point if any (e.g., convert "10.0" to "10")
						dateFromExcel111001 = dateFromExcel111001.split("\\.")[0];
						// Output for debugging: Make sure that the correct date value is being read
						System.out.println("Date to click: " + dateFromExcel111001);
						Thread.sleep(2000);
						// Ensure the calendar is visible and wait until the "10" element is clickable
						WebDriverWait wait11122 = new WebDriverWait(driver, Duration.ofSeconds(60));
						 try {
						        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
						        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
						    } catch (Exception ignored) {}
						WebElement dateElement121001 = wait11122.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'" + dateFromExcel111001 + "')]")));
						
						dateElement121001.click();
						Thread.sleep(2000);		
						 try {
						        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
						        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
						    } catch (Exception ignored) {}
						String POAmount = row.getCell(70).toString();
						wait1.until(ExpectedConditions.elementToBeClickable(By.name("POAmount")));
					    WebElement POAmounts = driver.findElement(By.name("POAmount"));
					   
					    POAmounts.clear();
					    POAmounts.sendKeys(POAmount);
					    POAmounts.sendKeys(Keys.ENTER);
					    
					
						// Locate the span element by its class name and text content
						WebElement submitButton = driver.findElement(By.xpath("//span[@class='app-submit-button' and contains(text(),'save')]"));

						// Click the submit button
						submitButton.click();

						 Thread.sleep(2000);
						 System.out.println("Estimate Created and Reocorded PO amount");		  
					
		    WebDriverWait waitloadeditestimateactionnn = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    waitloadeditestimateactionnn.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action-approve.svg']")));
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/action-approve.svg']")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[4]/div/div/span[1]")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[4]/div/div/span[1]")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div:nth-child(5) > div > div > span.approveSubmit")));
		    driver.findElement(By.cssSelector("#action-dialog-delete > div:nth-child(5) > div > div > span.approveSubmit")).click();
		   
		    System.out.println("Estimate approved");
		    Thread.sleep(2000);
		    
//		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[contains(@src, 'view-icon.svg')])[last()]"))).click();
//		    
//		    
//		    WebElement iframedoc = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("iframe-doc-viewer")));
//
//		    // Scroll the iframe into view (this simulates user scrolling to view the PDF)
//		    
//		    wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframe-doc-viewer")));
//		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", iframedoc);
//		    Thread.sleep(2000); // Scroll down by 500px
//		    
//		    wait1.until(ExpectedConditions.elementToBeClickable(By.id("open-button"))).click();
//		    WebElement closeImageElement = driver.findElement(By.xpath("//img[@src='./assets/img/svg/close-cross.svg']"));
//
//			 // Click the image element
//			    closeImageElement.click();
		    
		    WebDriverWait waitloadeditestimateactionnnn = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    waitloadeditestimateactionnnn.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
		    Thread.sleep(2000);
		 // Locate the image element by its src attribute
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action-appdetails.svg']")));
		    WebElement approvaldetails = driver.findElement(By.xpath("//img[@src='./assets/img/svg/action-appdetails.svg']"));

		    // Click the image element
		    approvaldetails.click();
		    Thread.sleep(2000);		    
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/close-cross.svg']")));
		    WebElement closeImageElement1 = driver.findElement(By.xpath("//img[@src='./assets/img/svg/close-cross.svg']"));

		 // Click the image element
		    closeImageElement1.click();
		    Thread.sleep(2000);
		    
		    
//		    WebDriverWait shareviaemailaction = new WebDriverWait(driver, Duration.ofSeconds(60));			   
//		    shareviaemailaction.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
//		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
//		    Thread.sleep(2000);
//		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src, 'action-share-email.svg')]")));
//		    WebElement shareEmailIcon = driver.findElement(By.xpath("//img[contains(@src, 'action-share-email.svg')]"));
//		    shareEmailIcon.click();
//		   Thread.sleep(2000);
//		   WebElement shareButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Share' and contains(@class, 'submit-button')]")));
//		   shareButton.click();
		   //Thread.sleep(10000);
//		   String originalWindow = driver.getWindowHandle();
//		   WebDriverWait printaction = new WebDriverWait(driver, Duration.ofSeconds(60));			   
//		   printaction.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
//		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
//		    Thread.sleep(2000);
//		    
//		    
//		 // Step 1: Click on Print icon
//		    WebDriverWait printaction1 = new WebDriverWait(driver, Duration.ofSeconds(60));			   
//		    printaction1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']")));
//		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action-print.svg']")).click();
//		    Thread.sleep(2000);
//
//		    // Step 2: Click on 'Print' button in modal/dialog
//		    WebDriverWait waitop = new WebDriverWait(driver, Duration.ofSeconds(60));
//		    WebElement printButton = waitop.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']")));
//		    printButton.click();
//		    Thread.sleep(3000); // wait for print window to open
//
//		    // Step 3: Switch to new window
//		    
//		    Set<String> allWindows = driver.getWindowHandles();
//
//		    for (String windowHandle : allWindows) {
//		        if (!windowHandle.equals(originalWindow)) {
//		            driver.switchTo().window(windowHandle);
//		            break;
//		        }
//		    }
//
//		    // Step 4: Apply zoom and scroll in the new window
//		    JavascriptExecutor jslr = (JavascriptExecutor) driver;
//		    jslr.executeScript("document.body.style.zoom='50%';");
//		    Thread.sleep(5000);
//		    jslr.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//
//		    // Optional: Wait for scroll to finish visually (not technically needed)
//		    Thread.sleep(3000);
//
//		    // Step 5: Close the print window and return to original
//		    driver.close();
//		    driver.switchTo().window(originalWindow);

		    
//		   boolean isPresent = false;
//		   WebElement targetElement = null;
//
//		   for (int i = 0; i < 10; i++) {
//		       List<WebElement> elements = driver.findElements(By.xpath("//*[@id='input_subject_title']"));
//		       if (!elements.isEmpty()) {
//		           isPresent = true;
//		           targetElement = elements.get(0);
//		           break;
//		       }
//		       try {
//		           Thread.sleep(1000); 
//		       } catch (InterruptedException e) {
//		           e.printStackTrace();
//		       }
//		   }
//
//		   if (isPresent && targetElement != null) {
//		       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);
//		       targetElement.click();
//		       System.out.println("Clicked on input_subject_title field.");
//		   } else {
//		       System.out.println("Element not found: input_subject_title");
//		   }
//
//		   
		   
//		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//*[@id=\"rightdrawer_compose_email_section\"]/form/section/div[1]/div/span")));
//		    driver.findElement(By.cssSelector("//*[@id=\"rightdrawer_compose_email_section\"]/form/section/div[1]/div/span")).click();
//		   WebDriverWait wait810 = new WebDriverWait(driver, Duration.ofSeconds(60));
//		   WebElement iframee = wait810.until(ExpectedConditions.presenceOfElementLocated(By.id("ssIFrame_google")));
//
//		   // Switch to the iframe using its id
//		   driver.switchTo().frame(iframee);
//
//		  
//		   
//		   
//		   String Shareviaemail = row.getCell(71).toString();
//		   WebElement 71Field = null;
//		   Actions actions = new Actions(driver);
//
//		   // Try clicking the field with a loop
//		   for (int i = 0; i < 10; i++) {
//		       try {
//		           shareviaField = driver.findElement(By.xpath("//*[@id='right_drawer_new_chat_user_select']/div/div/div[2]/input"));
//		           actions.moveToElement(shareviaField).click().perform();
//		           break; // success, exit loop
//		       } catch (Exception e) {
//		           Thread.sleep(500); // wait and retry
//		       }
//		   }
//
//		   // After successful click, proceed with typing and pressing Enter
//		   if (shareviaField != null) {
//		       shareviaField.sendKeys(Shareviaemail);
//		       Thread.sleep(500); // slight wait before hitting Enter
//		       shareviaField.sendKeys(Keys.ENTER);
//		   } else {
//		       System.out.println("Input field not found after retries.");
//		   }
//		   
//		    Thread.sleep(2000);		   
//		    WebElement sendButton = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.send-button[type='submit']")));
//		    sendButton.click();
		 
		    
		    
		   
		   

		    
		    
		    
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}

		 // Step 1: Click action icon
		 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Step 2: Click print icon
		 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
		 Thread.sleep(2000);  // Let modal appear
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Step 3: Click 'Print' button in modal
		 wait1.until(ExpectedConditions.elementToBeClickable(
		         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();

		 Thread.sleep(5000); // ⏳ Wait for the file to download

		 System.out.println("PDF download should be complete now.");
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		 // Step 1: Click action icon
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Step 2: Click print icon
		 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
		 Thread.sleep(2000);  // Let modal appear

		 
		 WebElement radioBtn = driver.findElement(By.cssSelector("input[type='radio'][value='Excel'][name='DocumentType']"));
		 radioBtn.click();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 
		 // Step 3: Click 'Print' button in modal
		 wait1.until(ExpectedConditions.elementToBeClickable(
		         By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));

		 Thread.sleep(2000);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/butt-generate-bill.svg']")));
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(
				    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
				));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-generate-bill.svg']")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(
				    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
				));
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/div/div/div[2]/input")));
		    
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/div/div/div[2]/input")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")));
	     
	        driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")).click();
	        Thread.sleep(3000);
	        try {
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
	        } catch (Exception ignored) {}
	        wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
	        
	     
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-validating/div/div[3]/div/div/span[2]")));
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-validating/div/div[3]/div/div/span[2]")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    
		 // --- First row: PDF download ---

		 // Step 1: Click action icon in first row
		 WebElement firstRowAction = wait1.until(ExpectedConditions.elementToBeClickable(
		     By.xpath("//*[@id='bill-to-client']/table/tbody/tr[1]/td[8]/span[1]/img")
		 ));
		 firstRowAction.click();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Step 2: Click print icon
		 wait1.until(ExpectedConditions.elementToBeClickable(
		     By.cssSelector("img[src='./assets/img/svg/action-print.svg']")
		 )).click();
		 Thread.sleep(2000);  // Wait for modal
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Step 3: Click 'Print' button in modal
		 wait1.until(ExpectedConditions.elementToBeClickable(
		     By.xpath("//span[@class='submit-button' and text()='Print']")
		 )).click();

		 Thread.sleep(5000); // Let the PDF download finish

		 System.out.println("PDF download for first row should be complete.");
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Wait until modal is gone
		 wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));

		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // --- Second row: Excel download ---

		 // Step 1: Click action icon in second row
		 WebElement secondRowAction = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='bill-to-client']/table/tbody/tr[1]/td[8]/span[1]/img")));
		 secondRowAction.click();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Step 2: Click print icon
		 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
		 Thread.sleep(2000);  // Wait for modal

		 // Step 3: Select Excel radio button
		 WebElement radiooBtn = driver.findElement(By.cssSelector("input[type='radio'][value='Excel'][name='DocumentType']"));
		 radiooBtn.click();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Step 4: Click 'Print' in modal
		 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
		 System.out.println("Created Client Bill");
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 // Wait for modal to disappear
		 wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		    
		 Thread.sleep(5000);
		    
		 System.out.println("Finalize bill started");
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='bill-to-client']/table/tbody/tr[1]/td[8]/span[1]/img")));
		 secondRowAction.click();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg//FinalizeBill.svg']"))).click();
				Thread.sleep(2000); // Wait for modalScript("arguments[0].click();", finalizeButton);
				 try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {} 
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes' and contains(@class, 'submit-button')]"))).click();
		Thread.sleep(5000);
		By locator = By.xpath("//*[@id='bill-to-client']/table/tbody/tr[1]/td[8]/span[1]/img");

		for (int attempt = 0; attempt < 5; attempt++) {
		    try {
		        WebElement secondRowAction1 = wait1.until(ExpectedConditions.elementToBeClickable(locator));
		        secondRowAction1.click();
		        break;  // exit loop if click is successful
		    } catch (StaleElementReferenceException e) {
		        // Element went stale, retry
		        System.out.println("Stale element exception caught, retrying... Attempt: " + (attempt + 1));
		    }
		}

		 System.out.println("Credit note creation");
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/icon-credit-Note.svg']"))).click();
		Thread.sleep(2000);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}	
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/create-new.svg']"))).click();
		Thread.sleep(1000);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#client-bill > div:nth-child(3) > div.ng-star-inserted > span.submit-button.ng-star-inserted")));
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div.ng-star-inserted > span.submit-button.ng-star-inserted"))).click();
		Thread.sleep(2000);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox'].checkBox.selectcheckall"))).click();
		

		String CreditnoteAmount = row.getCell(71).toString();
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='billamount'].lable-input-bill")));
		WebElement creditamount = driver.findElement(By.cssSelector("input[name='billamount'].lable-input-bill"));
		
		creditamount.clear();
		creditamount.sendKeys(CreditnoteAmount);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div.ng-star-inserted > span.submit-button.ng-star-inserted"))).click();
		Thread.sleep(500);
		// Wait and click the placeholder "Select Reason"
		

		// Get the reason from Excel
		String Creditnotereason = row.getCell(72).toString();

		// Wait for input field inside the combobox
		WebElement inputFieldcoombo= wait1.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//div[@role='combobox']//input")
		));

		// Type and select the reason
		inputFieldcoombo.sendKeys(Creditnotereason);
		inputFieldcoombo.sendKeys(Keys.ENTER);

		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div.ng-star-inserted > span.submit-button.ng-star-inserted"))).click();
		Thread.sleep(500);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > div:nth-child(3) > div.ng-star-inserted > span.submit-button.ng-star-inserted"))).click();
		Thread.sleep(500);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//span[contains(@class, 'submit-button') and contains(text(),'Generate')]")))
			    .click();
		Thread.sleep(10000);

		Thread.sleep(2000);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
			    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
			));
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
		 Thread.sleep(2000);
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='./assets/img/svg/action-print.svg']")));
		 try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}	
		 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-print\"]/div[2]/div[1]/div[1]/div/input[1]"))).click();
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Print' and contains(@class, 'submit-button')]"))).click();
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(
					    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
					));
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 wait1.until(ExpectedConditions.invisibilityOfElementLocated(
					    By.cssSelector("div.cdk-overlay-backdrop.cdk-overlay-dark-backdrop")));
			 
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}	
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}	
			 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
				 Thread.sleep(2000);
				 try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}
				 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='./assets/img/svg/action-print.svg']")));
				 try {
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
				        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
				    } catch (Exception ignored) {}	
				 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
					 Thread.sleep(2000);
					 try {
					        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
					        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
					    } catch (Exception ignored) {}
					 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-print\"]/div[2]/div[1]/div[1]/div/input[2]"))).click();
					 try {
					        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
					        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
					    } catch (Exception ignored) {}
					 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Print' and contains(@class, 'submit-button')]"))).click();
					 try {
					        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
					        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
					    } catch (Exception ignored) {}
					 wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.cdk-overlay-backdrop.cdk-overlay-dark-backdrop")));
					 Thread.sleep(2000);
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
							    By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-backdrop-showing")
							));
		    WebDriverWait waitloadchild = new WebDriverWait(driver, Duration.ofSeconds(60));	
		    
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    
		    waitloadchild.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bill-to-client > div:nth-child(2) > div > div > div:nth-child(4)")));
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bill-to-client > div:nth-child(2) > div > div > div:nth-child(4)")));
		    driver.findElement(By.cssSelector("#bill-to-client > div:nth-child(2) > div > div > div:nth-child(4)")).click();
		    
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/butt-issue-po.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-issue-po.svg']")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[5]/div/div[1]/div/ng-select/div/div/div[2]/input")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[5]/div/div[1]/div/ng-select/div/div/div[2]/input")));
		    WebElement vendorfields = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[5]/div/div[1]/div/ng-select/div/div/div[2]/input")); // Replace with actual ID
			vendorfields.sendKeys(vendormod);
		    vendorfields.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")));
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    
		    System.out.println("Created Vendor PO");
		   // WebDriverWait waitload8 = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    Thread.sleep(5000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action_icon.svg']")));
		    //waitload8.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/action_icon.svg']")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog\"]/div[1]/div/span/img")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog\"]/div[1]/div/span/img")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[3]/div/div/table/tr/td[1]/span")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[3]/div/div/table/tr/td[1]/span")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[5]/div/div/span[2]")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[5]/div/div/span[2]")).click();
		    Thread.sleep(2000);	
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
			 // Step 2: Click print icon
			 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);  // Let modal appear
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 // Step 3: Click 'Print' button in modal
			 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 Thread.sleep(5000); // ⏳ Wait for the file to download

			 System.out.println("PDF download should be complete now.");

			 wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}// Step 1: Click action icon
			 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']"))).click();
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 // Step 2: Click print icon
			 wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action-print.svg']"))).click();
			 Thread.sleep(2000);  // Let modal appear

			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 WebElement radioBtnn = driver.findElement(By.cssSelector("input[type='radio'][value='Excel'][name='DocumentType']"));
			 radioBtnn.click();
			 
			 
			 // Step 3: Click 'Print' button in modal
			 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='submit-button' and text()='Print']"))).click();
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {} 
			 wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));

			 Thread.sleep(2000);
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(
					    By.cssSelector("div.cdk-overlay-backdrop.cdk-overlay-dark-backdrop")
					));
			 try {
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
			    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/butt-vendor-bill.svg']")));
		    WebElement element12 = driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-vendor-bill.svg']"));
			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element12);
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-vendor-bill.svg']")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[1]/ng-select/div/div/div[2]/input")));
		    WebElement vendorfieldss = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[1]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			vendorfieldss.sendKeys(vendormod);
		    vendorfieldss.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-generate-vendor-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-generate-vendor-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
		    Thread.sleep(2000);
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/div/div/div[3]/input")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/div/div/div[3]/input")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    String VendorBillNo = row.getCell(14).toString();
		    WebElement VendorBillNoField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[1]/div[2]/div[1]/input"));
		    VendorBillNoField.sendKeys(VendorBillNo);
		    VendorBillNoField.sendKeys(Keys.TAB);
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-backdrop")));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-snack-bar-container")));
		    } catch (Exception ignored) {}
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    System.out.println("Created Vendor Bill");
		    driver.switchTo().defaultContent();
		    

		}
	    
	}



    public static void selectDate(WebDriver driver, String date) {
        // Locate all date buttons on the calendar (they are typically <button> elements)
        List<WebElement> dateButtons = driver.findElements(By.cssSelector(".mat-calendar-body-cell button"));

        // Loop through each button and find the matching date based on aria-label
        for (WebElement button : dateButtons) {
            String ariaLabel = button.getAttribute("aria-label");
            if (ariaLabel != null && ariaLabel.equals(date)) {
                // Click the button that matches the specified date
                button.click();
                System.out.println("Date " + date + " selected.");
                break; // Exit loop once the date is found and clicked
            }
        }
    }


	@And("Close the chrome Browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}


}
