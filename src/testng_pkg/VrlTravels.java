package testng_pkg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class VrlTravels {
	WebDriver driver;
	String url = "https://www.vrlbus.in";
	
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void urlLoading() {
		driver.get(url);
	}
	
	@Test
	public void testVerify() {
		String expectation = "Vijayanand Travels Private Ltd | ONLINE BUS TICKET BOOKINGS & TRAVEL SERVICES";
		String actual = driver.getTitle();
		System.out.println("Actual title is : "+actual);
		if(expectation.contains(actual)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
	
	@Test
	public void registerPage() {
		String src = driver.getPageSource();
		if(src.contains("Sign in / Sign up") ) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
	
	@Test
	public void links() {
		List<WebElement> li = driver.findElements(By.tagName("a"));		
		System.out.println("Total no. of links in the page : "+li.size());
		
		for(WebElement data : li) {
			String link = data.getAttribute("href");//values inside the href attribute so use get method
			System.out.println(data.getText()+" - "+link);
		}
	
		if(li.size() == 40) {
			System.out.println("number of links is 40");
		}
		else {
			System.out.println("Fail");
		}
	}
	
//	@Test
//	public void allField() {
//		
//		driver.findElement(By.xpath("//div[@id='largeModal']/div[1]/div[1]/button[1]")).click();
//		driver.findElement(By.xpath("//section[@id='VRL_Header']/div[1]/div[1]/div[1]/div[1]/div[2]//div[2]/a[1]")).click();
//	    driver.findElement(By.name("mobileNo")).sendKeys("8606295904");
//		
//		driver.findElement(By.tagName("button")).click();
//		
//		Alert alert = driver.switchTo().alert();		
//	    alert.accept();
//			}
	
	@Test
	public void radioButton() {
		Boolean rad = driver.findElement(By.xpath("//body/form[@id='aspnetForm']/div[3]/div[2]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/div[1]/div[1]/label[2]/span[1]/input[1]")).isSelected();
		if(rad) {
		  System.out.println("Selected");	
		}
		else
		{
			System.out.println("Not selected");
		}
	}
	
	@Test
	public void logoDisplayed() {
		Boolean rad1 = driver.findElement(By.xpath("//body/form[@id='aspnetForm']/div[3]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).isDisplayed();
		if(rad1) {
		  System.out.println("Logo is displayed");	
		}
		else
		{
			System.out.println("Logo Not selected");
		}
	}
	
	@Test
	public void verifyText() {

		driver.findElement(By.xpath("//section[@id='VRL_Header']/div[1]/div[1]/div[1]/div[1]/div[2]//div[2]/a[1]")).click();
		try {
		WebElement submitButton = driver.findElement(By.tagName("button"));
		String buttontText = submitButton.getText();
		System.out.println("The text of submit button is : "+ buttontText );
		if("Submit".equalsIgnoreCase(buttontText)) {
			System.out.println("Button text is correct");
		}else {
			System.out.println("Button text is incorrect");
		}
		}catch(Exception e) {
            e.printStackTrace();
			
		}
	}
	
	@Test
	public void screenshot() throws IOException {
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\dell\\OneDrive\\Hình ảnh\\Screenshots"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}