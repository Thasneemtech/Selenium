package testng_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	WebDriver driver;
	String url = "https://demoqa.com/droppable";
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void pageLoad() {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void dragDrop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.ScrollBy(0,500)","");
		
		WebElement dragme = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement drophere = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(dragme, drophere).perform();
		
		String expt = "Dropped!";
		String actual = driver.findElement(By.xpath("//*[@id=\"droppable\"]")).getText();
		System.out.println(actual);
		
		if(expt.equalsIgnoreCase(actual)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}

}
