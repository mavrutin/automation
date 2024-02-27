package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultiItems {

WebDriver driver = null;
	
	@Given("user on home page")
	public void user_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://marshalls.com/us/store/index.jsp");
		
	}

	@When("Add {string} to search")
	public void add_to_search(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		driver.findElement(By.id("search-text-input")).sendKeys(string);
	}

	@Then("userb expects {string} on page")
	public void userb_expects_on_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		 driver.getPageSource().contains(string); 
		 // Finally, closing driver after test is complete
		 driver.quit();
	}
	
}
