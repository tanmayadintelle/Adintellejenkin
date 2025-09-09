package StepDefinitions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class LoginStepsDefinition2 {
	static WebDriver driver;
	static String screenshotFolderPath;
	 public void takeScreenshot(String testName) throws IOException {
	        // Create a new folder based on the current date/time
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        FileUtils.copyFile(screenshot, new File(screenshotFolderPath + "\\" + testName + "_" + timestamp + ".png"));
	    }

	@SuppressWarnings("deprecation")
	@Given("User clicks on master and clicks on all the fields")
	public void user_is_on_login_page() throws IOException, InterruptedException {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        screenshotFolderPath = "screenshots\\Masterscreenshots\\" + timestamp;
        File folder = new File(screenshotFolderPath);
        if (!folder.exists()) {
            folder.mkdirs();  // Create the folder if it doesn't exist
        }
	    // Write code here that turns the phrase above into concrete actions
		ChromeOptions options = new ChromeOptions();
	    // Create a HashMap for preferences
	    HashMap<String, Object> prefs = new HashMap<>();    
	    // Block notifications by setting the preference value to 2 (block)
	    prefs.put("profile.default_content_setting_values.notifications", 2); 
	    // Add preferences to Chrome options
//	    options.setExperimentalOption("prefs", prefs);
	    options.addArguments("--headless=new"); // Use new headless for better rendering
	    options.addArguments("--disable-gpu");  // Prevent GPU issues in headless
	    options.addArguments("--window-size=1920,1080");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--remote-allow-origins=*");
	    driver =new ChromeDriver(options);
	    System.out.print("WebDriver initalized");
	    driver.get("https://pro.adintelle.com/v7/m-box/campaign"); 
	    System.out.print("Website opened");
	    driver.manage().window().setSize(new Dimension(1920, 1080));
	   // driver.manage().window().maximize();
	    String excelFilePath = "Master.xlsx";  // Path to your Excel file
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
			passwordField.sendKeys("Citi5bank$12345678");
			takeScreenshot("LoginPage");
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
		    
		    WebDriverWait waitload2 = new WebDriverWait(driver, Duration.ofSeconds(60));
			  
		    waitload2.until(ExpectedConditions.elementToBeClickable(By.className("show_collapse_icon")));
		    WebElement elementarrow = driver.findElement(By.className("show_collapse_icon"));
	        elementarrow.click();
	        Thread.sleep(5000); 
	        System.out.println("Logged in");
	        waitload2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"apps\"]")));
	        driver.findElement(By.xpath("//*[@id=\"apps\"]")).click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-my-apps/div/div[3]/div/div/div[1]/div[1]/span/span[2]")));
	      
	        Thread.sleep(5000);// Replace with your iframe ID
	        
	        driver.findElement(By.xpath("/html/body/m-modules/div[1]/div/div/m-app-chat/div/div[2]/m-my-apps/div/div[3]/div/div/div[1]/div[1]/span/span[2]")).click();
	    
	        JavascriptExecutor jls = (JavascriptExecutor) driver;
	        jls.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(5000);
	        
//	     // Corrected XPath without escaped quotes
//	        waitload11.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='top_header_margin']/m-my-apps/div/div[3]/div/div/div[2]/div[2]/div/div[1]/div/div[1]")));
////	        driver.findElement(By.xpath("//*[@id=\"top_header_margin\"]/m-my-apps/div/div[3]/div/div/div[2]/div[2]/div/div[1]/div/div[1]")).click(); 
//	        WebElement element = driver.findElement(By.xpath("//*[@id='top_header_margin']/m-my-apps/div/div[3]/div/div/div[2]/div[2]/div/div[1]/div/div[1]"));
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//	        Thread.sleep(5000);
	       
	        WebElement imageElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='https://instance-assets.s3.ap-south-1.amazonaws.com/public/images/application_logo/2015087366.png']")));

	        // Click the image
	        imageElement.click();
	       
//            WebElement element = waitload11.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".app_detail_item_name")));
//            element.click();        //	driver.findElement(By.xpath("/html/body/m-modules/modal-container/div[2]/m-application-user-branch/section/div[2]/perfect-scrollbar/div/div[1]/div[1]/div/p[2]")).click();
//            
	        Thread.sleep(10000);
	        Thread.sleep(10000);
	        Thread.sleep(10000);
	        System.out.println("User is on master page");
	        driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/ClientMaster.aspx?pagemenu=520&pagemenu1=5"); 
	        Thread.sleep(2000);
	        takeScreenshot("Client Master page");
	        driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/ClientBrandMaster.aspx?pagemenu=540&pagemenu1=5");
	        Thread.sleep(2000);
	        takeScreenshot("Client Brand page");
	        driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/MasterCreditor.aspx?pagemenu=560&pagemenu1=5");
	        Thread.sleep(2000);
	        takeScreenshot("Master Creditor page");
	        driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/MasterDebitors.aspx?pagemenu=570&pagemenu1=5");
	        Thread.sleep(2000);
	        takeScreenshot("Master Debitors page");
	        driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/ActivityMaster.aspx?pagemenu=571&pagemenu1=5");
	        Thread.sleep(2000);
	        takeScreenshot("Medium page");
	        driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/TargetGroup.aspx?pagemenu=573&pagemenu1=5");
	        Thread.sleep(2000);
	        takeScreenshot("Target Group page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/BrandVariantMaster.aspx?pagemenu=8026&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Brand variant master page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/BrandContractMaster.aspx?pagemenu=8028&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Brand Contract Master page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/Cinema_SiteMaster.aspx?pagemenu=8048&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Cinema Site Master page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/CommonMaster.aspx?FormType=Language&pagemenu=630&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Language page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/AdType.aspx?pagemenu=650&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("AdType page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/CommonMaster.aspx?FormType=Currency&pagemenu=660&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Currency page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/GeographyMaster.aspx?pagemenu=670&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Geography Master page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/MasterMarket.aspx?pagemenu=680&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot(" Master Market page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/EvalMarketLink.aspx?Type=&pagemenu=681&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Evalution Master Link page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/EvalMarketLink.aspx?Type=Corelate&pagemenu=682&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Channel Market correlation page");
		    Thread.sleep(2000);
		    
		    //Digital master
		    System.out.println("User is navigating to Digital medium");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/DigitalMasters/MasterSection.aspx?pagemenu=5091&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Section Master page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/DigitalMasters/MasterAssets.aspx?pagemenu=5092&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Assets Master page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/DigitalMasters/MasterPivot.aspx?pagemenu=5093&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Pivot Master page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/DigitalMasters/DigitalMasterPublisher.aspx?pagemenu=5094&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Publisher Master page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/DigitalMasters/MasterROCompany.aspx?pagemenu=5095&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("RO Company Master page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/DigitalMasters/MasterDealType.aspx?pagemenu=5096&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Deal Type Master page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/DigitalMasters/MasterRatePrimaryUnit.aspx?pagemenu=5097&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Rate Primary Unit Master page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/BrandVariantMaster.aspx?pagemenu=8026&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Brand variant page");
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/BrandContractMaster.aspx?pagemenu=8028&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Brand Contract page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/Dig_Type.aspx?pagemenu=8043&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Type page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/Dig_SubType.aspx?pagemenu=8044&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Sub-Type page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/Dig_Site.aspx?pagemenu=8045&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Site page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/Dig_Unit.aspx?pagemenu=8046&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Unit page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/Dig_Unit.aspx?pagemenu=8046&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Plan Type page");
		    Thread.sleep(2000);
		    driver.get("https://api-pro.adintelle.com/PROaDintelle_Master/Masters/Cinema_SiteMaster.aspx?pagemenu=8048&pagemenu1=5");
		    Thread.sleep(2000);
		    takeScreenshot("Cinema Site page");
		    Thread.sleep(2000);
		    close_browser();
		    
	        
		}
	    
	}
	@And("Close Browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}


}
	
