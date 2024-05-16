package Day12_Framework_driver_Utilitites;

import org.openqa.selenium.By;

import Utils.DataReader;
import Utils.Driver;

public class DriverDemo {

	
	public static void main(String[] args) {
		
		sauceDemoTest();
		
		
	}
	
	
	public static void sauceDemoTest() {
		
		Driver.getDriver().get("https://saucedemo.com");
		Driver.getDriver().findElement(By.id("user-name")).sendKeys(DataReader.getProperty("sauce_username"));
		Driver.getDriver().findElement(By.id("password")).sendKeys(DataReader.getProperty("sauce_password"));
		Driver.getDriver().findElement(By.id("login-button")).click();
		
	}
	
}
