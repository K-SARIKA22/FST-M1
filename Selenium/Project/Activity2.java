package Project;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
//Declaring the driver
	WebDriver driver;
	// Declaring the wait object
	WebDriverWait wait;

	// setup function
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://alchemy.hguy.co/jobs");
	}

	@Test
	public void pageheadingTest() {
	 // Locate heading (H1) element
    WebElement heading = driver.findElement(By.xpath("//h1[normalize-space()='Welcome to Alchemy Jobs']"));
    // Get the heading text
    String headingText = heading.getText();
    System.out.println("Header of the page is: " + headingText);
    Assert.assertEquals(headingText, "Welcome to Alchemy Jobs");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
