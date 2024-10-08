package VTiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.collect.Table.Cell;

public class ToCreateOrganizationUsingExcelFileTest {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Read test script data from Excel file
		
		//Step 1: get the excel path location&java object of the physical excel file
				FileInputStream fis= new FileInputStream("File path");
			
				//Step 2: Open workbook in read mode
				Workbook wb = WorkbookFactory.create(fis);
				
				//Step 3: Get the control of Org sheet
				Sheet sheet = (Sheet) wb.getSheet("Org");
				
				//Step 4: get the control of row 
				Row row = sheet.getRow(1);
				
				//Step 5: get the control of cell
				Cell cell = row.getCell(2);
				
				String data= cell.getStringCellValue();
				System.out.println(data);
				
				//Step 6: Close the workbook
				wb.close();
		
		//read the common data from Properties File
		FileInputStream pfis= new FileInputStream("File path");
		Properties prop= new Properties();
		prop.load(pfis);
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String UNAME = prop.getProperty("Username");
		String PWD = prop.getProperty("Password");
		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Org Module
		driver.findElement(By.linkText("Organizations")).click();
		//click on "Create new organization" lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//Create org by entering mandatory details
		driver.findElement(By.name("accountname")).sendKeys(data);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Verification
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(data)) {
			System.out.println(data+" Created Successfully");
		}else {
			System.out.println("Failed to create "+data);
		}
		
		//Sign out
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(administrator).click().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}




