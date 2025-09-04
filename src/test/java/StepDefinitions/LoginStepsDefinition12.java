package StepDefinitions;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
public class LoginStepsDefinition12 {
	static WebDriver driver;
	static String downloadDir;   
	static String firstDocNo;
	public void takeFullPageScreenshot(String testName) throws IOException {
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String filename = testName + "_" + firstDocNo + ".png";
	    File destFile = new File(downloadDir + "\\" + filename);
	    FileUtils.copyFile(screenshot, destFile);
	   // System.out.println("✅ Screenshot saved as: " + destFile.getAbsolutePath());
	}


	
	@SuppressWarnings("deprecation")
	@Given("User completes Tally Transfer flow")
	public void user_is_on_login_page_fincotransfer() throws IOException, InterruptedException, AWTException {
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		   // String downloadDir = "BTLoutputs\\" + timestamp;
		    downloadDir = new File("screenshots\\TallyTransfer\\" + timestamp).getAbsolutePath();

		    File downloadFolder = new File(downloadDir);
		    if (!downloadFolder.exists()) {
		        downloadFolder.mkdirs(); // ✅ Create the folder if not there
		    }
	    // Write code here that turns the phrase above into concrete actions
		ChromeOptions options = new ChromeOptions();

		    
	    HashMap<String, Object> prefs = new HashMap<>();    
	    // Block notifications by setting the preference value to 2 (block)
	    prefs.put("profile.default_content_setting_values.notifications", 2); 

	    options.addArguments("--headless=new"); // Use new headless for better rendering
	    options.addArguments("--disable-gpu");  // Prevent GPU issues in headless
	    options.addArguments("--window-size=1920,1080");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--remote-allow-origins=*");
//
	  
	
	   // Map<String, Object> prefs1 = new HashMap<>();
	    prefs.put("profile.default_content_setting_values.notifications", 2);
	    prefs.put("download.default_directory", downloadDir); // ✅ Your download path
//	    prefs1.put("plugins.always_open_pdf_externally", true);
//	    prefs1.put("download.prompt_for_download", false); 
//	    prefs1.put("directory_upgrade", true);             
//	    prefs1.put("safebrowsing.enabled", true);          
	    options.setExperimentalOption("prefs", prefs);
	    options.addArguments("--disable-blink-features=AutomationControlled");

	    driver =new ChromeDriver(options);

	    System.out.print("WebDriver initalized");
	    driver.get("https://pro.adintelle.com/v7/login"); 
	    //reduceResolution();
	    System.out.print("Website opened");
	   driver.manage().window().setSize(new Dimension(1920, 1080));
	   // driver.manage().window().maximize();
	    
	    String excelFilePath = "Book2.xlsx";  // Path to your Excel file
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			Row row = sheet.getRow(1); // Get the second row (0-indexed));
			WebDriverWait waitload2 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.name("username")));
			// Step 3: Find the form fields on the webpage and fill them with data from Excel
		    Thread.sleep(2000);
		   
			WebElement usernameField = driver.findElement(By.name("username")); // Replace with actual ID
			
			usernameField.sendKeys("tanmay.nayak");
			// ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");
			Thread.sleep(6000);
			// takeFullPageScreenshot("Login screen");
			// String Quantity = row.getCell(6).toString();
		    driver.findElement(By.name("acceptTerms")).click();
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identify_user_button_text_active\"]")));
		    driver.findElement(By.xpath("//*[@id=\"identify_user_button_text_active\"]")).click();
		    
		    WebDriverWait waitload1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
			    
		    waitload1.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		    
			WebElement passwordField = driver.findElement(By.name("password")); 
			passwordField.sendKeys("Citi5bank$12345678");
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
	        	}
	      
//        Thread.sleep(2000);// Replace with your iframe ID
//	       // Replace with the correct iframe ID
		    WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"apps\"]")));
	        driver.findElement(By.xpath("//*[@id=\"apps\"]")).click();
//	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-my-apps/div/div[3]/div/div/div[1]/div[1]/span/span[2]")));
	      
	        Thread.sleep(5000);// Replace with your iframe ID
	        
	      //  driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-my-apps/div/div[3]/div/div/div[1]/div[1]/span/span[2]")).click();
	    
	        JavascriptExecutor jls = (JavascriptExecutor) driver;
//	        jls.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//	        Thread.sleep(5000);
	       
	        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("search_chat_field")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", searchElement); // Scrolls to the element
	        // Click the image
	        searchElement.sendKeys("admin");
	        Thread.sleep(2000);
	        
	        WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//img[contains(@src, '828043.png')]")
	            ));
	          //  logo.click();
	        jls.executeScript("arguments[0].scrollIntoView(true);", logo);
	        // Click the image
	        logo.click();
	        Thread.sleep(2000);
	        
	       driver.switchTo().frame("appIframe");
	        Thread.sleep(2000);
	        WebElement agencyMenu = driver.findElement(By.xpath("//span[text()='Agency']"));
	       // agencyMenu.click();

	        jls.executeScript("arguments[0].scrollIntoView(true);", agencyMenu);
	        agencyMenu.click();
	        Thread.sleep(2000);
	       
	     // 1. Locate the row containing the desired text and checkbox
	        WebElement checkboxzz = driver.findElement(By.xpath(
	            "//tr[td[contains(text(), 'Mediaware Infotech Pvt Ltd')]]//input[@type='checkbox']"
	        ));
	        jls.executeScript("arguments[0].scrollIntoView(true);", checkboxzz);
	        // 2. Click the checkbox
	        checkboxzz.click();

	        
	        jls.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(2000);
	        WebElement modifyButton = driver.findElement(By.xpath("//input[@value='Modify' and @type='submit']"));

	        jls.executeScript("arguments[0].scrollIntoView(true);", modifyButton);
	        modifyButton.click();
	        Thread.sleep(2000);
	        Select accountingSystemDropdown = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpAccountCompany")));
	        
	        
	        String selectedOption = accountingSystemDropdown.getFirstSelectedOption().getText();

	        if (!selectedOption.equals("Tally")) {
	            accountingSystemDropdown.selectByVisibleText("Tally");
	            System.out.println("Dropdown changed to Tally.");
	        } else {
	            System.out.println("Tally is already selected.");
	        }
	        
	        jls.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();

	        
	        driver.switchTo().defaultContent();
	        
	        Thread.sleep(2000);

	     //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"apps\"]")));
	        driver.findElement(By.xpath("//*[@id=\"apps\"]")).click();
//	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-my-apps/div/div[3]/div/div/div[1]/div[1]/span/span[2]")));
	      
	        Thread.sleep(5000);// Replace with your iframe ID
	        
	      //  driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-my-apps/div/div[3]/div/div/div[1]/div[1]/span/span[2]")).click();
	    
	        //JavascriptExecutor jls = (JavascriptExecutor) driver;
//	        jls.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//	        Thread.sleep(5000);
	   
			  
	        WebElement searchElementq = wait.until(ExpectedConditions.elementToBeClickable(By.id("search_chat_field")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", searchElementq); // Scrolls to the element
	        // Click the image
	        searchElementq.sendKeys("tally transfer");
	        Thread.sleep(2000);
	        jls.executeScript("document.body.scrollTop = 0; document.documentElement.scrollTop = 0;");
//	        WebElement logo1 = wait.until(ExpectedConditions.presenceOfElementLocated(
//	        	    By.xpath("//img[contains(@src, '1266616467.png')]")
//	        	));
//
//	        	// 2. Scroll into view (optional)
//	        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logo1);
//
//	        // Small wait to allow any overlays/loaders to disappear
//	        Thread.sleep(1000);
//	        // Click the image
//	        logo1.click();
	       // Thread.sleep(4000);
	     // Find the app tile by app name text
	        WebElement appTile = driver.findElement(
	            By.xpath("//span[contains(text(),'Tally Transfer')]/ancestor::div[contains(@class,'app_detail_box')]")
	        );

	        // Scroll to it
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", appTile);

	        // Optional wait
	        Thread.sleep(500);

	        // Try normal click
	        try {
	            appTile.click();
	        } catch (ElementClickInterceptedException e) {
	            // If intercepted, fallback to JS click
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", appTile);
	        }

	        Thread.sleep(5000);
//	        WebElement iframe = waitid.until(ExpectedConditions.presenceOfElementLocated(By.id("appIframe")));
//	        driver.switchTo().frame(iframe);
//	        driver.switchTo().frame("appIframeAgency"); 
//	        System.out.println("Inside iframe");
//	        // Switch to iframe by id or index
	      //  driver.switchTo().frame("appIframe");  // or driver.switchTo().frame(0);
	        driver.switchTo().frame("appIframe");  //
//	        WebElement iframe = waitid.until(ExpectedConditions.presenceOfElementLocated(By.id("appIframe")));
//	        driver.switchTo().frame(iframe);
//	        driver.switchTo().frame("appIframeAgency"); 
//	        System.out.println("Inside iframe");
//	        // Switch to iframe by id or index
	       // driver.switchTo().frame("appIframe");  // or driver.switchTo().frame(0);

	     // Locate the element inside the iframe using normal XPath or any locator
	        WebElement pendingdoc = driver.findElement(By.xpath("//a[@href='#/TallyFinance/BillDetailsListComponent']"));
	        jls.executeScript("arguments[0].scrollIntoView(true);", pendingdoc);
	     // Click the element
	        try {
	        	pendingdoc.click();
	        } catch (ElementNotInteractableException e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pendingdoc);
	        }
	        Thread.sleep(5000);
	     // Switch back to the main page DOM
	        //driver.switchTo().defaultContent();

	        
	        WebElement pendingDocsLink = driver.findElement(
	        	    By.xpath("//*[@id=\"m_ver_menu\"]/ul/li[2]/a/i"));
	        	    jls.executeScript("arguments[0].scrollIntoView(true);", pendingDocsLink);
	        	
	        	pendingDocsLink.click();
	      
	        	 Thread.sleep(2000);
	        	 
	        	 WebElement filter = wait
	 	        	    .until(ExpectedConditions.elementToBeClickable(
	 	        	        By.id("filterIconID")
	 	        	    ));
	 	        jls.executeScript("arguments[0].scrollIntoView(true);", filter);
	 	        filter.click();
	 	        	 Thread.sleep(4000);
	 	        	 
	        
	        	 WebElement mediumLabel = driver.findElement(By.xpath("//label[contains(text(),'Medium')]"));
	        	 WebElement mediumDropdown = mediumLabel
	        	     .findElement(By.xpath("./following-sibling::ng-multiselect-dropdown//span[@class='dropdown-down']"));

	        	 wait.until(ExpectedConditions.elementToBeClickable(mediumDropdown)).click();
	        	 
	        	 Thread.sleep(2000);
	        	 WebElement unselectAllCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
	        			    By.xpath("//div[text()='UnSelect All']/preceding-sibling::input[@type='checkbox']")
	        			));

	        			// Scroll into view
	        			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", unselectAllCheckbox);

	        			// Optional: slight delay to ensure stability after scroll
	        			Thread.sleep(500);

	        			// Perform JavaScript click
	        			((JavascriptExecutor) driver).executeScript("arguments[0].click();", unselectAllCheckbox);
	        			Thread.sleep(2000);
	        			WebElement printCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
	        				    By.xpath("//div[normalize-space(text())='Print']/preceding-sibling::input[@type='checkbox']")
	        				));
	        			JavascriptExecutor js = (JavascriptExecutor) driver;
	        				// Click the checkbox
	        			js.executeScript("arguments[0].scrollIntoView(true);", printCheckbox);
	        			js.executeScript("arguments[0].click();", printCheckbox);
	        				Thread.sleep(2000);
	        				
	        				
	        	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
	       	    By.xpath("/html/body/div[2]/div/div[2]/app-bill-details-list/div/div/div/div/form/div[1]/div/mat-accordion/mat-expansion-panel/div/div/div/div[3]/div/div/button[1]")
	        	));

	        	button.click();
	        	Thread.sleep(2000);
	        	WebElement clientLabel = driver.findElement(By.xpath("//label[contains(text(),'Client')]"));
	        	WebElement clientDropdown = clientLabel
	        	    .findElement(By.xpath("./following-sibling::ng-multiselect-dropdown//span[@class='dropdown-down']"));

	        	wait.until(ExpectedConditions.elementToBeClickable(clientDropdown)).click();
	        	Thread.sleep(2000);
	        	
	        	 WebElement unselectAllCheckbox1 = wait.until(ExpectedConditions.elementToBeClickable(
	        			    By.xpath("//div[text()='UnSelect All']/preceding-sibling::input[@type='checkbox']")
	        			));

	        	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", unselectAllCheckbox1);

	        	// Optional: wait briefly after scrolling
	        	Thread.sleep(500);

	        	// Click using JavaScript
	        	((JavascriptExecutor) driver).executeScript("arguments[0].click();", unselectAllCheckbox1);
	        			Thread.sleep(2000);
	        			List<WebElement> checkboxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	        				    By.xpath("//div[normalize-space(text())='Amazon Seller Services Pvt Ltd.']/preceding-sibling::input[@type='checkbox']")
	        				));

	        				// Safety check
	        				if (checkboxes.size() >= 2) {
	        				    WebElement secondCheckbox = checkboxes.get(1); // Index 1 = second element

	        				    // Scroll into view
	        				    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", secondCheckbox);
	        				    Thread.sleep(500); // Optional delay

	        				    // Click using JS
	        				    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondCheckbox);
	        				} else {
	        				    System.out.println("Less than 2 matching checkboxes found.");
	        				}

	        				Thread.sleep(2000);
	        				WebElement brandLabel = driver.findElement(By.xpath("//label[contains(text(),'Brand')]"));

	        				// Locate the dropdown relative to the label
	        				WebElement brandDropdown = brandLabel.findElement(
	        				    By.xpath("./following-sibling::ng-multiselect-dropdown//span[@class='dropdown-down']")
	        				);

	        				// Wait until the element is present in DOM and visible
	        				wait.until(ExpectedConditions.visibilityOf(brandDropdown));

	        				// Scroll into view
	        				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", brandDropdown);

	        				// Optional: small delay to stabilize UI after scrolling
	        				Thread.sleep(500);

	        				// Click using JavaScript
	        				((JavascriptExecutor) driver).executeScript("arguments[0].click();", brandDropdown);
	        				Thread.sleep(2000);
	        				// Step 1: Wait until the element is in the DOM (not clickable)
	        				WebElement selectAllCheckbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(
	        				    By.xpath("//*[@id=\"cdk-accordion-child-0\"]/div/div/div[2]/div[2]/ng-multiselect-dropdown/div/div[2]/ul[1]/li[1]/input")
	        				));

	        				// Step 2: Scroll into view
	        				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", selectAllCheckbox1);

	        				// Step 3: Pause briefly (for scroll animation or rendering)
	        				Thread.sleep(500);

	        				// Step 4: Click using JavaScript
	        				((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectAllCheckbox1);
	        				
	     	        			Thread.sleep(2000);
	       
	        	 
	        
	        WebElement calendaricon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"m_Filter_Datepicker\"]/div/span")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", calendaricon);
	        // Click the image
	    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", calendaricon);
		    
//	        WebElement last30days = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/ul/li[4]")));
//	       
//	        // Click the image
//	        last30days.click();
	        Thread.sleep(8000);
	        WebElement last30Days = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.daterangepicker.dropdown-menu.ltr.opensleft.show-calendar > div.ranges > ul > li:nth-child(4)")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", last30Days);
	        jls.executeScript("arguments[0].focus();", last30Days);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", last30Days);

	        
	        Thread.sleep(5000);
	        WebElement applyButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Apply ']")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", applyButton);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyButton);

	        
	        Thread.sleep(8000);
	       
	        jls.executeScript("window.scrollTo({ top: 0, left: 0, behavior: 'instant' });");
	        Thread.sleep(4000);
	        
//	        WebElement deselectlockedbills =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/div")));
//	        jls.executeScript("arguments[0].scrollIntoView(true);", deselectlockedbills);
//	        deselectlockedbills.click();

//	        Thread.sleep(4000);
	        
	        WebElement unselectallbutton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/div")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", unselectallbutton);
	       // unselectallbutton.click();
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", unselectallbutton );
	        
	        
	        Thread.sleep(4000);
	        jls.executeScript("window.scrollTo({ top: 0, left: 0, behavior: 'instant' });");
	        
	     // Step 1: Get the index of the "Doc No" column (if you haven't already)
	        List<WebElement> headerCells = driver.findElements(By.xpath("//mat-header-row/mat-header-cell"));
	        int docNoIndex = -1;
	        for (int i = 0; i < headerCells.size(); i++) {
	            if (headerCells.get(i).getText().trim().equals("Bill No")) {
	                docNoIndex = i + 1; // XPath is 1-based
	                break;
	            }
	        }
	        if (docNoIndex == -1) {	
	            throw new RuntimeException("Bill No column not found");
	        }
	        Thread.sleep(15000);

	        // Step 2: Get the first Doc No from the first row
	        WebElement firstRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        	    By.xpath("//mat-row[1]")));
	        firstDocNo = firstRow.findElement(By.xpath(".//mat-cell[" + docNoIndex + "]")).getText().trim();
	        System.out.println("First Doc No: " + firstDocNo);
	        int mediumIndex = -1;
	        for (int i = 0; i < headerCells.size(); i++) {
	            if (headerCells.get(i).getText().trim().equals("Medium")) {
	                mediumIndex = i + 1;
	                break;
	            }
	        }
	        if (mediumIndex == -1) {
	            throw new RuntimeException("Medium column not found");
	        }

	        WebElement mediumCell = firstRow.findElement(By.xpath(".//mat-cell[" + mediumIndex + "]"));
	        String mediumValue = mediumCell.getText().trim();
	        System.out.println("Medium value from UI: " + mediumValue);
	        // Step 3: Find the row with that Doc No and check its checkbox
	        List<WebElement> rows = driver.findElements(By.xpath("//mat-row"));
	        for (WebElement row1 : rows) {
	            String docNoText = row1.findElement(By.xpath(".//mat-cell[" + docNoIndex + "]")).getText().trim();
	            if (docNoText.equals(firstDocNo)) {
	                WebElement checkbox = row1.findElement(By.xpath(".//mat-cell[1]//mat-checkbox"));
	                WebElement checkboxInput = checkbox.findElement(By.xpath(".//input[@type='checkbox']"));
	                if (!checkboxInput.isSelected()) {
	                    checkbox.click();
	                }
	                break;
	            }
	        }
	       
	        jls.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	        Thread.sleep(4000);
	        WebElement submitforenvoicingButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), ' Transfer to Tally ')]")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", submitforenvoicingButton);
	        submitforenvoicingButton.click();
	        Thread.sleep(500);
	        jls.executeScript("window.scrollTo({ top: 0, left: 0, behavior: 'instant' });");
	        Thread.sleep(4000);
	        WebElement successtab =  wait.until(ExpectedConditions.elementToBeClickable(
	        	    By.xpath("//*[@id=\"portletTabID\"]/div/div/div/div/div[1]/div/div[1]/ul/li[2]/a/div/span/a"))
	        	);
	        jls.executeScript("arguments[0].scrollIntoView(true);", successtab);
	        successtab.click();

	        Thread.sleep(2000);
	        WebElement searchtab = driver.findElement(
	        	    By.xpath("//*[@id=\"m_tabs_12_2\"]/div/div/div/div/div/div/div/div/div/input")
	        	);
	        jls.executeScript("arguments[0].scrollIntoView(true);", searchtab);
	        searchtab.sendKeys(firstDocNo);
	        Thread.sleep(2000);
	        
	        List<WebElement> matched = driver.findElements(By.xpath("//mat-cell[contains(@class,'cdk-column-Bill-Number') and normalize-space(text())='" + firstDocNo + "']"));
	        boolean isPresent = !matched.isEmpty() && matched.get(0).isDisplayed();

	        if (isPresent) {
	        	new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
	            System.out.println("Bill number " + firstDocNo + " is present on the initate screen.");
	            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	            Thread.sleep(2000);
	            takeFullPageScreenshot("Bill is present on intitate screen");
	        } else {
	        	 Thread.sleep(5000);
	            WebElement successTab =  wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//*[@id='portletTabID']/div/div/div/div/div[1]/div/div[1]/ul/li[3]/a/div/span")
	            	    )); // adjust xpath for success tab
	            jls.executeScript("arguments[0].scrollIntoView(true);", successTab);
	            successTab.click();

	            Thread.sleep(2000);
	            WebElement searchtab2 =wait.until(ExpectedConditions.elementToBeClickable(
	            	    By.xpath("//*[@id=\"m_tabs_12_3\"]/div/div/div/div/div/div/div/div/input")
	            		)); // adjust xpath for success search input
	            jls.executeScript("arguments[0].scrollIntoView(true);", searchtab2);
	            searchtab2.clear();
	            searchtab2.sendKeys(firstDocNo);

	            Thread.sleep(2000);

	            List<WebElement> matchedError = driver.findElements(By.xpath("//mat-cell[contains(@class,'cdk-column-Bill-Number') and normalize-space(text())='" + firstDocNo + "']"));
	            boolean isPresentSuccess = !matchedError.isEmpty() && matchedError.get(0).isDisplayed();

	            if (isPresentSuccess) {
	            	new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
	                System.out.println("Bill number " + firstDocNo + " is present on the error screen.");
	                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	                Thread.sleep(2000);
	                takeFullPageScreenshot("Error screen");
	            } else {
	            	new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
	            	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	                System.out.println("Bill number " + firstDocNo + " NOT found on both success and error screens.");
	                Thread.sleep(2000);
	                takeFullPageScreenshot("NOT found on both success and error screen");
	                
	                
	            }
	        }

        }
        

        Thread.sleep(5000);        
        try {
            String folderPath = "D:\\Finco Transfer\\Tally Console App1";
            String dllFile = "aDintelle_Git_TallyTransfer.dll";

            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dotnet " + dllFile);
            processBuilder.directory(new File(folderPath)); // Set working directory
            processBuilder.redirectErrorStream(true); // Combine stdout and stderr

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("🔧 DLL Output: " + line);
            }

            int exitCode = process.waitFor();
            System.out.println("✅ DLL executed successfully. Exit code: " + exitCode);

        } catch (Exception e) {
            System.out.println("❌ Failed to execute DLL: " + e.getMessage());
            e.printStackTrace();
        }
        Thread.sleep(5000); 
        
        
        Thread.sleep(5000); 
        driver.switchTo().defaultContent();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"apps\"]")));
        driver.findElement(By.xpath("//*[@id=\"apps\"]")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-my-apps/div/div[3]/div/div/div[1]/div[1]/span/span[2]")));
      
        Thread.sleep(5000);// Replace with your iframe ID
        
      //  driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-my-apps/div/div[3]/div/div/div[1]/div[1]/span/span[2]")).click();
    
        JavascriptExecutor jls = (JavascriptExecutor) driver;
//        jls.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//        Thread.sleep(5000);
   
		  
        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("search_chat_field")));
        jls.executeScript("arguments[0].scrollIntoView(true);", searchElement); // Scrolls to the element
        // Click the image
        searchElement.sendKeys("tally transfer");
        
        
        WebElement appTile1 = driver.findElement(
        	    By.xpath("//span[contains(text(),'Tally Transfer')]/ancestor::div[contains(@class,'app_detail_box')]")
        	);

        	// Scroll to it
        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", appTile1);

        	// Optional wait
        	Thread.sleep(500);

        	// Try normal click
        	try {
        	    appTile1.click();
        	} catch (ElementClickInterceptedException e) {
        	    // If intercepted, fallback to JS click
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", appTile1);
        	}
        Thread.sleep(4000);
        
        Thread.sleep(5000);
//        WebElement iframe = waitid.until(ExpectedConditions.presenceOfElementLocated(By.id("appIframe")));
//        driver.switchTo().frame(iframe);
//        driver.switchTo().frame("appIframeAgency"); 
//        System.out.println("Inside iframe");
//        // Switch to iframe by id or index
      //  driver.switchTo().frame("appIframe");  // or driver.switchTo().frame(0);
        driver.switchTo().frame("appIframe"); 
        	Thread.sleep(4000);
        	
        	// ---------- Check in Transfer Completed Tab (Tab 4) ----------
        	


    } // 👈 This is the closing bracket of your @Given method
   

       

	@And("Downloads reports for Tally Transfer")
	public void display_status_download_reports() throws InterruptedException, IOException {
		 JavascriptExecutor jls = (JavascriptExecutor) driver;
		// driver.switchTo().frame("appIframe");
		 Thread.sleep(5000);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 WebElement reportstab = driver.findElement(By.xpath("//a[@href='#/TallyFinance/Report']"));
	        jls.executeScript("arguments[0].scrollIntoView(true);", reportstab);
//	     // Click the element
	        try {
	        	reportstab.click();
	        } catch (ElementNotInteractableException e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reportstab);
	        }
	        Thread.sleep(500);
	        WebElement selectClientSpan = wait.until(ExpectedConditions.elementToBeClickable(
	        	    By.xpath("//span[normalize-space()='Select Client']")
	        	));
	        	jls.executeScript("arguments[0].scrollIntoView(true);", selectClientSpan);
	        	selectClientSpan.click();
	        	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        	Thread.sleep(2000);
	        	WebElement selectAllCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
	        	    By.xpath("//input[@aria-label='multiselect-select-all' and @type='checkbox']")
	        	));

	        	// Scroll into view and click using JavaScript (to avoid interception)
	        	JavascriptExecutor js = (JavascriptExecutor) driver;
	        	js.executeScript("arguments[0].scrollIntoView(true);", selectAllCheckbox);
	        	Thread.sleep(500); // Give time to scroll
	        	js.executeScript("arguments[0].click();", selectAllCheckbox);
	        	Thread.sleep(500);
	        	js.executeScript("window.scrollTo(0, 0);");
	        	WebElement selectBrandSpan = wait.until(ExpectedConditions.elementToBeClickable(
		        	    By.xpath("//span[normalize-space()='Select Brand']")
		        	));
		        	jls.executeScript("arguments[0].scrollIntoView(true);", selectBrandSpan);
		        	selectBrandSpan.click();
		        	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        	Thread.sleep(2000);
		        	Thread.sleep(2000);
		        	WebElement selectAllCheckbox1 = wait.until(ExpectedConditions.elementToBeClickable(
		        		    By.xpath("(//input[@aria-label='multiselect-select-all' and @type='checkbox'])[2]")));
		        		

		        	js.executeScript("arguments[0].scrollIntoView(true);", selectAllCheckbox1);
		        	Thread.sleep(500); // Give time to scroll
		        	js.executeScript("arguments[0].click();", selectAllCheckbox1);
		        	js.executeScript("window.scrollTo(0, 0);");
		        	
		        	Thread.sleep(500);
		        	WebElement selectMediumSpan = wait.until(ExpectedConditions.elementToBeClickable(
			        	    By.xpath("//span[normalize-space()='Select Medium']")
			        	));
			        	jls.executeScript("arguments[0].scrollIntoView(true);", selectMediumSpan);
			        	selectMediumSpan.click();
			        	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        	Thread.sleep(2000);
			        	Thread.sleep(2000);
			        	WebElement selectAllCheckbox2 = wait.until(ExpectedConditions.elementToBeClickable(
			        		    By.xpath("(//input[@aria-label='multiselect-select-all' and @type='checkbox'])[3]")));
			        	js.executeScript("arguments[0].scrollIntoView(true);", selectAllCheckbox2);
			        	Thread.sleep(500); // Give time to scroll
			        	js.executeScript("arguments[0].click();", selectAllCheckbox2);
			        	
			        	Thread.sleep(500);
			        	js.executeScript("window.scrollTo(0, 0);");
			        	WebElement billstatusspan = wait.until(ExpectedConditions.elementToBeClickable(
				        	    By.xpath("//span[normalize-space()='Bill Status']")
				        	));
				        	jls.executeScript("arguments[0].scrollIntoView(true);", billstatusspan);
				        	billstatusspan.click();
				        	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				        	Thread.sleep(2000);
				        	Thread.sleep(2000);
				        	WebElement selectAllCheckbox3 =wait.until(ExpectedConditions.elementToBeClickable(
				        		    By.xpath("(//input[@aria-label='multiselect-select-all' and @type='checkbox'])[4]")));
				               //selectAllCheckbox.click();
				        	js.executeScript("arguments[0].scrollIntoView(true);", selectAllCheckbox3);
				        	Thread.sleep(500); // Give time to scroll
				        	js.executeScript("arguments[0].click();", selectAllCheckbox3);
				        	js.executeScript("window.scrollTo(0, 0);");
				        	Thread.sleep(2000);
				        	WebElement calendarIcon = wait.until(ExpectedConditions.elementToBeClickable(
				        		    By.xpath("//*[@id=\"m_Filter_Datepicker\"]/div/span")));
				        	js.executeScript("arguments[0].scrollIntoView(true);", calendarIcon);
				        	calendarIcon.click();
				        	Thread.sleep(2000);
				        				
				        	WebElement last30Day1s =wait.until(ExpectedConditions.elementToBeClickable(
				        		    By.cssSelector("body > div.daterangepicker.dropdown-menu.ltr.opensright.show-calendar > div.ranges > ul > li:nth-child(4)")
				        			)); 
				        	js.executeScript("arguments[0].scrollIntoView(true);", last30Day1s);
				        	last30Day1s.click();
				        	Thread.sleep(2000);
//				        	 WebElement applyButton1 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Apply']")));
//				 	        jls.executeScript("arguments[0].scrollIntoView(true);", applyButton1);
//				 	        applyButton1.click();
				 	        Thread.sleep(10000);
				 	       WebElement applyButton2 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Apply ']")));
				 	        jls.executeScript("arguments[0].scrollIntoView(true);", applyButton2);
				 	        applyButton2.click();
				 	        Thread.sleep(10000);
				 	     //  String baseFolder = "screenshots\\BillTransfer";
//				 	      boolean found = isDocNoPresentInLatestExcel(baseFolder, firstDocNo);
//
//				 	      if (found) {
//				 	          System.out.println("Doc number " + firstDocNo + " found in the Excel report.");
//				 	      } else {
//				 	          System.out.println("Doc number " + firstDocNo + " NOT found in the Excel report.");
//				 	      }
				        		
			        	
	}
	
	
//	public static void takeScreenshot(WebDriver driver, String fileName) {
//	    try {
//	        TakesScreenshot ts = (TakesScreenshot) driver;
//	        File source = ts.getScreenshotAs(OutputType.FILE);
//	        File destination = new File("screenshots/" + fileName + ".png");
//	        FileUtils.copyFile(source, destination);
//	        System.out.println("Screenshot taken: " + destination.getAbsolutePath());
//	    } catch (Exception e) {
//	        System.out.println("Failed to capture screenshot: " + e.getMessage());
//	    }
//	}


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

    public boolean isDocNoPresentInLatestExcel(String baseFolder, String firstDocNo) throws IOException {
        // Find latest folder inside baseFolder (screenshots\BillTransfer)
        File folder = new File(baseFolder);
        File[] subfolders = folder.listFiles(File::isDirectory);
        if (subfolders == null || subfolders.length == 0) {
            System.out.println("No subfolders found inside " + baseFolder);
            return false;
        }

        // Sort folders by lastModified descending to get latest folder
        Arrays.sort(subfolders, Comparator.comparingLong(File::lastModified).reversed());
        File latestFolder = subfolders[0];

        // Find latest Excel file inside latest folder
        File[] excelFiles = latestFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        if (excelFiles == null || excelFiles.length == 0) {
            System.out.println("No Excel files found inside " + latestFolder.getAbsolutePath());
            return false;
        }
        Arrays.sort(excelFiles, Comparator.comparingLong(File::lastModified).reversed());
        File latestExcelFile = excelFiles[0];

        // Open Excel and search for firstDocNo
        try (FileInputStream fis = new FileInputStream(latestExcelFile);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming first sheet

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING) {
                        if (cell.getStringCellValue().equals(firstDocNo)) {
                            return true;
                        }
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        if (String.valueOf((long) cell.getNumericCellValue()).equals(firstDocNo)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false; // not found
    }
//    private void reduceResolution() throws AWTException {
//        System.setProperty("java.awt.headless", "false");
//        Robot robot = new Robot();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        for (int i = 0; i < 1; i++) {
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_MINUS);
//            robot.keyRelease(KeyEvent.VK_MINUS);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//               System.out.println("issue with resolution");     
//               Thread.currentThread().interrupt();//logger.logs( "Interrupted!", e);
//                
//            }
//        }
//    }
//    public static void captureScreenshot(WebDriver driver, String screenshotName, File downloadFolder) throws InterruptedException {
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        //File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        Thread.sleep(1000);
//        // Build destination file path
//        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        File dest = new File(downloadFolder, screenshotName + "_billtransfer_" + timestamp + ".png");
//
//        try {
//        	Thread.sleep(1000);
//            FileUtils.copyFile(src, dest);
//            System.out.println("✅ Screenshot saved: " + dest.getAbsolutePath());
//        } catch (IOException e) {
//        	Thread.sleep(1000);
//            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
//        }
//    }

//    private static String timestamp() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
//    }

    
    
	@Then("Closes the chromes Browser completely")
	public void closes_the_browserrr() {
	    // Write code here that turns the phrase above into concrete actions
	driver.quit();
	}


}
