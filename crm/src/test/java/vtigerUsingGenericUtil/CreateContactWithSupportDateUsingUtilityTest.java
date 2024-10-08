package vtigerUsingGenericUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.Select;

import genericutility.ExcelFileUtility;
import genericutility.JavaUtility;
import genericutility.PropertyFileUtility;
import genericutility.WebDriverUtility;

public class CreateContactWithSupportDateUsingUtilityTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
				String lastName = eutil.readDataFromExcelFile("Contact", 1, 2)+randomNum;
		
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
		
		//Navigate to Contact module
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on "Create contact" lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Create Contact with mandatory details
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		 //Add the support date
		String startDate= jutil.getSystemDateyyyMMdd();
		String endDate= jutil.getRequiredDateyyyMMdd(30);
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verification
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(lastName)) {
			System.out.println(lastName+" created successfully");
		}else {
			System.out.println("Failed to create "+lastName);
		}
		
		
		//Logout
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.moveToElement(driver, administrator);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//close the browser
		driver.quit();
	}

}


