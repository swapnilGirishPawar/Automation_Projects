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

// these imports are required to use tap options:- 
import static io.appium.java_client.touch.TapOptions.tapOptions;

public class TaskDragDrop extends capabilities {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capability();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Views\")")).click();
		
		driver.findElementByAccessibilityId("Drag and Drop").click();
		
		WebElement c1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement c2 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));

		TouchAction touch = new TouchAction(driver);
		
		touch.longPress(longPressOptions().withElement(element(c1)).withDuration(ofSeconds(3))).moveTo(element(c2)).release().perform();
		
}
}
