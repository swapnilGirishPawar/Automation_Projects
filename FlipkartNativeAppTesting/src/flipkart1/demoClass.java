package flipkart1;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class demoClass extends capabilities{
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException {
		driver  = capability();
	}
	
	@Test (enabled = true)
	public void loginToAddToCart()
	{
		System.out.println("Hey there !");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Not able to scroll.
		driver.pressKey(new KeyEvent(AndroidKey.DPAD_UP));
		TouchAction ta = new TouchAction<>(driver);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"English\"))").click();
		
		driver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/select_btn']")).click();
		driver.findElement(By.xpath("//*[@text='088884 02650']")).click();
		driver.findElement(By.xpath("//*[@text='Search for Products, Brands and More']")).click();
		WebElement element = driver.findElementByAccessibilityId("Search grocery products");
		String text = "ball Pen";
		element.sendKeys(text+"\n");
		driver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/txt_title']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/allow_button']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"FLAIR Carbonix Ball Pen\"))").click();
		driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
		driver.findElementByAccessibilityId("Back Button").click();
		driver.findElement(By.xpath("//*[@text='GO TO CART']")).click();
		driver.findElement(By.xpath("//*[@text='Place Order']")).click();
		
	}
	
	
	@Test (enabled = false)
	public void login() throws InterruptedException
	{
//Page - 01
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"English\"))").click();
		driver.findElement(MobileBy.id("com.flipkart.android:id/select_btn")).click();
		
// Page - 02
		Thread.sleep(30000);
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Phone Number\"]")).sendKeys("8888402650");
		driver.findElement(MobileBy.id("com.flipkart.android:id/select_btn")).click();
		
// Page - 03
		Thread.sleep(20000);
		driver.findElement(By.id("com.flipkart.android:id/tv_left_cta")).click(); // resource ID
		//driver.findElement(By.xpath("//*[@text='Use Password']")).click();

// Page - 04
		driver.findElement(MobileBy.id("com.flipkart.android:id/phone_input")).sendKeys("swapnil123");
		driver.findElement(MobileBy.id("com.flipkart.android:id/button")).click();
		
// Page - 05 - Home page
		
		
	}
}
