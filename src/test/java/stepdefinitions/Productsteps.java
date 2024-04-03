package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Productsteps {
	private WebDriver driver = new ChromeDriver();
	ProductHomePage productHomePage = new ProductHomePage(driver);

	@Given("I am on the homepage of the website")
	public void iAmOnTheHomepageOfTheWebsite() {
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
	}

	@Then("I should see search results for {string}")
	public void iShouldSeeSearchResultsForProduct(String Product) {
		productHomePage.clickonsearchInput(Product);
	}

	@Then("user is able to add to the cart successfully {string}")
	public void user_is_able_to_add_to_the_cart_successfully(String Product) {
		productHomePage.mobilesearch(Product);
		productHomePage.cart();
	}

	@When("product is added to cart then gotocart")
	public void productIsAddedToCartThenGotocart() {
		productHomePage.AddtoCart();
	}

	@Then("user is able to click the place order button")
	public void userIsAbleToClickThePlaceOrderButton() {
		productHomePage.clickPlaceOrder();
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
}
}
