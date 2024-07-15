package basics_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		String src = driver.getPageSource();
		
		//if(src.contains("Gmail")&&src.contains("thasni")) {
		
		if(src.contains("Privacy")) {
			System.out.println("Text is Present");
		}
		else {
			System.out.println("Text is not Present");
		}
	}

}
