package test;

import org.testng.annotations.Test;

import junit.framework.Assert;
import page.CreatePage;
import page.FbLoginpage;
import page.PageafactryFbLoginPage;

public class PageFctryFblginTest extends BaseClass {
	
	public void loginTest() {
		PageafactryFbLoginPage ob = new PageafactryFbLoginPage(driver);
		ob.setValues("abc@gmail.com", "abc");
		ob.loginClick();
		
		driver.navigate().back();
		driver.navigate().back();
	}
	
	@Test
	public void createTestacti() {
		CreatePage cp = new CreatePage(driver);
		cp.createPageClick();
		String Actualtitle = cp.titleVerification();
		System.out.println(Actualtitle);
		Assert.assertEquals(Actualtitle, "Facebook");
		
	}
	
}
