package testng_pkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JanasyaPro {
	WebDriver driver;
	String url = "https://janasya.com/";
	
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
	 public void janasyawebsite() {
		 driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
		 
		 Boolean logo = driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]")).isDisplayed();
			if(logo) {
			  System.out.println("Logo is displayed");	
			}
			else
			{
				System.out.println("Logo Not selected");
			}
			

			
			 driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/toolbar-item[1]/div[2]/div[3]/div[1]/div[1]/div[1]")).click();
			 driver.findElement(By.xpath("//span[contains(text(),'15')]")).click();
			 
			 WebElement categ = driver.findElement(By.xpath("//h3[contains(text(),'Categories')]"));
			 categ.click();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 driver.findElement(By.xpath("//div[@id='CollectionSection-template--16349890937002__product-grid']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")).click();
			 
			
			 
	 
			 

			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,600)");
			 driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]")).click();
			 
			
			 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
			 driver.findElement(By.id("44199301382314")).click();
			 
			
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); 
//        	   driver.findElement(By.xpath("//body/div[@id='halo-cart-sidebar']/button[1]")).click();
			
			
		
			driver.navigate().back();
			 
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			 WebElement ethic = driver.findElement(By.xpath("//sticky-header/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]"));
			 Actions act = new Actions(driver);
			 act.moveToElement(ethic).perform();
			  
			  
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//sticky-header/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/ul[1]/li[3]/a[1]"))).click();
			  
			  WebElement search = driver.findElement(By.id("Search-In-Modal"));
			  search.sendKeys("kurtha",Keys.ENTER);
			  
			  driver.findElement(By.xpath("//header/div[1]/div[1]/div[3]/div[1]/div[1]/a[2]")).click();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); 
			  
			  
			  
			  
	 }
	 
	 @Test
	 public void locatelinks() {
		 List<WebElement> li = driver.findElements(By.tagName("a"));		
			System.out.println("Total no. of links in the page : "+li.size());
			
			for(WebElement data : li) {
				String link = data.getAttribute("href");
				System.out.println(data.getText()+" - "+link);
			}
			
			
			
			 List<WebElement> navbarmenu = driver.findElements(By.tagName("ul"));
			 for (WebElement menu : navbarmenu) {
				 
		            System.out.println(menu.getText());
		        }
		 
	 }
	 
	 
	 
	 

}