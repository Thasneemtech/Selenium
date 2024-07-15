package testng_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginValidatnpro {
	
	WebDriver driver;
	String url = "https://www.torrid.com/account";
	
	@BeforeTest
	public void setUp() {
		driver= new ChromeDriver();
	}
	
	@BeforeMethod
	public void pageLoad() {
		driver.get(url);
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void signIn() {
		driver.findElement(By.xpath("//input[@id='dwfrm_login_username_d0vaggfnlmbb']")).sendKeys("thasneemkp1999@gmail.com");
		driver.findElement(By.xpath("//input[@id='dwfrm_login_password']")).sendKeys("Torrid@123");
		driver.findElement(By.xpath("//button[@name='dwfrm_login_login']")).click();
		
		String actualCurrent_url = driver.getCurrentUrl();
		System.out.println("Current url = "+actualCurrent_url);
		String expectation = "https://www.torrid.com/account?loginflow=myaccount";
		
		if(actualCurrent_url.equalsIgnoreCase(expectation)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
}
