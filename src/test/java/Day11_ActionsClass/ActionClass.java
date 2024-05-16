package Day11_ActionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass {

	
	public static void main(String[] args) {
		
		dragNdrop();
		
		//actionsHoverOver();
		
		
	}
	
	
	public static void dragNdrop() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  
	
		driver.get("https://demoqa.com/droppable");

		Actions act = new Actions(driver);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(drag, drop).build().perform();
		
		act.click(drop);
		
				
	}
	
	public static void actionsHoverOver() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));  
	
		driver.get("https://demoqa.com/menu");
		
		Actions act = new Actions(driver);
		
		WebElement menu1 = driver.findElement(By.linkText("Main Item 2"));
		act.moveToElement(menu1).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("SUB SUB LIST")));
		
		WebElement menu2 = driver.findElement(By.partialLinkText("SUB SUB LIST"));
		act.moveToElement(menu2).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sub Sub Item 1")));
		
		WebElement menu3 = driver.findElement(By.linkText("Sub Sub Item 1"));
		act.moveToElement(menu3).build().perform();
		
		
	}
	
}
