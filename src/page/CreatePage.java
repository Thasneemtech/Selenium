package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage {
	WebDriver driver;
	
	//pagefactory
	@FindBy(xpath = "//*[@id=\"reg_pages_msg\"]/a")
	WebElement createPage;

	public CreatePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void createPageClick() {
		// TODO Auto-generated method stub
		createPage.click();
		
	}

	public String titleVerification() {
		// TODO Auto-generated method stub
		String Actualtitle = driver.getTitle();
		return null;
	}

}
