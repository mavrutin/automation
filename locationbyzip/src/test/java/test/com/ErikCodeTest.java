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
public class ErikCodeTest {

    private WebDriver driver;
    private String baseUrl;

    public ErikCodeTest() {
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

    //FAQ browsing
    @Test
    public void testFAQs() throws Exception {
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.linkText("FAQs")).click();
        driver.get("https://www.marshalls.com/us/store/jump/topic/FAQs/22200018p");
        driver.findElement(By.xpath("//div[@id='main']/div[2]/section/div/div/div/a[2]")).click();
        driver.findElement(By.id("rewardsSection?icid=4.29.21_Marshalls_FAQ_Rewards_Anchor_Link")).click();
        assertEquals(driver.findElement(By.id("rewardsSection?icid=4.29.21_Marshalls_FAQ_Rewards_Anchor_Link")).getText(), "Rewards FAQs");
    }

    //Add gift card
    @Test
    public void testGiftCard() throws Exception {
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.linkText("Gift Cards")).click();
        driver.get("https://www.marshalls.com/us/store/jump/topic/Gift-Cards/2400013");
        driver.findElement(By.xpath("//*[@id=\"WP-TBD_Content_Hero_GiftCards_D\"]/div[2]/div[2]/a[1]")).click();
        //driver.get("https://www.marshalls.com/us/store/jump/product/Gift-Cards/9010000000?icid=9.28.21:Marshalls:LP:Desktop_GiftCards:by_mail");
        driver.findElement(By.xpath("//div[@id='product-9010000000']/section/div[2]/form/div[3]/div/div/ul/li[4]/a/img")).click();
        driver.findElement(By.id("denomination")).click();
        new Select(driver.findElement(By.id("denomination"))).selectByVisibleText("$50.00");
        driver.findElement(By.id("addItemToOrder")).click();
        driver.findElement(By.linkText("View Bag")).click();
        driver.get("https://www.marshalls.com/us/store/checkout/cart.jsp");
        assertEquals(driver.findElement(By.linkText("Gift Cards")).getText(), "Gift Cards");

    }

    // Google Play
    @Test
    public void testGooglePlayStore() throws Exception {
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.linkText("Get It On Google Play")).click();
        driver.get("https://play.google.com/store/apps/details?id=com.tjx.marshalls");
        driver.findElement(By.xpath("//body[@id='yDmH0d']/c-wiz[2]/div/div/div[2]/div/div")).click();
        //driver.findElement(By.xpath("//body[@id='yDmH0d']/c-wiz[2]/div/div/div[2]/div[2]/div/div/div/c-wiz[2]/div/section/div/div/br[6]")).click();
        //assertEquals(driver.findElement(By.xpath("//body[@id='yDmH0d']/c-wiz[2]/div/div/div[2]/div/div/div/c-wiz/div[2]/div/div/h1")).getText(), "Marshalls Official");
    }

    //Download it On The App Store
    @Test
    public void testAppleStore() throws Exception {
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.linkText("Download it On The App Store")).click();
        driver.get("https://apps.apple.com/us/app/marshalls-official/id1454639999");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Description'])[1]/following::p[2]")).click();
        assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Description'])[1]/following::p[2]")).getText(), "Thanks for downloading the Marshalls App. Now you can shop amazing styles & savings anytime, anywhere.");
    }

}
