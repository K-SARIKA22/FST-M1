package project;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class Activity4 {
    WebDriver driver;
 
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
driver.get("https://alchemy.hguy.co/jobs/");
    }
 
    @Test
    public void verifySecondHeading() {
        // This finds the heading with exact text "Quia quis non"
        WebElement secondHeading = driver.findElement(By.xpath("//h2[text()='Quia quis non']"));
 
        // Get text
        String headingText = secondHeading.getText();
        System.out.println("Heading found: " + headingText);
 
        // Validate it matches
        Assert.assertEquals(headingText, "Quia quis non", "Heading text does not match!");
    }
 
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}