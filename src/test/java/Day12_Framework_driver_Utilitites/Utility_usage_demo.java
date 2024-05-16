package Day12_Framework_driver_Utilitites;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BrowserUtils;

public class Utility_usage_demo {

	
	public static void main(String[] args) {
		
		AlertUtilDemo();
	}
	
	
	public static void AlertUtilDemo() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		BrowserUtils utils = new BrowserUtils();
		
		
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("alertButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		utils.alert_accept(driver);
		
		driver.quit();
		
		
	}
}
