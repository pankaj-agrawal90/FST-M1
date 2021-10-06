package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity4 {

	  WebDriver driver;
	  
	  @BeforeMethod
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	  }

	  @Test
	  public void verify2ndHeading() {
		WebElement secondheading = driver.findElement(By.xpath("//h2"));
		String Expected2ndHeading = secondheading.getText();
		System.out.println("Heading of the page is: "+ Expected2ndHeading);
		String Actual2ndHeading = "Quia quis non";
		Assert.assertEquals(Actual2ndHeading, Expected2ndHeading);
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
