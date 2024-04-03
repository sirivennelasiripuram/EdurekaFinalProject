package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
	private WebDriver driver;
	
	// Locators
	private By searchForText = By.xpath("//textarea[@aria-label='Search']");
	private By demoBlazeLink = By.xpath("//h3[text()='Demo Blaze']");
	
	// Constructor
	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchForText(String Text) {
		driver.findElement(searchForText).sendKeys(Text);
		driver.findElement(searchForText).submit();		
	}

	public boolean LinkPresentInResults(String Text) {
		WebElement linkPresentInResults = driver.findElement(By.xpath("//h3[text()='" + Text + "']"));
	   return linkPresentInResults.isDisplayed();
	}

	public void clickOnFirstResult() {
		try {
			Thread.sleep(3000);
		driver.findElement(demoBlazeLink).click();
		} catch (Exception e) {
		}
	}

	public boolean getCurrentUrl() {
		  String getcurrentUrl = driver.getCurrentUrl();
	      boolean status = false;
	      if (getcurrentUrl.contains("demoblaze"))
	    	  status= true;
	    	  else
	    		  status =false;
	      return status;
	}
}
