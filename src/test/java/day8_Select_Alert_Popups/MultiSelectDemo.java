package day8_Select_Alert_Popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiSelectDemo {

	
	public static void main(String [] args) throws InterruptedException {
				
		sebDriverWaitDemo();
						
	}
	
	
	public static void sebDriverWaitDemo() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		driver.get("https://ebay.com");

		driver.findElement(By.linkText("Motors")).click();

		WebDriverWait letswait = new WebDriverWait(driver,Duration.ofSeconds(5));

		letswait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Add a vehicle']")));

//		WebElement addVehicleText = driver.findElement(By.xpath("//div[text()='Add a ve']"));
//		letswait.until(ExpectedConditions.visibilityOf(addVehicleText));
		
		
		System.out.println("Element ADD VEHICLE is VISIBLE");
		
		
	}
	
	
	
	public static void deselectDemo() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		driver.get("https://demoqa.com/select-menu");
		
		driver.findElement(By.xpath("//div[text() = 'Select...']")).click();
		
		Thread.sleep(1000);
		
		// WebElement drop = driver.findElement(By.xpath("(//div[@class = ' css-2b097c-container'])[3]"));
		
		driver.findElement(By.xpath("//div[text() = 'Green']")).click();
		driver.findElement(By.xpath("//div[text() = 'Red']")).click();
		driver.findElement(By.xpath("//div[text() = 'Blue']")).click();
		driver.findElement(By.xpath("//div[text() = 'Black']")).click();

		Thread.sleep(500);

		driver.findElement(By.xpath("(//div[@class = 'css-xb97g8'])[4]")).click();
	
	}
	
	
	public static void selectMultiDeselectDemo() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/select-menu");
		
		driver.findElement(By.xpath("//div[text() = 'Select...']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//option[text() = 'Volvo']")).click();
		driver.findElement(By.xpath("//option[text() = 'Saab']")).click();
		driver.findElement(By.xpath("//option[text() = 'Opel']")).click();
		driver.findElement(By.xpath("//option[text() = 'Audi']")).click();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//option[text() = 'Volvo']")).click();
		driver.findElement(By.xpath("//option[text() = 'Saab']")).click();
		driver.findElement(By.xpath("//option[text() = 'Opel']")).click();
		driver.findElement(By.xpath("//option[text() = 'Audi']")).click();

		WebElement cars = driver.findElement(By.id("cars"));
		
		Select select = new Select(cars);
		select.selectByVisibleText("Volvo");
		select.selectByVisibleText("Saab");
		select.selectByVisibleText("Opel");
		select.selectByVisibleText("Audi");
		
		select.deselectByVisibleText("Saab");
		
		Thread.sleep(1000);
		
		select.deselectAll();
		
	}
	
}
