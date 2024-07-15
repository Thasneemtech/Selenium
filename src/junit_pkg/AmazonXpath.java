package junit_pkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonXpath {
	
	WebDriver driver;
	String url = "https://www.amazon.in";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void mobileLinkLocate() {
		driver.findElement(By.xpath("//*[@id='nav-xshop']/a[6]")).click();
		driver.findElement(By.xpath("//*[@id='nav-xshop']/a[10]")).click();
		
	}

	@After
	public void brwsrClose() {
		driver.quit();
	}
}