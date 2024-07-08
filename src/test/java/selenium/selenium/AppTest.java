package selenium.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;




/**
 * Unit test for simple App.
 */
public class AppTest {
private WebDriver driver;

@BeforeClass
public void setUp() {
    // Set the path to your WebDriver executable
	String projectpath=System.getProperty("user.dir");
	System.out.println(projectpath);
    System.setProperty("webdriver.chrome.driver",projectpath + "/drivers/chromedriver/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
   

    // Initialize the WebDriver (ChromeDriver in this case)
    driver = new ChromeDriver(options);
}

@Test
public void testGoogleSearch() {
    // Open Google
    driver.get("https://www.google.com");

    // Find the search box
    WebElement searchBox = driver.findElement(By.name("q"));

    // Type a query
    searchBox.sendKeys("Selenium WebDriver");

    // Submit the query
    searchBox.submit();

    // Wait for the results to load
    try {
        Thread.sleep(2000); // This is a simple wait. For a more reliable solution, use WebDriverWait.
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Check the title contains the search term
    String title = driver.getTitle();
    Assert.assertTrue(title.contains("Selenium WebDriver"));
}

@AfterClass
public void tearDown() {
    // Close the browser
    if (driver != null) {
        driver.quit();
    }
}
}
 