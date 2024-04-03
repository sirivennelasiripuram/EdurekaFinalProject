// LoginPage.java

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductHomePage {
	private WebDriver driver;
	
	// Locators
	private By clickonsearchInput = By.id("nava");
	private By mobilesearch = By.id("hrefch");
	private By cart = By.id("addToCart(1)");
	private By AddtoCart = By.id("cartur");
	private By clickPlaceOrder = By.xpath("//button[text()='Place Order']");
	
	// Constructor
	public ProductHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods
	public void clickonsearchInput(String Product) {
		try {
    		Thread.sleep(3000);
    		 driver.findElement(clickonsearchInput).click();  	
    		 }
    	catch (Exception e) {			
		}  
	}

	public void mobilesearch(String Product) {
		try {
    		Thread.sleep(3000);
    		driver.findElement(mobilesearch).click();    	
    		}
    	catch (Exception e) {			
		}  
	}

	public void cart() {
		try {
    		Thread.sleep(3000);
    		driver.findElement(cart).click();	}
    	catch (Exception e) {			
		} 
	}
	
	public boolean productaddedmessage () {
    	try {
			Thread.sleep(3000);
	    	String alertMessage = driver.switchTo().alert().getText();
	        if (alertMessage.contains("Product added")) {
	           return true;
	        } else {
	            return false;
	        }  
		} 
    	catch (InterruptedException e) {			
			e.printStackTrace();
			return false;
		}	
	}

	public void AddtoCart() {
		driver.findElement(AddtoCart).click();
		}

	public void clickPlaceOrder() {
		driver.findElement(clickPlaceOrder).click();
	}	
}
