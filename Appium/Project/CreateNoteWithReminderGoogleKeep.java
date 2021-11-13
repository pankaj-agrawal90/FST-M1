package projectSubmission;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CreateNoteWithReminderGoogleKeep {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass

	public void beforeClass() throws MalformedURLException {
		// Set the desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
	}

	
	@Test
	
	public void googleKeepAppTest () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Create New Note and Set Reminder 
		driver.findElementById("new_note_button").click();
		MobileElement noteTitle = driver.findElementById("editable_title");
		noteTitle.sendKeys("Test Title");
		MobileElement noteDesc = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Note\")"));
		noteDesc.sendKeys("Test Description");
		driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view").click();
		driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]").click();
		
		//Navigate back and ensure Note added successfully
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
		Thread.sleep(5000);
		String addedNoteTitle = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		System.out.println("Note Title and Description :" +addedNoteTitle);
		String addedNoteDesc = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
		System.out.println("Note Title and Description :" +addedNoteDesc);
		Boolean rem = driver.findElementById("com.google.android.keep:id/reminder_chip_text").isEnabled();
		System.out.println("Reminder Value : " +rem);
		Assert.assertEquals(addedNoteTitle, "Test Title");
		Assert.assertEquals(addedNoteDesc, "Test Description");
		Assert.assertTrue(rem);
		
	}
	
@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}

}