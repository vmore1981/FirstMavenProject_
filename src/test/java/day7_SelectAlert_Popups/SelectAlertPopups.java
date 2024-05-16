package day7_SelectAlert_Popups;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectAlertPopups {

	
	public static void main(String[] args) throws InterruptedException {
		
		specDropdown();
		
		
	}
	
	
	
	public static void specDropdown() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		driver.findElement(By.xpath("(//div[@class=\"ui fluid search selection dropdown\"])[1]")).click();
		
		Thread.sleep(500);

		driver.findElement(By.xpath("(//div[text()='Algeria'])[1]")).click();
		
		
		
	}
	
	
	
	
	public static void selectDemo() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://demoqa.com/select-menu");
		
		
		WebElement colors = driver.findElement(By.id("oldSelectMenu"));
		Thread.sleep(300);
		Select letsSelect = new Select(colors);
		
		String firstSelectedColor = letsSelect.getFirstSelectedOption().getText();
		
		System.out.println("Get the First Selected Option is: " + firstSelectedColor);
		
//		letsSelect.selectByVisibleText("Purple");
				
		letsSelect.selectByIndex(8);
		
		// Get all the selected options.
		
		List <WebElement> allColors = letsSelect.getAllSelectedOptions(); 
		
		for(WebElement color : allColors) {
			System.out.println("Color is: " + color.getText());
		}
		
		
		System.out.println("Number of SELECTED colors is: " + allColors.size());
		
		
		
		letsSelect.
		
		
	}
	
	
	
}
