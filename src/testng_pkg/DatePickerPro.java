package testng_pkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatePickerPro {
	
	WebDriver driver;
	String url = "https://www.trivago.com";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void loadUrl() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void datePicker() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div/fieldset/button[1]")).click();
		datePickerMethod("July 2024","23");
	}

	private void datePickerMethod(String expmnth, String expdate) throws InterruptedException {
		Thread.sleep(4000);
		while(true) {
			String actmnth = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/h3")).getText();//path for > forward button
			System.out.println(actmnth);
			if(actmnth.equals(expmnth)) {
				System.out.println("month = "+actmnth);
				break;
			}
			else {
				driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/button[2]")).click();
			}
		}
		List<WebElement> alldates = driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/button/time"));
		for(WebElement dateelement : alldates) {
			String actdate = dateelement.getText();
			if(actdate.equals(expdate)) {
				System.out.println(actdate);
				dateelement.click();
				break;
			}
		}
	
	
	}	
			

}
