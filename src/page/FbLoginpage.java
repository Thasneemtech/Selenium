package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbLoginpage {
	
	/* Company level project creation
	 * 1st step Project creation --> in maven (project build automation tool)
	 * 2nd --> Design pattern --> POM
	 * 3rd --> language --> java
	 * 4th --> for comparison we use Testng
	 * 5th --> Framework --> DataDriven Frame work
	 */
	
	WebDriver driver;
	
	//create object repository
	
	By fbemail = By.id("email");
	By fbpswd = By.id("pass");
	By fbloginbutton = By.name("login");
	
	//contructor
	public FbLoginpage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//action methods
	public void setValues(String email, String pswd) {
		driver.findElement(fbemail).sendKeys(email);
		driver.findElement(fbpswd).sendKeys(pswd);
	}
	
	//action methods
	public void login() {
		driver.findElement(fbloginbutton).click();
		
	}


	
	

}
