package testng_pkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PrjctReportGenerator {
	
	WebDriver driver;
	String url = "https://www.greenmarknatural.com";
	
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
	public void setUp() {
		reporter = new ExtentHtmlReporter("./Reports/myreport2.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "Localhost");
		extent.setSystemInfo("OS","Windows 11 Home");
		extent.setSystemInfo("Tester Name", "Thasneem");
		extent.setSystemInfo("Browser Name", "Chrome");
		
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void loadUrl() {
		driver.get(url);
	}
	
	@Test
	public void GreenMarkTitleVerification() {
		test = extent.createTest("GreenMarkTitleVerification");
		String exp = "Green Mark Natural Solutions - Top Ayurvedic Herbal Products and Medicine Dealer in Mullurkkara, Thrissur, Kerala, India";
		String act = driver.getTitle();
		System.out.println(act);
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void buttonTextVerification() {
		test = extent.createTest("buttonTextVerification");
		String expectation = "Search";
		String actual = driver.findElement(By.xpath("//span[contains(text(),'Search')]")).getText();
		System.out.println("Actual text : "+actual);
		Assert.assertEquals(expectation,actual);
	}
	
	@AfterMethod
	public void browserClose(ITestResult result) throws IOException {
		if(result.getStatus()==TestResult.FAILURE) {
			test.log(Status.FAIL, "Test case failed is "+result.getName());
			test.log(Status.FAIL, "Test case failed is "+result.getThrowable());
			String screenshotPath = screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case skipped is "+result.getName());
		
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,  "Test case passed is "+result.getName());
		
		}
	}
	
	private String screenshotMethod(WebDriver driver, String screenshotname) throws IOException {
		//TODO Auto-generated method stub
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = "./Screenshot/"+screenshotname+".png";
		
		FileHandler.copy(src,new File(destination));
		return destination;
	}
	
	@AfterTest
	public void teardown() {
		extent.flush();
	}

}
