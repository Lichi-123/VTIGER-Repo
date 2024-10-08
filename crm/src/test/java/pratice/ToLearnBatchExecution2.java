package pratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ToLearnBatchExecution2 {
	
	@Test(groups = "Smoke Test")
	public void m4() {
		WebDriver driver = new FirefoxDriver();
		System.out.println("M4 executed");//smoke
		
	}
	@Test(groups = "Regression Test")
	public void m5() {
		WebDriver driver = new FirefoxDriver();
		System.out.println("M5 executed");//Regression
		
		
		
	}
	@Test(groups = "Regression Test")
	public void m6() {
		WebDriver driver = new FirefoxDriver();
		System.out.println("M6 executed");//Regression


}
}