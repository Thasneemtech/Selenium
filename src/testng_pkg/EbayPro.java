package testng_pkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EbayPro {
	WebDriver driver;
	String url = "https://www.ebay.com";
	
	@BeforeTest
	public void setUp() {
		driver= new ChromeDriver();
	}
	
	@BeforeMethod
	public void pageLoad() {
		driver.get(url);
		
		driver.manage().window().maximize();
	}
	
//	@Test
//	public void signInclick() {
//		driver.findElement(By.xpath("//*[@id=\"gh-ug\"]/a")).click();
//		driver.findElement(By.id("userid")).sendKeys("thasneemkp1999@gmail.com");
//		driver.findElement(By.id("signin-continue-btn")).click();
//		driver.findElement(By.xpath("//*[@id=\"signin_ggl_btn\"]")).click();
//		driver.findElement(By.id("passkeys-cancel-btn")).click();
		
	@Test
	public void brokenLinks() {
		List<WebElement>li = driver.findElements(By.tagName("a"));
		System.out.println(li.size());
		
		for(WebElement data : li) {
			String links = data.getAttribute("href");
			String linkText = data.getText();
			System.out.println(linkText + " \t " + links );

		}
		
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"gh-p-1\"]/a"));
		ele.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		
		WebElement img = driver.findElement(By.xpath("//*[@id=\"refit-spf-container\"]/div[2]/div[3]/div/div[2]/div/div/div[1]/a/div/img"));
		img.click();
	
		//WebElement prdct = driver.findElement(By.xpath("//*[@id=\"refit-spf-container\"]/div[2]/div[3]/div/div[2]/div/div/div[1]/a/div/img"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)", "");
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"atcBtn_btn_1\"]"));
        addToCartButton.click();
	}
//
//	@Test
//	public void dropDown() {
//
//		WebElement elmnt = driver.findElement(By.xpath("//*[@id=\"gh-eb-My\"]/div/a[1]/i"));
//		Select d = new Select(elmnt);
//		d.selectByVisibleText("https://www.ebay.com/mye/myebay/summary");
//		
//	}

		


}
