package Day9_labSession;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HomeworkReview {

	public static void main(String[] args)  {
		
		amazonSelectHW();
				
	}

	
	
	public static void amazonSelectHW() {
				
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.com");
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
	
		if(driver.getTitle().equals(expectedTitle)) {
			System.out.println("Site is GOOD");
		} else {
			System.out.println("Wrong Site");			
		}
		
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select letsSelect = new Select(dropdown);		
		
		if(letsSelect.getFirstSelectedOption().getText().equals("All Departments")) {
			
			System.out.println("All Departments is the default selected option.");
		} else {
			System.out.println("Dropdown is mismatch by default");
			
		}
		
		letsSelect.selectByVisibleText("Home & Kitchen");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee mug" + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='\"coffee mug\"']")));
		
		if (driver.getTitle().contains("coffee mug")) {
			System.out.println("Title is verified");
		} else {
			System.out.println("Title is NOT verified");
		}
		
		if (letsSelect.getFirstSelectedOption().getText().contains("Home & Kitchen")) {
			System.out.println("DropDown is verified");
		} else {
			System.out.println("DropDown is NOT verified");
		}

		
		
	}
	
	
	
	public static void ebayHW() {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://www.ebay.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
		
		WebElement searchStr = driver.findElement(By.id("gh-ac"));
		
		searchStr.sendKeys("coffee mug");
		driver.findElement(By.id("gh-btn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".srp-controls__count-heading")));
				
		List <WebElement> mugs = driver.findElements(By.cssSelector(".s-item__price"));
		
		for (WebElement itemPrice : mugs) {
			System.out.println("Item price is:  " + itemPrice.getText());
		}
		
		driver.close();
	}
	
	
	
	
	public static void amazonHomework()   {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.com");
		driver.findElement(By.linkText("Sign in securely")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

		WebElement signinH1 = driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]"));
		
		if (signinH1.isDisplayed()) {
			System.out.println("Sign In page is VALID");
		} else {
			System.out.println("Sign In page is INVALID");
		}
		
		driver.navigate().back();
		driver.navigate().forward();
				
		if (driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]")).isDisplayed()) {
			System.out.println("Sign In page is VALID");
		} else {
			System.out.println("Sign In page is INVALID");
		}
		
		driver.findElement(By.partialLinkText("Create your Amazon account")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_customer_name")));
		
		if (driver.findElement(By.id("ap_customer_name")).isDisplayed()) {
			System.out.println("Create account page is VALID");
		} else {
			System.out.println("Create account page is INVALID");
		}
	
		driver.findElement(By.id("continue")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Enter your name')]")));
				
		WebElement errorMsg1 = driver.findElement(By.xpath("//div[contains(text(),'Enter your name')]"));
		WebElement errorMsg2 = driver.findElement(By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]"));
		WebElement errorMsg3 = driver.findElement(By.xpath("//div[contains(text(),'Minimum 6 characters required')]"));
		
		if(errorMsg1.isDisplayed() && errorMsg1.getText().equals("Enter your name")) {
			System.out.println("Error message 'Enter your name' - is DISPLAYED");			
		} else {	
			System.out.println("Error message 'Enter your name' - is NOT displayed");			
		}
			
		if(errorMsg2.isDisplayed() && errorMsg2.getText().equals("Enter your email or mobile phone number")) {
			System.out.println("Error message 'Enter your email or mobile phone number' - is DISPLAYED");			
		} else {
			System.out.println("Error message 'Enter your email or mobile phone number' - is NOT displayed");			
		}

		if(errorMsg3.isDisplayed() && errorMsg3.getText().equals("Minimum 6 characters required")) {
			System.out.println("Error message 'Minimum 6 characters required' - is DISPLAYED");			
	
		} else {
			System.out.println("Error message 'Minimum 6 characters required' - is NOT displayed");			
		}
		
		driver.close();
		
		
	}
	
	
}
