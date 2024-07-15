package junit_pkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextVerificagtion {
	
	WebDriver driver;
	String url = "https://www.google.com";
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void srchBtntextVerification() {
		
		driver.get(url);
		
		String expectation = "Google Search";
		String actual = driver.findElement(By.name("btnK")).getAttribute("value");
		System.out.println("Actual text : "+actual);
		
		if(expectation.equals(actual)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
	
	@After
	public void brwsrClsing() {
		
		driver.quit();
	}
}
