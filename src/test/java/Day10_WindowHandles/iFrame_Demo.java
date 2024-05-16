package Day10_WindowHandles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;



public class iFrame_Demo {

	
	public static void main (String [] args) {
			
		nestedIframe();
		
	}
	
	
	public static void nestedIframe() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/nestedframes");
		
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		
		driver.switchTo().frame(driver.findElement(By.id("frame2")));
		
		
		
	}
	
	
	public static void iFrameDemo() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/frames");
		
		String mainTextPart = driver.findElement(By.xpath("//div[contains(text(),'Sample Iframe page There are 2 ')]")).getText();
		
		System.out.println(mainTextPart);
		
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		
		String iFrame1text = driver.findElement(By.xpath("//h1[contains(text(),'This is a sample page')]")).getText();
		
		if (iFrame1text.equals("This is a sample page")) {
		
			System.out.println("Text in iFrame1 = 'This is a sample page'");
			
		} else {
			
			System.out.println("Text in iFrame1 != 'This is a sample page'");
						
		}
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.id("frame2")));
		
		String iFrame2text = driver.findElement(By.id("sampleHeading")).getText();
		
		if (iFrame2text.equals("This is a sample page")) {
		
			System.out.println("Text in iFrame2 = 'This is a sample page'");
			
		} else {
			
			System.out.println("Text in iFrame2 != 'This is a sample page'");
						
		}
		
		driver.quit();
		
	}
	
}
