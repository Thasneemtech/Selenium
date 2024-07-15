package basics_selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver =  new ChromeDriver();
		driver.get("https://www.google.com");
		EdgeDriver driver1 = new EdgeDriver();
		driver1.get("https://www.facebook.com");

	}

}
