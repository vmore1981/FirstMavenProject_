package day8_Select_Alert_Popups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		alertAfter5Seconds();
	}

	
	public static void alertAfter5Seconds() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("timerAlertButton")).click();
		
		WebDriverWait waiter = new WebDriverWait(driver,Duration.ofSeconds(5));
		waiter.until(ExpectedConditions.alertIsPresent());		
		
		Alert handle = driver.switchTo().alert();
		
		String alertText = handle.getText(); 
 		
		if (alertText.equals("This alert appeared after 5 seconds")) {

			System.out.println("TEST IS PASSED");
		
		} else {
		
			System.out.println("TEST IS FAILED");
	
		}
		
		handle.dismiss();
	}


	
	public static void alertHandling() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("alertButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Thread.sleep(500);
		
		Alert handle = driver.switchTo().alert();
		
		// accept is for anything confirmitive like: Yes, Okay, 
		handle.accept();
		
	}
}
