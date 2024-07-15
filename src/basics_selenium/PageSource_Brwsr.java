package basics_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageSource_Brwsr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com");
		
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		
		//driver = new EdgeDriver();
		//driver.get("https://www.google.com");
		
		String src = driver.getPageSource();
		
		if(src.contains("Gmail")) {
			System.out.println("Text is Present");
		}
		else {
			System.out.println("Text is not Present");
		}

	}

}
