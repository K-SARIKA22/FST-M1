package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Project {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		

		// Open the page
		driver.get("https://alchemy.hguy.co/jobs");
		// Print the url of the page
		System.out.println("Page URL: " + driver.getCurrentUrl());
		driver.quit();
	}

}
