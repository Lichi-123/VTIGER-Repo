package VTiger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLearnDDTUsingPropertiesFile {

	
	public static void main(String[] args) throws IOException {
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Insert data to Properties file
		//To write data		
		Properties prop1= new Properties();
		prop1.setProperty("Browser", "firefox");
		prop1.setProperty("Url", "http://localhost:8888/");
		prop1.setProperty("Username", "admin");
		prop1.setProperty("Password", "password");
		
		
		//Create the object of FOS
		FileOutputStream fos= new FileOutputStream("C:\\\\Users\\\\admin\\\\OneDrive\\\\Desktop\\\\Selenium");
		
		//Store the data
				prop1.store(fos, "Common Data");
		System.out.println("Data entered succesfully");
		
		//Read data
		//Step 1: Create object of FIS
		FileInputStream fis= new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop\\Selenium");
		
		//Step 2: Load all the keys
		
		Properties prop= new Properties();
		prop.load(fis);
		
		//Step 3: Read the data
		String BROWSER = prop.getProperty("Browser");
		System.out.println(BROWSER);
		String UNAME = prop.getProperty("Username");
		System.out.println(UNAME);
		String PWD = prop.getProperty("Password");
		System.out.println(PWD);
		String URL = prop.getProperty("Url");
		System.out.println(URL);
		
		
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("password");
    driver.findElement(By.id("submitButton")).click();

	
	}

}


