package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FrequentAskQuestion {
	WebDriver driver = null;

	@Given("my driver is open")
	public void my_driver_is_open() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("marshalls home page is open")
	public void marshalls_home_page_is_open() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		driver.navigate().to("https://marshalls.com/us/store/index.jsp");
	}

	@When("I click in link")
	public void i_click_in_link() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		driver.findElement(By.linkText("FAQs")).click();
	}

	@Then("faq is open")
	public void faq_is_open() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		driver.getPageSource().contains("FAQ");

		driver.quit();
	}

}