package testng_pkg;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadUsingAutoIt {
	
	WebDriver driver;
	String url = "https://www.ilovepdf.com/word_to_pdf";
	
	@BeforeTest
	public void setUp() {
		driver= new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void fileUpldAutoit() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]/span")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\AutoItScripts\\Script1.exe");
		Thread.sleep(3000);
	}
}
