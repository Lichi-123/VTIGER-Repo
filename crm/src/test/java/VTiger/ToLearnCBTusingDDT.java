package VTiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ToLearnCBTusingDDT {
	
	public static void main (String[]args) throws IOException{
		//Reading the data from Properties file
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\OneDrive\\Documents");
		Properties prop=new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
		String UNAME = prop.getProperty("Username");
		String PWD = prop.getProperty("Password");
		RemoteWebDriver driver=null;
		
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		
		
		else if(Browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(UNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.name("submitButton")).click();
	}
		
		
		
	}


