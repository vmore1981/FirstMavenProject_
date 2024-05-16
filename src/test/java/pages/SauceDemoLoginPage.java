package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utils.Driver;

public class SauceDemoLoginPage {

	
	public SauceDemoLoginPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);	
	
	}
	


	@FindBy (id = "user-name")
	public WebElement loginUsername;
	
	@FindBy (id = "password")
	public WebElement loginPassword;

	@FindBy (xpath = "//input[@id='login-button']")
	public WebElement loginBtn;
	
	@FindBy (css = "h3[data-test='error']")
	public WebElement loginEmptyError;
	
	
	
	
	

}

