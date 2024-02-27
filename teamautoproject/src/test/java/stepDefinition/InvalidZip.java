package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidZip {

	WebDriver driver = null;

	@Given("a browser is on marshalls store locator search page")
	public void a_browser_is_on_marshalls_store_locator_search_page() {
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.marshalls.com/us/store/stores/storeLocator.jsp");

	}

	@When("the invalid zip code is entered")
	public void the_invalid_zip_code_is_entered() {
		driver.findElement(By.id("store-location-zip")).sendKeys("abc12");
	}

	@When("User clicks search button")
	public void user_clicks_search_button() {
		driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
	}

	@Then("the related results are visible")
	public void the_related_results_are_visible() {
		driver.getPageSource().contains("valid zip");

		// Finally, closing driver after test is complete
		driver.quit();

	}

}
