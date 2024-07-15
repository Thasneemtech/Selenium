package testng_pkg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenTesting {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUpEnv() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() throws IOException {
		FileInputStream f = new FileInputStream("‪C:\\Users\\dell\\Documents\\Book1poi.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);	
		XSSFSheet sh = wb.getSheet("Sheet1");
		int row = sh.getLastRowNum();
		System.out.println(row);
		for(int i=1;i<=row;i++) {
			String email = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("email = "+email);
			String pswd = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password = "+pswd);
			
			driver.get("https://www.facebook.com");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(pswd);
			driver.findElement(By.xpath("//button[@name='login']")).click();
			
		}
		
		
	}

}
