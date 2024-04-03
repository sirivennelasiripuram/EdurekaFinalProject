package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class googlehomepagesteps {
	
    private WebDriver driver= new ChromeDriver();
    GoogleHomePage googlepage = new GoogleHomePage(driver);

    @Given("open browser navigate to google homepage")
    public void openBrowserNavigateToGoogleHomepage() {
    	driver.manage().window().maximize();
    	driver.get("https://www.google.com");
    }

    @When("search for {string}")
    public void searchForText(String Text) {
    	googlepage.searchForText(Text);
   }
	
    @Then("results should contains {string} link")
    public void results_should_contains_link(String Text) {
         googlepage.LinkPresentInResults(Text);
    }
 
    @When("click on first result")
    public void click_on_first_result() {
    	googlepage.clickOnFirstResult();    	
    }
    
    @Then("validate the url of the current window")
    public void validateTheUrlOfTheCurrentWindow() {
        Assert.assertTrue(googlepage.getCurrentUrl());      
    }

    @After
    public void closeBrowser() {
        // Close the browser after scenario execution
    	if (driver != null) {
			driver.quit();
		}
    }
}
