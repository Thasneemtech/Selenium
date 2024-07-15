package testng_pkg;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JanasyaPro {
	
	WebDriver driver;
	String url = "https://janasya.com";
	
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
	public void newclick() {
		driver.findElement(By.xpath("//*[@id=\"HeaderNavigation\"]/nav/ul/li[1]/a/span")).click();
	}
	
	@Test
	public void logoVerify() {
		
		Boolean logo = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16349892411562__0551e2c3-4916-467e-a6e9-b0d8594a3ff3\"]/header/div/div/div[2]/div/div/div/a/img")).isDisplayed();
		if(logo) {
			System.out.println("Logo is present");
		}
		else{
			System.out.println("Logo is not present");
		}
	}
	
//	@Test
//	public void dropDown() {
//		WebElement drpdwn = driver.findElement(By.xpath("//*[@id=\"CollectionProductGrid\"]/div/toolbar-item/div[2]/div[3]/div[1]/div/div/span[2]"));
//		Select dd = new Select(drpdwn);
//		dd.selectByVisibleText("15");
//		
//	}
//	
//	@Test
//	public void slctCategories() {
//		WebElement drpdwn1 = driver.findElement(By.xpath("//*[@id=\"halo-sidebar\"]/div[2]/div[1]/div[1]/h3"));
//		Select dd1 = new Select(drpdwn1);
//		dd1.selectByVisibleText("Kurtas");
//	}
//	
	@Test
	public void linksLocate() {
		
		List<WebElement>li = driver.findElements(By.tagName("a"));  //here datas stored in li
		System.out.println("Total no of links : "+li.size());
		
		    for(WebElement data : li) {
			String links = data .getAttribute("href");   //for-each loop
			System.out.println(data.getText() + "   " + links);
		    }
	}
	
	@Test
	public void menusLocate() {
		
		List<WebElement> menu = driver.findElements(By.tagName("ul"));
		System.out.println("Total no of menus : "+menu.size());
		
		for(WebElement data : menu) {
			System.out.println(data.getText());
		}
	}
	
	@Test
	public void searchText() {
		WebElement search = driver.findElement(By.id("Layer_1"));
		search.sendKeys("kurta");
		search.submit();
	}
	
	@Test
	public void windowHandle() {
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow = "+driver.getTitle());
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles) {
			if(!handle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(handle);
				driver.findElement(By.name("emailid")).sendKeys("abc123@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
		
		
	}
	
}
