package Project;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
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
	public void pageTitletest() {
		Assert.assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");
		System.out.println("New page title is: " + driver.getTitle());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
