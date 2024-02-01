/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Lenovo
 */
public class LocationByZipTest {
        private WebDriver driver;
        private String baseUrl;
    public LocationByZipTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        //FAQdriver.quit();
        driver.quit();
    }    
    
    @Test
    public void testFAQs() throws Exception {
    driver.get("https://www.marshalls.com/us/store/index.jsp");
    driver.findElement(By.linkText("FAQs")).click();
    driver.get("https://www.marshalls.com/us/store/jump/topic/FAQs/22200018p");
    driver.findElement(By.xpath("//div[@id='main']/div[2]/section/div/div/div/a[2]")).click();
    driver.findElement(By.id("rewardsSection?icid=4.29.21_Marshalls_FAQ_Rewards_Anchor_Link")).click();
    assertEquals(driver.findElement(By.id("rewardsSection?icid=4.29.21_Marshalls_FAQ_Rewards_Anchor_Link")).getText(), "Rewards FAQs");
  }
        
    //Store locator by valid zip code
  @Test 
  public void testSoreLocatorTestCase() throws Exception {
    driver.get("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
    driver.findElement(By.id("store-location-zip")).click();
    driver.findElement(By.id("store-location-zip")).clear();
    driver.findElement(By.id("store-location-zip")).sendKeys("60090");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Store Info and Directions")).click();
    driver.get("https://www.marshalls.com/us/store/stores/Arlington+Heights-IL-60004/559/aboutstore");
  }

   //Store locator by valid city and state combo
  @Test
  public void testLocationCityStateTestCase() throws Exception {
    driver.get("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
    driver.findElement(By.id("store-location-city")).click();
    driver.findElement(By.id("store-location-city")).clear();
    driver.findElement(By.id("store-location-city")).sendKeys("Chicago");
    new Select(driver.findElement(By.id("store-location-state"))).selectByVisibleText("Idaho");
    new Select(driver.findElement(By.id("store-location-state"))).selectByVisibleText("Illinois");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Store Info and Directions")).click();
    driver.get("https://www.marshalls.com/us/store/stores/Chicago-IL-60611/690/aboutstore");
  }
    
  //Store locator with invalid zip
 @Test
  public void testInvalidZipTestCase() throws Exception {
    driver.get("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
    driver.findElement(By.id("store-location-zip")).click();
    driver.findElement(By.id("store-location-zip")).clear();
    driver.findElement(By.id("store-location-zip")).sendKeys("801AB");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.id("store-location-zip")).click();
    driver.findElement(By.id("store-location-zip")).clear();
    driver.findElement(By.id("store-location-zip")).sendKeys("80100");
    driver.findElement(By.name("submit")).click();
  }

  //Store locator with valid city and invalid (empty) state combo
 @Test
  public void testInvalidCityStateTestCase() throws Exception {
    driver.get("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
    driver.findElement(By.id("store-location-city")).click();
    driver.findElement(By.id("store-location-city")).clear();
    driver.findElement(By.id("store-location-city")).sendKeys("New York");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.xpath("//form[@id='findStoresForm']/div[3]/div/div/span")).click();
    driver.findElement(By.xpath("//form[@id='findStoresForm']/div[3]/div/div/span")).click();
    driver.findElement(By.id("store-location-state")).click();
    new Select(driver.findElement(By.id("store-location-state"))).selectByVisibleText("Alabama");
    driver.findElement(By.name("submit")).click();
  }
  
  //Store locator with invalid city and valid state combo
 @Test
  public void testInvalidCityTestCase() throws Exception {
    driver.get("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
    driver.findElement(By.id("store-location-city")).click();
    driver.findElement(By.id("store-location-city")).clear();
    driver.findElement(By.id("store-location-city")).sendKeys("Some City");
    driver.findElement(By.id("store-location-state")).click();
    new Select(driver.findElement(By.id("store-location-state"))).selectByVisibleText("Delaware");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.id("store-location-city")).click();
    driver.findElement(By.id("store-location-city")).clear();
    driver.findElement(By.id("store-location-city")).sendKeys("123_Test@_><");
    driver.findElement(By.name("submit")).click();
  }
  
  
}
