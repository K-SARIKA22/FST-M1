import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JobListingAutomation {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        // Set the path for the GeckoDriver (FirefoxDriver)
        System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");

        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    public void createJobListing() {
        // Step 2: Log in
        WebElement usernameField = driver.findElement(By.id("user_login"));
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        WebElement loginButton = driver.findElement(By.id("wp-submit"));

        usernameField.sendKeys("root"); // Replace with your username
        passwordField.sendKeys("pa$$w0rd"); // Replace with your password
        loginButton.click();

        // Step 3: Navigate to Job Listings
        WebElement jobListingsMenu = driver.findElement(By.linkText("Job Listings"));
        jobListingsMenu.click();

        // Step 4: Click on "Add New"
        WebElement addNewButton = driver.findElement(By.linkText("Add New"));
        addNewButton.click();

        // Step 5: Fill in the job details
        WebElement jobTitleField = driver.findElement(By.id("post-title-0"));
        WebElement jobDescriptionField = driver.findElement(By.id("content"));
        WebElement companyField = driver.findElement(By.id("job_company"));
        WebElement locationField = driver.findElement(By.id("job_location"));
        WebElement jobTypeField = driver.findElement(By.id("job_type"));
        WebElement publishButton = driver.findElement(By.id("publish"));

        jobTitleField.sendKeys("Software Engineer");
        jobDescriptionField.sendKeys("We are looking for a Software Engineer to join our team.");
        companyField.sendKeys("Tech Company");
        locationField.sendKeys("Remote");
        jobTypeField.sendKeys("Full-time");

        // Step 6: Publish the job listing
        publishButton.click();

        // Step 7: Verify the job listing was created
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notice-success")));

        // Check for success message
        WebElement successMessage = driver.findElement(By.className("notice-success"));
        if (successMessage.isDisplayed()) {
            System.out.println("Job listing published successfully!");
        }

        // Optionally, verify the presence of the new job listing in the job listings table
        jobListingsMenu.click(); // Navigate back to job listings
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wp-list-table"))); // Wait for the table to load

        // Check if the new job listing appears in the table
        boolean jobExists = driver.getPageSource().contains("Software Engineer");
        if (jobExists) {
            System.out.println("Job listing is present in the job listings table.");
        } else {
            System.out.println("Job listing is NOT present in the job listings table.");
        }
    }

    @AfterClass
    public static void closeBrowser() {
        // Step 8: Close the browser
        driver.quit();
    }
}
