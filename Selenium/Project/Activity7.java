package seleniumProject_JobBoard;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity7 {

	  WebDriver driver;
	  
	  @BeforeMethod
	  public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
	  }

	  @Test
	  public void createJobs() throws InterruptedException {
		driver.findElement(By.xpath("//ul/li[3]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class = 'button']")).click();
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		driver.findElement(By.id("job_title")).sendKeys("Automation Tester");
		driver.findElement(By.id("job_location")).sendKeys("India");
		driver.findElement(By.id("job_description_ifr")).sendKeys("Looking for a Selenium Automation Tester");
		
		
		driver.findElement(By.xpath("//input[@class = 'button']")).click();
		driver.findElement(By.id("job_preview_submit_button")).click();
		
		driver.findElement(By.linkText("Jobs")).click();
		driver.findElement(By.id("search_keywords")).sendKeys("Automation Tester");
		driver.findElement(By.xpath("//input[@value = 'Search Jobs']")).click();
		
		Thread.sleep(1000);
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

}
