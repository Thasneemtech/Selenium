package junit_pkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RediffDropdown {
	
	WebDriver driver;
	String url = "https://register.rediff.com/register/register.php?FormName=user_details";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void dropDownList() {
		
		WebElement day = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
		Select d = new Select(day);
		d.selectByVisibleText("22");
		
		WebElement month = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		Select m = new Select(month);
		m.selectByIndex(04);
		

		WebElement year = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
		Select y = new Select(year);
		y.selectByValue("1999");
	}
	
	@Test
	public void radioButtonCheck() {
		Boolean select = driver.findElement(By.xpath(url)).isSelected();
		
		if(select) {
			System.out.println("selected");
		}
		else {
			System.out.println("Not selected");
		}
	}

}
