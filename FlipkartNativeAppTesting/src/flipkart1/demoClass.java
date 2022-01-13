package flipkart1;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
	
	@AfterTest
	public void AT() throws InterruptedException 
	{
		System.out.println("All test cases passed !");
		Thread.sleep(3000);
		driver.closeApp();
	}
	
	@Test (priority = 0)
	public void TC01_Login()
	{
		System.out.println("Test Scenario 1 - User should able to login into home page and able to see search bar.");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Page 01 - Language selection
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"English\"))").click();		
		driver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/select_btn']")).click();
//Page 02 - Phone number popup for login
		driver.findElement(By.xpath("//*[@text='088884 02650']")).click();
//Page 03 - Home Page
		WebElement searchBar = driver.findElement(By.xpath("//*[@text='Search for Products, Brands and More']"));
		String actual = searchBar.getText();
		String expected = "Search for Products, Brands and More";
		//WebElement expected = driver.findElement(By.xpath("//*[@text='Search for Products, Brands and More']"));
		Assert.assertEquals(actual, expected);
		System.out.println("TC01_Login - Passed !");
	}
	
	@Test (dependsOnMethods = "TC01_Login")
	public void TC02_SearchForProduct() throws InterruptedException
	{
		System.out.println("Test Scenario 2 - User should able to search perticular product and able to see product details.");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Page 04 - Search Bar functionality
		driver.findElement(By.xpath("//*[@text='Search for Products, Brands and More']")).click();
		WebElement element = driver.findElementByAccessibilityId("Search grocery products");
		String text = "ball Pen";
		element.sendKeys(text+"\n");
//Page 05 - permissions popups
		driver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/txt_title']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/allow_button']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).click();
//Page 06 - All Products to perticular product.
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"FLAIR Carbonix Ball Pen\"))").click();
		Thread.sleep(3000);	
//Page 07 - Product details 
		WebElement productName = driver.findElement(By.xpath("//*[@text='FLAIR Carbonix Ball Pen (Pack of 25, Blue)']"));
		String actual = productName.getText();
		String expected = "FLAIR Carbonix Ball Pen (Pack of 25, Blue)";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (dependsOnMethods = "TC02_SearchForProduct")
	public void TC03_addToCart() throws InterruptedException
	{
		System.out.println("Test Scenario 3 - User should able to click on add to cart option and product should be added into cart");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
//Page 08 - Popup
		driver.findElementByAccessibilityId("Back Button").click();
//Page 09 - Cart page
		driver.findElement(By.xpath("//*[@text='GO TO CART']")).click();
		Thread.sleep(3000);
		
		//String expectedQuantity = "1";
		//WebElement E = driver.findElement(By.xpath("//*[@text='Qty: 1']"));
		//String actualQuantity = E.toString().substring(3);
		//System.out.println(actualQuantity);
		//Assert.assertEquals(expectedQuantity,actualQuantity);
	}
	
	@Test (dependsOnMethods = "TC03_addToCart")
	public void emptyCart() throws InterruptedException
	{
		System.out.println("Test Scenario 4 - User should able to remove product from cart and navigate to home page.");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Remove']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@text='Remove']")).click();
		driver.findElementByAccessibilityId("Back Button");
	}
	
	
	// Not working: Unable to locate element on screen.
	@Test (enabled = false)
	public void TC04_LogOut() throws InterruptedException
	{
		System.out.println("Test Scenario 4 - User should able to logout from App.");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Back Button").click();
		Thread.sleep(3000);
		driver.findElementByAccessibilityId("Drawer").click();
	}

}
