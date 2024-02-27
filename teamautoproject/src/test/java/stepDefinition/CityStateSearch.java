package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CityStateSearch {
	
	WebDriver driver = null;
	
	@Given("my browser is open")
	public void my_browser_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize(); 
	}

	@Given("user is on marshalls store locator search page")
	public void user_is_on_marshalls_store_locator_search_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.navigate().to("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
	}

	@When("the valid city")
	public void the_valid_city() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("store-location-city")).sendKeys("Schaumburg");
	}

	@When("state is entered")
	public void state_is_entered() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("store-location-state")).sendKeys("Illinois");
	}

	@When("user clicks search button")
	public void user_clicks_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
	}

	@Then("then related results are visible")
	public void then_related_results_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.getPageSource().contains("Schaumburg");
		
		driver.quit();
	}


}
