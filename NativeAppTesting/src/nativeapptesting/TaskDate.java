package nativeapptesting;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.AbstractOptionCombinedWithPosition;
import io.appium.java_client.touch.offset.ElementOption;

// these imports are required to use tap options:- 
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

//Long options 
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;


public class TaskDate extends capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capability();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Views\")")).click();
		driver.findElementByAccessibilityId("Date Widgets").click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("1. Dialog").click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("change the time").click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("9").click();
		
		WebElement strt = driver.findElementByAccessibilityId("15");
		WebElement stop = driver.findElementByAccessibilityId("45");
		
		TouchAction touch = new TouchAction(driver);
		touch.longPress(longPressOptions().withElement(element(strt)).withDuration(ofSeconds(3))).moveTo(element(stop)).release().perform();
		
		driver.findElement(MobileBy.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
