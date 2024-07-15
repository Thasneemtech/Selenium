package testng_pkg;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VrlTravels {
	
	WebDriver driver;
	String url = "https://www.vrlbus.in";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void urlLoad() {
		driver.get(url);
	}
	
	@Test
	public void titleVerify() {
		
		String expectation = "VRL TRAVELS";
		String actual = driver.getTitle();
		System.out.println("Actual Result = "+actual);
		
		if(expectation.equals(actual)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
	
	@Test
	public void pageSourceText() {
		String src = driver.getPageSource();
		
		if(src.contains("Sign In")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}		
	}
	
	@Test
	public void linksLocate() {
		List<WebElement>li = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links = "+li.size());
		
		for(WebElement data : li) {
			String links = data.getAttribute("href");
			System.out.println(data.getText() + "  " + links);
		}
		
		if(li.size()==40) {
			System.out.println("No of links = 40");
		}
		else {
			System.out.println("fail");
		}
	}
	
	@Test
	public void fillFields() {
		driver.findElement(By.xpath("//*[@id=\"largeModal\"]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"VRL_Header\"]/div/div/div/div/div[2]/div[2]/a")).click();
		driver.findElement(By.id("txtPhoneNo")).sendKeys("2324354656");
		
		driver.findElement(By.xpath("//*[@id=\"largeModal\"]/div/div/button")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
}

