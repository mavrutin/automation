package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NoResult {

WebDriver driver = null;
	
	@Given("User is on home page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://marshalls.com/us/store/index.jsp");
		
	}

	@When("User searches irrelevant items in a search box")
	public void user_searches_irrelevant_items_in_a_search_box() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("search-text-input")).sendKeys("live roses");
			}

	@When("User clicks search")
	public void user_clicks_search() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("search-submit-button")).click();	
	}

	@Then("User is shown no results")
	public void user_is_shown_no_results() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		driver.getPageSource().contains("no result"); 
		driver.quit();
	}
	
}
