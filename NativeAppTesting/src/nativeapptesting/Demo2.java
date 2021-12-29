package nativeapptesting;

import java.net.MalformedURLException;

import javax.swing.Scrollable;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo2 extends capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capability();
		
// How to open NOTIFICATIONS
		//driver.openNotifications();
		//driver.findElement(MobileBy.AccessibilityId("Battery Saver")).click();

// How to scroll
		//scroll till element and click on that element. (Last element)
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Views\")")).click();
		
		// for webapp - javascript & for nativapp- UiScrollable.
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WebView\")")).click();
	
	}
}
