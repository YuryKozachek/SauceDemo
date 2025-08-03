//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import java.time.Duration;
//import java.util.HashMap;
//
//public class LocatorsTest {
//    WebDriver driver;
//    SoftAssert softAssert;
//    ChromeOptions chromeOptions;
//    Actions actions;
//
//    @BeforeTest
//    public void setSetting() {
//        softAssert = new SoftAssert();
//        chromeOptions = new ChromeOptions();
//        HashMap<String, Object> chromePrefs = new HashMap<>();
//        chromePrefs.put("credentials_enable_service", false);
//        chromePrefs.put("profile.password_manager_enabled", false);
//        chromeOptions.setExperimentalOption("prefs", chromePrefs);
//        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--disable-notifications");
//        chromeOptions.addArguments("--disable-popup-blocking");
//        chromeOptions.addArguments("--disable-infobars");
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        actions = new Actions(driver);
//    }
//
//    @Test
//    public void getAllLocators() {
//        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.id("user-name"));
//        driver.findElement(By.name("password"));
//        driver.findElement(By.className("submit-button"));
//        driver.findElement(By.tagName("input"));
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.name("password")).sendKeys("secret_sauce");
//        driver.findElement(By.className("submit-button")).click();
//        driver.findElement(By.linkText("Sauce Labs Backpack"));
//        driver.findElement(By.partialLinkText("Light"));
//        driver.findElement(By.xpath("//div[@data-test='inventory-list']"));
//        driver.findElement(By.xpath("//button[text()='Add to cart']"));
//        driver.findElement(By.xpath("//div[contains(@data-test,'item')]"));
//        driver.findElement(By.xpath("//div[contains(text(),'Swag')]"));
//        driver.findElement(By.xpath("//button[text()='Add to cart']//ancestor::div"));
//        driver.findElement(By.xpath("//div[@id='inventory_container']//descendant::a"));
//        driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']//following::div"));
//        driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']//parent::div"));
//        driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']//preceding::div"));
//        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie' and text()='Add to cart']"));
//        driver.findElement(By.cssSelector(".inventory_item"));
//        driver.findElement(By.cssSelector(".inventory_item.inventory_item"));
//        driver.findElement(By.cssSelector(".inventory_item .inventory_item_img"));
//        driver.findElement(By.cssSelector("#page_wrapper"));
//        driver.findElement(By.cssSelector("button"));
//        driver.findElement(By.cssSelector("div.bm-burger-button"));
//        driver.findElement(By.cssSelector("[target=\"_blank\"]"));
//        driver.findElement(By.cssSelector("[class~=\"header_container\"]"));
//        driver.findElement(By.cssSelector("[lang|=\"en\"]"));
//        driver.findElement(By.cssSelector("[class^=\"primary_header\"]"));
//        driver.findElement(By.cssSelector("[class$=\"primary_header\"]"));
//        driver.findElement(By.cssSelector("[class*=\"primary_header\"]"));
//    }
//
//    @AfterTest(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//        softAssert.assertAll();
//    }
//}