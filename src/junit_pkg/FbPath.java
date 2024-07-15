package junit_pkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbPath {
	
	WebDriver driver;
	String url = "https://www.facebook.com";
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void fbPath() {
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
	}
	
	@After
	public void brwsrClose() {
		driver.quit();
	}

}
