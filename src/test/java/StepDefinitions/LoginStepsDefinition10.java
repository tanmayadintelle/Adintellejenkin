package StepDefinitions;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition10 {
	static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("User completes Bill Transfer flow")
	public void user_is_on_login_page_billtransfer() throws IOException, InterruptedException, AWTException {

	    // Write code here that turns the phrase above into concrete actions
		ChromeOptions options = new ChromeOptions();

		    
	    HashMap<String, Object> prefs = new HashMap<>();    
	    // Block notifications by setting the preference value to 2 (block)
	    prefs.put("profile.default_content_setting_values.notifications", 2); 
	    // Add preferences to Chrome options
	//    options.setExperimentalOption("prefs", prefs);
	    options.addArguments("--headless=new"); // Use new headless for better rendering
	    options.addArguments("--disable-gpu");  // Prevent GPU issues in headless
	    options.addArguments("--window-size=1920,1080");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--remote-allow-origins=*");
	    driver =new ChromeDriver(options);
//	    System.out.print("WebDriver initalized");
//	    driver.get("https://pro.adintelle.com/v7/m-box/campaign"); 
//	    System.out.print("Website opened");
	  
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	   // String downloadDir = "BTLoutputs\\" + timestamp;
	    String downloadDir = new File("screenshots\\BillTransfer\\" + timestamp).getAbsolutePath();

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
	    options.addArguments("--disable-blink-features=AutomationControlled");

	    driver =new ChromeDriver(options);

	    System.out.print("WebDriver initalized");
	    driver.get("https://pro.adintelle.com/v7/login"); 
	    reduceResolution();
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
			
			WebElement usernameField = driver.findElement(By.name("username")); // Replace with actual ID
			
			usernameField.sendKeys("tanmay.nayak");
			// String Quantity = row.getCell(6).toString();
		    driver.findElement(By.name("acceptTerms")).click();
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identify_user_button_text_active\"]")));
		    driver.findElement(By.xpath("//*[@id=\"identify_user_button_text_active\"]")).click();
		    
		    WebDriverWait waitload1 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
			   
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
	        searchElement.sendKeys("bill transfer");
	        
	        
	        WebElement imageElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='https://instance-assets.s3.ap-south-1.amazonaws.com/public/images/application_logo/24913248.png']")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", imageElement);
	        // Click the image
	        imageElement.click();
	        Thread.sleep(4000);
	        
	        
//	        WebElement iframe = waitid.until(ExpectedConditions.presenceOfElementLocated(By.id("appIframe")));
//	        driver.switchTo().frame(iframe);
//	        driver.switchTo().frame("appIframeAgency"); 
//	        System.out.println("Inside iframe");
//	        // Switch to iframe by id or index
	        driver.switchTo().frame("appIframe");  // or driver.switchTo().frame(0);

	     // Locate the element inside the iframe using normal XPath or any locator
	        WebElement pendingdoc = driver.findElement(By.xpath("//a[@href='#/Finance/BillDetailsListComponent']"));
	        jls.executeScript("arguments[0].scrollIntoView(true);", pendingdoc);
	     // Click the element
	        pendingdoc.click();

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
	        	 
	        	 
	        
	        WebElement calendaricon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"m_Filter_Datepicker\"]/div/span")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", calendaricon);
	        // Click the image
	        calendaricon.click();
		    
//	        WebElement last30days = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/ul/li[4]")));
//	       
//	        // Click the image
//	        last30days.click();
	        Thread.sleep(8000);
	        WebElement last30Days = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.daterangepicker.dropdown-menu.ltr.opensleft.show-calendar > div.ranges > ul > li:nth-child(4)")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", last30Days);
	        jls.executeScript("arguments[0].focus();", last30Days);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", last30Days);

	        
	        Thread.sleep(8000);
	        WebElement applyButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Apply ']")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", applyButton);
	        applyButton.click();
	        
	        Thread.sleep(8000);
	       
	        jls.executeScript("window.scrollTo({ top: 0, left: 0, behavior: 'instant' });");
	        Thread.sleep(4000);
	        
	        WebElement deselectlockedbills =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/div")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", deselectlockedbills);
	        deselectlockedbills.click();

	        Thread.sleep(4000);
	        
	        WebElement unselectallbutton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-checkbox-2\"]/label/div")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", unselectallbutton);
	        unselectallbutton.click();

	        Thread.sleep(4000);
	        jls.executeScript("window.scrollTo({ top: 0, left: 0, behavior: 'instant' });");
	        
	     // Step 1: Get the index of the "Doc No" column (if you haven't already)
	        List<WebElement> headerCells = driver.findElements(By.xpath("//mat-header-row/mat-header-cell"));
	        int docNoIndex = -1;
	        for (int i = 0; i < headerCells.size(); i++) {
	            if (headerCells.get(i).getText().trim().equals("Doc No")) {
	                docNoIndex = i + 1; // XPath is 1-based
	                break;
	            }
	        }
	        if (docNoIndex == -1) {
	            throw new RuntimeException("Doc No column not found");
	        }

	        // Step 2: Get the first Doc No from the first row
	        WebElement firstRow =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-row[1]")));
	        String firstDocNo = firstRow.findElement(By.xpath(".//mat-cell[" + docNoIndex + "]")).getText().trim();
	        System.out.println("First Doc No: " + firstDocNo);

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
	        WebElement submitforenvoicingButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Submit For E-Invoicing')]")));
	        jls.executeScript("arguments[0].scrollIntoView(true);", submitforenvoicingButton);
	        submitforenvoicingButton.click();
	        Thread.sleep(500);
	        jls.executeScript("window.scrollTo({ top: 0, left: 0, behavior: 'instant' });");
	        Thread.sleep(4000);
	        WebElement successtab =  wait.until(ExpectedConditions.elementToBeClickable(
	        	    By.xpath("//*[@id=\"portletTabID\"]/div/div/div/div/div[1]/div/div[1]/ul/li[2]/a/div/span"))
	        	);
	        jls.executeScript("arguments[0].scrollIntoView(true);", successtab);
	        successtab.click();

	        Thread.sleep(2000);
	        WebElement searchtab = driver.findElement(
	        	    By.xpath("//*[@id=\"m_tabs_12_2\"]/div/div/div/div/div/div[1]/div/div/input")
	        	);
	        jls.executeScript("arguments[0].scrollIntoView(true);", searchtab);
	        searchtab.sendKeys(firstDocNo);
	        Thread.sleep(2000);
	        
	        List<WebElement> matched = driver.findElements(By.xpath("//mat-cell[contains(@class,'cdk-column-Bill-Number') and normalize-space(text())='" + firstDocNo + "']"));
	        boolean isPresent = !matched.isEmpty() && matched.get(0).isDisplayed();

	        if (isPresent) {
	        	Thread.sleep(2000);
	            System.out.println("Bill number " + firstDocNo + " is present on the success screen.");
	            captureScreenshot(driver, "Success_" + firstDocNo,downloadFolder);
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
	                System.out.println("Bill number " + firstDocNo + " is present on the error screen.");
	                Thread.sleep(2000);
	                captureScreenshot(driver, "Error_" + firstDocNo,downloadFolder);
	            } else {
	                System.out.println("Bill number " + firstDocNo + " NOT found on both success and error screens.");
	                Thread.sleep(2000);
	                captureScreenshot(driver, "NotFoundinSuccessorError_" + firstDocNo,downloadFolder);
	            }
	        }

        }
	}
	    
       

	@And("Downloads reports")
	public void display_status_download_reports() throws InterruptedException {
		 JavascriptExecutor jls = (JavascriptExecutor) driver;
		 Thread.sleep(2000);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 WebElement reportstab = driver.findElement(By.xpath("//a[@href='#/Finance/Report']"));
	        jls.executeScript("arguments[0].scrollIntoView(true);", reportstab);
	     // Click the element
	        reportstab.click();
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
				 	        
				 	       WebElement applyButton2 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Apply ']")));
				 	        jls.executeScript("arguments[0].scrollIntoView(true);", applyButton2);
				 	        applyButton2.click();
				 	        Thread.sleep(10000);
				        		
			        	
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

    private void reduceResolution() throws AWTException {
        System.setProperty("java.awt.headless", "false");
        Robot robot = new Robot();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        for (int i = 0; i < 1; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               System.out.println("issue with resolution");     
               Thread.currentThread().interrupt();//logger.logs( "Interrupted!", e);
                
            }
        }
    }
    public static void captureScreenshot(WebDriver driver, String screenshotName, File downloadFolder) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Build destination file path
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File dest = new File(downloadFolder, screenshotName + "_billtransfer_" + timestamp + ".png");

        try {
            FileUtils.copyFile(src, dest);
            System.out.println("✅ Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }

    private static String timestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    
	@Then("Closes the chrome Browser")
	public void closes_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
//		driver.quit();
	}


}
