package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Map;
//import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition5 {
	static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("User completes Press pro sanity flow")
	public void user_is_on_login_page() throws IOException, InterruptedException {

	    // Write code here that turns the phrase above into concrete actions
		ChromeOptions options = new ChromeOptions();
	    // Create a HashMap for preferences
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless=new");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--disable-blink-features=AutomationControlled");
//		// DON’T use headless in scheduler
//		options.addArguments("--start-maximized"); 
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");

	    HashMap<String, Object> prefs = new HashMap<>();    
	    // Block notifications by setting the preference value to 2 (block)
	    prefs.put("profile.default_content_setting_values.notifications", 2); 
	    // Add preferences to Chrome options
	    options.setExperimentalOption("prefs", prefs);
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String downloadDir = "D:\\fd\\btladintelleautomation\\pressoutput\\" + timestamp;

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
	    
	    String excelFilePath = "D:\\fd\\btladintelleautomation\\Presspro.xlsx";  // Path to your Excel file
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			Row row = sheet.getRow(1); // Get the second row (0-indexed));
			WebDriverWait waitload2 = new WebDriverWait(driver, Duration.ofSeconds(80));
			 ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.name("username")));
			// Step 3: Find the form fields on the webpage and fill them with data from Excel
			
			WebElement usernameField = driver.findElement(By.name("username")); // Replace with actual ID
			
			usernameField.sendKeys("tanmay.nayak");
			
		    driver.findElement(By.name("acceptTerms")).click();
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"identify_user_button_text_active\"]")));
		    driver.findElement(By.xpath("//*[@id=\"identify_user_button_text_active\"]")).click();
		    
		    WebDriverWait waitload1 = new WebDriverWait(driver, Duration.ofSeconds(80));
		    WebDriverWait waitloadz = new WebDriverWait(driver, Duration.ofSeconds(80));
			   
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
	        	WebDriverWait waitload22 = new WebDriverWait(driver, Duration.ofSeconds(80));
				  
			    waitload22.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span")));
	            // If the element is found, click on it
	            warningButtonList.get(0).click();
	            System.out.println("Warning button clicked.");
	        }
	        Thread.sleep(4000);
//		    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span")).click();
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
		    WebDriverWait waitload23 = new WebDriverWait(driver, Duration.ofSeconds(80));
			  
		    waitload23.until(ExpectedConditions.elementToBeClickable(By.className("show_collapse_icon")));
		    WebElement elementarrow = driver.findElement(By.className("show_collapse_icon"));
	        elementarrow.click();
	        
	        System.out.println("Logged in");
	        //((JavascriptExecutor) driver).executeScript("document.body.style.zoom='100%'");
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
	        waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"apps\"]")));
	        driver.findElement(By.xpath("//*[@id=\"apps\"]")).click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
	        
//		    WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
		    
		    Thread.sleep(5000);

	        WebElement imageElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='https://instance-assets.s3.ap-south-1.amazonaws.com/public/images/application_logo/1558225374.png']")));

	        // Click the image
	        imageElement.click();
//	        Thread.sleep(10000);
	        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("appIframe")));
            driver.switchTo().frame(iframe);
            Thread.sleep(5000);
          

            String dropdownXpath = "//span[@class='select2-selection select2-selection--single']";

            // The option to be selected
            
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXpath)));
            dropdown.click();
            String Client = row.getCell(2).toString();
 		   
            System.out.println("Dropdown clicked.");
            WebElement client = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"PartialCBES\"]/span/span/span[1]/input")));

	        client.sendKeys(Client);
	        
	        driver.findElement(By.xpath("/html/body/div[5]/div/span/span/span[2]/ul/li")).click();
	       Thread.sleep(4000);
	        
	        WebElement button = driver.findElement(By.xpath("//button[text()='Create Estimate']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	      
	        String campaignname = row.getCell(3).toString();
	 		   
           
            WebElement campaign = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Campaign_Name\"]")));

	        campaign.sendKeys(campaignname);
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Start_Date\"]")));
	        // Start Date click for add new estimate
	        WebElement calendarButton111 = driver.findElement(By.xpath("//*[@id=\"Start_Date\"]"));
	       
			calendarButton111.click();
			
			// Read the value "10" from the Excel sheet (ensure this is the exact value)
			String dateFromExcel1 = row.getCell(4).toString().trim();

			// Remove decimal point if any (e.g., convert "10.0" to "10")
			dateFromExcel1 = dateFromExcel1.split("\\.")[0];
			// Output for debugging: Make sure that the correct date value is being read
			System.out.println("Date to click: " + dateFromExcel1);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));

			// Click the day cell with the matching date
			List<WebElement> allDates = driver.findElements(By.xpath("//div[contains(@class,'datepicker-days')]//td[@class='day' or contains(@class, 'active')]"));

			boolean dateClicked = false;
			for (WebElement dateElement : allDates) {
			    if (dateElement.getText().equals(dateFromExcel1)) {
			        dateElement.click();
			        dateClicked = true;
			        break;
			    }
			}

			if (!dateClicked) {
			    System.out.println("Date not found or not clickable: " + dateFromExcel1);
			}
	        
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"End_Date\"]")));
			// End Date click for add new estimate
	        WebElement calendarButton2 = driver.findElement(By.xpath("//*[@id=\"End_Date\"]"));
	       
			calendarButton2.click();
			
			// Read the value "10" from the Excel sheet (ensure this is the exact value)
			String dateFromExcel2 = row.getCell(5).toString().trim();

			// Remove decimal point if any (e.g., convert "10.0" to "10")
			dateFromExcel2 = dateFromExcel2.split("\\.")[0];
			// Output for debugging: Make sure that the correct date value is being read
			System.out.println("Date to click: " + dateFromExcel2);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));

			// Click the day cell with the matching date
			List<WebElement> allDatess = driver.findElements(By.xpath("//div[contains(@class,'datepicker-days')]//td[@class='day' or contains(@class, 'active')]"));

			boolean dateClickedd = false;
			for (WebElement dateElement : allDatess) {
			    if (dateElement.getText().equals(dateFromExcel2)) {
			        dateElement.click();
			        dateClickedd = true;
			        break;
			    }
			}

			if (!dateClickedd) {
			    System.out.println("Date not found or not clickable: " + dateFromExcel2);
			}
	        
			
			
			// Estimate Date click for add new estimate
	        WebElement calendarButton3 = driver.findElement(By.xpath("//*[@id=\"Estimate_Date\"]"));
	       
			calendarButton3.click();
			
			// Read the value "10" from the Excel sheet (ensure this is the exact value)
			String dateFromExcel3 = row.getCell(6).toString().trim();

			// Remove decimal point if any (e.g., convert "10.0" to "10")
			dateFromExcel3 = dateFromExcel3.split("\\.")[0];
			// Output for debugging: Make sure that the correct date value is being read
			System.out.println("Date to click: " + dateFromExcel3);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));

			// Click the day cell with the matching date
			List<WebElement> allDatesss = driver.findElements(By.xpath("//div[contains(@class,'datepicker-days')]//td[@class='day' or contains(@class, 'active')]"));

			boolean dateClickeddd = false;
			for (WebElement dateElement : allDatesss) {
			    if (dateElement.getText().equals(dateFromExcel3)) {
			        dateElement.click();
			        dateClickeddd = true;
			        break;
			    }
			}

			if (!dateClickedd) {
			    System.out.println("Date not found or not clickable: " + dateFromExcel3);
			}
	        
			String SAC = row.getCell(7).toString();
            WebElement SACfield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SAC\"]")));
            SACfield.sendKeys(SAC);
	        
            String AAC = row.getCell(8).toString();
            WebElement AACfield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"AAC\"]")));
            AACfield.sendKeys(AAC);
	             
            //Format type selection
            
            String formatdropdownText = row.getCell(9).toString().trim();

            System.out.println("Dropdown value from Excel: " + formatdropdownText);

            // Find and select the dropdown value
            
            WebElement dropdownElementformat = wait.until(ExpectedConditions.elementToBeClickable(By.id("Bill_Format_Id")));
            Select dropdowntextformat = new Select(dropdownElementformat);

           
            dropdowntextformat.selectByVisibleText(formatdropdownText);
            System.out.println("Selected: " + formatdropdownText);
          
            //Tax Template selection
            
            
            String taxdropdownText = row.getCell(10).toString().trim();

            System.out.println("Dropdown value from Excel: " + taxdropdownText);

            // Find and select the dropdown value
            
            WebElement dropdownElementtax = wait.until(ExpectedConditions.elementToBeClickable(By.id("Tax_Template_Id")));
            Select dropdowntexttax = new Select(dropdownElementtax);

           
            dropdowntexttax.selectByVisibleText(taxdropdownText);
            System.out.println("Selected: " + taxdropdownText);
            Thread.sleep(2000);
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"colsemodal\"]"))).click();
            Thread.sleep(10000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Currency_Id\"]"))).click();
            //CURRENCY DROPDOWN
            
            String currencydropdownText = row.getCell(11).toString().trim();

            System.out.println("Dropdown value from Excel: " + currencydropdownText);

            // Find and select the dropdown value
            
            WebElement dropdownElementcurrency = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Currency_Id\"]")));
            Select dropdowntextcurrency = new Select(dropdownElementcurrency);

           
            dropdowntextcurrency.selectByVisibleText(currencydropdownText);
            System.out.println("Selected: " + currencydropdownText);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btnsubmit\"]"))).click();
            
            Thread.sleep(5000);
            
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[7]/div/div/div/div[3]/button"))).click();


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[3]/a[2]"))).click();
            
            System.out.println("Navigating to Publications and Packages");
          
            String Publication = row.getCell(12).toString();
            WebElement Publicationfield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Publication\"]")));
            Publicationfield.sendKeys(Publication);
            Publicationfield.click();
           
            Thread.sleep(4000);
            String publicationText = row.getCell(13).toString().trim();

         // XPath dynamically built using the Excel value
         String xpath = "//li[normalize-space(text())='" + publicationText + "']";

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

         boolean clicked = false;
         int attempts = 0;

         while (!clicked && attempts < 3) {
             try {
            	 Thread.sleep(6000);
                 // Wait for the element to be clickable freshly each time
                 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                 element.click();
                 
                 clicked = true;
             } catch (StaleElementReferenceException e) {
                 System.out.println("Retrying due to stale element...");
                 
                 attempts++;
                 Thread.sleep(1000); // short wait before retry
             }
         }
         if (!clicked) {
             throw new RuntimeException("Failed to click the publication after retries: " + publicationText);
         }
         Thread.sleep(3000);

         WebElement alledi= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"allEdi\"]")));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alledi);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", alledi);

  
         

         ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
         Thread.sleep(3000);
         String spacewidth = row.getCell(14).toString();
         WebElement spacewidthfield = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Dimension1")));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", spacewidthfield);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", spacewidthfield);
         Thread.sleep(3000);
      Thread.sleep(300); // Let the scroll settle
      try {
          spacewidthfield.clear(); // Optional: Clear old value
          spacewidthfield.sendKeys(spacewidth);
      } catch (ElementClickInterceptedException e) {
          System.out.println("⚠️ Click intercepted on Dimension1 — using JavaScript fallback.");
          ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + spacewidth + "';", spacewidthfield);
      }
         Thread.sleep(3000);
         String spaceheight = row.getCell(15).toString();
        
         WebElement spaceheightfield = wait.until(ExpectedConditions.elementToBeClickable(By.id("Dimension2")));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", spaceheightfield);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", spaceheightfield);
         Thread.sleep(3000);
         spaceheightfield.sendKeys(spaceheight);
         Thread.sleep(3000);
         
         String rate = row.getCell(16).toString();
         WebElement ratefield = wait.until(ExpectedConditions.elementToBeClickable(By.id("Rate")));
         ratefield.sendKeys(rate);
         Thread.sleep(3000);
         WebElement buyingRateField = wait.until(ExpectedConditions.elementToBeClickable(By.id("TotalBuyingRates")));
        
         //JavascriptExecutor js = (JavascriptExecutor) driver;

      // Step 1: Set value to "0" to break auto-binding
      js.executeScript("arguments[0].value = '0';", buyingRateField);

      // Optional: Trigger input event if necessary
      js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", buyingRateField);

      Thread.sleep(500); // Allow any JS triggers to complete

      // Step 2: Now set actual value from Excel
      String buyingRate = row.getCell(17).toString().trim();
      js.executeScript("arguments[0].value = arguments[1];", buyingRateField, buyingRate);
      js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", buyingRateField);


         
      String noOfInsertion = row.getCell(18).toString().trim();
      WebElement noOfInsertionField = wait.until(ExpectedConditions.elementToBeClickable(By.id("NoOfInsertion")));

      // Focus and backspace multiple times to ensure old value is removed
      noOfInsertionField.click();
      Thread.sleep(200); // small delay

      // Use Actions to send multiple BACK_SPACE keys
      Actions actions = new Actions(driver);
      actions.moveToElement(noOfInsertionField)
             .click()
             .sendKeys(Keys.END) // Move to end of field
             .sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE) // Delete any existing characters
             .sendKeys(noOfInsertion)
             .perform();

      
         
         js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
         
       
         wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_btn"))).click();
         Thread.sleep(2000);
         try {
        	    WebElement okButton = new WebDriverWait(driver, Duration.ofSeconds(80))
        	        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK' or text()='Ok']")));
        	    okButton.click();
        	    Thread.sleep(4000); // If needed, else replace with explicit wait
        	} catch (TimeoutException e) {
        	    // Element not found or not clickable within timeout, continue with next steps
        	    System.out.println("OK button not present, proceeding to next step.");
        	}
         Thread.sleep(4000);
         //Add new for package code
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[3]/a[2]")));
         
         
         
         String xpathaddnew = "//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[3]/a[2]";

         // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
         for (int attemptss = 0; attemptss < 10; attemptss++) {
             try {
                 // Find the element by XPath
                 WebElement element = driver.findElement(By.xpath(xpathaddnew));
                 Thread.sleep(2000);
                 // Click the element
                 element.click();
                 System.out.println("Element clicked successfully!");
                 break; // Exit the loop if the click is successful
             } catch (Exception e) {
            	 
                 // If an exception occurs, retry
                 System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
             }
         }
         Thread.sleep(2000);
         wait.until(ExpectedConditions.elementToBeClickable(By.id("stpck"))).click();
         
         String packagecode = row.getCell(19).toString();
         WebElement packagecodefield = wait.until(ExpectedConditions.elementToBeClickable(By.id("PackageCode")));
         packagecodefield.click();
         packagecodefield.clear();
         packagecodefield.sendKeys(packagecode);
         Thread.sleep(4000);
         packagecodefield.click();
         packagecodefield.sendKeys(Keys.ENTER);
        
         
         Thread.sleep(5000); // Wait for suggestions to appear or DOM to update

      // Wait for the list of <li> elements to be visible
         List<WebElement> listItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
             By.xpath("//li[contains(@class, 'list-group-item')]")
         ));

         // Check if the list is not empty, then click the first element
         if (!listItems.isEmpty()) {
             listItems.get(0).click();  // Click the first element
         } else {
             System.out.println("No list items found!");
         }

         Thread.sleep(4000);
         wait.until(ExpectedConditions.elementToBeClickable(By.id("SavePackSel"))).click();
         String spacewidth1 = row.getCell(20).toString();
         WebElement spacewidthfield1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("Dimension1")));
         spacewidthfield1.sendKeys(spacewidth1);
         Thread.sleep(3000);
         String spaceheight1 = row.getCell(21).toString();
         spacewidthfield1.click();
         WebElement spaceheightfield1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("Dimension2")));
         spaceheightfield1.sendKeys(spaceheight1);
         Thread.sleep(3000);
         Thread.sleep(2000);
         String rate1 = row.getCell(22).toString();
         WebElement ratefield1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("Rate")));
         ratefield1.sendKeys(rate1);
         Thread.sleep(3000);
        

      // Step 1: Re-locate the element before interacting
        

      // Clear and set value to '0'
      // Wait for the element to be clickable
      // Wait for the element to be clickable
         buyingRateField = wait.until(ExpectedConditions.elementToBeClickable(By.id("TotalBuyingRates")));

         // Step 1: Clear the field by setting its value to an empty string ('')
         // Ensure it's not readonly or disabled before interacting with it
         js.executeScript("arguments[0].removeAttribute('readonly');", buyingRateField);  // Remove readonly if present
         js.executeScript("arguments[0].removeAttribute('disabled');", buyingRateField);  // Remove disabled if present

         // Focus the field before clearing it
         js.executeScript("arguments[0].focus();", buyingRateField);

         // Clear the field by setting its value to an empty string
         js.executeScript("arguments[0].value = '';", buyingRateField);
         js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", buyingRateField);  // Trigger input event

         // Step 2: Get the value from Excel (assuming you already have 'row' object for the Excel row)
         String buyingRate1 = row.getCell(23).toString().trim();
         System.out.println("Buying rate fetched from Excel: " + buyingRate1);  // Optional for debugging

         // Step 3: Re-locate the element after the value is cleared to avoid stale reference
         buyingRateField = wait.until(ExpectedConditions.elementToBeClickable(By.id("TotalBuyingRates")));

         // Step 4: Set the new value from Excel to the field
         js.executeScript("arguments[0].value = arguments[1];", buyingRateField, buyingRate1);
         js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", buyingRateField);  // Trigger input event

      
      // Get the value from Excel
         String noOfInsertion1 = row.getCell(24).toString().trim();

         // Wait for the element to be clickable
         WebElement noOfInsertionField1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("NoOfInsertion")));

         // Step 1: Remove readonly and disabled attributes (if applicable)
         js.executeScript("arguments[0].removeAttribute('readonly');", noOfInsertionField1);
         js.executeScript("arguments[0].removeAttribute('disabled');", noOfInsertionField1);

         // Step 2: Clear the field by setting its value to an empty string
         js.executeScript("arguments[0].value = '';", noOfInsertionField1);  // Clear the field
         js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", noOfInsertionField1);  // Trigger input event

         // Step 3: Alternatively, if you want to simulate BACK_SPACE, use Actions
         // Focus on the element and backspace multiple times to clear the field (optional)
         Actions action = new Actions(driver);
         action.moveToElement(noOfInsertionField1)
                .click()
                .sendKeys(Keys.END) // Move to the end of the field
                .sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE) // Delete existing characters
                .perform();

         // Step 4: Enter the new value from Excel
         action.moveToElement(noOfInsertionField1)
                .click()
                .sendKeys(noOfInsertion1)  // Set the new value from Excel
                .perform();

         // Optional Debugging: Print the value before and after clearing
         String valueBeforeClear = js.executeScript("return arguments[0].value;", noOfInsertionField1).toString();
         System.out.println("Value before clearing: " + valueBeforeClear);

         // Wait for the final value to be updated
         String valueAfterUpdate = js.executeScript("return arguments[0].value;", noOfInsertionField1).toString();
         System.out.println("Final value after update: " + valueAfterUpdate);
      

      js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
      
      
      wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_btn"))).click();
   
      try {
  	    WebElement okButton = new WebDriverWait(driver, Duration.ofSeconds(80))
  	        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK' or text()='Ok']")));
  	    okButton.click();
  	    Thread.sleep(4000); // If needed, else replace with explicit wait
  	} catch (TimeoutException e) {
  	    // Element not found or not clickable within timeout, continue with next steps
  	    System.out.println("OK button not present, proceeding to next step.");
  	}
   Thread.sleep(4000);
      
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mySidebar\"]/div/div/span[3]"))).click();  
      Thread.sleep(500);
      wait.until(ExpectedConditions.elementToBeClickable(
    		    By.xpath("//span[text()='Estimate']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
    		).click();

    
      
      WebElement schedulingTab = wait.until(ExpectedConditions.elementToBeClickable(
    		    By.xpath("//span[@class='navbarsubtext' and text()='Scheduling']")
    		));
    		schedulingTab.click();
    		Thread.sleep(3000);
      wait.until(ExpectedConditions.elementToBeClickable(By.id("BtnAutoSch"))).click();  
      Thread.sleep(3000);
      String insertionToschedule = row.getCell(25).toString();
      WebElement insertionToschedulefield1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("insertionToschedule")));
      insertionToschedulefield1.clear();
      insertionToschedulefield1.sendKeys(insertionToschedule);
      
      wait.until(ExpectedConditions.elementToBeClickable(By.id("txtAutoSchDate"))).click();
      String targetDay = row.getCell(26).toString().trim();

		// Remove decimal point if any (e.g., convert "10.0" to "10")
		targetDay = targetDay.split("\\.")[0];
		// Output for debugging: Make sure that the correct date value is being read
		System.out.println("Date to click: " + dateFromExcel2);
		
      WebElement dateElement = driver.findElement(By.xpath("//td[@class='day' and text()='" + targetDay + "']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElement);
      dateElement.click();
      
      String dayincrement = row.getCell(27).toString();
      WebElement dayincrementfield1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("Days_Increment")));
      dayincrementfield1.clear();
      dayincrementfield1.sendKeys(dayincrement);
      Thread.sleep(1000);
      
      js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
      Thread.sleep(3000);
      
      
      
      
      String xpaths = "btnProceedAutoSch";

      if (driver.findElements(By.id(xpaths)).size() > 0) {
          boolean clickeddd = false;
          int attempt = 0;

          while (!clickeddd && attempt < 3) {
              try {
                  Thread.sleep(6000);
                  WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(xpaths)));
                  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                  wait.until(ExpectedConditions.elementToBeClickable(element));

                  try {
                      element.click();
                  } catch (ElementClickInterceptedException e) {
                      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                  }

                  // ✅ Wait for the page to move on
                  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(xpaths)));

                  clickeddd = true;

              } catch (StaleElementReferenceException e) {
                  System.out.println("Retrying due to stale element...");
                  attempt++;
                  Thread.sleep(1000);
              }
          }

          if (!clicked) {
              throw new RuntimeException("Failed to click the button after retries: " + xpaths);
          }
      }

      
      
      Thread.sleep(3000);
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mySidebar\"]/div/div/span[3]"))).click();  
      Thread.sleep(500);
      
      wait.until(ExpectedConditions.elementToBeClickable(
  		    By.xpath("//span[text()='Estimate']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
  		).click();
      Thread.sleep(2000);
      WebElement viewTab = wait.until(ExpectedConditions.elementToBeClickable(
  		    By.xpath("//span[@class='navbarsubtext' and text()='View']")
  		));
      viewTab.click();
      Thread.sleep(2000);
      wait.until(ExpectedConditions.presenceOfElementLocated(
    		    By.xpath("//tr[td[contains(normalize-space(),'" + campaignname + "')]]")
    		));
      
      Thread.sleep(3000);
      String dynamicXpath = "//tr[td[contains(normalize-space(),'" + campaignname + "')]]//input[@class='ChkStyle']";

      WebElement approvalCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXpath)));

      // Scroll and wait briefly
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", approvalCheckbox);
      Thread.sleep(500);  // Small pause for headless rendering

      // Try normal click, fall back to JS click
      try {
          wait.until(ExpectedConditions.elementToBeClickable(approvalCheckbox));
          approvalCheckbox.click();
      } catch (org.openqa.selenium.WebDriverException e) {
          System.out.println("Standard click failed, using JS click.");
          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", approvalCheckbox);
      }



Thread.sleep(2000);
   String POno = row.getCell(28).toString();
   WebElement POnofield = wait.until(ExpectedConditions.elementToBeClickable(By.id("PONo")));
   POnofield.sendKeys(POno);

   
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PODate"))).click();
   
   String targettDay = row.getCell(29).toString().trim();

// 2. Remove decimal if the cell contains numeric like "14.0"
   targettDay = targettDay.contains(".") ? targettDay.split("\\.")[0] : targettDay;

   System.out.println("Date to click: " + targettDay);

// 3. Wait until the datepicker is visible
   
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));

// 4. Build XPath dynamically based on the target day
   String dateXpath = "//td[contains(@class, 'day') and not(contains(@class, 'old')) and not(contains(@class, 'new')) and text()='" + targettDay + "']";

// 5. Wait for the specific date to be clickable
   WebElement dateElemen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXpath)));

// 6. Scroll and click
   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElemen);
   dateElemen.click();

   
   String POamount = row.getCell(30).toString();
   WebElement POamountfield = wait.until(ExpectedConditions.elementToBeClickable(By.id("PO_Amount")));
   POamountfield.clear();
   POamountfield.sendKeys(POamount);
  
   wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmitApp"))).click();
	System.out.print("Estimate Approved");
	Thread.sleep(1000);
	
	String dynamicXpathh = "//td[contains(normalize-space(), '" + campaignname + "')]";

	WebElement campaignCell = null;

	for (int attempt = 1; attempt <= 3; attempt++) {
	    try {
	        // Wait for the cell to be clickable and re-fetch the element
	        campaignCell = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpathh)));

	        // Scroll into view (just in case)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", campaignCell);

	        // Click the cell (this will trigger rowClick(...))
	        campaignCell.click();

	        System.out.println("Clicked campaign: " + campaignname);
	        break;  // Exit the loop if the click is successful

	    } catch (StaleElementReferenceException e) {
	        System.out.println("Attempt " + attempt + ": StaleElementReferenceException - retrying...");
	    } catch (Exception e) {
	        System.out.println("Attempt " + attempt + ": Failed to click due to: " + e.getMessage());
	        break;  // Exit loop if any other error occurs
	    }
	}
	
	System.out.print("Estimate Outputs print");
	//Print Estimate
	Thread.sleep(2000);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));
	Thread.sleep(2000);
	new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
    
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/button"))).click();
	Thread.sleep(500);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/a"))).click();
	 try {
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingModal")));
		} catch (TimeoutException e) {
		    System.out.println("Loading modal did not disappear within timeout, continuing anyway...");
		}
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/input"))).click();
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
	 Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/button"))).click();
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/a"))).click();
	
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/span[2]/input"))).click();
		
	 wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
	 Thread.sleep(2000);
	//Print Orignal
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(
			    By.cssSelector("div.modal-body") // or a more precise selector if needed
			));
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/button"))).click();
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[2]/a"))).click();
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-body")));
	 Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/span[2]/input"))).click();
		
	
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(
			    By.cssSelector("div.modal-body") // or a more precise selector if needed
			));
	 //Estimate Schedule
	Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/button"))).click();
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[2]/a"))).click();
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-body")));
	 Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/input"))).click();
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(
			    By.cssSelector("div.modal-body") // or a more precise selector if needed
			));
	 //Estimate Schedule
	Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/button"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[4]/a"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/input"))).click();
	 
	 
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.id("Month1"))).click();
	 WebElement monthDropdown = driver.findElement(By.id("Month1"));

	// Wrap in Select class
	Select select = new Select(monthDropdown);

	// Get all options
	List<WebElement> optionss = select.getOptions();

	// Find and select the first valid (non-default) option
	for (WebElement option : optionss) {
	    String value = option.getAttribute("value");

	    // Skip the default 'Select' option
	    if (!value.equals("-1")) {
	        select.selectByValue(value);  // or select.selectByVisibleText(option.getText());
	        System.out.println("Selected month: " + option.getText());
	        break;
	    }
	}
	 
	WebElement monthDropdown1 = driver.findElement(By.id("Month2"));

	// Create Select instance
	Select select1 = new Select(monthDropdown1);

	// Get all available options
	List<WebElement> options1 = select1.getOptions();

	// Check there's more than just the default option
	if (options1.size() > 1) {
	    // Select the last option (ignoring the default 'Select' at index 0)
	    WebElement lastMonthOption = options1.get(options1.size() - 1);

	    // Select by value or visible text
	    select1.selectByValue(lastMonthOption.getAttribute("value"));
	    // OR: select.selectByVisibleText(lastMonthOption.getText());

	    System.out.println("Selected last month: " + lastMonthOption.getText());
	} else {
	    System.out.println("No valid month options found to select.");
	}
	 
	wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/button"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[4]/a"))).click();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/span[2]/input"))).click();
	//*[@id="loadingModal"]/div/div/div/div/section/fieldset[1]/legend[1]/span[2]/input
	
	WebElement monthDropdown12 = driver.findElement(By.id("Month"));

	// Wrap in Select class
	Select select11 = new Select(monthDropdown12);

	// Get all options
	List<WebElement> optionse = select11.getOptions();

	// Select the first valid option (skip default with value="-1")
	for (WebElement option : optionse) {
	    String value = option.getAttribute("value");
	    if (!value.equals("-1")) {
	        select11.selectByValue(value);  // Or use selectByVisibleText(option.getText())
	        System.out.println("Selected first month: " + option.getText());
	        break;
	    }
	}
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
	
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/button"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MainDiv\"]/div[1]/form/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[4]/a"))).click();
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/span[2]/input"))).click();	
	//*[@id="loadingModal"]/div/div/div/div/section/fieldset[1]/legend[1]/input
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"MonthSelection\"]/legend/span[2]/input"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.id("Month1"))).click();
		
	 WebElement monthDropdown13 = driver.findElement(By.id("Month1"));

		// Wrap in Select class
		Select sele = new Select(monthDropdown13);

		// Get all options
		List<WebElement> optioonss = sele.getOptions();

		// Find and select the first valid (non-default) option
		for (WebElement option : optioonss) {
		    String value = option.getAttribute("value");

		    // Skip the default 'Select' option
		    if (!value.equals("-1")) {
		        sele.selectByValue(value);  // or select.selectByVisibleText(option.getText());
		        System.out.println("Selected month: " + option.getText());
		        break;
		    }
		}
		 
		WebElement monthDropdown11 = driver.findElement(By.id("Month2"));

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", monthDropdown11);

		wait.until(ExpectedConditions.elementToBeClickable(monthDropdown11)).click();

		// Select logic
		Select select111 = new Select(monthDropdown11);
		List<WebElement> options11 = select111.getOptions();

		if (options11.size() > 1) {
		    WebElement lastMonthOption = options11.get(options11.size() - 1);
		    select111.selectByValue(lastMonthOption.getAttribute("value"));
		    System.out.println("Selected last month: " + lastMonthOption.getText());
		} else {
		    System.out.println("No valid month options found to select.");
		}

		 
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
	
	System.out.print("Estimate Outputs downloaded");
	
	System.out.print("RO Creation started");
	
	String xpathaddsidebar = "//*[@id=\"mySidebar\"]/div/div/span[3]";

    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
    for (int attemptss = 0; attemptss < 10; attemptss++) {
        try {
            // Find the element by XPath
            WebElement element = driver.findElement(By.xpath(xpathaddsidebar));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            Thread.sleep(1000);
            // Click the element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            System.out.println("Element clicked successfully!");
            break; // Exit the loop if the click is successful
        } catch (Exception e) {
        	
            // If an exception occurs, retry
            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
        }
    }
	
	
	
//	
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click(); 
//	
	 wait.until(ExpectedConditions.elementToBeClickable(
 		    By.xpath("//span[text()='Release']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
 		).click();

 
   
   WebElement ROTab2 = wait.until(ExpectedConditions.elementToBeClickable(
 		    By.xpath("//span[@class='navbarsubtext' and text()='RO']")
 		));
 		ROTab2.click();
  	
      Thread.sleep(2000);
      
 		wait.until(ExpectedConditions.elementToBeClickable(By.id("selectAllPub"))).click();	
 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'swal-button') and text()='OK']"))).click();	
 	
 		
 	
 		//WebElement generateROButton = driver.findElement(By.xpath("//button[contains(text(),'Generate RO')]"));
 		
 		
 		String xpathaddgeneratero = "//button[contains(text(),'Generate RO')]";

 	// Retry loop
 	for (int attemptss = 0; attemptss < 10; attemptss++) {
 	    try {
 	        // Find the scrollable div
 	        WebElement scrollableDiv = driver.findElement(By.cssSelector(".card.bg-white"));

 	        // Scroll all the way to the right
 	        
 	        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableDiv);

 	        // Wait a bit for scroll to finish (optional)
 	        Thread.sleep(500);

 	        // Find the target element
 	        WebElement element = driver.findElement(By.xpath(xpathaddgeneratero));

 	       
 	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);



 	        // Click the element
 	        element.click();

 	        System.out.println("Element clicked successfully!");
 	        break; // Exit loop if successful
 	    } catch (Exception e) {
 	        System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
 	    }
 	}

	

 		wait.until(ExpectedConditions.elementToBeClickable(By.id("BtnCall"))).click();	
 		
 		boolean clicker = false;

 		for (int attempt = 1; attempt <= 10; attempt++) {
 		    try {
 		        List<WebElement> closeButtons = driver.findElements(By.xpath("//*[@id=\"MessageModelCancel\"]/div/div/div[3]/button"));

 		        for (WebElement buttonr : closeButtons) {
 		            if (buttonr.isDisplayed() && buttonr.isEnabled()) {
 		                js.executeScript("arguments[0].scrollIntoView(true);", buttonr);
 		                js.executeScript("arguments[0].click();", buttonr);
 		                System.out.println("Close button clicked via JS successfully.");
 		                clicker = true;
 		                break;
 		            }
 		        }

 		        if (clicker) break;

 		        System.out.println("Attempt " + attempt + ": Close button not clickable yet.");
 		        Thread.sleep(500);
 		    } catch (Exception e) {
 		        System.out.println("Attempt " + attempt + " failed. Retrying...");
 		        Thread.sleep(500);
 		    }
 		}
 		
 		System.out.print("RO Created");
 		
 		
 		
 		String xpathaddsidebarreschedule = "//*[@id=\"mySidebar\"]/div/div/span[3]";

 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
 	        try {
 	            // Find the element by XPath
 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebarreschedule));
 	            Thread.sleep(1000);
 	            // Click the element
 	            element.click();
 	            System.out.println("Element clicked successfully!");
 	            break; // Exit the loop if the click is successful
 	        } catch (Exception e) {
 	            // If an exception occurs, retry
 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
 	        }
 	    }
 		
 		
 		
 	//	
// 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click(); 
 	//	
 		 wait.until(ExpectedConditions.elementToBeClickable(
 	 		    By.xpath("//span[text()='Release']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
 	 		).click();

 		Thread.sleep(2000);
 	   
 		WebElement rescheduleBtn = wait.until(ExpectedConditions.elementToBeClickable(
 			    By.xpath("//span[@class='navbarsubtext' and text()='Reschedule']")));

 			try {
 			    rescheduleBtn.click();
 			    System.out.println("Reschedule button clicked normally.");
 			} catch (ElementClickInterceptedException | TimeoutException e) {
 			    System.out.println("Click failed, trying JavaScript click: " + e.getMessage());
 			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rescheduleBtn);
 			    System.out.println("Clicked via JavaScript.");
 			}
 	  
 	// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ReschTable_filter\"]/label/input"))).click();
 	  Thread.sleep(4000);
 	  
 	// Correct XPath syntax: no backslashes needed
 	// Read value from Excel
 	 String rescheduleSearch = row.getCell(33).toString();  // Assuming cell 32 contains "Chennai"

 	 // Wait for the search input to be clickable and enter the value
 	 WebElement rescheduleSearchField = wait.until(ExpectedConditions.elementToBeClickable(
 	     By.xpath("//div[@id='ReschTable_filter']//input[@type='search']")
 	 ));
 	 rescheduleSearchField.clear();
 	 rescheduleSearchField.sendKeys(rescheduleSearch);


			
	WebElement firstCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox' and contains(@name,'ChkCshIDs')]")));
	firstCheckbox.click();
 	      

	// Step 1: Get day from Excel (e.g., "26")
	// Step 1: Get the day from correct Excel column
	String day = row.getCell(34).toString().trim();  // Make sure this contains something like "26"
	System.out.println("Date to click: " + day);
	Thread.sleep(5000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ScheduledDate")));
	// Step 2: Click the ScheduledDate input to open the datepicker
	WebElement dateFieldreschedule = wait.until(ExpectedConditions.elementToBeClickable(By.id("ScheduledDate")));
	dateFieldreschedule.click();

	// Step 3: Wait for the datepicker popup to be visible
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));

	List<WebElement> dayElements = driver.findElements(By.xpath(
		    "//div[contains(@class,'datepicker-days')]//td[not(contains(@class,'old')) and not(contains(@class,'new')) and normalize-space(text())='" + day + "']"
		));

		if (!dayElements.isEmpty()) {
		    WebElement dayElement = dayElements.get(0);

		    // Step 5: Wait until visible with a fallback retry mechanism
		    int attemptsr = 0;
		    boolean clicked1 = false;

		    while (attemptsr < 3 && !clicked1) {
		        try {
		        	 Thread.sleep(2000);
		            wait.until(ExpectedConditions.visibilityOf(dayElement));
		            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dayElement);
		            Thread.sleep(500); // Let scroll finish
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dayElement);
		            System.out.println("✅ Clicked on date: " + day);
		            clicked1 = true;
		        } catch (Exception e) {
		            System.out.println("⚠️ Attempt " + (attemptsr + 1) + ": Failed to click on date " + day + " - " + e.getMessage());
		            Thread.sleep(1000);
		            attemptsr++;
		        }
		    }

		    if (!clicked1) {
		        System.out.println("❌ Could not click on date: " + day + " after retries.");
		    }
			} else {
			System.out.println("❌ Date " + day + " not found in current calendar view.");
			}
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-footer")));
		Thread.sleep(4000);
		// Wait for modal to disappear (if any)
		// Wait for modal-footer to disappear
		new WebDriverWait(driver, Duration.ofSeconds(60))
		    .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-footer")));

		// Try waiting for datepicker to disappear, but don't crash if it doesn't
		try {
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("datepicker-days")));
		} catch (TimeoutException e) {
		    System.out.println("⚠️ Datepicker did not disappear in expected time.");
		}

		// Blur the date field (useful to close calendars)
		((JavascriptExecutor) driver).executeScript("arguments[0].blur();", dateFieldreschedule);

		// Replace Thread.sleep(5000) with explicit wait if possible, otherwise keep short wait
		Thread.sleep(3000); // Reduced wait to 3 sec for better responsiveness

		// Wait and click "Set Insertion" button
		WebElement submitButton0404 = wait.until(ExpectedConditions.elementToBeClickable(By.id("BtnSetInsertion")));
		submitButton0404.click();
		Thread.sleep(6000);
 // Reduced wait, replace if possible with explicit wait for next element

		// Scroll to and wait for submit button
		WebElement submitButton17 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnsubmit")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton17);
		Thread.sleep(500); // Allow scroll time

		try {
		    submitButton17.click();
		} catch (ElementClickInterceptedException e) {
		    System.out.println("⚠️ Click intercepted, retrying with JS");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton17);
		}
		Thread.sleep(6000);
		// Wait and click the "GenRoResch" button
		WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("GenRoResch")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);



		// Wait for and click the "Ok" button in popup
//		Thread.sleep(7000);
		
		boolean okClickedFinal = false;

		By okBtnLocator = By.xpath("//button[normalize-space(text())='Ok' and contains(@onclick, 'ClosePopUp')]");

		for (int finalOkAttempt = 1; finalOkAttempt <= 10; finalOkAttempt++) {
		    try {
		        System.out.println("🔁 Attempt " + finalOkAttempt + ": Looking for OK button...");

		      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(okBtnLocator));
		        // Scroll into view in center
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", okButton);
		        Thread.sleep(300); // allow scroll to settle

		        // Try clicking
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okButton);

		        System.out.println("✅ OK button clicked successfully on attempt " + finalOkAttempt);
		        okClickedFinal = true;
		        break;

		    } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
		        System.out.println("⚠️ Retryable exception on attempt " + finalOkAttempt + ": " + e.getMessage());
		    } catch (TimeoutException te) {
		        System.out.println("⏳ OK button not clickable in time on attempt " + finalOkAttempt);
		    } catch (Exception e) {
		        System.out.println("❌ Unexpected error on attempt " + finalOkAttempt + ": " + e.getMessage());
		    }

		    Thread.sleep(1000); // Small pause before retry
		}

		if (!okClickedFinal) {
		    throw new RuntimeException("❌ Failed to click OK button after 10 attempts.");
		}


		Thread.sleep(10000);
		Thread.sleep(3000);



	 
	String xpathaddsidebar1rescprint = "//*[@id=\"mySidebar\"]/div/div/span[3]";
	//
//	 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
	 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
	 	        try {
//	 	            // Find the element by XPath
	 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebar1rescprint));
	 	            Thread.sleep(1000);
	 	            // Click the element
	 	            element.click();
	 	            System.out.println("Element clicked successfully!");
	 	            break; // Exit the loop if the click is successful
	 	        } catch (Exception e) {
//	 	            // If an exception occurs, retry
	 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
	 	        }
	 	    }
 		
	 	   wait.until(ExpectedConditions.elementToBeClickable(
	 	 		    By.xpath("//span[text()='Print Documents']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
	 	 		).click();
 		
 		
	 	   
	 	  wait.until(ExpectedConditions.elementToBeClickable(
	 	 		    By.xpath("//*[@id=\"submenu_274\"]/ul/li[2]/a/span"))
	 	 		).click();
	 	  Thread.sleep(4000);	 	
	 	  
	 	  WebElement resexcel=wait.until(ExpectedConditions.presenceOfElementLocated(
	 	  By.id("RescheduleExcel")));
	 	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resexcel);
	 	 resexcel.click();
 		
	 	 System.out.print("RO Rescheule with output");
 		
 		
 		

	 		String xpathaddsidebarcancellation = "//*[@id=\"mySidebar\"]/div/div/span[3]";

	 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
	 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
	 	        try {
	 	            // Find the element by XPath
	 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebarcancellation));
	 	            Thread.sleep(1000);
	 	            // Click the element
	 	            element.click();
	 	            System.out.println("Element clicked successfully!");
	 	            break; // Exit the loop if the click is successful
	 	        } catch (Exception e) {
	 	            // If an exception occurs, retry
	 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
	 	        }
	 	    }
	 		
	 		
	 		
	 	//	
//	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click(); 
	 	//	
	 		 wait.until(ExpectedConditions.elementToBeClickable(
	 	 		    By.xpath("//span[text()='Release']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
	 	 		).click();

	 		Thread.sleep(2000);
	 	   
	 	   WebElement ROCancellation = wait.until(ExpectedConditions.elementToBeClickable(
	 	 		    By.xpath("//span[@class='navbarsubtext' and text()='Cancellation']")
	 	 		));
	 	  ROCancellation.click();
	 	  
	 	// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ReschTable_filter\"]/label/input"))).click();
	 	  Thread.sleep(4000);
	 	  
	 	 String cancellationSearch = row.getCell(35).toString();  // Assuming cell 32 contains "Chennai"

	 	 // Wait for the search input to be clickable and enter the value
	 	 WebElement cancellationSearchField = wait.until(ExpectedConditions.elementToBeClickable(
	 	     By.xpath("//*[@id=\"CanTable_filter\"]/label/input")
	 	 ));
	 	cancellationSearchField.clear();
	 	cancellationSearchField.sendKeys(cancellationSearch);
	 	wait.until(ExpectedConditions.elementToBeClickable(
		 	     By.xpath("//input[@type='checkbox' and contains(@name,'ScheduleID')]")
		 	 ));
	 	WebElement firstCheckbox0 = driver.findElement(By.xpath("//input[@type='checkbox' and contains(@name,'ScheduleID')]"));
	 	firstCheckbox0.click();
		
	 	WebElement submitButton11 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnsubmit")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton11);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton11);
	 	
		WebElement saveButton1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("GenRoCan")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton1);
		
	 	boolean clicked2 = false;

	 	for (int attempt1 = 1; attempt1 <= 10; attempt1++) {
	 	    try {
	 	        List<WebElement> okButtons1 = driver.findElements(
	 	            By.xpath("//button[normalize-space(text())='Ok' and contains(@onclick, 'ClosePopUp')]")
	 	        );

	 	        if (!okButtons1.isEmpty()) {
	 	            WebElement okBtn = okButtons1.get(0);
	 	           js.executeScript("arguments[0].scrollIntoView({block:'center'});", okBtn);
	 	            Thread.sleep(300); // slight delay after scroll
	 	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn);

	 	            System.out.println("✅ OK button clicked successfully on attempt " + attempt1);
	 	            clicked2 = true;
	 	            break; // success, exit loop
	 	        } else {
	 	            System.out.println("❌ Attempt " + attempt1 + ": OK button not found.");
	 	        }

	 	    } catch (Exception e) {
	 	        System.out.println("⚠️ Attempt " + attempt1 + ": Exception occurred - " + e.getMessage());
	 	    }

	 	    try {
	 	        Thread.sleep(1000); // wait before next attempt
	 	    } catch (InterruptedException ie) {
	 	        Thread.currentThread().interrupt();
	 	    }
	 	}

	 	if (!clicked2) {
	 	    System.out.println("❌ Failed to click OK button after 10 attempts.");
	 	}


	 	String xpathaddsidebar1canprint = "//*[@id=\"mySidebar\"]/div/div/span[3]";
		//
//		 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
		 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
		 	        try {
//		 	            // Find the element by XPath
		 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebar1canprint));
		 	            Thread.sleep(1000);
		 	            // Click the element
		 	            element.click();
		 	            System.out.println("Element clicked successfully!");
		 	            break; // Exit the loop if the click is successful
		 	        } catch (Exception e) {
//		 	            // If an exception occurs, retry
		 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
		 	        }
		 	    }
	 		
		 	   wait.until(ExpectedConditions.elementToBeClickable(
		 	 		    By.xpath("//span[text()='Print Documents']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
		 	 		).click();
	 		
	 		
		 	   
		 	  wait.until(ExpectedConditions.elementToBeClickable(
		 	 		    By.xpath("//*[@id=\"submenu_274\"]/ul/li[3]/a/span"))
		 	 		).click();
		 	  Thread.sleep(4000);	 	
		 	  
		 	  wait.until(ExpectedConditions.elementToBeClickable(
		 	  By.id("DocPDF"))
		 	 		).click();
	 		
		 	 System.out.print("RO Cancellation with output");
	 	
		 	String xpathaddsidebarmakegood = "//*[@id=\"mySidebar\"]/div/div/span[3]";
	 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
	 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
	 	        try {
	 	            // Find the element by XPath
	 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebarmakegood));
	 	            Thread.sleep(1000);
	 	            // Click the element
	 	            element.click();
	 	            System.out.println("Element clicked successfully!");
	 	            break; // Exit the loop if the click is successful
	 	        } catch (Exception e) {
	 	            // If an exception occurs, retry
	 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
	 	        }
	 	    }
	 		
	 		
	 		
	 	//	
//	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
	 	//	
	 		 wait.until(ExpectedConditions.elementToBeClickable(
	 	 		    By.xpath("//span[text()='Release']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
	 	 		).click();
	 		Thread.sleep(2000);
	 	  
	 	   WebElement ROMakeGood = wait.until(ExpectedConditions.elementToBeClickable(
	 	 		    By.xpath("//span[@class='navbarsubtext' and text()='Make Good']")
	 	 		));
	 	  try {
	 		 ROMakeGood.click();
			    System.out.println("Reschedule button clicked normally.");
			} catch (ElementClickInterceptedException | TimeoutException e) {
			    System.out.println("Click failed, trying JavaScript click: " + e.getMessage());
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ROMakeGood);
			    System.out.println("Clicked via JavaScript.");
			}

	 	 
	 	// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ReschTable_filter\"]/label/input"))).click();
	 	  Thread.sleep(4000);
	 	 
	 	// Correct XPath syntax: no backslashes needed
	 	// Read value from Excel
	 	 String makegoodSearch = row.getCell(36).toString();  // Assuming cell 32 contains "Chennai"
	 	 // Wait for the search input to be clickable and enter the value
	 	 WebElement makegoodSearchField = wait.until(ExpectedConditions.elementToBeClickable(
	 	     By.xpath("//*[@id=\"ReschTable_filter\"]/label/input")
	 	 ));
	 	 makegoodSearchField.clear();
	 	 makegoodSearchField.sendKeys(makegoodSearch);
				
		WebElement firstCheckbox1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox' and contains(@name,'ChkCshIDs')]")));
		firstCheckbox1.click();
		Thread.sleep(2000);  
		// Step 1: Get day from Excel (e.g., "26")
		// Step 1: Get the day from correct Excel column
		String day1 = row.getCell(37).toString().trim();  // Make sure this contains something like "26"
		System.out.println("Date to click: " + day1);
		// Step 2: Click the ScheduledDate input to open the datepicker
		WebElement dateFieldmakegood = wait.until(ExpectedConditions.elementToBeClickable(By.id("ScheduledDate")));
		dateFieldmakegood.click();
		Thread.sleep(2000);
		// Step 3: Wait for the datepicker popup to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));
		// Step 4: Click on the day in the calendar
		Thread.sleep(2000);
		List<WebElement> dayElements1 = driver.findElements(By.xpath(
			    "//div[contains(@class,'datepicker-days')]//td[not(contains(@class,'old')) and not(contains(@class,'new')) and normalize-space(text())='" + day1 + "']"
			));

			if (!dayElements1.isEmpty()) {
			    WebElement dayElement1 = dayElements1.get(0);

			    // Step 5: Wait until visible with a fallback retry mechanism
			    int attemptsr = 0;
			    boolean clicked1 = false;

			    while (attemptsr < 3 && !clicked1) {
			        try {
			        	 Thread.sleep(2000);
			            wait.until(ExpectedConditions.visibilityOf(dayElement1));
			            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", dayElement1);
			            Thread.sleep(500); // Let scroll finish
			            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dayElement1);
			            System.out.println("✅ Clicked on date: " + day1);
			            clicked1 = true;
			        } catch (Exception e) {
			            System.out.println("⚠️ Attempt " + (attemptsr + 1) + ": Failed to click on date " + day1 + " - " + e.getMessage());
			            Thread.sleep(1000);
			            attemptsr++;
			        }
			    }

			    if (!clicked1) {
			        System.out.println("❌ Could not click on date: " + day1 + " after retries.");
			    }
				} else {
				System.out.println("❌ Date " + day1 + " not found in current calendar view.");
				}
			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-footer")));
			Thread.sleep(4000);
			// Wait for modal to disappear (if any)
			// Wait for modal-footer to disappear
			new WebDriverWait(driver, Duration.ofSeconds(30))
			    .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-footer")));

			// Try waiting for datepicker to disappear, but don't crash if it doesn't
			try {
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("datepicker-days")));
			} catch (TimeoutException e) {
			    System.out.println("⚠️ Datepicker did not disappear in expected time.");
			}

			// Blur the date field (useful to close calendars)
			((JavascriptExecutor) driver).executeScript("arguments[0].blur();", dateFieldmakegood);

			// Replace Thread.sleep(5000) with explicit wait if possible, otherwise keep short wait
			Thread.sleep(3000); // Reduced wait to 3 sec for better responsiveness

		Thread.sleep(2000);
		// Step 5: Click the submit button
		
		
		
		
		
		WebElement submitButton004 = wait.until(ExpectedConditions.elementToBeClickable(By.id("BtnSetInsertion")));
		submitButton004.click();
		Thread.sleep(2000);
		WebElement submitButton005 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnsubmit")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton005);
		Thread.sleep(500);

		// Try clicking submit button, retry with JS if click intercepted
		try {
			submitButton005.click();
		} catch (ElementClickInterceptedException e) {
		    System.out.println("⚠️ Click intercepted, retrying with JS");
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton005);
		}

		Thread.sleep(2000);
		WebElement saveButton100 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("GenRoResch")));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton100);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton100);

		Thread.sleep(2000);
		boolean clicked4 = false;

		for (int attempt5 = 1; attempt5 <= 10; attempt5++) {
		    try {
		        List<WebElement> okButtons6 = driver.findElements(
		            By.xpath("//button[normalize-space(text())='Ok' and contains(@onclick, 'ClosePopUp')]")
		        );

		        if (!okButtons6.isEmpty()) {
		            WebElement okBtn7 = okButtons6.get(0);
		            
		            if (okBtn7.isDisplayed() && okBtn7.isEnabled()) {
		                ((JavascriptExecutor) driver).executeScript(
		                    "arguments[0].scrollIntoView({block: 'center'});", okBtn7
		                );
		                Thread.sleep(300); // Delay after scroll (can tweak this)
		                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn7);

		                System.out.println("✅ OK button clicked successfully on attempt " + attempt5);
		                clicked4 = true;
		                break;
		            } else {
		                System.out.println("⚠️ Attempt " + attempt5 + ": OK button found but not interactable yet.");
		            }
		            Thread.sleep(300); // slight delay after scroll
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn7);

		            System.out.println("✅ OK button clicked successfully on attempt " + attempt5);
		            clicked4 = true;
		            break; // success, exit loop
		        } else {
		            System.out.println("❌ Attempt " + attempt5 + ": OK button not found.");
		        }

		    } catch (Exception e) {
		        System.out.println("⚠️ Attempt " + attempt5 + ": Exception occurred - " + e.getMessage());
		    }

		    try {
		        Thread.sleep(1000); // wait before next attempt
		    } catch (InterruptedException ie) {
		        Thread.currentThread().interrupt();
		    }
		}

		if (!clicked4) {
		    System.out.println("❌ Failed to click OK button after 10 attempts.");
		}

		 Thread.sleep(2000);
		 String xpathaddsidebar1makegoodrint = "//*[@id=\"mySidebar\"]/div/div/span[3]";
			//
//			 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
			 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
			 	        try {
//			 	            // Find the element by XPath
			 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebar1makegoodrint));
			 	            Thread.sleep(1000);
			 	            // Click the element
			 	            element.click();
			 	            System.out.println("Element clicked successfully!");
			 	            break; // Exit the loop if the click is successful
			 	        } catch (Exception e) {
//			 	            // If an exception occurs, retry
			 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
			 	        }
			 	    }

 		 wait.until(ExpectedConditions.elementToBeClickable(
 	 		    By.xpath("//span[text()='Print Documents']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
 	 		).click();

 	 
 		Thread.sleep(2000);
 		 wait.until(ExpectedConditions.elementToBeClickable(
	 	 		    By.xpath("//*[@id=\"submenu_274\"]/ul/li[4]/a/span"))
	 	 		).click();

 			
 			
 			  WebElement mgoodex=wait.until(ExpectedConditions.presenceOfElementLocated(
 				 	  By.id("MakeGoodExlOwtput")));
 				 	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mgoodex);
 				 	mgoodex.click();
 				 	 System.out.print("RO Makgeood with output");

 			Thread.sleep(2000);
 			
 			

 	 		String xpathaddsidebar1 = "//*[@id=\"mySidebar\"]/div/div/span[3]";

 	 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
 	 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
 	 	        try {
 	 	            // Find the element by XPath
 	 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebar1));
 	 	            Thread.sleep(1000);
 	 	            // Click the element
 	 	            element.click();
 	 	            System.out.println("Element clicked successfully!");
 	 	            break; // Exit the loop if the click is successful
 	 	        } catch (Exception e) {
 	 	            // If an exception occurs, retry
 	 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
 	 	        }
 	 	    }
 	 		
 	 		
 	 		
 	 	//	
// 	 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click(); 
 	 	//	
 	 		 wait.until(ExpectedConditions.elementToBeClickable(
 	 	 		    By.xpath("//span[text()='Print Documents']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
 	 	 		).click();

 	 	 
 	 	   
 	 		WebElement roTab = wait.until(ExpectedConditions.elementToBeClickable(
 	 			    By.xpath("//*[@id=\"submenu_274\"]/ul/li[1]/a")
 	 			));
 	 			roTab.click();
 	 			Thread.sleep(3000);
 	 			 wait.until(ExpectedConditions.presenceOfElementLocated(
 	 	 			    By.xpath("//a[contains(@onclick,'PrintPopUp') and contains(@href,'PrintReleaseOrderPrinting')]")));
 	 			// Wait for the checkbox row to be present
 	 			WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(
 	 			    By.xpath("//input[contains(@id, 'ChkROSelect_')]")
 	 			));

 	 			// Navigate to the parent row
 	 			WebElement parentRow = checkbox.findElement(By.xpath("./ancestor::tr"));

 	 			// Find the 2nd <td> (which holds the RO number)
 	 			WebElement roNumberCell = parentRow.findElement(By.xpath("./td[2]"));

 	 			// Extract the RO number text
 	 			String roNumber = roNumberCell.getText().trim();

 	 			System.out.println("Fetched RO Number: " + roNumber);

 	 	 		WebElement printLink = driver.findElement(By.xpath("//a[contains(@onclick,'PrintPopUp') and contains(@href,'PrintReleaseOrderPrinting')]"));

 	 	 	// Scroll into view (optional but safer if it's out of view)
 	 	 	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", printLink);

 	 	 	// Click the print icon link
 	 	 	printLink.click();

 	 	 	
 	 	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/span[2]/input"))).click();	
 	 		//*[@id="loadingModal"]/div/div/div/div/section/fieldset[1]/legend[1]/input
 	 		
 	 	 	wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
 	 	 	 wait.until(ExpectedConditions.elementToBeClickable(
 		 			    By.xpath("//a[contains(@onclick,'PrintPopUp') and contains(@href,'PrintReleaseOrderPrinting')]")));
 		 		WebElement printLink1 = driver.findElement(By.xpath("//a[contains(@onclick,'PrintPopUp') and contains(@href,'PrintReleaseOrderPrinting')]"));

 		 	// Scroll into view (optional but safer if it's out of view)
 		 	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", printLink1);

 		 	// Click the print icon link
 		 	printLink1.click();

 		 	Thread.sleep(3000);
 		 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loadingModal\"]/div/div/div/div/section/fieldset[1]/legend[1]/input"))).click();	
 			//*[@id="loadingModal"]/div/div/div/div/section/fieldset[1]/legend[1]/input
 		 	Thread.sleep(3000);
 		 	wait.until(ExpectedConditions.elementToBeClickable(By.id("btnOK"))).click();
 		 	
 		 	Thread.sleep(3000);
 			String xpathaddsidebar2 = "//*[@id=\"mySidebar\"]/div/div/span[3]";

 	 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
 	 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
 	 	        try {
 	 	            // Find the element by XPath
 	 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebar2));
 	 	            Thread.sleep(1000);
 	 	            // Click the element
 	 	            element.click();
 	 	            System.out.println("Element clicked successfully!");
 	 	            break; // Exit the loop if the click is successful
 	 	        } catch (Exception e) {
 	 	            // If an exception occurs, retry
 	 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
 	 	        }
 	 	    }
 	 		
 	 	   wait.until(ExpectedConditions.elementToBeClickable(
 		 		    By.xpath("//span[text()='Billing']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
 		 		).click();

 		 
 	 	  WebElement logvendorbillTab = wait.until(ExpectedConditions.elementToBeClickable(
 	  		    By.xpath("//span[@class='navbarsubtext' and text()='Log Vendor Bill']")
 	  		));
 	 	 logvendorbillTab.click();
 		 	
 	 	// Wait until the label is visible
 	 
 	 	
 	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreateNewVB"))).click();
 	 	
 	 	

 	 	WebElement roNumberButton = wait.until(ExpectedConditions.elementToBeClickable(
 	 	    By.xpath("//button[contains(text(),'RO Number') and @onclick='LoadROList();']")
 	 	));

 	 	roNumberButton.click();
 	 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ROListTable_filter\"]/label/input")));
 	 	WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"ROListTable_filter\"]/label/input"));
 	 	searchInput.clear();  // Optional: clear any pre-filled text
 	 	searchInput.sendKeys(roNumber);
 	 	
 	 	
 	 	WebElement firstRadioButton = wait.until(ExpectedConditions.elementToBeClickable(
 	 		    By.cssSelector("input[type='radio'][data-rono^='RO/']")
 	 		));

 	 		// Click the radio button
 	 		firstRadioButton.click();
 	 		  
 	 		String Vendorbillno = row.getCell(31).toString();
 	 		WebElement Vendorbillnofield = wait.until(ExpectedConditions.elementToBeClickable(By.id("VendorBillNo_VBLog")));
 	 		Vendorbillnofield.sendKeys(Vendorbillno);
 	 		wait.until(ExpectedConditions.elementToBeClickable(By.id("VendorBillDate_VBLog"))).click();
 	 		
 	 	
 	 	    String vendorbilldate = row.getCell(32).toString().trim();

 			// Remove decimal point if any (e.g., convert "10.0" to "10")
 	   vendorbilldate = vendorbilldate.split("\\.")[0];
 			// Output for debugging: Make sure that the correct date value is being read
 			
 			
 	   	WebElement dateElementvbilldate = wait.until(ExpectedConditions.elementToBeClickable(
 			    By.xpath("//td[contains(@class,'day') and not(contains(@class,'old')) and not(contains(@class,'new')) and text()='" + vendorbilldate + "']")
 			));

 			// Click the correct day
 			dateElementvbilldate.click();
 			Thread.sleep(2000);
 			wait.until(ExpectedConditions.elementToBeClickable(By.id("submitWithourRo"))).click();
 			Thread.sleep(2000);

 			WebElement okButton170 = wait.until(ExpectedConditions.elementToBeClickable(
 				    By.xpath("//button[text()='OK' and contains(@class,'swal-button--confirm')]")));
 				okButton170.click();
 				Thread.sleep(3000);
 				
 				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"chkallPublicationInser\"]"))).click();
 				Thread.sleep(3000);
 				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"verifyAndContinue\"]"))).click();
 				Thread.sleep(3000);
 				
 				String xpathaddsidebar3 = "//*[@id=\"mySidebar\"]/div/div/span[3]";
 				System.out.print("Log vendor bill and verify completed");
 		 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
 		 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
 		 	        try {
 		 	            // Find the element by XPath
 		 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebar3));
 		 	            Thread.sleep(1000);
 		 	            // Click the element
 		 	            element.click();
 		 	            System.out.println("Element clicked successfully!");
 		 	            break; // Exit the loop if the click is successful
 		 	        } catch (Exception e) {
 		 	            // If an exception occurs, retry
 		 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
 		 	        }
 		 	    }
 		 		System.out.print("Client Bill Generation starting");
 			   wait.until(ExpectedConditions.elementToBeClickable(
 			 		    By.xpath("//span[text()='Billing']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
 			 		).click();
 			   
 			  WebElement clientbillTab = wait.until(ExpectedConditions.elementToBeClickable(
 			  		    By.xpath("//span[@class='navbarsubtext' and text()='Client Bill']")
 			  		));
 			 	 clientbillTab.click();
 			 	 
 			 	 
 			 	wait.until(ExpectedConditions.elementToBeClickable(
 			  		    By.xpath("//*[@id=\"btnsubmit\"]")
 			  		)).click();
 			 	 Thread.sleep(2000);
 			 	wait.until(ExpectedConditions.elementToBeClickable(
 			  		    By.xpath("//*[@id=\"chkallPublicationInser\"]")
 			  		)).click();
	
 			 	String xpathaddgenerateclientbill = "//button[contains(text(),'Generate Bill')]";

 			 	// Retry loop
 			 	for (int attemptss = 0; attemptss < 10; attemptss++) {
 			 	    try {
 			 	        // Find the scrollable div
 			 	        WebElement scrollableDiv = driver.findElement(By.cssSelector(".card.bg-white"));

 			 	        // Scroll all the way to the right
 			 	        
 			 	        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableDiv);

 			 	        // Wait a bit for scroll to finish (optional)
 			 	        Thread.sleep(2000);

 			 	        // Find the target element
 			 	        WebElement element = driver.findElement(By.xpath(xpathaddgenerateclientbill));

 			 	        // Scroll to the element
 			 	       
 			 	      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);


 			 	        // Click the element
 			 	        element.click();

 			 	        System.out.println("Element clicked successfully!");
 			 	        break; // Exit loop if successful
 			 	    } catch (Exception e) {
 			 	        System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
 			 	    }
 			 	}

 			 	 
 		      
 		        
 			 	boolean clickeddd = false;
 			 	int attempt = 0;

 			 	while (!clickeddd && attempt < 3) {
 			 	    try {
 			 	        Thread.sleep(6000);

 			 	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("BtnSubmitOB")));

 			 	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
 			 	        Thread.sleep(500); // let scroll settle

 			 	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
 			 	        System.out.println("Client Bill Generated");

 			 	        // Wait for expected result (confirmation, URL change, etc.)
 			 	       

 			 	        clickeddd = true;

 			 	    } catch (Exception e) {
 			 	        System.out.println("Attempt " + (attempt + 1) + " failed: " + e.getMessage());
 			 	        attempt++;
 			 	    }
 			 	}
 			 	Thread.sleep(4000);
 			 	WebElement okButton11 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"OBNumberMsg\"]/div/div/div/div[3]/button")));

 			// Scroll the button into view
 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", okButton11);
 			Thread.sleep(500);  // Let the scroll settle

 			// Click the button
 			okButton11.click();
		 	
 			boolean clicked14 = false;
 			int attempts14 = 0;

 			while (!clicked14 && attempts14 < 3) {
 			    try {
 			        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(60));

 			        WebElement element = shortWait.until(
 			            ExpectedConditions.refreshed(
 			                ExpectedConditions.elementToBeClickable(
 			                    By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[2]/form/div[3]/div/div[2]/div/div/div[2]/div/table/tbody/tr/td[7]/a[1]")
 			                )
 			            )
 			        );

 			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
 			        Thread.sleep(500); // Let scroll complete

 			        element.click();
 			       System.out.println(" Click successful.");
 			        clicked = true;

 			    } catch (StaleElementReferenceException e) {
 			        System.out.println(" Attempt " + (attempts + 1) + ": stale element, retrying...");
 			        attempts++;
 			        Thread.sleep(1000);
 			    } catch (Exception e) {
 			        System.out.println(" Other error: " + e.getMessage());
 			        break;
 			    }
 			}

 			if (!clicked) {
 			    throw new RuntimeException(" Element not clickable after 3 attempts.");
 			}
 			 	 
 			 	WebElement buttonOB = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnGenerateCB")));

 			// Scroll the button into view
 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonOB);
 			Thread.sleep(500); // Optional: Allow the scroll to settle

 			// Wait for the button to be clickable (useful if it’s hidden behind something)
 			wait.until(ExpectedConditions.elementToBeClickable(buttonOB));

 			// Click the button
 			buttonOB.click();
 			System.out.println("Print button clicked successfully");
 			 	 
 			 	

 	 			boolean clicked15 = false;
 	 			int attempts15 = 0;

 	 			while (!clicked15 && attempts15 < 3) {
 	 			    try {
 	 			        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(60));

 	 			        WebElement element = shortWait.until(
 	 			            ExpectedConditions.refreshed(
 	 			                ExpectedConditions.elementToBeClickable(
 	 			                    By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[2]/form/div[3]/div/div[2]/div/div/div[2]/div/table/tbody/tr/td[7]/a[2]")
 	 			                )
 	 			            )
 	 			        );

 	 			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
 	 			        Thread.sleep(500); // Let scroll complete

 	 			        element.click();
 	 			       System.out.println("Click successful.");
 	 			        clicked = true;

 	 			    } catch (StaleElementReferenceException e) {
 	 			        System.out.println("Attempt " + (attempts + 1) + ": stale element, retrying...");
 	 			        attempts++;
 	 			        Thread.sleep(1000);
 	 			    } catch (Exception e) {
 	 			        System.out.println(" Other error: " + e.getMessage());
 	 			        break;
 	 			    }
 	 			}
 			 	 
 				WebElement buttonOBexcel = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("BtnClickToPrint")));

 	 			// Scroll the button into view
 	 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonOBexcel);
 	 			Thread.sleep(500); // Optional: Allow the scroll to settle

 	 			// Wait for the button to be clickable (useful if it’s hidden behind something)
 	 			wait.until(ExpectedConditions.elementToBeClickable(buttonOBexcel));

 	 			// Click the button
 	 			buttonOBexcel.click();
 	 			
 	 			System.out.println("Print button clicked successfully");
 	 			
			 	 Thread.sleep(2000);
			 	 String xpathaddsidebar00 = "//*[@id=\"mySidebar\"]/div/div/span[3]";
	 			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mySidebar\"]/div/div/span[3]")));
	 					
	 		    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
	 		    for (int attemptss = 0; attemptss < 10; attemptss++) {
	 		        try {
	 		            // Find the element by XPath
	 		            WebElement element = driver.findElement(By.xpath(xpathaddsidebar00));
	 		            Thread.sleep(1000);
	 		            // Click the element
	 		            element.click();
	 		            System.out.println("Element clicked successfully!");
	 		            break; // Exit the loop if the click is successful
	 		        } catch (Exception e) {
	 		            // If an exception occurs, retry
	 		            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
	 		        }
	 		    }
	 		    
	 		    
	 		    
	 		    
	 		    
	 		   wait.until(ExpectedConditions.elementToBeClickable(
			 		    By.xpath("//span[text()='Billing']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
			 		).click();
			   
	 		// If it's the 3rd occurrence of "IB Booking"
	 		 WebElement ibBookingTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
	 			    By.xpath("//span[@class='navbarsubtext' and text()='IB Booking']")
	 			));
	 			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ibBookingTab);

			 	 Thread.sleep(3000);
			 	 wait.until(ExpectedConditions.elementToBeClickable(By.id("btnsubmit"))).click();
				 	 
				 	 
			 	Thread.sleep(2000);	 
			 	
			 	 wait.until(ExpectedConditions.elementToBeClickable( By.id("BtnBookIB"))).click();
			 	 
			 	 wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//button[text()='Book IB']")));
 			 	WebElement bookIbBtn = driver.findElement(By.xpath("//button[text()='Book IB']"));
			 	bookIbBtn.click();
			 	
			 	wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//button[text()='Ok' and contains(@onclick, 'ClosePopUp')]")));
			 	WebElement okButton101 = driver.findElement(By.xpath("//button[text()='Ok' and contains(@onclick, 'ClosePopUp')]"));
			 	okButton101.click();
			 	new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
			 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingModalClientBill")));
			 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ModalOBPrinting")));
			 	Thread.sleep(300); 
			 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("IBExcel")));
			 	WebElement buttonIBbookingexcel = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IBExcel")));

 	 			// Scroll the button into view
 	 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonIBbookingexcel);
 	 			Thread.sleep(500); // Optional: Allow the scroll to settle

 	 			// Wait for the button to be clickable (useful if it’s hidden behind something)
 	 			wait.until(ExpectedConditions.elementToBeClickable(buttonIBbookingexcel));

 	 			// Click the button
 	 			buttonIBbookingexcel.click();
 	 			
 	 			System.out.println("IB booked and output printed");
 	 			
			 	Thread.sleep(400);
//			 	wait.until(ExpectedConditions.elementToBeClickable( By.id("IBCancel")));
//			 	WebElement ibcancel101 = driver.findElement(By.id("IBCancel"));
//			 	ibcancel101.click();
//			 	Thread.sleep(400);
//			 	wait.until(ExpectedConditions.elementToBeClickable( By.id("btnOBYes")));
//			 	WebElement ibcancelyes101 = driver.findElement(By.id("btnOBYes"));
//			 	ibcancelyes101.click();
//			   WebElement okButtonibcancel = wait.until(ExpectedConditions.elementToBeClickable(
//				        By.xpath("//button[@onclick='return ClosePopUp();' and text()='Ok']")));
//
//				    // Scroll into view if necessary
//				    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", okButtonibcancel);
//
//				    // Try regular click first
//				   okButtonibcancel.click();
			 	String xpathaddsidebar17 = "//*[@id=\"mySidebar\"]/div/div/span[3]";

			    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
			    for (int attemptss = 0; attemptss < 10; attemptss++) {
			        try {
			            // Find the element by XPath
			            WebElement element = driver.findElement(By.xpath(xpathaddsidebar17));
			            Thread.sleep(1000);
			            // Click the element
			            element.click();
			            System.out.println("Element clicked successfully!");
			            break; // Exit the loop if the click is successful
			        } catch (Exception e) {
			            // If an exception occurs, retry
			            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
			        }
			    }
				
				
				
			//	
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click(); 
			//	
				 wait.until(ExpectedConditions.elementToBeClickable(
			 		    By.xpath("//span[text()='Release']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
			 		).click();

			 
			   
			   WebElement ROTab1 = wait.until(ExpectedConditions.elementToBeClickable(
			 		    By.xpath("//span[@class='navbarsubtext' and text()='RO']")
			 		));
			 		ROTab1.click();
			  	
			      Thread.sleep(2000);
			      
			 		wait.until(ExpectedConditions.elementToBeClickable(By.id("selectAllPub"))).click();	
			 		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'swal-button') and text()='OK']"))).click();	
			 	
			 		
			 	
			 		//WebElement generateROButton = driver.findElement(By.xpath("//button[contains(text(),'Generate RO')]"));
			 		
			 		
			 		String xpathaddgeneratero1 = "//button[contains(text(),'Generate RO')]";

			 	// Retry loop
			 	for (int attemptss = 0; attemptss < 10; attemptss++) {
			 	    try {
			 	        // Find the scrollable div
			 	        WebElement scrollableDiv = driver.findElement(By.cssSelector(".card.bg-white"));

			 	        // Scroll all the way to the right
			 	        
			 	        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableDiv);

			 	        // Wait a bit for scroll to finish (optional)
			 	        Thread.sleep(10000);

			 	        // Find the target element
			 	        WebElement element = driver.findElement(By.xpath(xpathaddgeneratero1));
			 	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);


			 	        // Scroll to the element
			 	       // js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);

			 	        // Click the element
			 	        element.click();

			 	        System.out.println("Element clicked successfully!");
			 	        break; // Exit loop if successful
			 	    } catch (Exception e) {
			 	        System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
			 	    }
			 	}

				
			 	Thread.sleep(3000);			 		
			 	wait.until(ExpectedConditions.elementToBeClickable(By.id("BtnCall"))).click();	
			 	
			 		
			 		boolean clicker1 = false;

			 		for (int attempt1 = 1; attempt1 <= 10; attempt1++) {
			 		    try {
			 		        List<WebElement> closeButtons = driver.findElements(By.xpath("//*[@id=\"MessageModelCancel\"]/div/div/div[3]/button"));

			 		        for (WebElement buttonr : closeButtons) {
			 		            if (buttonr.isDisplayed() && buttonr.isEnabled()) {
			 		                js.executeScript("arguments[0].scrollIntoView(true);", buttonr);
			 		                js.executeScript("arguments[0].click();", buttonr);
			 		                System.out.println("Close button clicked via JS successfully.");
			 		                clicker1 = true;
			 		                break;
			 		            }
			 		        }

			 		        if (clicker1) break;

			 		        System.out.println("Attempt " + attempt1 + ": Close button not clickable yet.");
			 		        Thread.sleep(500);
			 		    } catch (Exception e) {
			 		        System.out.println("Attempt " + attempt + " failed. Retrying...");
			 		        Thread.sleep(500);
			 		    }
			 		}
			 		
			 		System.out.print("RO Created for IB provision"); 	 
			 		
			 		String xpathaddsidebar4 = "//*[@id=\"mySidebar\"]/div/div/span[3]";
	 				System.out.print("Log vendor bill and verify completed");
	 		 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
	 		 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
	 		 	        try {
	 		 	            // Find the element by XPath
	 		 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebar4));
	 		 	            Thread.sleep(1000);
	 		 	            // Click the element
	 		 	            element.click();
	 		 	            System.out.println("Element clicked successfully!");
	 		 	            break; // Exit the loop if the click is successful
	 		 	        } catch (Exception e) {
	 		 	            // If an exception occurs, retry
	 		 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
	 		 	        }
	 		 	    }
	 		 		System.out.print("Client Bill Generation starting");
	 			   wait.until(ExpectedConditions.elementToBeClickable(
	 			 		    By.xpath("//span[text()='Billing']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
	 			 		).click();
	 			   
	 			  WebElement clientbillTab1 = wait.until(ExpectedConditions.elementToBeClickable(
	 			  		    By.xpath("//span[@class='navbarsubtext' and text()='Client Bill']")
	 			  		));
	 			 	 clientbillTab1.click();
	 			 	 
	 			 	wait.until(ExpectedConditions.elementToBeClickable(
	 			  		    By.xpath("//*[@id=\"btnsubmit\"]")
	 			  		)).click();
	 			 	 Thread.sleep(2000);
	 			 	boolean isCheckboxClicked = false;

	 			 	for (int pubChkAttempt = 1; pubChkAttempt <= 10; pubChkAttempt++) {
	 			 	    try {
	 			 	        WebElement pubCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
	 			 	            By.xpath("//*[@id='chkallPublicationInser']"))
	 			 	        );

	 			 	       
	 			 	      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", pubCheckbox);


	 			 	        Thread.sleep(300); // allow scroll to complete

	 			 	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pubCheckbox);

	 			 	        System.out.println("✅ Checkbox clicked on attempt " + pubChkAttempt);
	 			 	        isCheckboxClicked = true;
	 			 	        break;

	 			 	    } catch (Exception e) {
	 			 	        System.out.println("⚠️ Attempt " + pubChkAttempt + " to click checkbox failed: " + e.getMessage());
	 			 	    }

	 			 	    try {
	 			 	        Thread.sleep(1000); // small wait before retrying
	 			 	    } catch (InterruptedException ie) {
	 			 	        Thread.currentThread().interrupt();
	 			 	    }
	 			 	}

	 			 	if (!isCheckboxClicked) {
	 			 	    throw new RuntimeException("❌ Failed to click checkbox after 10 attempts.");
	 			 	}
	 			 	
	 			 	Thread.sleep(2000);
	 			 	String xpathaddgenerateclientbill1 = "//button[contains(text(),'Generate Bill')]";

	 			 	// Retry loop
	 			 	for (int attemptss = 0; attemptss < 10; attemptss++) {
	 			 	    try {
	 			 	        // Find the scrollable div
	 			 	        WebElement scrollableDiv = driver.findElement(By.cssSelector(".card.bg-white"));

	 			 	        // Scroll all the way to the right
	 			 	        
	 			 	        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableDiv);

	 			 	        // Wait a bit for scroll to finish (optional)
	 			 	        Thread.sleep(500);

	 			 	        // Find the target element
	 			 	        WebElement element = driver.findElement(By.xpath(xpathaddgenerateclientbill1));

	 			 	        // Scroll to the element
	 			 	        //js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);
	 			 	      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);


	 			 	        // Click the element
	 			 	        element.click();

	 			 	        System.out.println("Element clicked successfully!");
	 			 	        break; // Exit loop if successful
	 			 	    } catch (Exception e) {
	 			 	        System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
	 			 	    }
	 			 	}

	 			 	 
	 		      
	 		        
	 			 	boolean clickeddd1 = false;
	 			 	int attempt1 = 0;

	 			 	while (!clickeddd1 && attempt1 < 3) {
	 			 	    try {
	 			 	        Thread.sleep(6000);

	 			 	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("BtnSubmitOB")));

	 			 	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	 			 	        Thread.sleep(500); // let scroll settle

	 			 	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	 			 	        System.out.println("Client Bill Generated");

	 			 	        // Wait for expected result (confirmation, URL change, etc.)
	 			 	       

	 			 	        clickeddd1 = true;

	 			 	    } catch (Exception e) {
	 			 	        System.out.println("Attempt " + (attempt1 + 1) + " failed: " + e.getMessage());
	 			 	        attempt1++;
	 			 	    }
	 			 	}
	 			 	Thread.sleep(4000);
	 			 	boolean clickedOkButton111 = false;
	 			 	for (int attemptx = 1; attemptx <= 10; attemptx++) {
	 			 	    try {
	 			 	        Thread.sleep(3000); // Add some wait between attempts

	 			 	        WebElement okButton111_attempt = driver.findElement(By.xpath("//*[@id=\"OBNumberMsg\"]/div/div/div/div[3]/button"));
	 			 	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", okButton111_attempt);
	 			 	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okButton111_attempt);

	 			 	        System.out.println("✅ okButton111 clicked on attempt " + attemptx);
	 			 	        clickedOkButton111 = true;
	 			 	        break;
	 			 	    } catch (Exception e) {
	 			 	        System.out.println("⚠️ Attempt " + attemptx + " to click okButton111 failed: " + e.getMessage());
	 			 	    }
	 			 	}

	 			 	if (!clickedOkButton111) {
	 			 	    throw new RuntimeException("❌ Failed to click okButton111 after 10 attempts.");
	 			 	}

	 			Thread.sleep(500);  // Let the scroll settle

	 			// Click the button
	 			
	 			System.out.print("Client bill created for Vendor provisioning");
	 			Thread.sleep(3000);	 			
	 			
	 			String xpathaddsidebar5 = "//*[@id=\"mySidebar\"]/div/div/span[3]";
 				System.out.print("Log vendor bill and verify completed");
 		 	    // Loop to click the element//*[@id="MainDiv"]/div[1]/form/div[2]/div[2]/div[3]/a[2]
 		 	    for (int attemptss = 0; attemptss < 10; attemptss++) {
 		 	        try {
 		 	            // Find the element by XPath
 		 	            WebElement element = driver.findElement(By.xpath(xpathaddsidebar5));
 		 	            Thread.sleep(1000);
 		 	            // Click the element
 		 	            element.click();
 		 	            System.out.println("Element clicked successfully!");
 		 	            break; // Exit the loop if the click is successful
 		 	        } catch (Exception e) {
 		 	            // If an exception occurs, retry
 		 	            System.out.println("Attempt " + (attemptss + 1) + " failed. Retrying...");
 		 	        }
 		 	    }
 		 		System.out.print("Client Bill Generation starting");
 			   wait.until(ExpectedConditions.elementToBeClickable(
 			 		    By.xpath("//span[text()='Billing']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))
 			 		).click();
 			  Thread.sleep(6000);
 			  WebElement vendorbillTab1 = wait.until(ExpectedConditions.elementToBeClickable(
 			  		    By.xpath("//span[@class='navbarsubtext' and text()='Vendor Bill']")
 			  		));
 			 vendorbillTab1.click();
 			Thread.sleep(6000);
 			Thread.sleep(7000);
 			Thread.sleep(6000);
 			 wait.until(ExpectedConditions.elementToBeClickable(By.id("btnsubmitProvision"))).click();
 			 
 			 String vendorbillno = row.getCell(38).toString();  // Assuming cell 32 contains "Chennai"
 			Thread.sleep(6000);
 		 	 // Wait for the search input to be clickable and enter the value
 		 	 WebElement vendorbillnoField = wait.until(ExpectedConditions.elementToBeClickable(By.id("VendorBillNo")));
 		 	vendorbillnoField.clear();
 		 	vendorbillnoField.sendKeys(vendorbillno);
 		// Read value from Excel
 		 	String datevendorprov = row.getCell(39).toString().trim(); // Example: "2025-05-30"
 		 	Thread.sleep(2000);
 		 	// Locate the input field
 		 	WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("CreationDate")));
 		 	Thread.sleep(6000);
 		 	// Clear existing value and enter new date
 		 	dateInput.clear();
 		 	dateInput.sendKeys(datevendorprov);
 		 	Thread.sleep(2000);
 		 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio' and contains(@id, 'RadioVendorID_')]")));
 		 	WebElement radio = driver.findElement(By.xpath("//input[@type='radio' and contains(@id, 'RadioVendorID_')]"));
 		 	Thread.sleep(6000);
 		 	radio.click();
 		 	
 		 	Thread.sleep(2000);
 		 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']")));
 		 	WebElement okButton0909 = driver.findElement(By.xpath("//button[text()='Ok']"));
 		 	Thread.sleep(6000);
 		 	okButton0909.click();
 		 	Thread.sleep(2000);
 		 	String vendorbillamount = row.getCell(40).toString();
 		 	WebElement vendorbillamountField = wait.until(ExpectedConditions.elementToBeClickable(By.id("VendorBillNetAmt")));
 		 	vendorbillamountField.clear();
 		 	Thread.sleep(6000);
 		 	vendorbillamountField.sendKeys(vendorbillamount);
 		 	Thread.sleep(2000);
 		 	String netbillamount = row.getCell(41).toString();
 		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ModalOBPrinting")));
 		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingModalClientBill")));
 		 	WebElement netbillamountField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, 'BillAmountClass') and contains(@name, 'BilledAmtVen_')]")));
 		 	
 		 	if (netbillamountField.isDisplayed() && netbillamountField.isEnabled()) {
 		 	    try {
 		 	        netbillamountField.clear();
 		 	      WebElement okButton10003 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']")));
 		 	    okButton10003.click();
 	 		 	  Thread.sleep(6000);
 	 		 	    
 		 	   
 	 		 	  Thread.sleep(6000);
 	 		 	   
 		 	        netbillamountField.sendKeys(netbillamount);
 		 	        
 		 	    } catch (ElementNotInteractableException e) {
 		 	        System.out.println("Element is not interactable even after wait: " + e.getMessage());
 		 	        // Optionally retry with JS or report issue
 		 	    }
 		 	} else {
 		 	    System.out.println("Net bill amount field is not ready for interaction.");
 		 	}
 		 	try {
 		 	    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(80));
 		 	  Thread.sleep(4000);
 		 	    WebElement okButton10001 = shortWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']")));
 		 	  Thread.sleep(6000);
 		 	    okButton10001.click();
 		 	  Thread.sleep(4000);
 		 	  Thread.sleep(2000);
 		 	    System.out.println("OK button clicked.");
 		 	} catch (TimeoutException e) {
 		 	    System.out.println("OK button not visible/clickable, continuing...");
 		 	}
 		 	Thread.sleep(3000);
 		 	
 			Actions actions1 = new Actions(driver);
 			for (int i = 0; i < 5; i++) {
 			    actions1.sendKeys(Keys.PAGE_DOWN).perform();
 			}
 		   js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
 		   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingModalClientBill")));
 		   new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal.fade.in")));
 		  Thread.sleep(6000);
 		//button[text()='Proceed']
 		 By proceedBtn = By.xpath("//button[text()='Proceed' and contains(@onclick, 'ProceedToIBProvision')]");

 		for (int attempt2 = 1; attempt2 <= 10; attempt2++) {
 		    try {
 		    	Thread.sleep(10000);
 		    	Thread.sleep(6000);
 		    	 Thread.sleep(3000);
 		        System.out.println("Attempting to click Proceed, attempt " + attempt2);
 		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

 		        // Wait for any modal to disappear
 		        new WebDriverWait(driver, Duration.ofSeconds(30))
 		            .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal.fade.in")));

 		        WebElement proceedElement = new WebDriverWait(driver, Duration.ofSeconds(30))
 		            .until(ExpectedConditions.elementToBeClickable(proceedBtn));
 		       ((JavascriptExecutor) driver)
 		      .executeScript("arguments[0].scrollIntoView({block:'center'});", proceedElement);
// 		        js.executeScript("arguments[0].scrollIntoView(true);", proceedElement);
 		        Thread.sleep(500); // small buffer
 		        js.executeScript("arguments[0].click();", proceedElement);

 		        System.out.println("✅ Proceed button clicked on attempt " + attempt2);
 		        break; // success, exit loop

 		    } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
 		        System.out.println("⚠️ Retryable exception on attempt " + attempt2 + ": " + e.getMessage());
 		        Thread.sleep(2000); // Give DOM time to stabilize

 		    } catch (TimeoutException te) {
 		        System.out.println("⏳ Proceed button not clickable on attempt " + attempt2 + ": " + te.getMessage());
 		        Thread.sleep(3000);

 		    } catch (Exception e) {
 		        System.out.println("❌ Unhandled error on attempt " + attempt2 + ": " + e.getMessage());
 		        if (attempt2 == 10) {
 		            throw e; // only throw if last retry fails
 		        }
 		    }
 		}

 		 	Thread.sleep(5000);
 		 	
 		// Retry clicking saveBtn up to 10 times, else throw exception
 		 	boolean isSaveClicked = false;

 		 	for (int saveAttempt = 1; saveAttempt <= 10; saveAttempt++) {
 		 	    try {
 		 	        List<WebElement> saveBtnCandidates = driver.findElements(
 		 	            By.xpath("//button[normalize-space(text())='Save' and contains(@onclick, 'FormSubmit')]")
 		 	        );

 		 	        if (!saveBtnCandidates.isEmpty()) {
 		 	            WebElement saveBtnElement = saveBtnCandidates.get(0);

 		 	            
 		 	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveBtnElement);
 		 	            Thread.sleep(300); // slight buffer after scroll

 		 	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtnElement);

 		 	            System.out.println("✅ Save button clicked successfully on attempt " + saveAttempt);
 		 	            isSaveClicked = true;
 		 	            break; // success, break loop
 		 	        } else {
 		 	            System.out.println("❌ Attempt " + saveAttempt + ": Save button not found.");
 		 	        }

 		 	    } catch (Exception clickError) {
 		 	        System.out.println("⚠️ Attempt " + saveAttempt + ": Exception while clicking Save - " + clickError.getMessage());
 		 	    }

 		 	    try {
 		 	        Thread.sleep(1000); // wait before retry
 		 	    } catch (InterruptedException interrupted) {
 		 	        Thread.currentThread().interrupt(); // restore interruption status
 		 	    }
 		 	}

 		 	if (!isSaveClicked) {
 		 	    throw new RuntimeException("❌ Failed to click Save button after 10 attempts.");
 		 	}
 		 	
 		 	
 		 	// Retry clicking okButtonib up to 10 times, else throw exception
 		 	boolean isPopupOkClicked = false;

 		 	for (int okAttempt = 1; okAttempt <= 10; okAttempt++) {
 		 	    try {
 		 	        Thread.sleep(6000); // optional wait before locating the element

 		 	        List<WebElement> okPopupButtons = driver.findElements(
 		 	            By.xpath("//button[normalize-space(text())='Ok' and contains(@onclick, 'ClosePopUpEditNo')]")
 		 	        );

 		 	        if (!okPopupButtons.isEmpty()) {
 		 	            WebElement okPopupBtn = okPopupButtons.get(0);

 		 	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", okPopupBtn);
 		 	            
 		 	            Thread.sleep(300); // short delay to allow smooth scroll

 		 	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okPopupBtn);
 		 	            Thread.sleep(10000); // post-click delay if needed

 		 	            System.out.println("✅ Ok button (ClosePopUpEditNo) clicked on attempt " + okAttempt);
 		 	            isPopupOkClicked = true;
 		 	            break;
 		 	        } else {
 		 	            System.out.println("❌ Attempt " + okAttempt + ": Ok button not found.");
 		 	        }

 		 	    } catch (Exception ex) {
 		 	        System.out.println("⚠️ Attempt " + okAttempt + ": Exception occurred - " + ex.getMessage());
 		 	    }

 		 	    try {
 		 	        Thread.sleep(1000); // wait before retrying
 		 	    } catch (InterruptedException ie) {
 		 	        Thread.currentThread().interrupt();
 		 	    }
 		 	}

 		 	if (!isPopupOkClicked) {
 		 	    throw new RuntimeException("❌ Failed to click Ok button (ClosePopUpEditNo) after 10 attempts.");
 		 	}


 		 	// Retry clicking btn up to 10 times, else throw exception
 		 	boolean isIbExcelClicked = false;

 		 	for (int ibExcelAttempt = 1; ibExcelAttempt <= 10; ibExcelAttempt++) {
 		 	    try {
 		 	        Thread.sleep(5000); // Optional wait before retrying

 		 	        WebElement ibExcelButton = driver.findElement(By.id("IBExcel"));

 		 	      
 		 	        
 		 	      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ibExcelButton);


 		 	        Thread.sleep(300); // short delay to ensure scroll completion

 		 	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ibExcelButton);
 		 	        Thread.sleep(500); // post-click buffer

 		 	        System.out.println("✅ IB Excel button clicked on attempt " + ibExcelAttempt);
 		 	        isIbExcelClicked = true;
 		 	        break;

 		 	    } catch (Exception e) {
 		 	        System.out.println("⚠️ Attempt " + ibExcelAttempt + " to click IB Excel failed: " + e.getMessage());
 		 	    }

 		 	    try {
 		 	        Thread.sleep(1000); // short pause before next retry
 		 	    } catch (InterruptedException ie) {
 		 	        Thread.currentThread().interrupt();
 		 	    }
 		 	}

 		 	if (!isIbExcelClicked) {
 		 	    throw new RuntimeException("❌ Failed to click IB Excel button after 10 attempts.");
 		 	}

 		 	Thread.sleep(500);
		}
	    
	}
	
	
	@When("Download all the reports")
	public void download_all_the_report() throws IOException, InterruptedException {
		
		
	    String excelFilePath = "D:\\fd\\btladintelleautomation\\Presspro.xlsx";  // Path to your Excel file

	    // Open workbook and file input stream with try-with-resources for auto-close
	    try (FileInputStream file = new FileInputStream(new File(excelFilePath));
	         Workbook workbook = new XSSFWorkbook(file)) {

	        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
	        Row row = sheet.getRow(1); // 2nd row (index 1) for date input

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
	        Thread.sleep(3000);
	        // Click sidebar toggle up to 10 times if needed
	        String sidebarXpath = "//*[@id=\"mySidebar\"]/div/div/span[3]";
	        for (int attempt = 0; attempt < 10; attempt++) {
	            try {
	                WebElement element = driver.findElement(By.xpath(sidebarXpath));
	                Thread.sleep(1000);
	                element.click();
	                System.out.println("Sidebar toggle clicked successfully!");
	                break;
	            } catch (Exception e) {
	                System.out.println("Attempt " + (attempt + 1) + " to click sidebar failed. Retrying...");
	            }
	        }

	        // Navigate to Reports > Status Report
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[text()='Reports']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))).click();

	        WebElement statusReportTab = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[@class='navbarsubtext' and text()='Status Report']")));
	        statusReportTab.click();
	        Thread.sleep(3000);
	        new WebDriverWait(driver, Duration.ofSeconds(20)).until(driver1 -> true);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("chkallclient"))).click();
	        Thread.sleep(500);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("selectAllStatus"))).click();
	        Thread.sleep(500);
	     

	        // Extract the estimate number from label
	        Thread.sleep(1000);
	     // --- START DATE SELECTION ---
	        String startDay = row.getCell(42).toString().trim().split("\\.")[0];
	        String startMonth = row.getCell(43).toString().trim(); // e.g., "December"
	        String startYear = row.getCell(44).toString().trim();  // e.g., "2024"
	        selectDate(driver, wait, By.id("StartDate"), startDay, startMonth, startYear);
	        Thread.sleep(1000);
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
	        // --- END DATE SELECTION ---
	        String endDay = row.getCell(45).toString().trim().split("\\.")[0];
	        String endMonth = row.getCell(46).toString().trim();  // e.g., "December"
	        String endYear = row.getCell(47).toString().trim();   // e.g., "2024"
	        selectDate(driver, wait, By.id("EndDate"), endDay, endMonth, endYear);

	        WebElement labelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CurrentSession_EstimateNo")));
	        String estimateNumber = labelElement.getText(); // e.g., EST/00361
	        System.out.println("Captured Estimate Number: " + estimateNumber);

	        // Write the estimate number to Excel cell A3 (row 2, column 0)
	        Row targetRow = sheet.getRow(2);
	        if (targetRow == null) {
	            targetRow = sheet.createRow(2);
	        }
	        Cell targetCell = targetRow.getCell(0);
	        if (targetCell == null) {
	            targetCell = targetRow.createCell(0);
	        }
	        targetCell.setCellValue(estimateNumber);

	        // Save the changes to the Excel file (use try-with-resources to avoid locking)
	        try (FileOutputStream outFile = new FileOutputStream(new File(excelFilePath))) {
	            workbook.write(outFile);
	        }

	        System.out.println("Estimate number saved to Excel cell A3.");
	        Thread.sleep(1000);
//	       Thread.sleep(500);
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox1"))).click();
	        Thread.sleep(1000);
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnPrintStatusReport"))).click();
	        Thread.sleep(2000); 
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        
	        Thread.sleep(500);
	        //for default report
	        String sidebarXpath13 = "//*[@id=\"mySidebar\"]/div/div/span[3]";
	        for (int attempt = 0; attempt < 10; attempt++) {
	            try {
	                WebElement element = driver.findElement(By.xpath(sidebarXpath13));
	                Thread.sleep(1000);
	                element.click();
	                System.out.println("Sidebar toggle clicked successfully!");
	                break;
	            } catch (Exception e) {
	                System.out.println("Attempt " + (attempt + 1) + " to click sidebar failed. Retrying...");
	            }
	        }
	        Thread.sleep(500);
	        // Navigate to Reports > Status Report
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[text()='Reports']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))).click();
	        Thread.sleep(500);
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
	        WebElement statusReportTab13 = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[@class='navbarsubtext' and text()='Status Report']")));
	        statusReportTab13.click();
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
	        Thread.sleep(500);
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
	        for (int i = 0; i < 10; i++) {
	            try {
	            	Thread.sleep(10000);
	            	Thread.sleep(5000);
	                WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chkallclient")));
	                wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
	                System.out.println("Clicked chkallclient checkbox on attempt " + (i + 1));
	                break;
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException on attempt " + (i + 1) + " - Retrying...");
	                Thread.sleep(500); // Optional: small delay before retry
	            } catch (Exception e) {
	                System.out.println("Other exception on attempt " + (i + 1) + ": " + e.getMessage());
	                Thread.sleep(500); // Avoid tight retry loop
	            }
	        }
	        Thread.sleep(1000);
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("selectAllStatus"))).click();

	     
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
	        // Extract the estimate number from label
	        Thread.sleep(1000);
	     // --- START DATE SELECTION ---
	        String startDay1 = row.getCell(42).toString().trim().split("\\.")[0];
	        String startMonth1 = row.getCell(43).toString().trim(); // e.g., "December"
	        String startYear1 = row.getCell(44).toString().trim();  // e.g., "2024"
	        selectDate(driver, wait, By.id("StartDate"), startDay1, startMonth1, startYear1);
	        Thread.sleep(1000);
	        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> true);
	        // --- END DATE SELECTION ---
	        String endDay1 = row.getCell(45).toString().trim().split("\\.")[0];
	        String endMonth1 = row.getCell(46).toString().trim();  // e.g., "December"
	        String endYear1 = row.getCell(47).toString().trim();   // e.g., "2024"
	        selectDate(driver, wait, By.id("EndDate"), endDay1, endMonth1, endYear1);
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        WebElement labelElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CurrentSession_EstimateNo")));
	        String estimateNumber1 = labelElement1.getText(); // e.g., EST/00361
	        System.out.println("Captured Estimate Number: " + estimateNumber1);

	        // Write the estimate number to Excel cell A3 (row 2, column 0)
	        Row targetRow1 = sheet.getRow(2);
	        if (targetRow1 == null) {
	            targetRow1 = sheet.createRow(2);
	        }
	        Cell targetCell1 = targetRow1.getCell(0);
	        if (targetCell1 == null) {
	            targetCell1 = targetRow1.createCell(0);
	        }
	        targetCell1.setCellValue(estimateNumber1);

	        // Save the changes to the Excel file (use try-with-resources to avoid locking)
	        try (FileOutputStream outFile = new FileOutputStream(new File(excelFilePath))) {
	            workbook.write(outFile);
	        }

	        System.out.println("Estimate number saved to Excel cell A3.");
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        Thread.sleep(1000);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox1"))).click();
	        Thread.sleep(1000);
	        Thread.sleep(1000);
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkboxDefault"))).click();
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnPrintStatusReport"))).click();
	        
	        
	        
	        Thread.sleep(5000); 
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        
	        
	        String sidebarXpath1 = "//*[@id=\"mySidebar\"]/div/div/span[3]";
	        for (int attempt = 0; attempt < 10; attempt++) {
	            try {
	                WebElement element = driver.findElement(By.xpath(sidebarXpath1));
	                Thread.sleep(1000);
	                element.click();
	                System.out.println("Sidebar toggle clicked successfully!");
	                break;
	            } catch (Exception e) {
	                System.out.println("Attempt " + (attempt + 1) + " to click sidebar failed. Retrying...");
	            }
	        }

	        // Navigate to Reports > Status Report
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[text()='Reports']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))).click();

	        WebElement billregisterTab = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[@class='navbarsubtext' and text()='Bill Register']")));
	        billregisterTab.click();
	        Thread.sleep(3000);
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        for (int i = 0; i < 10; i++) {
	            try {
	            	new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	            	 Thread.sleep(500);
	            	   wait.until(ExpectedConditions.elementToBeClickable(
	       	                By.id("chkallclient")));
	                WebElement checkbox = driver.findElement(By.id("chkallclient"));
	                checkbox.click();
	                System.out.println("Clicked chkallclient checkbox on attempt " + (i + 1));
	                break; // success, exit loop
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException on attempt " + (i + 1));
	                // optionally wait a bit before retrying
	            }
	        }
	        Thread.sleep(500);
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	     // --- START DATE SELECTION ---
	        String startDay2 = row.getCell(48).toString().trim().split("\\.")[0];
	        String startMonth2 = row.getCell(49).toString().trim();
	        String startYear2 = row.getCell(50).toString().trim();
	        selectDate(driver, wait, By.id("StartDate"), startDay2, startMonth2, startYear2);
	        Thread.sleep(1000);
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        // --- END DATE SELECTION ---
	        String endDay2 = row.getCell(51).toString().trim().split("\\.")[0];
	        String endMonth2 = row.getCell(52).toString().trim();
	        String endYear2 = row.getCell(53).toString().trim();
	        selectDate(driver, wait, By.id("EndDate"), endDay2, endMonth2, endYear2);

	        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnGenerateBillRegister"))).click();
	       
	        Thread.sleep(5000); 
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        String sidebarXpath2 = "//*[@id=\"mySidebar\"]/div/div/span[3]";
	        for (int attempt = 0; attempt < 10; attempt++) {
	            try {
	                WebElement element = driver.findElement(By.xpath(sidebarXpath2));
	                Thread.sleep(1000);
	                element.click();
	                System.out.println("Sidebar toggle clicked successfully!");
	                break;
	            } catch (Exception e) {
	                System.out.println("Attempt " + (attempt + 1) + " to click sidebar failed. Retrying...");
	            }
	        }

	        // Navigate to Reports > Status Report
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[text()='Reports']/following-sibling::span[@class='pull-right']//img[@class='down-arrow']"))).click();

	        WebElement purchaseregisterTab = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[@class='navbarsubtext' and text()='Purchase Register']")));
	        purchaseregisterTab.click();

	        Thread.sleep(1000);

	        for (int i = 0; i < 10; i++) {
	            try {
	            	new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	            	Thread.sleep(1000);
	                WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("StartDate")));
	                startDateInput.click();
	                System.out.println("Clicked StartDate input on attempt " + (i + 1));

	                // Wait for the calendar popup to appear
	                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));
	                break;
	            } catch (StaleElementReferenceException | TimeoutException e) {
	                System.out.println("Retrying StartDate calendar open: " + (i + 1));
	                Thread.sleep(300);
	            }
	        }
	        String dayFromExcel = row.getCell(54).toString().trim().split("\\.")[0];
	        String monthFromExcel = row.getCell(55).toString().trim();
	        String yearFromExcel = row.getCell(56).toString().trim();

	        System.out.println("Date from Excel: " + dayFromExcel + " " + monthFromExcel + " " + yearFromExcel);
	        new WebDriverWait(driver, Duration.ofSeconds(2)).until(driver1 -> true);
	        // Navigate to the correct month and year
	        By monthYearLocator = By.cssSelector("th.datepicker-switch");
	        By prevButtonLocator = By.cssSelector("th.prev");
	        By nextButtonLocator = By.cssSelector("th.next");

	        while (true) {
	            WebElement monthYearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearLocator));
	            String currentMonthYear = monthYearElement.getText(); // e.g., "December 2024"
	            
	            if (currentMonthYear.equalsIgnoreCase(monthFromExcel + " " + yearFromExcel)) {
	                System.out.println("Reached desired month/year: " + currentMonthYear);
	                break;
	            }

	            String[] parts = currentMonthYear.split(" ");
	            int currentMonthNum = monthToNumber(parts[0]);
	            int currentYearNum = Integer.parseInt(parts[1]);
	            int targetMonthNum = monthToNumber(monthFromExcel);
	            int targetYearNum = Integer.parseInt(yearFromExcel);

	            if (currentYearNum > targetYearNum || (currentYearNum == targetYearNum && currentMonthNum > targetMonthNum)) {
	                wait.until(ExpectedConditions.elementToBeClickable(prevButtonLocator)).click();
	            } else {
	                wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator)).click();
	            }

	            Thread.sleep(300); // Give time for UI to update
	        }
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));
	        List<WebElement> dayElements = driver.findElements(By.xpath("//div[contains(@class,'datepicker-days')]//td[contains(@class, 'day')]"));

	        for (WebElement date : dayElements) {
	            if (date.getText().equals(dayFromExcel)) {
	                date.click();
	                System.out.println("Selected day: " + dayFromExcel);
	                break;
	            }
	        }

	        // End date selection
//	        wait.until(ExpectedConditions.elementToBeClickable(By.id("EndDate"))).click();
//	        String endDateFromExcel2 = row.getCell(5).toString().trim().split("\\.")[0];
//	        System.out.println("End Date to click: " + endDateFromExcel2);
//
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));
//	        List<WebElement> endDates2 = driver.findElements(By.xpath("//div[contains(@class,'datepicker-days')]//td[@class='day' or contains(@class, 'active')]"));
//	        for (WebElement date : endDates2) {
//	            if (date.getText().equals(endDateFromExcel2)) {
//	                date.click();
//	                break;
//	            }
//	        }
	        
	        
	     // Click on EndDate input with retry logic
	        Thread.sleep(1000);

	        for (int i = 0; i < 10; i++) {
	            try {
	            
	                Thread.sleep(1000);
	                WebElement endDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("EndDate")));
	                endDateInput.click();
	                System.out.println("Clicked EndDate input on attempt " + (i + 1));

	                // Wait for the calendar popup to appear
	                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));
	                break;
	            } catch (StaleElementReferenceException | TimeoutException e) {
	                System.out.println("Retrying EndDate calendar open: " + (i + 1));
	                Thread.sleep(300);
	            }
	        }

	        // Read end date values from Excel
	        String endDayFromExcel = row.getCell(57).toString().trim().split("\\.")[0];
	        String endMonthFromExcel = row.getCell(58).toString().trim();
	        String endYearFromExcel = row.getCell(59).toString().trim();

	        System.out.println("End Date from Excel: " + endDayFromExcel + " " + endMonthFromExcel + " " + endYearFromExcel);

	        // Month-Year navigation for EndDate
	        By endMonthYearLocator = By.cssSelector("th.datepicker-switch");
	        By endPrevButtonLocator = By.cssSelector("th.prev");
	        By endNextButtonLocator = By.cssSelector("th.next");

	        while (true) {
	            WebElement endMonthYearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(endMonthYearLocator));
	            String currentEndMonthYear = endMonthYearElement.getText(); // e.g., "December 2024"

	            if (currentEndMonthYear.equalsIgnoreCase(endMonthFromExcel + " " + endYearFromExcel)) {
	                System.out.println("Reached desired end month/year: " + currentEndMonthYear);
	                break;
	            }

	            String[] parts = currentEndMonthYear.split(" ");
	            int currentMonthNum = monthToNumber(parts[0]);
	            int currentYearNum = Integer.parseInt(parts[1]);
	            int targetMonthNum = monthToNumber(endMonthFromExcel);
	            int targetYearNum = Integer.parseInt(endYearFromExcel);

	            if (currentYearNum > targetYearNum || (currentYearNum == targetYearNum && currentMonthNum > targetMonthNum)) {
	                wait.until(ExpectedConditions.elementToBeClickable(endPrevButtonLocator)).click();
	            } else {
	                wait.until(ExpectedConditions.elementToBeClickable(endNextButtonLocator)).click();
	            }

	            Thread.sleep(300);
	        }

	        // Click the desired day
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));
	        List<WebElement> endDayElements = driver.findElements(By.xpath("//div[contains(@class,'datepicker-days')]//td[contains(@class, 'day')]"));

	        for (WebElement date : endDayElements) {
	            if (date.getText().equals(endDayFromExcel)) {
	                date.click();
	                System.out.println("Selected end day: " + endDayFromExcel);
	                break;
	            }
	        }

	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox1"))).click();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnGeneratePurchaseRegister"))).click();
		       
	        Thread.sleep(5000); 
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.switchTo().defaultContent(); // optional cleanup
	    }
	}

	



    public static void selectDate(WebDriver driver, String date) {
        // Locate all date buttons on the calendar (they are typically <button> elements)
        List<WebElement> dateButtons = driver.findElements(By.cssSelector(".mat-calendar-body-cell button"));

        // Loop through each button and find the matching date based on aria-label
        for (WebElement button : dateButtons) {
            String ariaLabel = button.getAttribute("aria-label");
            if (ariaLabel != null && ariaLabel.equals(date)) {
                // Click the button thatmatches the specified date
                button.click();
                System.out.println("Date " + date + " selected.");
                break; // Exit loop once the date is found and clicked
            }
        }
    }

    public int monthToNumber(String month) {
        switch (month.toLowerCase()) {
            case "january": return 1;
            case "february": return 2;
            case "march": return 3;
            case "april": return 4;
            case "may": return 5;
            case "june": return 6;
            case "july": return 7;
            case "august": return 8;
            case "september": return 9;
            case "october": return 10;
            case "november": return 11;
            case "december": return 12;
            default: throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
    public void selectDate(WebDriver driver, WebDriverWait wait, By dateFieldLocator, String day, String month, String year) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(dateFieldLocator)).click();
        Thread.sleep(500);

        By monthYearLocator = By.cssSelector("th.datepicker-switch");
        By prevButtonLocator = By.cssSelector("th.prev");
        By nextButtonLocator = By.cssSelector("th.next");

        while (true) {
            WebElement monthYearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearLocator));
            String currentMonthYear = monthYearElement.getText();

            if (currentMonthYear.equalsIgnoreCase(month + " " + year)) {
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

            Thread.sleep(300); // Give UI time to update
        }

        List<WebElement> dayElements = driver.findElements(By.xpath("//div[contains(@class,'datepicker-days')]//td[contains(@class, 'day')]"));
        for (WebElement date : dayElements) {
            if (date.getText().equals(day) && date.isEnabled()) {
                date.click();
                break;
            }
        }
    }

	@And("Close the chrom3 Brows3r")
	public void close_the_browser() {
	
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}


}
