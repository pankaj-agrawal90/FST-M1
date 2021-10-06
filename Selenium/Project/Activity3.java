package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity3 {

	  WebDriver driver;
	  
	  @BeforeMethod
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	  }
		  
	  @Test
	  public void getImageURL() {
		  WebElement url = driver.findElement(By.xpath("//img"));
		  String imageURL = url.getAttribute("src");
		  System.out.println("URL of the iamge is: "+ imageURL);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
