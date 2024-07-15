package junit_pkg;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksLocateGoogle {
	
	WebDriver driver;
	String url = "https://www.google.com";
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void linksLocate() {
		
		List<WebElement>li = driver.findElements(By.tagName("a"));  //here datas stored in li
		System.out.println("Total no of links : "+li.size());
		
		    for(WebElement data : li) {
			String links = data .getAttribute("href");   //for-each loop
			System.out.println(links);
		    }
		
		//for(int i=0;i<li.size();i++) {          //for loop
//			WebElement s = li.get(i);           //store the datas to webelement from li
//			String links = s.getAttribute("href");
//			String linkTest = s.getText();      //get texts
//			System.out.println(linkTest +" \t "+ links);
//		}
	}

		//@After
		//public void browserClose() {
			//driver.quit();
		
	//}
}
