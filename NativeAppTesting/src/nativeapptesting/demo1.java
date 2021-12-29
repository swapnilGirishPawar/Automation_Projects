package nativeapptesting;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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


public class demo1 extends capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capability();
		
		//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Views\")")).click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)").getSize());
		WebElement Link = driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		System.out.println(Link.getSize());
		
		
// How to tap on emelent.
		// Store it into WebElement 
		WebElement expandList = driver.findElementByAccessibilityId("Expandable Lists");
		// same as actions in selenium we use touchAction here
		TouchAction ta = new TouchAction(driver);
		//perform actions here.
		// tap point options is uses X & Y cordinates - (Not used here)
		// tap tapoptions is use to locate elements. - (used below)
		ta.tap(tapOptions().withElement(element(expandList))).perform();
		Thread.sleep(3000);
		driver.findElementByAccessibilityId("1. Custom Adapter").click();
		WebElement lp = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
// to long press on element
		ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(2))).release().perform();

		Thread.sleep(2000);
		
		String txt = driver.findElements(By.className("android.widget.TextView")).get(1).getText();
		System.out.println(txt);
		//driver.findElements(MobileBy.className("android.widget.LinearLayout")).get(1).click();
		
		
		
	
		
	}
}
