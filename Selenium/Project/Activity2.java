package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity2 {
	
  WebDriver driver;
	  
  @BeforeMethod
  public void beforeMethod() {
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs/");
  }
	  
  @Test
  public void verifyHeading() {
	  WebElement heading = driver.findElement(By.xpath("//h1[@Class = 'entry-title']"));
	  String ExpectedHeading = heading.getText();
	  System.out.println("Heading of the page is: "+ ExpectedHeading);
	  String ActualHeading = "Welcome to Alchemy Jobs";
	  Assert.assertEquals(ActualHeading, ExpectedHeading);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}