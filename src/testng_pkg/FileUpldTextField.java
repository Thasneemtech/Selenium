package testng_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpldTextField {
	
	WebDriver driver;
	String url = "https://demo.guru99.com/test/upload";
	
	@BeforeTest
	public void setUp() {
		driver= new ChromeDriver();
	}
	
	@BeforeMethod
	public void pageLoad() {
		driver.get(url);
	}
	
	@Test
	public void textFieldFileUpld() {
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]")) ;
		upload.sendKeys("C:\\Users\\HP\\Desktop\\AIR COOLER-WPS Office-2.doc");
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"terms\"]"));
		checkbox.click();
		WebElement sbmtFile = driver.findElement(By.xpath("//*[@id=\"submitbutton\"]"));
		sbmtFile.click();
	}
	

}
