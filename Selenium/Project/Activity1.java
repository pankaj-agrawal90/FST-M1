package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	
  WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://alchemy.hguy.co/jobs/");
  }
  
  @Test
  public void verifyTitle() {
	  String title = driver.getTitle();
	  System.out.println("Title is: "+ title);
	  Assert.assertEquals("Alchemy Jobs – Job Board Application", title);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
}