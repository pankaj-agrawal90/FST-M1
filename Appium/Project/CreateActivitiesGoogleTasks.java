package projectSubmission;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CreateActivitiesGoogleTasks {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	List<MobileElement> activityNames = null;
	String activity1Name, activity2Name, activity3Name;
	
 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "pixel4Emulator");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.google.android.apps.tasks");
	  caps.setCapability("appActivity", ".ui.TaskListsActivity");
	  caps.setCapability("noReset", true);
	  
	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(appServer, caps);
	  wait = new WebDriverWait(driver, 10);
  }
  
  @Test
  public void createActivities() throws InterruptedException {
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Save\")")).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Save\")")).click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Save\")")).click();
	  
	  Thread.sleep(5000);
	  activityNames = driver.findElementsById("com.google.android.apps.tasks:id/task_name");
	  for(MobileElement activity : activityNames) {
		  System.out.println(activity.getText());
	  }
	  
	  activity1Name = activityNames.get(0).getText();
	  Assert.assertEquals(activity1Name, "Complete the second Activity Google Keep");
	  
	  activity2Name = activityNames.get(1).getText();
	  Assert.assertEquals(activity2Name, "Complete Activity with Google Keep");
	  
	  activity3Name = activityNames.get(2).getText();
	  Assert.assertEquals(activity3Name, "Complete Activity with Google Tasks");
	 
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
