package junit_pkg;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	WebDriver driver;
	String url = "https://www.luminartechnolab.com";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void pageScreenShot() throws Exception{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("‪C:\\Selenium\\Screenshot.png"));
	}
	
	@Test
	public void elementScreenShot() throws IOException{
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[2]/div/div[1]/svg/path"));
		File src1 = ele.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, new File("‪C:\\Selenium\\Screenshot1.png"));
	}
	
	@After
	public void browerClose() {
		driver.quit();
	}

}
