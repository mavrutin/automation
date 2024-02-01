/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
public class NataliaTest {

    private WebDriver driver;
    private String baseUrl;

    public NataliaTest() {
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
        driver.quit();
    }
    
    //Search for existing items
     @Test(priority = 1)
    public void testTCSearchVaildItems() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        WebDriverWait wait = new WebDriverWait(driver, 20);  //20 sec
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-text-input")));
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("plant");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=plant&qfh_sch=Search");
        driver.findElement(By.xpath("//img[@alt='18in Syngonium Plant']")).click();
        driver.get("https://www.marshalls.com/us/store/jump/product/18in-Syngonium-Plant/4000233464?colorId=NS10704139&pos=1:1&Ntt=plant");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("pants");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=pants&qfh_sch=Search");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("cups");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=cups&qfh_sch=Search");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("dress");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/women-women-clothing-dresses-womens/_/N-1499979199?searchTerm=dress");
        driver.quit();
    }

    //Suggested items based on key word
    
    @Test(priority = 2)
    public void testSuggested() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("drill");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=drill&qfh_sch=Search");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("rye");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=rye&qfh_sch=Search");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("kiwi");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=kiwi&qfh_sch=Search");
        driver.quit();
    }

   //Item not found based on key word
     @Test(priority = 3)
    public void testUntitledTestCase() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("live roses");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/noresults/?_dyncharset=utf-8&initSubmit=true&Ntt=live+roses&qfh_sch=Search");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("iuyugeeg");
        driver.findElement(By.id("search-submit-button")).click();
        driver.get("https://www.marshalls.com/us/store/shop/noresults/?_dyncharset=utf-8&initSubmit=true&Ntt=iuyugeeg&qfh_sch=Search");
        driver.close();
        
        }
    
}
