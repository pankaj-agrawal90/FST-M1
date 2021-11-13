package projectSubmission;

import java.net.MalformedURLException;
import java.net.URL;

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

public class CreateNoteGoogleKeep {
	
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
	 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "pixel4Emulator");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.google.android.keep");
	  caps.setCapability("appActivity", ".activities.BrowseActivity");
	  caps.setCapability("noReset", true);
	  
	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(appServer, caps);
	  wait = new WebDriverWait(driver, 10);
  }
  
  @Test
  public void createNotes() {
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
	  driver.findElementByAccessibilityId("New text note").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/editable_title")));
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Complete Appium Project");
	  
      driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Need to complete Appium Project by 21st Oct");
	  driver.findElementByAccessibilityId("Open navigation drawer").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/index_note_title")));
	  String actualTitle = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
	  System.out.println("Title of the notes is: " + actualTitle);
	  
	  Assert.assertEquals(actualTitle, "Complete Appium Project");
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
