package VTiger;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToLearnCrossBrowserTesting {
	
	private static Scanner sc;

	public static void main(String[]args) {
		
		sc = new Scanner(System.in);
		
		System.out.println("Chrome");
		String BROWSER = sc.next();
		
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		
		
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
	}

}
