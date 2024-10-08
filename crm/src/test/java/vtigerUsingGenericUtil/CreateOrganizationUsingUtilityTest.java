package vtigerUsingGenericUtil;


	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;

	import genericutility.ExcelFileUtility;
	import genericutility.JavaUtility;
	import genericutility.PropertyFileUtility;
	import genericutility.WebDriverUtility;

	public class CreateOrganizationUsingUtilityTest {

		public static void main(String[] args) throws IOException {
			WebDriver driver= null;
			PropertyFileUtility putil= new PropertyFileUtility();
			ExcelFileUtility eutil= new ExcelFileUtility();
			JavaUtility jutil= new JavaUtility();
			WebDriverUtility wutil= new WebDriverUtility();
					
			//Read the common data from properties file
			String BROWSER = putil.readDataFromProperties("Browser");
			String URL = putil.readDataFromProperties("Url");
			String UNAME = putil.readDataFromProperties("Username");
			String PWD = putil.readDataFromProperties("Password");
			
			//Generate Random Number
			int randomNum = jutil.getRandomNumber();
			
			//Read the Test script data from excel file
			String orgName = eutil.readDataFromExcelFile("Org", 1, 2)+randomNum;
			
			//Cross Browser Testing / launch empty browser
			
			
			if(BROWSER.equalsIgnoreCase("chrome")) {
				driver= new ChromeDriver();
			}else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver= new FirefoxDriver();
			}else if(BROWSER.equalsIgnoreCase("edge")) {
				driver= new EdgeDriver();
			}else {
				driver= new ChromeDriver();
			}
			
			//Enter the URL
			driver.get(URL);
			driver.manage().window().maximize();
			wutil.waitForPageToLoad(driver);
			
			//Login to application
			driver.findElement(By.name("user_name")).sendKeys(UNAME);
			driver.findElement(By.name("user_password")).sendKeys(PWD);
			driver.findElement(By.id("submitButton")).click();
			
			//Navigate to organization module
			driver.findElement(By.linkText("Organizations")).click();
			
			//Click on "Create Org" lookup image
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			//Create org with mandatory details
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Verification
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgName)) {
				System.out.println(orgName+" created successfully");
			}else {
				System.out.println("Failed to create "+orgName);
			}
			
			//Logout
			WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wutil.moveToElement(driver, administrator);
			driver.findElement(By.linkText("Sign Out")).click();
			
			//close the browser
			driver.quit();	

		}

	}


