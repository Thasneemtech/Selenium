package testng_pkg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	
	@BeforeTest
	public void setUp() {
		System.out.println("Browser opening");
	}
	
	@BeforeMethod
	public void urlLoad() {
		System.out.println("url loading");
	}
	
	@Test(priority = 1,invocationCount = 2)
	public void main1() {
		System.out.println("Title verification");
	}
	
	@Test(priority = -1,enabled = false)
	public void main2() {
		System.out.println("Page source");
	}
	
	@Test(priority = 0,dependsOnMethods = {"main1"})
	public void main3() {
		System.out.println("Broken links");
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Browser closing");
	}
}
