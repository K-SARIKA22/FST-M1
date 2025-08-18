package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Activity7 {
    WebDriver driver;
 
    @BeforeClass
    public void setup() {
        // No need for System.setProperty with Maven + Selenium 4
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
driver.get("https://alchemy.hguy.co/jobs");
    }
 
    @Test
    public void createJobListing() throws InterruptedException {
        // Step 1: Click "Post a Job"
        driver.findElement(By.linkText("Post a Job")).click();
 
        // Step 2: Fill job details
driver.findElement(By.id("create_account_email")).sendKeys("testuser@example.com");
driver.findElement(By.id("job_title")).sendKeys("Selenium Test Engineer");
driver.findElement(By.id("job_location")).sendKeys("Remote");
driver.findElement(By.id("application")).sendKeys("hr@example.com");
driver.findElement(By.id("company_name")).sendKeys("Alchemy TestNG Ltd");
 
        // Step 3: Click Preview
driver.findElement(By.name("submit_job")).click();
 
        // Step 4: Submit the listing
        Thread.sleep(2000); // wait for preview page
driver.findElement(By.id("job_preview_submit_button")).click();
 
        // Step 5: Verify job listing appears
        Thread.sleep(2000);
        WebElement jobListing = driver.findElement(By.cssSelector("div.job_listings"));
        String listingText = jobListing.getText();
        System.out.println("Job Listing Found: " + listingText);
 
        Assert.assertTrue(listingText.contains("Selenium Test Engineer"),
                "Job was not posted successfully!");
    }
 
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}