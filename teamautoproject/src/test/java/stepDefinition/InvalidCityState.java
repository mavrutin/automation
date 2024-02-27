package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidCityState {
	WebDriver driver = null;
	
	@Given("user browser is open")
	public void user_browser_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		  System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize(); 
	}

	@Given("it is on marshalls store locator search page")
	public void it_is_on_marshalls_store_locator_search_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 driver.navigate().to("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
	}

	@When("the {string} city")
	public void the_city(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("store-location-city")).sendKeys(string);
	}

	@When("state {string} is entered")
	public void state_is_entered(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("store-location-state")).sendKeys(string);
	}

	@When("search button clicked")
	public void search_button_clicked() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.name("submit")).sendKeys(Keys.ENTER);
	}

	@Then("verify the {string} in step")
	public void verify_the_in_step(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		 driver.getPageSource().contains(string); 
		 
		 // Finally, closing driver after test is complete
		 driver.quit();
	}


}
