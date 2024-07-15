package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.FbLoginpage;

public class FbLoginTest {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		FbLoginpage ob = new FbLoginpage(driver);
		Thread.sleep(2000);
		ob.setValues("abc@gmail.com","abc");
		ob.login();
		driver.navigate().back();
	}

}
