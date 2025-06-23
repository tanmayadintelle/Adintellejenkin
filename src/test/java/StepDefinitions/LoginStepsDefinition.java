package StepDefinitions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class LoginStepsDefinition {
	static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("User completes BTL exisitng flow")
	public void user_is_on_login_page() throws IOException, InterruptedException {

	    // Write code here that turns the phrase above into concrete actions
		ChromeOptions options = new ChromeOptions();
	    // Create a HashMap for preferences
		
	    HashMap<String, Object> prefs = new HashMap<>();    
	    // Block notifications by setting the preference value to 2 (block)
	    prefs.put("profile.default_content_setting_values.notifications", 2); 
	    // Add preferences to Chrome options
	    options.setExperimentalOption("prefs", prefs);
	    
	    driver =new ChromeDriver(options);
	    DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(List.of("*hotjar.com*", "*hotjar.io*")));
	    
	    System.out.print("WebDriver initalized");
	    driver.get("https://playground.adintelle.com/v7/m-box/campaign"); 
	    System.out.print("Website opened");
	    driver.manage().window().maximize();
	    String excelFilePath = "D:\\fd\\btladintelleautomation\\Book1.xlsx"; 
	    
	    // Path to your Excel file
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        try (Workbook workbook = new XSSFWorkbook(file)) {
        	Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			Row row = sheet.getRow(1); // Get the second row (0-indexed));
			WebDriverWait waitload2 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.name("username")));
			// Step 3: Find the form fields on the webpage and fill them with data from Excel
			
			WebElement usernameField = driver.findElement(By.name("username")); // Replace with actual ID
			
			usernameField.sendKeys("tanmayn");
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
	       
            // Optionally, print out the button's text or state (for debugging)
;

	        System.out.println("Hotjar survey popup removed.");
	        WebElement iframe = waitid.until(ExpectedConditions.presenceOfElementLocated(By.id("appIframeAgency"))); 
	        Thread.sleep(2000);// Replace with your iframe ID
	        driver.switchTo().frame(iframe);
//		    driver.switchTo().frame("appIframeAgency"); 
	        System.out.println("Inside iframe");// Replace with the correct iframe ID
		    WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		   
		    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"planning\"]/div/table/thead/tr/th[1]")));
//		    JavascriptExecutor jsif = (JavascriptExecutor) driver;
//	        jsif.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", iframe);
		    String jobname = row.getCell(2).toString(); // Third column (Searchfield)
		    waitload.until(ExpectedConditions.elementToBeClickable(By.name("search_value")));
//		    
			// Step 3: Find the form fields on the webpage and fill them with data from Excel
			WebElement searchField = driver.findElement(By.name("search_value")); // Replace with actual ID
			
			searchField.sendKeys(jobname);
			Thread.sleep(4000);
			waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='planning']/div/table/tbody/tr[1]/td[1]")));
			driver.findElement(By.xpath("//*[@id='planning']/div/table/tbody/tr[1]/td[1]")).click();
		 
	         
	         
	         
	         
			
			WebDriverWait waitload3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		    waitload3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(2)")));
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(2)")).click();
		    Thread.sleep(2000);
		    System.out.println("Searched Job");
		    JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	        Thread.sleep(2000);
	        Thread.sleep(2000);
	        Thread.sleep(2000);
	        Thread.sleep(2000);
	        Thread.sleep(2000);
	        Thread.sleep(2000);
	        //need to add wait
	        
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
	        driver.findElement(By.xpath("//img[@src='./assets/img/svg/addactivity.svg']")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-autocomplete='list']")));
		    WebElement inputField = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		    Thread.sleep(2000);
		    inputField.click();
		    String activity = row.getCell(3).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[2]/input")));
		    WebElement activityField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			
			activityField.sendKeys(activity);
		    activityField.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
		    String remark = row.getCell(4).toString();
		    WebElement remarkField = driver.findElement(By.name("description"));
			remarkField.sendKeys(remark);
			remarkField.sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();			
			
		    String HSN = row.getCell(5).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input")));
		    WebElement HSNField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input"));
			HSNField.sendKeys(HSN);
		    HSNField.sendKeys(Keys.ENTER);
		    
		    String Quantity1 = row.getCell(6).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		    WebElement QuantityField = driver.findElement(By.name("quantity"));
			QuantityField.sendKeys(Quantity1);
		    QuantityField.sendKeys(Keys.ENTER);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			Thread.sleep(2000);
			String Rate = row.getCell(7).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.name("Rate")));
		    WebElement RateField = driver.findElement(By.name("Rate"));
		    RateField.clear();
			RateField.sendKeys(Rate);
		    RateField.sendKeys(Keys.ENTER);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		    
		    System.out.println("Added activity");
		    Thread.sleep(5000);
		 
	        

	        // Get all elements with the activeAction class
	        List<WebElement> editButtons = driver.findElements(By.xpath("//table/tbody//img[contains(@src, 'edit.svg')]"));

	     // Check if the list is not empty and click on the last "Edit" button
	     if (!editButtons.isEmpty()) {
	         WebElement lastEditButton = editButtons.get(editButtons.size() - 1);

	         // Scroll the last "Edit" button into view
	         
	         js.executeScript("arguments[0].scrollIntoView(true);", lastEditButton);
	         
	         // Ensure the element is clickable
	         WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(60));
	         wait12.until(ExpectedConditions.elementToBeClickable(lastEditButton));

	         // Click the last "Edit" button
	         lastEditButton.click();
	         System.out.println("Clicked on the last 'Edit' button.");
	     } else {
	         System.out.println("No 'Edit' buttons found.");
	     }
		    
		    
		    String activity1 = row.getCell(22).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[3]/input")));
		    WebElement activityField1 = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[3]/input")); // Replace with actual ID
			activityField1.clear();
			activityField1.sendKeys(activity1);
		    activityField1.sendKeys(Keys.ENTER);
		    activityField1.sendKeys(Keys.TAB);
		    //driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		    
			
		    String remark1mod = row.getCell(23).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
		    WebElement remarkField1mod = driver.findElement(By.name("description"));
		    remarkField1mod.clear();
			remarkField1mod.sendKeys(remark1mod);
			remarkField1mod.sendKeys(Keys.TAB);
			
			//driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
			
			
			
		    String HSNmod = row.getCell(24).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[3]/input")));
		    WebElement HSNFieldmod = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[3]/input"));
		    HSNFieldmod.clear();		    
			HSNFieldmod.sendKeys(HSNmod);
		    HSNFieldmod.sendKeys(Keys.ENTER);
		    
		    String Quantity1mod = row.getCell(25).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		    WebElement QuantityFieldmod = driver.findElement(By.name("quantity"));
		    
		    QuantityFieldmod.clear();
			QuantityFieldmod.sendKeys(Quantity1mod);
		    QuantityFieldmod.sendKeys(Keys.ENTER);
		    QuantityFieldmod.sendKeys(Keys.TAB);
		    //driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		  
			
			String Ratemod = row.getCell(26).toString();
		    WebElement RateFieldmod = driver.findElement(By.name("Rate"));
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		    RateFieldmod.clear();
		    
		    RateFieldmod.clear();
			RateFieldmod.sendKeys(Ratemod);
		    RateFieldmod.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		    
		    
		    

		    
		    System.out.println("Activty modified");
		    Thread.sleep(4000);
		    WebDriverWait waitload5 = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    waitload5.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/add-cost.svg']")));
		    JavascriptExecutor jsl = (JavascriptExecutor) driver;
	        WebElement element = driver.findElement(By.xpath("//img[@src='./assets/img/svg/add-cost.svg']"));

	        // Scroll to the element
	        jsl.executeScript("arguments[0].scrollIntoView(true);", element);

	        // Click the element
	        element.click();
	        
//		    driver.findElement(By.xpath("//*[@id=\"newActivitydiv\"]/div[2]/span/img")).click();
		    Thread.sleep(2000);
		    String subactivity = row.getCell(8).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[2]/ng-select/div/div/div[2]/input")));
		    WebElement subactivityField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[2]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			subactivityField.sendKeys(subactivity);
		    subactivityField.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[4]/ng-select/div/div/div[2]/input")));
		    String vendor = row.getCell(9).toString();
		    WebElement vendorfield = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[4]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			
			vendorfield.sendKeys(vendor);
		    vendorfield.sendKeys(Keys.ENTER);
		    
		    
		    String remark1 = row.getCell(10).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
		    WebElement remarkField1 = driver.findElement(By.name("description"));
			remarkField1.sendKeys(remark1);
			remarkField1.sendKeys(Keys.TAB);
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div")));
			driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			
		    String HSN1 = row.getCell(11).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[7]/ng-select/div/div/div[2]/input")));
		    WebElement HSNField1 = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[7]/ng-select/div/div/div[2]/input"));
		    
			HSNField1.sendKeys(HSN1);
		    HSNField1.sendKeys(Keys.ENTER);
		    
		    String Quantity11 = row.getCell(12).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		    WebElement QuantityField1 = driver.findElement(By.name("quantity"));
			QuantityField1.sendKeys(Quantity11);
		    QuantityField1.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
		    
			String Rate1 = row.getCell(13).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.name("Rate")));
		    WebElement RateField1 = driver.findElement(By.name("Rate"));
		    
		    RateField1.clear();
			RateField1.sendKeys(Rate1);
		    RateField1.sendKeys(Keys.ENTER);
		    
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
			    wait05.until(ExpectedConditions.elementToBeClickable(lastModifyButton));

			    // Click the last "Modify" button
			    lastModifyButton.click();
			    System.out.println("Clicked on the last 'Modify' button.");
			} else {
			    System.out.println("No 'Modify' buttons found.");
			}
			  Thread.sleep(2000);
			  
			  
			  
			  //MOdify subactivity starts here
			  
			  
			  String subactivitymod = row.getCell(27).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(2) > ng-select > div > div > div.ng-input > input[type=text]")));
			  WebElement subactivityFieldmod = driver.findElement(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(2) > ng-select > div > div > div.ng-input > input[type=text]"));
			  
			  subactivityFieldmod.sendKeys(subactivitymod);
			  subactivityFieldmod.clear();
			  subactivityFieldmod.sendKeys(Keys.ENTER);
			  Thread.sleep(2000);

			  String vendormod = row.getCell(28).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(4) > ng-select > div > div > div.ng-input > input[type=text]")));
			  WebElement vendorfieldmod = driver.findElement(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(4) > ng-select > div > div > div.ng-input > input[type=text]"));
			  
			  vendorfieldmod.clear();
			  vendorfieldmod.sendKeys(vendormod);
			  vendorfieldmod.sendKeys(Keys.ENTER);
			  Thread.sleep(2000);

			  String remark1mods = row.getCell(29).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
			  WebElement remarkField1mods = driver.findElement(By.name("description"));
			  remarkField1mods.clear();
			  remarkField1mods.sendKeys(remark1mods);
			  remarkField1mods.sendKeys(Keys.TAB);
			  

			  String HSN1mods = row.getCell(30).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(7) > ng-select > div > div > div.ng-input > input[type=text]")));
			  WebElement HSNField1mods = driver.findElement(By.cssSelector("#action-dialog-delete > div > table > tr > td:nth-child(7) > ng-select > div > div > div.ng-input > input[type=text]"));
			 
			  HSNField1mods.clear();
			  HSNField1mods.sendKeys(HSN1mods);
			  HSNField1mods.sendKeys(Keys.ENTER);
			  Thread.sleep(2000);

			  String Quantity11mods = row.getCell(31).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
			  WebElement QuantityField1mods = driver.findElement(By.name("quantity"));
			  
			  QuantityField1mods.clear();
			  QuantityField1mods.sendKeys(Quantity11mods);
			  QuantityField1mods.sendKeys(Keys.ENTER);
			  Thread.sleep(2000);

			  String Rate1mods = row.getCell(32).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("Rate")));
			  WebElement RateField1mods = driver.findElement(By.name("Rate"));
			  Thread.sleep(2000);
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
		    waitload61.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/AdditionalLineItems.svg']")));
		    WebElement imageadl = driver.findElement(By.cssSelector("img[src='./assets/img/svg/AdditionalLineItems.svg']"));
		    imageadl.click();
		    
		      Thread.sleep(2000);
		      String itemtype = row.getCell(33).toString();
		      wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection1\"]/div[3]/div/table/tr/td[2]/ng-select/div/div/div[2]/input")));
			  WebElement itemtypes = driver.findElement(By.xpath("//*[@id=\"selection1\"]/div[3]/div/table/tr/td[2]/ng-select/div/div/div[2]/input"));
			  
			  itemtypes.sendKeys(Keys.ENTER);
			  itemtypes.sendKeys(itemtype);
			  itemtypes.sendKeys(Keys.ENTER);
			  itemtypes.sendKeys(Keys.ENTER);
			  

			  String description = row.getCell(34).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("adddescription")));
			  WebElement descriptions = driver.findElement(By.name("adddescription"));
			 
			  descriptions.clear();
			  descriptions.sendKeys(description);
			  descriptions.sendKeys(Keys.ENTER);
		    
			  String amount = row.getCell(35).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("lineitemAmount")));
			  WebElement amounts = driver.findElement(By.name("lineitemAmount"));
			
			  
			  amounts.sendKeys(amount);
			  amounts.sendKeys(Keys.ENTER);
			  wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selection1 > div.row.ng-star-inserted > div > table > tr > td:nth-child(8) > span")));
			  driver.findElement(By.cssSelector("#selection1 > div.row.ng-star-inserted > div > table > tr > td:nth-child(8) > span")).click();
			  Thread.sleep(5000); 
			  
			  System.out.println("Added additional line item");
			  JavascriptExecutor jszoom = (JavascriptExecutor) driver;
			     jszoom.executeScript("document.body.style.zoom='95%'");
			     Thread.sleep(1000);
			 
			     WebElement activityfromestimate = driver.findElement(By.xpath("//img[@src='./assets/img/svg/addactivity.svg']"));
			  activityfromestimate.click();

		    
		    //Addactivityinsideest
		    
		    String activityinest = row.getCell(36).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/ng-select/div/div/div[2]/input")));
		    WebElement activityFieldinest = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[2]/div/div[1]/div[1]/div[1]/div[1]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			
		    Thread.sleep(2000);
			 
			activityFieldinest.sendKeys(activityinest);
		    activityFieldinest.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div:nth-child(3) > div > div > span")));
		    driver.findElement(By.cssSelector("#action-dialog-delete > div:nth-child(3) > div > div > span")).click();
			
			
			
		    String HSNinest = row.getCell(38).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[2]/div/div[1]/div[3]/div[1]/div/ng-select/div/div/div[2]/input")));
		    WebElement HSNFieldinest = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[2]/div/div[1]/div[3]/div[1]/div/ng-select/div/div/div[2]/input"));    
			HSNFieldinest.sendKeys(HSNinest);
		    HSNFieldinest.sendKeys(Keys.ENTER);
		    
			
			String Rateinest = row.getCell(40).toString();
			 wait1.until(ExpectedConditions.elementToBeClickable(By.name("Rate")));
		    WebElement RateFieldinest = driver.findElement(By.name("Rate"));
		    RateFieldinest.clear();
			RateFieldinest.sendKeys(Rateinest);
		    RateFieldinest.sendKeys(Keys.ENTER);
		    
			
			
		    String Quantity1inest = row.getCell(39).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("quantity")));
		    WebElement QuantityFieldinest = driver.findElement(By.name("quantity"));
		    
			QuantityFieldinest.sendKeys(Quantity1inest);
		    QuantityFieldinest.sendKeys(Keys.ENTER);
		    
			
		    String remarkinest = row.getCell(37).toString();
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("description")));
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("description")));
		    WebElement remarkFieldinest = driver.findElement(By.name("description"));
		    remarkFieldinest.clear();
			remarkFieldinest.sendKeys(remarkinest);
			
			driver.findElement(By.cssSelector("#action-dialog-delete > div:nth-child(3) > div > div > span")).click();
			
			Thread.sleep(2000);
			 
		 
			 		    
		    System.out.println("Added activity inside estimate");
		    
		    
		
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
			driver.findElement(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
			//driver.findElement(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
			driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
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
			WebElement dateElement110 = wait112.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'" + dateFromExcel110 + "')]")));
			
			dateElement110.click();
			
			
			
			
			String docname = row.getCell(42).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[4]/div/input")));
		    WebElement docnames = driver.findElement(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[4]/div/input"));
		    
		    docnames.clear();
			docnames.sendKeys(docname);
		    docnames.sendKeys(Keys.ENTER);
		    
			
			String header = row.getCell(43).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[5]/div/textarea")));
		    WebElement headers = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[5]/div/textarea"));
		    
		    headers.clear();
			headers.sendKeys(header);
		    headers.sendKeys(Keys.ENTER);
		    
			String footer = row.getCell(44).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[6]/div/textarea")));
		    WebElement footers = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[6]/div/textarea"));
		    footers.clear();
			footers.sendKeys(footer);
		    footers.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    
		    WebDriverWait waitloadeditestimateaction = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    waitloadeditestimateaction.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
		    Thread.sleep(2000);
		    WebDriverWait waitloadeditestimate = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    waitloadeditestimate.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg//modify-icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg//modify-icon.svg']")).click();
		    Thread.sleep(2000);
		    
		    
		    String remarkmodestimate = row.getCell(56).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("Description")));
		    WebElement remarkFieldmodestimate = driver.findElement(By.name("Description"));
		    remarkFieldmodestimate.clear();
			remarkFieldmodestimate.sendKeys(remarkmodestimate);
			remarkFieldmodestimate.sendKeys(Keys.TAB);

		    String HSNmodestimate = row.getCell(57).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"planning\"]/div/table/tbody/tr[1]/td[6]/ng-select/div/div/div[3]/input")));
		    WebElement HSNFieldmodestimate = driver.findElement(By.xpath("//*[@id=\"planning\"]/div/table/tbody/tr[1]/td[6]/ng-select/div/div/div[3]/input"));
		    HSNFieldmodestimate.clear();
			HSNFieldmodestimate.sendKeys(HSNmodestimate);
		    HSNFieldmodestimate.sendKeys(Keys.ENTER);
		   
		    
		    String Quantity1modestimate = row.getCell(58).toString();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.name("qty")));
		    WebElement QuantityFieldmodestimate = driver.findElement(By.name("qty"));
		    QuantityFieldmodestimate.clear();
			QuantityFieldmodestimate.sendKeys(Quantity1modestimate);
		    QuantityFieldmodestimate.sendKeys(Keys.ENTER);
		    //driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			Thread.sleep(2000);
			String Ratemodestimate = row.getCell(59).toString();
			wait1.until(ExpectedConditions.elementToBeClickable(By.name("rate")));
		    WebElement RateFieldmodestimate = driver.findElement(By.name("rate"));
		    Thread.sleep(2000);
		    RateFieldmodestimate.clear();
			RateFieldmodestimate.sendKeys(Ratemodestimate);
		    RateFieldmodestimate.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='client-estimate']/table/tbody/tr/td[4]/span[1]")));
		    WebElement elementToClick = driver.findElement(By.xpath("//*[@id='client-estimate']/table/tbody/tr/td[4]/span[1]"));
		    elementToClick.click();
		    
		   
			  

			  String descriptionsmodest = row.getCell(61).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("adddescription")));
			  WebElement descriptionsmodestimate = driver.findElement(By.name("adddescription"));
			  descriptionsmodestimate.clear();
			  descriptionsmodestimate.sendKeys(descriptionsmodest);
			  descriptionsmodestimate.sendKeys(Keys.ENTER);
		    
			  String amountmodestimate = row.getCell(62).toString();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.name("lineitemAmount")));
			  WebElement amountsmodestimate = driver.findElement(By.name("lineitemAmount"));
			  amountsmodestimate.clear();
			  amountsmodestimate.sendKeys(amountmodestimate);
			  amountsmodestimate.sendKeys(Keys.ENTER); 
			  
			  
			 
			  WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
			  WebElement elementToClick12 = wait12.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selection1 > div:nth-child(3) > div > table > tr > td:nth-child(8) > span")));

			  // Click on the element
			  elementToClick12.click();
			  WebElement elementToClick13 = wait12.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-estimate > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));

			  // Click on the element
			  elementToClick13.click();
			  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]")));
			  WebElement calendarButton11 = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]"));
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
				WebElement dateElement1210 = wait1112.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'" + dateFromExcel1110 + "')]")));
				
				dateElement1210.click();
				
				
				
				String docnamee = row.getCell(64).toString();
				 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[4]/div/input")));
			    WebElement docnamees = driver.findElement(By.xpath("//*[@id=\"selection2\"]/div[2]/div[1]/div[4]/div/input"));
			    docnamees.clear();
				docnamees.sendKeys(docnamee);
			    docnamees.sendKeys(Keys.ENTER);
			    
				
				String headerr = row.getCell(65).toString();
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[5]/div/textarea")));
			    WebElement headerrs = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[5]/div/textarea"));
			    
			    headerrs.clear();
				headerrs.sendKeys(headerr);
			    headerrs.sendKeys(Keys.ENTER);
			    
				
				String footerr = row.getCell(66).toString();
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[6]/div/textarea")));
			    WebElement footerrs = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[2]/div[1]/div[6]/div/textarea"));
			    footerrs.clear();
				footerrs.sendKeys(footerr);
			    footerrs.sendKeys(Keys.ENTER);
			    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
				    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
				    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
				    
				    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
				    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")));
				    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
				    
				    WebDriverWait waitloadeditestimateactionn = new WebDriverWait(driver, Duration.ofSeconds(60));			   
				    waitloadeditestimateactionn.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
				    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
				    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/recordPO.svg']")));
			  
				    
				    WebElement recordPO = driver.findElement(By.xpath("//img[@src='./assets/img/svg/recordPO.svg']"));

				 // Click on the image element
				    recordPO.click();
				    Thread.sleep(2000);
					String contractno = row.getCell(67).toString();
					wait1.until(ExpectedConditions.elementToBeClickable(By.name("ContractNo")));
				    WebElement contractnumber = driver.findElement(By.name("ContractNo"));
				    
				   
				    contractnumber.clear();
				    contractnumber.sendKeys(contractno);
				    contractnumber.sendKeys(Keys.ENTER);
				    
					
					String PONumber = row.getCell(68).toString();
					wait1.until(ExpectedConditions.elementToBeClickable(By.name("PONumber")));
				    WebElement PONumbers = driver.findElement(By.name("PONumber"));
				    
				    PONumbers.clear();
				    PONumbers.sendKeys(PONumber);
				    PONumbers.sendKeys(Keys.ENTER);
				    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-record-po-details/div/div[3]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]")));
		    
					 WebElement calendarButton111101 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-record-po-details/div/div[3]/div[1]/div[2]/div/div/div/mat-datepicker-toggle/button/span[3]"));
						calendarButton111101.click();
						JavascriptExecutor jsk = (JavascriptExecutor) driver;
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
						WebElement dateElement121001 = wait11122.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-calendar-body-cell-content mat-focus-indicator' and contains(text(),'" + dateFromExcel111001 + "')]")));
						
						dateElement121001.click();
						Thread.sleep(2000);		
					
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
		    waitloadeditestimateactionnn.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action-approve.svg']")));
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/action-approve.svg']")).click();
		   
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[4]/div/div/span[1]")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[4]/div/div/span[1]")).click();
		    
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#action-dialog-delete > div:nth-child(5) > div > div > span.approveSubmit")));
		    driver.findElement(By.cssSelector("#action-dialog-delete > div:nth-child(5) > div > div > span.approveSubmit")).click();
		   
		    System.out.println("Estimate approved");
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[contains(@src, 'view-icon.svg')])[last()]"))).click();
		    
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement iframedoc = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iframe-doc-viewer")));

		    // Scroll the iframe into view (this simulates user scrolling to view the PDF)
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", iframedoc);
		    Thread.sleep(2000);
		    WebDriverWait waitloadeditestimateactionnnn = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    waitloadeditestimateactionnnn.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
		    Thread.sleep(2000);
		 // Locate the image element by its src attribute
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action-appdetails.svg']")));
		    WebElement approvaldetails = driver.findElement(By.xpath("//img[@src='./assets/img/svg/action-appdetails.svg']"));

		    // Click the image element
		    approvaldetails.click();

		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/close-cross.svg']")));
		    WebElement closeImageElement = driver.findElement(By.xpath("//img[@src='./assets/img/svg/close-cross.svg']"));

		 // Click the image element
		    closeImageElement.click();
		    Thread.sleep(2000);
//		    WebDriverWait waitloadeditestimateactionprint = new WebDriverWait(driver, Duration.ofSeconds(40));			   
//		    waitloadeditestimateactionprint.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
//		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
//		    Thread.sleep(2000);
//		    
//		    WebElement printEstimatepdf = driver.findElement(By.xpath("//img[@src='./assets/img/svg/action-print.svg']"));
//
//		 // Click on the image element
//		    printEstimatepdf.click();
//		    
//		    WebElement printButton = driver.findElement(By.xpath("//span[@class='submit-button' and text()='Print']"));
//
//		 // Click on the print button
//		    printButton.click();
//		    
//		    String originalWindow = driver.getWindowHandle();
//
//		
//		 Thread.sleep(3000); 
//
//		 // Step 4: Get all window handles
//		 Set<String> allWindows = driver.getWindowHandles();
//
//		 // Step 5: Switch to the new tab
//		 for (String window : allWindows) {
//		     if (!window.equals(originalWindow)) {
//		         driver.switchTo().window(window);
//		         break;
//		     }
//		 }
//
//		Thread.sleep(5000);
//		 driver.switchTo().window(originalWindow);
//		    
//		    
//		    
//		    
//		    
//		    
//		    
//		    
//		    
//		    
//		    
//		    
//		    
//		    
//		    Thread.sleep(5000);
//		    
//		    
//		    
//		    
//		    
//		    
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/butt-generate-bill.svg']")));
		    
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-generate-bill.svg']")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/div/div/div[2]/input")));
		    
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/div/div/div[2]/input")).click();
		   
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")));
	     
	        driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")).click();
	        Thread.sleep(3000);
	        wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
	        
	     
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
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
		    
		    WebDriverWait waitloadchild = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    waitloadchild.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(4)")));
		   
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(4)")));
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(4)")).click();
		    
		    Thread.sleep(2000);
		    System.out.println("Created Client Bill");
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/butt-issue-po.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-issue-po.svg']")).click();
		    Thread.sleep(2000);
		    
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[5]/div/div[1]/div/ng-select/div/div/div[2]/input")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[5]/div/div[1]/div/ng-select/div/div/div[2]/input")));
		    WebElement vendorfields = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[5]/div/div[1]/div/ng-select/div/div/div[2]/input")); // Replace with actual ID
			vendorfields.sendKeys(vendormod);
		    vendorfields.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")));
		   
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")));
		    Thread.sleep(2000);driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    
		    System.out.println("Created Vendor PO");
		   // WebDriverWait waitload8 = new WebDriverWait(driver, Duration.ofSeconds(60));			   
		    Thread.sleep(2000);
		    //waitload8.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/action_icon.svg']")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog\"]/div[1]/div/span/img")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog\"]/div[1]/div/span/img")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[3]/div/div/table/tr/td[1]/span")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[3]/div/div/table/tr/td[1]/span")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"action-dialog-delete\"]/div[5]/div/div/span[2]")));
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[5]/div/div/span[2]")).click();
		    Thread.sleep(2000);	
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/butt-vendor-bill.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-vendor-bill.svg']")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[1]/ng-select/div/div/div[2]/input")));
		    WebElement vendorfieldss = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[1]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			vendorfieldss.sendKeys(vendormod);
		    vendorfieldss.sendKeys(Keys.ENTER);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-generate-vendor-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")));
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-generate-vendor-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
		    Thread.sleep(2000);
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")).click();
		   
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/div/div/div[3]/input")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/div/div/div[3]/input")).click();
		    
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    String VendorBillNo = row.getCell(14).toString();
		    WebElement VendorBillNoField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[1]/div[2]/div[1]/input"));
		    VendorBillNoField.sendKeys(VendorBillNo);
		    VendorBillNoField.sendKeys(Keys.TAB);
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")));
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    System.out.println("Created Vendor Bill");
		    driver.switchTo().defaultContent();
		    

		}
	    
	}

//	@When("User enter valid username an password")
//	@When("User enter valid {string} an {string}")
//	//public void user_enter_valid_username_an_password() {
//	public void user_enter_valid_an(String username, String password) throws InterruptedException {
//		Thread.sleep(3000);
//	    // Write code here that turns the phrase above into concrete actions
//	    driver.findElement(By.name("username")).sendKeys(username);
//	    Thread.sleep(2000);
//	    driver.findElement(By.name("acceptTerms")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//*[@id=\"identify_user_button_text_active\"]")).click();
//	    Thread.sleep(3000);
//	    driver.findElement(By.name("password")).sendKeys(password);
//	    driver.findElement(By.xpath("//*[@id=\"login_button_text_active\"]")).click();
//	    Thread.sleep(1000);
//	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span")).click();
//	    Thread.sleep(2000);
//	    Thread.sleep(2000);
//	    Thread.sleep(2000);
//	    Thread.sleep(2000);
//	    Thread.sleep(2000);
//	    Thread.sleep(2000);
//	    Thread.sleep(2000);
//	    Thread.sleep(2000);
//	    Thread.sleep(2000);
//
//	    driver.switchTo().frame("appIframeAgency");  // Replace with the correct iframe ID
//
//	 // Step 2: Wait for the element to be visible and clickable
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='planning']/div/table/tbody/tr[1]/td[1]")));
//
//	    // Click the element
//	    element.click();
//	    Thread.sleep(9000);
//	    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(2)")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//img[@src='./assets/img/svg/addactivity.svg']")).click();
//	    Thread.sleep(2000);
//	    WebElement inputField = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
//	    inputField.click();
//	    inputField.sendKeys("CRM");
//	    inputField.sendKeys(Keys.ENTER);
//	    
//	  
//	    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[4]/textarea")).sendKeys("CRM");
//	    WebElement inputFields = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input"));
//	    inputFields.click();
//	    inputFields.sendKeys("998361");
//	    inputFields.sendKeys(Keys.ENTER);
//	    
//	    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[7]/input")).sendKeys("1");
//	    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[8]/input")).sendKeys("10");
//	    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
//        Thread.sleep(9000);
//	    driver.switchTo().defaultContent();
//	    driver.quit();
//	 // Step 4: Optionally, switch back to the main content after interacting with the iframe
//	    
//        // Continue with other actions if necessary
//        
//	}
//	@And("Click on Login Button")
//	public void click_on_login_button() throws InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//		
//		
//		 
//	}
//
//	@Then("User should be navigated to home page")
//	public void user_should_be_navigated_to_home_page() throws InterruptedException {
//		Thread.sleep(2000);
//	    // Write code here that turns the phrase above into concrete actions
//	    Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size()>0,"User navigated to home page");
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


	@And("Close the Browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}


}
