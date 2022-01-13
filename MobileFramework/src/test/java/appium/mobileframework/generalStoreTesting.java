package appium.mobileframework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.Key;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
public class generalStoreTesting extends capabilities {
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws IOException, InterruptedException {
		 
	}
	
		
		@Test (enabled = false)
		public void test1() throws MalformedURLException, InterruptedException
		{
			System.out.println("hello World");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Page - 01 
			//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina \"))").click();
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			
			
			//Page - 02
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike Blazer Mid '77\"))");
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			//Page - 03
			//driver.findElement(By.xpath("//*[@elementId='3307accb-d951-4375-9e83-f4898ac82e9f']")).click();
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
			
			// Now it took me to chrome browser.
			
		}
		
		@Test (enabled = false)
		public void negetiveTest()
		{
			System.out.println("hello World");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Page - 01 
			//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
				driver.findElement(By.xpath("//*[@text='Female']")).click();
				driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	// This is how to capture error message in android using toast.
			String error = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
			System.out.println(error);
		}
		
		@Test(enabled = false)
		public void Test3()
		{
			//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
			
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"))");
			driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
			driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
			
		}
		
		@Test (enabled = false)
		public void test4() throws MalformedURLException, InterruptedException
		{
			System.out.println("hello World");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Page - 01 
			//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina \"))").click();
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			
			
			//Page - 02
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(textMatches(\"Jordan 6 Rings\").instance(0))");
			int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			for(int i=0;i<count;i++)
			{
				String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
				if(productName.equalsIgnoreCase("Jordan 6 Rings"))
				{
					System.out.println(productName);
					driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
					break;
				}
			}
			System.out.println("clicked on jordan 6 rings");	
		}
			
			/*
			AndroidElement end = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"))");
			while(end != null)
			{
				int count = driver.findElements(By.id("android.widget.LinearLayout")).size();
				System.out.println(count);
			}
			*/
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(textMatches(\"Jordan 6 Rings\").instance(0))");
			//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			//driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
// want to find how many products are there...getSize();
			
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\"))");
			//what if i want to click on the specific elemnt add to cart jordon 6 rings
			//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))");
			
		
		
		@Test
		public void test5() throws InterruptedException, IOException
		{
			driver = capability();
			service = startServer();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
// Page - 01
			driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Niharika");
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			driver.findElement(By.id("android:id/text1")).click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
// Page - 02
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			Thread.sleep(2000);
// Page - 03
			String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
			System.out.println(amount1);
			amount1 = amount1.substring(1);
			double p1 = Double.parseDouble(amount1);

			String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
			System.out.println(amount2);
			amount2 = amount2.substring(1);
			double p2 = Double.parseDouble(amount2);
			
			double total = p1+p2;
			System.out.println(total);
			
			String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
			totalAmount = totalAmount.substring(1);
			double totalAmount1 = Double.parseDouble(totalAmount);
			
			Assert.assertEquals(total,totalAmount1);
			System.out.println("Amount is equal !!!");
			
			
			TouchAction touch = new TouchAction(driver);
			// Tap on below element
			driver.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).click();
			
			WebElement lp = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/termsButton"));
			
			touch.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).perform();
			
			driver.findElement(MobileBy.id("android:id/button1")).click();
			driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();	
			Thread.sleep(5000);
// Web view page starts here
			
			// get the total views in hybrid app. ie web view & app view
			Set<String> contextnames = driver.getContextHandles();
			for (String contextname : contextnames)
			{
				System.out.println(contextname);
			}
			
			// Switch to web View 
			driver.context("WEBVIEW_com.androidsample.generalstore");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Moolya");
			driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
			
			// pressing back button on screen.
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
			// Switch to app view
			driver.context("NATIVE_APP");
			service.stop();
			
		}
	}