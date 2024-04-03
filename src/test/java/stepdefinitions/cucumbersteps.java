package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import io.cucumber.java.en.Then;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cucumbersteps {
	WebDriver driver = new ChromeDriver();
	LoginPage logInPage = new LoginPage(driver);

	@Given("the user is on the login page")
	public void theUserIsOnTheLoginPage() {
		// Initialize WebDriver and navigate to the login page
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\USER\\eclipse-workspace\\Blaze\\src\\test\\resources\\drivers\\chromedriver.exe");

		// Maximize the browser window
		driver.manage().window().maximize();
		//launching browser
		driver.get("https://www.demoblaze.com/");
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		logInPage.clickonloginfeild();
	}

	@When("the user enters valid username {string} and password {string}")
	public void user_enters_credentials(String username, String password) {
		logInPage.enterUsername(username);
		logInPage.enterPassword(password);
	}

	@When("user clicks on Login popup window")
	public void user_clicks_on_login_popup_window() {
		logInPage.clickLoginButton();
	}

	@Then("the user should be redirected to the Homepage and greetings welcome {string}")
	public void the_user_should_be_redirected_to_the_homepage_and_greetings_welcome(String username) {
		try {
			Thread.sleep(3000);
			assertEquals(logInPage.getGreetingsMessage(), "Welcome " + username);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	 @When("user clicks sign up button")
	    public void userClicksSignUpButton() {
	       logInPage.signUpPage();
	    }

	    @And("user enters valid username and password")
	    public void userEntersValidUsernameAndPassword() {
	        logInPage.username();
	    	logInPage.password();
	    }

	    @And("clicks sign up button")
	    public void clicksSignUpButton() {
	        logInPage.EntersignUp();
	    }

	    @Then("user should be able to sign up successfully")
	    public void userShouldBeAbleToSignUpSuccessfully() {
	       logInPage.successMessage();
	    }
	

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}