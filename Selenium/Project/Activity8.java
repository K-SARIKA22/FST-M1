package project;

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

public class Activity8 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass

	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}

	@Test(priority = 1)

	public void verifyPageTitle() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Log In ‹ Alchemy Jobs — WordPress");
	}

	@Test(priority = 2)

	public void verifyUserLogin() {
		// Find the username field of the login form and enter the username into that
		// field.
		driver.findElement(By.id("user_login")).sendKeys("root");

		// Find the password field of the login form and enter the password into that
		// field.
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

		// click on remember me
		driver.findElement(By.id("rememberme")).click();

		// Find the login button and click it.
		driver.findElement(By.id("wp-submit")).click();

		// Verify that you have logged in.
		WebElement loggedinPageHeading = driver.findElement(By.xpath("//h1[text()='Dashboard']"));
		Assert.assertTrue(loggedinPageHeading.isDisplayed(), "Logged in is failed");

	}

	@AfterClass

	public void closeBrowser() {
		driver.quit();

	}
}
