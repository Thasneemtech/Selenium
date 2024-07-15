package mockTest;

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

public class DemoMock {

	WebDriver driver;
	String url = "https://demo.nopcommerce.com/register?returnUrl=%2Fcar";
	
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
	public void logoVerify() {
		
		Boolean logo = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
		if(logo) {
			System.out.println("Logo is present");
		}
		else{
			System.out.println("Logo is not present");
		}
	}
	
	@Test
	public void registration() {
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Thasneem");
		driver.findElement(By.id("LastName")).sendKeys("KP");
		
		WebElement drpDwn = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]"));
		Select d = new Select(drpDwn);
		d.selectByVisibleText("22");
		
		WebElement drpDwn1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]"));
		Select m = new Select(drpDwn1);
		m.selectByValue("4");
		
		WebElement drpDwn2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]"));
		Select y = new Select(drpDwn2);
		y.selectByVisibleText("1998");
		
		driver.findElement(By.id("Email")).sendKeys("yadhuk697@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Demo@12345");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Demo@12345");
		driver.findElement(By.id("register-button")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[2]/a")).click();
		
	}
	
//	@Test
//	public void loginClick() {
//		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
//		driver.findElement(By.id("Email")).sendKeys("thasneemkp1999@gmail.com");
//		driver.findElement(By.id("Password")).sendKeys("Demo@12345");
//		driver.findElement(By.id("RememberMe")).click();
//		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
//		
//	}
	
	@Test
	public void SearchField() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Electronics");
		search.submit();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/form/div[2]/button")).click();
	}
	
	@Test
	public void linksLocate() {
		
		List<WebElement>li = driver.findElements(By.tagName("a"));  
		System.out.println("Total no of links : "+li.size());
		
		    for(WebElement data : li) {
			String links = data .getAttribute("href");   
			String linkTest = data.getText();      
        	System.out.println(linkTest +" \t "+ links);
		    }
		    
	}
	
	@Test
	public void addCart() {
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[1]/div/div[2]/div/div/a/img")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-29\"]")).click();
	}
	
	@Test
	public void scrollDown() {
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a")).click();
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			
			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[4]/div[2]/div[2]/a")).click();

	}
}
