package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchItem {
	
	WebDriver driver = null;

	@Given("home page")
	public void browser_is_open() {
		// Initiate the Chrome-driver and open the browser.
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("User inputs relevant items in a search bar")
	public void user_inputs_relevant_items_in_a_search_bar() {
		driver.navigate().to("https://marshalls.com/us/store/index.jsp");
	}

	@When("User searches items in a search box")
	public void user_searches_items_in_a_search_box() {
		driver.findElement(By.id("search-text-input")).sendKeys("plant");
	}

	@And("clicks search")
	public void hits_enter() {
		// Simulate the clicking of enter key
		driver.findElement(By.id("search-submit-button")).click();
		//driver.findElement(By.id("search-submit-button"));
	}

	@Then("User is shown all valid items")
	public void user_is_shown_all_valid_items() {
		//driver.get(
				//"https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=plant&qfh_sch=Search");
	    driver.getPageSource().contains("plant in"); 
	    driver.quit();

	}

}
