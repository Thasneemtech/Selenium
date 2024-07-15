package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageafactryFbLoginPage {

	WebDriver driver;
	
	@FindBy(id = "email")
	WebElement fbEmail;
	
	@FindBy(id = "pass")
	WebElement fbPass;
	
	@FindBy(name = "login")
	WebElement fbLogin;
	
	public PageafactryFbLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this); //initializing the webelements
		
	}
	
	public void setValues(String UN,String pswd) {
		fbEmail.sendKeys(UN);
		fbPass.sendKeys(pswd);
	}
	
	public void loginClick() {
		fbLogin.click();
		
	}
}

