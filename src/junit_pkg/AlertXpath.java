package junit_pkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertXpath {
	
	WebDriver driver;
	String url = "file:///C:/Users/dell/Desktop/alert.html";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void atertXpathLocate() {
		
		//Absolute Xpath                                                   //Unhandled alerr exception
		//driver.findElement(By.xpath("/html/body/input[1]")).click();
	   //driver.findElement(By.xpath("/html/body/input[2]")).sendKeys("THASNEEM");
		//driver.findElement(By.xpath("/html/body/input[3]")).sendKeys("KP");
		//driver.findElement(By.xpath("/html/body/input[4]")).click();
		
		
		//RELATIVE
		driver.findElement(By.xpath("//input[1]]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//input[2]")).sendKeys("THASNEEM");
		driver.findElement(By.xpath("//input[3]")).sendKeys("KP");
		driver.findElement(By.xpath("//input[4]")).click();
		
	}
	@After
	public void brwsrClose() {
		driver.quit();

	}
}
