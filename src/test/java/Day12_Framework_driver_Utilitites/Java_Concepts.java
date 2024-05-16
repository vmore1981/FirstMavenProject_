package Day12_Framework_driver_Utilitites;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java_Concepts {

	
	public static void main (String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		WebElement Web = driver.findElement(By.id("default"));
		
		webelClick(Web);
		System.out.println(con("CCC+ ","+DDD"));
		
	}
	
	
	public static String webel_RetString(WebElement W) {
		
		return W.getText();
	}
	
	public static void webelClick_Print(WebElement W, String Str) {
	
		W.sendKeys(Str);
	}

	
	public static void webelClick(WebElement W) {
		
		W.click();
	}
	
	
	public static String con (String A, String B) {
		
		String c = A + B;
		return c;
	}
	
	
}
