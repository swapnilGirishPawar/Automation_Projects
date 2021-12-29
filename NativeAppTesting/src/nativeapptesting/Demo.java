package nativeapptesting;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Demo extends capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = capability();
		System.out.println("App is running ! ");
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(4000);
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		Thread.sleep(4000);
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		Thread.sleep(4000);
		//driver.findElement(MobileBy.xpath("//*[contains(text(),'WiFi settings')]")).click();
		//driver.findElement(MobileBy.partialLinkText("WiFi settings")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		Thread.sleep(4000);
		
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("SwapnilP");
		driver.hideKeyboard();
		Thread.sleep(4000);
		//driver.findElement(MobileBy.id("android:id/button1")).click();
		driver.findElements(MobileBy.className("android.widget.Button")).get(0).click(); 	 	 	
		Thread.sleep(3000);
		
		// to click on back button.
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}

}
