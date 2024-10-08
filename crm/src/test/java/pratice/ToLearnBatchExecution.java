package pratice;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToLearnBatchExecution {
	
	@Test(groups = "Smoke Test")
	public void m1() {
		WebDriver driver = new FirefoxDriver();
		System.out.println("M1 executed");//smoke
		
	}
	@Test(groups = "Regression Test")
	public void m21() {
		WebDriver driver = new FirefoxDriver();
		System.out.println("M2 executed");//Regression
		
		
		
	}
	@Test(groups = "Regression Test")
	public void m3() {
		WebDriver driver = new FirefoxDriver();
		System.out.println("M3 executed");//Regression

}
}
