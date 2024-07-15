package testng_pkg;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGenerator {

	WebDriver driver;
	String url = "https://www.facebook.com";
	
	ExtentHtmlReporter reporter;//create reference variables for 3 classes of extend reporter
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
	public void setUp() {
		reporter = new ExtentHtmlReporter("./Reports/myreport1.html");//it is a path for storing to the project
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "Localhost");
		extent.setSystemInfo("OS","Windows 10 pro");
		extent.setSystemInfo("Tester Name", "Thasneem");
		extent.setSystemInfo("Browser Name", "Chrome");
		
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void loadUrl() {
		driver.get(url);
	}
	
	@Test
	public void fbTitleVerification() {
		test = extent.createTest("FbTitleVerification");
		String exp = "facebook";
		String act = driver.getTitle();
		System.out.println(act);
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void buttonTextVerification() {
		test = extent.createTest("buttonTextVerification");
//		String expectation = "LOGIN";
//		String actual = driver.findElement(By.name("login")).getText();
//		System.out.println("Actual text : "+actual);
//		Assert.assertEquals(expectation,actual);
	}
	
	@AfterMethod
	public void browserClose(ITestResult result) throws IOException {//ITestResult is a listener in testng for report generation
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
	
	public static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = "./Screenshot/"+screenshotname+".png";
		
		org.openqa.selenium.io.FileHandler.copy(src,new File(destination));
		return destination;
	}
	
	@AfterTest
	public void teardown() {
		extent.flush();//used for generate report
	}


	
}

