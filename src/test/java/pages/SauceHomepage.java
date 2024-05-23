package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Driver;

public class SauceHomepage {

	
	public SauceHomepage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	
	@FindBy (css = ".inventory_item_price")
	public List<WebElement> itemPrices;
	
	
	@FindBy (xpath = "//span[text()='Products']")
	public WebElement homepage_product_text;
	
}
