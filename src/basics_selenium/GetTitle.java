package basics_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		String expectation = "google";
		String actual = driver.getTitle();
		System.out.println("Actual Result : "+actual);
		
		if(expectation.equals(actual)) {
			System.out.println("Pass");
		}
		else {
				System.out.println("Fail");
			}
		

	}

}
