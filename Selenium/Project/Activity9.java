package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity9 {

	  WebDriver driver;
	  
	  @BeforeMethod
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	  }

	  @Test
	  public void AddJob() {
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		driver.findElement(By.xpath("//div[text() = 'Job Listings']")).click();
		driver.findElement(By.xpath("//a[@class = 'page-title-action']")).click();
		
		driver.findElement(By.id("post-title-0")).sendKeys("Automation Test Lead");
		driver.findElement(By.id("_company_website")).sendKeys("https://www.ibm.com");
		driver.findElement(By.id("_company_twitter")).sendKeys("@IBM");
		driver.findElement(By.id("_job_location")).sendKeys("India");
		driver.findElement(By.id("_company_name")).sendKeys("IBM India");
		driver.findElement(By.id("_company_name")).sendKeys("\"THINK\"");
		driver.findElement(By.xpath("//button[contains(text(), 'Publish')]")).click();
		driver.findElement(By.xpath("//button[text() = 'Publish']")).click();	
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
