package junit_pkg; 

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonWork {
	
	WebDriver driver;
	String url = "https://www.amazon.in";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void getTitleVerify() {
		String Expectation = "Amazone";
		String Actual = driver.getTitle();
		System.out.println("Actual Result = "+Actual);
		
		if(Expectation.equalsIgnoreCase(Actual)) {
			System.out.println("Pass");
			}
		else {
			System.out.println("Fail");
		}
	}
	
	@Test
	public void pageSource() {
		String src = driver.getPageSource();
		
		if(src.contains("Mobiles")) {
			System.out.println("Text is present");
		}
		else {
			System.out.println("Text is not present");
		}
	}
	
	@Test
	public void searchLocator() {
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("Electronics");
		search.submit();
	}
	
	@Test
	public void signinLocator() {
		
		driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc123@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
	
		driver.navigate().back();
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[@id='nav-xshop']/a[5]")).click();
		driver.findElement(By.id("nav-cart-count")).click();
		driver.findElement(By.id("nav-hamburger-menu")).click();
	}
	
	@Test
	public void linksLocate() {
		
		List<WebElement>li = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links : "+li.size());
		
		for(int i=0;i<li.size();i++) {
			WebElement s = li.get(i);
			String links = s.getAttribute("href");
			String linkTest = s.getText();
			System.out.println(linkTest + "\t" + links);
		}	
	}
}

