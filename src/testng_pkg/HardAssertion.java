package testng_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class HardAssertion {
	
	WebDriver driver;
	String url = "https://www.google.com";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void hardAssertion() {
		String expct = "google";
		String act = driver.getTitle();
		System.out.println("Actual = "+act);
		//Assert.assertEquals(act, expct,""Title is not seen);
		Assert.assertEquals(act, expct);
	}
	
}
