package testng_pkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandlerWrk {
	
		WebDriver driver;
		String url = "https://www.amazon.in";
		
		@BeforeTest
		public void setUp() {
			driver= new ChromeDriver();
			driver.get(url);
			
			driver.manage().window().maximize();	
			}
		
		@Test
		public void searchtext(){
			WebElement search = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
			search.sendKeys("mobile phones");
			search.submit();
			
			String expectation = "Amazon.in:mobilephones";
			String actual = driver.getTitle();
			System.out.println("actual is : "+actual);
			Assert.assertEquals(expectation,actual);
			
			WebElement elem = driver.findElement(By.xpath("//*[@id=\"CardInstance0uBsPiYLNq9O6oOVbT_KAg\"]/div[1]/div[2]/div[1]/div/div[2]/a/span/span[2]"));
			elem.click();
			
	}
		
	@Test
	public void windowHandle() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)","");
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow = "+driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,800)","");
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles) {
			if(!handle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
				
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}
		
//		@Test
//		public void windowHandler1() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,500)","");
//		
//		String parentWindow = driver.getWindowHandle();
//		System.out.println("parentWindow = "+driver.getTitle());
//		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
//		
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollBy(0,800)","");
//		
//		Set<String> allWindowHandles = driver.getWindowHandles();
//		for(String handle : allWindowHandles) {
//			if(!handle.equalsIgnoreCase(parentWindow)) {
//				driver.switchTo().window(handle);
//				driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
//				
//				driver.close();
//			}
//			driver.switchTo().window(parentWindow);
//		}
//		
//	}
//
//		
//	
//	@Test
//	public void cart() throws InterruptedException {
//		Thread.sleep(30000);
//		driver.navigate().back();
//		
//		JavascriptExecutor js4 = (JavascriptExecutor) driver;
//		js4.executeScript("window.scrollBy(500,0)","");
//		
//		
//	}
	

}
		
		



