package Day10_WindowHandles;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandleDemo {

				
	
	public static void main(String[] args) {
		
		demoQAWindowHandlesDemo();
		
	}
	
	
	
	public static void demoQAWindowHandlesDemo() {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/browser-windows");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
		
		String mainWindowID = driver.getWindowHandle();
		System.out.println("Main Window ID is: " + mainWindowID);
		
		driver.findElement(By.id("tabButton")).click();
		
		
		
		Set <String> mainWindowsID = driver.getWindowHandles();
		
		String newWindow = mainWindowID;
		
		for(String windowSingle : mainWindowsID) {
				
			if(!windowSingle.equals(mainWindowID)) {
				newWindow = windowSingle;				
			}
			System.out.println(windowSingle);
		}
		
		
		//Iterator over collection of items
		
		Iterator <String> iterate = mainWindowsID.iterator();
		String firstWindowID = iterate.next();

		
		driver.switchTo().window(newWindow);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
		
		if (driver.findElement(By.id("sampleHeading")).getText().equals("This is a sample page")) {

			System.out.println("MISSION ACCOMPLISHED!");
			
		} else {
			
			System.out.println("FAIL");
			
		}
		
		driver.close();
		
		
		
		driver.switchTo().window(mainWindowID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));

		System.out.println("STEP almost DONE");
		driver.findElement(By.id("tabButton")).click();
		
		System.out.println("FINAL");
		
		
		driver.quit();
		
		
		
	}
	
	
}
