package StepDefinitions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Map;
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
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	    System.out.print("WebDriver initalized");
	    driver.get("https://playground.adintelle.com/v7/m-box/campaign"); 
	    System.out.print("Website opened");
	    driver.manage().window().maximize();
	    String excelFilePath = "D:\\fd\\btladintelleautomation\\Book1.xlsx";  // Path to your Excel file
        FileInputStream file = new FileInputStream(new File(excelFilePath));
        try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			Row row = sheet.getRow(1); // Get the second row (0-indexed));
			// Step 3: Find the form fields on the webpage and fill them with data from Excel
			Thread.sleep(2000);
			Thread.sleep(2000);
			String username = row.getCell(0).toString();
			WebElement usernameField = driver.findElement(By.name("username")); // Replace with actual ID
			Thread.sleep(2000);
			usernameField.sendKeys(username);
			 String Quantity = row.getCell(6).toString();
		    driver.findElement(By.name("acceptTerms")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"identify_user_button_text_active\"]")).click();
		    Thread.sleep(3000);
		    WebDriverWait waitload1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			  
			   
		    waitload1.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		    String password = row.getCell(1).toString();
			WebElement passwordField = driver.findElement(By.name("password")); 
			passwordField.sendKeys(password);
			driver.findElement(By.xpath("//*[@id=\"login_button_text_active\"]")).click();
		    Thread.sleep(1000);
		    Thread.sleep(2000);
		    
		 // Initialize the WebDriverWait with a timeout of 10 seconds 
		 // Define the XPath to locate the element
		    String warningDialogButtonXpath = "/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span";

	        // Find the elements matching the XPath
	        List<WebElement> warningButtonList = driver.findElements(By.xpath(warningDialogButtonXpath));

	        // Check if the element is present
	        if (!warningButtonList.isEmpty()) {
	        	WebDriverWait waitload2 = new WebDriverWait(driver, Duration.ofSeconds(30));
				  
			    waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span")));
	            // If the element is found, click on it
	            warningButtonList.get(0).click();
	            System.out.println("Warning button clicked.");
	        }
//		    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/m-login-warning-dialog/div/div[2]/div[2]/div/button/div/span")).click();
		    
		    WebDriverWait waitload2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			  
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.className("show_collapse_icon")));
		    WebElement elementarrow = driver.findElement(By.className("show_collapse_icon"));
	        elementarrow.click();
	        Thread.sleep(10000); 
	        System.out.println("Logged in");
	        WebDriverWait waitid = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement iframe = waitid.until(ExpectedConditions.presenceOfElementLocated(By.id("appIframeAgency"))); 
	        Thread.sleep(2000);// Replace with your iframe ID
	        driver.switchTo().frame(iframe);
//		    driver.switchTo().frame("appIframeAgency"); 
	        System.out.println("Inside iframe");// Replace with the correct iframe ID
		    WebDriverWait waitload = new WebDriverWait(driver, Duration.ofSeconds(30));
		  
		   
		    waitload.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"planning\"]/div/table/thead/tr/th[1]")));
//		    JavascriptExecutor jsif = (JavascriptExecutor) driver;
//	        jsif.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", iframe);
		    String jobname = row.getCell(2).toString(); // Third column (Searchfield)
			Thread.sleep(3000);
			// Step 3: Find the form fields on the webpage and fill them with data from Excel
			WebElement searchField = driver.findElement(By.id("mat-input-0")); // Replace with actual ID
			Thread.sleep(4000);
			searchField.sendKeys(jobname);
			
			driver.findElement(By.xpath("//*[@id='planning']/div/table/tbody/tr[1]/td[1]")).click();
			WebDriverWait waitload3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		    waitload3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(2)")));
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(2)")).click();
		    Thread.sleep(2000);
		    System.out.println("Searched Job");
		    JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	        Thread.sleep(2000);
	        
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/addactivity.svg']")).click();
		    Thread.sleep(2000);
		    WebElement inputField = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		    inputField.click();
//		    String HSN = row.getCell(5).toString();
//		    WebElement HSNField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input"));
//		    Thread.sleep(4000);
//			HSNField.sendKeys(HSN);
//		    HSNField.sendKeys(Keys.ENTER);
//		    Thread.sleep(2000);
		    String activity = row.getCell(3).toString();
		    WebElement activityField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[1]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			Thread.sleep(4000);
			activityField.sendKeys(activity);
		    activityField.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			Thread.sleep(4000);
		    String remark = row.getCell(4).toString();
		    WebElement remarkField = driver.findElement(By.name("description"));
			remarkField.sendKeys(remark);
			remarkField.sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			Thread.sleep(4000);
			
			
		    String HSN = row.getCell(5).toString();
		    WebElement HSNField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input"));
		    Thread.sleep(4000);
			HSNField.sendKeys(HSN);
		    HSNField.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
			Thread.sleep(2000);
		    String Quantity1 = row.getCell(6).toString();
		    WebElement QuantityField = driver.findElement(By.name("quantity"));
		    Thread.sleep(2000);
			QuantityField.sendKeys(Quantity1);
		    QuantityField.sendKeys(Keys.ENTER);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			Thread.sleep(2000);
			String Rate = row.getCell(7).toString();
		    WebElement RateField = driver.findElement(By.name("Rate"));
		    Thread.sleep(2000);
		    RateField.clear();
			RateField.sendKeys(Rate);
		    RateField.sendKeys(Keys.ENTER);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
		    
		    
		    
//		    JavascriptExecutor jsadd = (JavascriptExecutor) driver;
//	        jsadd.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[4]/textarea")).sendKeys("CRM");
//		    WebElement inputFields = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[6]/ng-select/div/div/div[2]/input"));
//		    inputFields.click();
//		    inputFields.sendKeys("998361");
//		    inputFields.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[7]/input")).sendKeys("1");
//		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[8]/input")).sendKeys("10");
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[9]/span[2]")).click();
		    Thread.sleep(2000);
		    System.out.println("Added activity");
		    WebDriverWait waitload5 = new WebDriverWait(driver, Duration.ofSeconds(30));			   
		    waitload5.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"newActivitydiv\"]/div[2]/span/img")));
		    JavascriptExecutor jsl = (JavascriptExecutor) driver;
	        WebElement element = driver.findElement(By.xpath("//img[@src='./assets/img/svg/add-cost.svg']"));

	        // Scroll to the element
	        jsl.executeScript("arguments[0].scrollIntoView(true);", element);

	        // Click the element
	        element.click();
//		    driver.findElement(By.xpath("//*[@id=\"newActivitydiv\"]/div[2]/span/img")).click();
		    Thread.sleep(2000);
		    String subactivity = row.getCell(8).toString();
		    WebElement subactivityField = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[2]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			Thread.sleep(4000);
			subactivityField.sendKeys(subactivity);
		    subactivityField.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    String vendor = row.getCell(9).toString();
		    WebElement vendorfield = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[4]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			Thread.sleep(4000);
			vendorfield.sendKeys(vendor);
		    vendorfield.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    
		    String remark1 = row.getCell(10).toString();
		    WebElement remarkField1 = driver.findElement(By.name("description"));
			remarkField1.sendKeys(remark1);
			remarkField1.sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			Thread.sleep(4000);
			
		    String HSN1 = row.getCell(11).toString();
		    WebElement HSNField1 = driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[7]/ng-select/div/div/div[2]/input"));
		    Thread.sleep(4000);
			HSNField1.sendKeys(HSN1);
		    HSNField1.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
			Thread.sleep(2000);
		    String Quantity11 = row.getCell(12).toString();
		    WebElement QuantityField1 = driver.findElement(By.name("quantity"));
		    Thread.sleep(2000);
			QuantityField1.sendKeys(Quantity11);
		    QuantityField1.sendKeys(Keys.ENTER);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div")).click();
			Thread.sleep(2000);
			String Rate1 = row.getCell(13).toString();
		    WebElement RateField1 = driver.findElement(By.name("Rate"));
		    Thread.sleep(2000);
		    RateField1.clear();
			RateField1.sendKeys(Rate1);
		    RateField1.sendKeys(Keys.ENTER);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div/table/tr/td[11]/span[2]")).click();
		    Thread.sleep(2000);
		    JavascriptExecutor jso = (JavascriptExecutor) driver;
	        jso.executeScript("window.scrollBy(0, -1000)");
			Thread.sleep(2000);
			System.out.println("Added sub-activity");
			driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(3)")).click();
		    Thread.sleep(2000);
			
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-create-estimate.svg']")).click();
		    
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[5]/div/div[1]/div/mat-sidenav-content/div/div/table/thead/tr/th[1]/input")).click();

		    WebDriverWait waitload6 = new WebDriverWait(driver, Duration.ofSeconds(30));			   
		    waitload6.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")));
			driver.findElement(By.cssSelector("#planning > div > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-estimate/div/div[3]/div[2]/span[2]")).click();
		    WebDriverWait waitload7 = new WebDriverWait(driver, Duration.ofSeconds(30));			   
		    waitload7.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/action_icon.svg']")).click();
		    Thread.sleep(2000);
		    
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/action-approve.svg']")).click();
		   
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[4]/div/div/span[1]")).click();
		    Thread.sleep(2000);		  
		    driver.findElement(By.cssSelector("#action-dialog-delete > div:nth-child(5) > div > div > span.approveSubmit")).click();
		    Thread.sleep(2000);
		    System.out.println("Estimate created and approved");
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-generate-bill.svg']")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/div/div/div[2]/input")).click();
		   

	     
	        driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[5]/div/div[2]/div/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    Thread.sleep(2000);
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/app-validating/div/div[3]/div/div/span[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-client-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);
		    
		    
		    Thread.sleep(5000);
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-dashboard > div > div:nth-child(2) > div > div > div:nth-child(4)")).click();
		    
		    Thread.sleep(2000);
		    System.out.println("Created Client Bill");
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-issue-po.svg']")).click();
		    Thread.sleep(2000);
		    
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[5]/div/div[1]/div/ng-select/div/div/div[2]/input")).click();
		    
		    WebElement vendorfields = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[5]/div/div[1]/div/ng-select/div/div/div[2]/input")); // Replace with actual ID
			Thread.sleep(4000);
			vendorfields.sendKeys(vendor);
		    vendorfields.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-po/div/div[3]/div[2]/span[2]")).click();
		    WebDriverWait waitload8 = new WebDriverWait(driver, Duration.ofSeconds(30));			   
		    waitload8.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/svg/action_icon.svg']")));
		    driver.findElement(By.xpath("//img[@src='./assets/img/svg/action_icon.svg']")).click();
		    Thread.sleep(2000);
		    System.out.println("Created Vendor PO");
		    driver.findElement(By.xpath("//*[@id=\"action-dialog\"]/div[1]/div/span/img")).click();
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[3]/div/div/table/tr/td[1]/span")).click();
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("//*[@id=\"action-dialog-delete\"]/div[5]/div/div/span[2]")).click();
		    Thread.sleep(2000);	
		    driver.findElement(By.cssSelector("img[src='./assets/img/svg/butt-vendor-bill.svg']")).click();
		    Thread.sleep(2000);
		    
		    WebElement vendorfieldss = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[1]/ng-select/div/div/div[2]/input")); // Replace with actual ID
			Thread.sleep(4000);
			vendorfieldss.sendKeys(vendor);
		    vendorfieldss.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("body > app-root > div > div > div > main > div > app-generate-vendor-bill > div > div:nth-child(3) > div:nth-child(2) > span.submit-button.ng-star-inserted")).click();
		    
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")).click();
		    Thread.sleep(2000);
		    Thread.sleep(2000);
		    
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/div/div/div[3]/input")).click();
		    Thread.sleep(5000);	
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div")).click();
		    Thread.sleep(2000);	
//		    driver.findElement(By.xpath("//*[@id=\"selection1\"]/div[2]/div[2]/ng-select/div/div/div[3]/input")).click();
//		    Thread.sleep(2000);	
		    //driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")).click();
		    Thread.sleep(2000);	
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#client-bill > table > thead > tr > th.mat-mdc-header-cell.mdc-data-table__header-cell.cdk-header-cell.cdk-column-select.mat-column-select.ng-star-inserted > input")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    String VendorBillNo = row.getCell(14).toString();
		    WebElement VendorBillNoField = driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[5]/div/div[2]/div[1]/div[2]/div[1]/input"));
		    VendorBillNoField.sendKeys(VendorBillNo);
		    VendorBillNoField.sendKeys(Keys.TAB);
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    Thread.sleep(2000);	
		    driver.findElement(By.xpath("/html/body/app-root/div/div/div/main/div/app-generate-vendor-bill/div/div[3]/div[2]/span[2]")).click();
		    Thread.sleep(2000);	
		    Thread.sleep(2000);	
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

	@And("Close the Browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}


}
