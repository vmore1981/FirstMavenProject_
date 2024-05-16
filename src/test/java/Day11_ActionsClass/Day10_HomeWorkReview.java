package Day11_ActionsClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day10_HomeWorkReview {

	
	public static void main(String[] args) {
	
		guru99_windowHandle();
		
		
	}
	
	
	public static void guru99_windowHandle() {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("http://demo.guru99.com/popup.php");
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
	
		String title = driver.getTitle();
		
		String mainWindowID = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set <String> windowsID = driver.getWindowHandles();
		
		Iterator <String> iter = windowsID.iterator();
		
		String firstWindowID = iter.next();
		
		String secondWindowID = iter.next();
				
		driver.switchTo().window(secondWindowID);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='emailid']")));
				
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("vmore.corp@gmail.com");
		
		driver.findElement(By.name("btnLogin")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
	
		String h2Text = driver.findElement(By.xpath("//h2[contains(text(),'Access details to demo site.')]")).getText();
		
		if (h2Text.equals("Access details to demo site.")) {
			
			System.out.println("SUCCESS");
	
		} else {
		
			System.out.println("FAIL");
			
		}
		
		String userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		String passwordID = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

		System.out.println("User ID: " + userID);
		System.out.println("Password: " + pa sswordID);
		
		
		
				
		driver.quit();
		
		
	}
	
	
}
