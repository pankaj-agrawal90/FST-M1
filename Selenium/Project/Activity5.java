package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity5 {

	  WebDriver driver;
	  
	  @BeforeMethod
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	  }

	  @Test
	  public void clickJobs() {
		driver.findElement(By.xpath("//ul/li[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//h1[@class = 'entry-title']"));
		String title = element.getText();
		System.out.println("Title of the page is: "+ title);
		Assert.assertEquals("Jobs", title);
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
