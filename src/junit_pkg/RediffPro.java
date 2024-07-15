package junit_pkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffPro {
	
	WebDriver driver;
	String url = "https://www.rediff.com";
	
	@Before
	public void setuP() {
		
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void checkRadButton() {
		
		Boolean rd_Btn = driver.findElement(By.xpath("")).isEnabled();
				if(rd_Btn) {
					System.out.println();
				}
	}

}
