package junit_pkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
	
	WebDriver driver;
	String url = "https://www.google.com";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void elementLocator() {
		//driver.findElement(By.name("q")).sendKeys("books");
		//driver.findElement(By.name("btnK")).click();// when runs here comes error suchas "Element not interactable Exception"
		     
		//WebElement search = driver.findElement(By.name("q"));
		//search.sendKeys("Books",Keys.ENTER);
		
		     //OR
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Books");
		search.submit();
	}

}
