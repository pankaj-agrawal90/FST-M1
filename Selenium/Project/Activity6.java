package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity6 {

	  WebDriver driver;
	  
	  @BeforeMethod
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	  }

	  @Test
	  public void searchJobs() {
		driver.findElement(By.xpath("//ul/li[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("search_keywords")).sendKeys("Test Automation");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//h3[text() = 'Test Specialist_Automation']")).click();
		driver.findElement(By.xpath("//input[contains(@class, 'application')]")).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(@class, 'email')]"));
		System.out.println("Email address is: "+ element.getText());
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
