package testng_pkg;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandlerWrk {
	
	WebDriver driver;
	String url = "https://www.amazon.in/";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}
	
   @BeforeMethod
	public void urlLoading() {
		driver.get(url);	
		driver.manage().window().maximize();
	}
   @Test
    public void amazon() throws InterruptedException {
	   WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Mobilephones",Keys.ENTER);
		
//		String excepted = "Mobilephones";
//		String actual = driver.getTitle();
//		System.out.println("Actual title is : "+actual);
//		Assert.assertEquals(actual, excepted, "Title not found");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window = "+driver.getTitle());
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/a[1]/div[1]/img[1]")).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles) {
			if(!handle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(handle);
				
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,250)");
				
				
				driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[38]/div[1]/span[1]/span[1]/span[1]/input[1]")).click();
				
				
				
			}
			
			
		}
		
		String parentWindow1 = driver.getWindowHandle();
		System.out.println("Parent Window = "+driver.getTitle());
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[38]/div[1]/span[1]/span[1]/span[1]/input[1]")).click();
		
		Set<String> allWindowHandles1 = driver.getWindowHandles();
		for(String handle : allWindowHandles1) {
			if(!handle.equalsIgnoreCase(parentWindow1)) {
				driver.switchTo().window(handle);
				
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,250)");
				
				
			
//		    WebElement button= driver.findElement(By.xpath("//body/div[8]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/span[1]/span[1]/input[1]"));
//			button.click();	
			driver.close();
   }
				
   		driver.switchTo().window(parentWindow1);
			
			

}
		
		
		Thread.sleep(3000);
		driver.navigate().back();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(250,0)");
		
		driver.findElement(By.id("nav-cart-count-container")).click();
   }
   
   
   
   
   
   
   
   
   
   
   
   

}