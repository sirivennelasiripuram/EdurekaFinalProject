// LoginPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.UUID;

public class LoginPage {
    private WebDriver driver;    
    
    // Locators
    private By Loginfield = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    private By greetingsMessage = By.id("nameofuser");
    private By signUpText = By.id("signin2");
    private By userName_SignUp = By.xpath("//input[@id='sign-username']");
    private By password_SignUp = By.id("sign-password");
    private By signUpButton = By.xpath("//button[contains(text(),'Sign up')]");
   
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickonloginfeild() {
    	driver.findElement(Loginfield).click(); 
    }
    
    public void enterUsername(String loginusername) {
    	try {
    		Thread.sleep(5000);
    		driver.findElement(usernameField).sendKeys(loginusername);
    	}
    	catch (Exception e) {			
		}        
    }

    public void enterPassword(String loginpassword) {
        driver.findElement(passwordField).sendKeys(loginpassword);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getGreetingsMessage() {
        return driver.findElement(greetingsMessage).getText();
    }
    
    public void signUpPage() {
    	   driver.findElement(signUpText).click();
    }
    
    public void username() {
    	try {
			Thread.sleep(3000);
			String username = "New User_" + UUID.randomUUID().toString();
	    	System.out.println("value of user name is "+username);
	    	driver.findElement(userName_SignUp).click();
	    	driver.findElement(userName_SignUp).sendKeys(username);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}    	
    }
    
    public void password() {
	        driver.findElement(password_SignUp).sendKeys("12345");
	}
    
    public void EntersignUp() {
    driver.findElement(signUpButton).click();
    }
    
    public boolean successMessage() {
    	try {
			Thread.sleep(3000);
	    	String alertMessage = driver.switchTo().alert().getText();
	        if (alertMessage.contains("Sign up successful")) {
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
}
