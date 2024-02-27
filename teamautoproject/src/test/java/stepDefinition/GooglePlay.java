package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GooglePlay {
	WebDriver driver = null;
	
	@Given("driver is opent and home page is visible")
	public void driver_is_opent_and_home_page_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://marshalls.com/us/store/index.jsp");
	}

	@When("now click on link")
	public void now_click_on_link() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.findElement(By.linkText("Get It On Google Play")).click();
	    driver.get("https://play.google.com/store/apps/details?id=com.tjx.marshalls");
	    driver.findElement(By.xpath("//body[@id='yDmH0d']/c-wiz[2]/div/div/div[2]/div/div")).click();
	    
	}

	@Then("google play is visible")
	public void google_play_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.getPageSource().contains("Marshalls Official");

		driver.quit();
		
	}

}
