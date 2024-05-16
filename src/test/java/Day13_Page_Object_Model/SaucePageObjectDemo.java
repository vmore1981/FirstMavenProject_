package Day13_Page_Object_Model;

import Utils.DataReader;
import Utils.Driver;
import pages.SauceDemoLoginPage;


public class SaucePageObjectDemo {

	
	public static void main (String [] args) {
		
		sauceLoginDemo();
		
	}
	
	
	public static void sauceLoginDemo() {
		
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
		
		 
		Driver.getDriver().get(DataReader.getProperty("sauce_url"));
		
		loginPage.loginUsername.sendKeys(DataReader.getProperty("sauce_username"));
		
		loginPage.loginPassword.sendKeys(DataReader.getProperty("sauce_password"));

		loginPage.loginBtn.click();
		
//		Driver.quitDriver();
		
				
	}
	
	
}
