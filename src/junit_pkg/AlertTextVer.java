package junit_pkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTextVer {

	WebDriver driver;
	String url = "file:///C:/Users/dell/Desktop/alert.html";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void getalertText() {
		
		driver.findElement(By.xpath("/html/body/input[1]")).click();
		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();
		if(alertText.equalsIgnoreCase("Hello ! I am an alertbox!!")) {
			System.out.println("Text is Present");
		}
		else {
			System.out.println("Text is not present");
		}
	}
}
