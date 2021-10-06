package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity8 {

	  WebDriver driver;
	  
	  @BeforeMethod
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	  }

	  @Test
	  public void login() {
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		String expectedelement = driver.findElement(By.xpath("//h1[text() = 'Dashboard']")).getText();
		Assert.assertEquals("Dashboard", expectedelement);
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
