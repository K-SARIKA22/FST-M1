package seleniumtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity6 {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver(); 
		//Open the URL of the given site
		driver.get("https://alchemy.hguy.co/jobs/");
		//Thread.sleep(3000);
		//Open the jobs page by clicking on the given link
		driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
		Thread.sleep(3000);
		// search the job by keywords
		driver.findElement(By.id("search_keywords")); 
		WebElement searchtxt = driver.findElement(By.id("search_keywords"));
		searchtxt.sendKeys("AutomationTester");
		//click on the particular job 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		//click on the apply button
		driver.findElement(By.xpath("//div[@class='position']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='application_button button']")).click();
		System.out.println("qwe@abc.com");
		

//		System.out.println("Page title is" + driver.getTitle());
		
		driver.quit();

	}



}
