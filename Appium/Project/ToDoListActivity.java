package projectSubmission;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ToDoListActivity {
	
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
	 List<MobileElement> taskNames = null;
	 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "pixel4Emulator");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.android.chrome");
	  caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	  caps.setCapability("noReset", true);
	  
	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(appServer, caps);
	  wait = new WebDriverWait(driver, 10);
  }
  
  @Test
  public void createToDoList() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("https://www.training-support.net/selenium");
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.view.View")));
	  driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
	  driver.findElement(MobileBy.AndroidUIAutomator("textContains(\"To-Do List\")")).click();
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Add tasks to list");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Get number of tasks");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	  
	  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Clear the list");
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
	  
	  taskNames = driver.findElements(MobileBy.AndroidUIAutomator("resourceId(\"tasksList\")"));
	  for(MobileElement task : taskNames) {
		  System.out.println(task.getText());
	  }
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
