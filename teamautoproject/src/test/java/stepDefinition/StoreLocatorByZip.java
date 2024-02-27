package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreLocatorByZip {
	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		  System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize(); 
	}

	@Given("User is on marshalls store locator search page")
	public void user_is_on_marshalls_store_locator_search_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.navigate().to("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
	}

	@When("User enters a zip code in a search box")
	public void user_enters_a_zip_code_in_a_search_box() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("store-location-zip")).sendKeys("60089");
	}

	@When("hits search button")
	public void hits_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
	}

	@Then("User is navigated to search feature")
	public void user_is_navigated_to_search_feature() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.getPageSource().contains("Buffalo Grove");
		
		 // Finally, closing driver after test is complete
		driver.quit();
	}
	
	
	
}
