package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GiftCard {
	WebDriver driver = null;

	@Given("wed driver is open")
	public void wed_driver_is_open() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("store main page is open")
	public void store_main_page_is_open() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		driver.navigate().to("https://marshalls.com/us/store/index.jsp");
	}

	@When("we click gift card")
	public void we_click_gift_card() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		driver.findElement(By.linkText("Gift Cards")).click();
	}

	@Then("gift card page visible")
	public void gift_card_page_visible() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		driver.getPageSource().contains("Gift Cards");

		driver.quit();
	}

}
