package Project;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Activity5 {
	
WebDriver driver;

@BeforeTest
public void SetUp()
{
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://alchemy.hguy.co/jobs/");
}

@Test
public void TitleValidation() {
        
     driver.findElement(By.linkText("Jobs")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Jobs – Alchemy Jobs");
        driver.quit();
	}

@AfterTest
public void tearDown()
{
	driver.quit();
}

}
