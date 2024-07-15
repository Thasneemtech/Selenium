package junit_pkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleVerify {
	
	//Instance Variable
	WebDriver driver;
	String url = "https://www.facebook.com";
	
	//Annotation
	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void elementLocate() {
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys("abc123@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("abcd@123");
		driver.findElement(By.name("login")).click();
		
	}
	
	@Test
	public void titleVerify() {
		
		String expt = "facebook";
		String act1 = driver.getTitle();
		System.out.println("Actual Title : "+act1);
		
		if(expt.equals(act1)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
	
	@Test
	public void pageSource() {
		
		String src =driver.getPageSource(); 
		
		if(src.contains("Images")) {
			System.out.println("Text is Present");
		}
		else {
			System.out.println("Text is not  present");
		}
		
	}
	
	@After
	public void browserClose() {
		driver.quit();
	}
}
