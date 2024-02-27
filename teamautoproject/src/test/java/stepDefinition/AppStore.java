package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppStore {
	WebDriver driver = null;
	
	@Given("my driver is open and main page is open")
	public void my_driver_is_open_and_main_page_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://marshalls.com/us/store/index.jsp");
	}

	@When("click on app store")
	public void click_on_app_store() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.linkText("Download it On The App Store")).click();
	}

	@Then("app store page visible")
	public void app_store_page_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.getPageSource().contains("Marshalls Official");

		driver.quit();
		
	}


}
