package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToBag {
	
WebDriver driver = null;
	
	@Given("driver is open")
	public void driver_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("product page is open")
	public void product_page_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.navigate().to("https://www.marshalls.com/us/store/jump/product/beauty-accessories-beauty-accessories-handbags-luggage-travel/25in-Hardside-Character-Spinner/4000250448?colorId=NS4155705&pos=1:8&N=143024879");
	}

	@When("I click add")
	public void i_click_add() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("addItemToOrder")).click();
	}

	@Then("item added to my bag")
	public void item_added_to_my_bag() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.getPageSource().contains("Added");
				
		driver.quit();
	}


}
