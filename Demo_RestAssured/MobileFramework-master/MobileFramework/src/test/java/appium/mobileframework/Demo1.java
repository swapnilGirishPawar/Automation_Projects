package appium.mobileframework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
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

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class Demo1 extends Capabilities {

	
		AndroidDriver<AndroidElement> driver;
	
	
		@BeforeTest
		public void BT() throws IOException, InterruptedException
		{
			//driver = capability();
			
		}

		@Test(enabled = false)
		public void TC1()
		{
			//Positive testing
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//I want to enter the name
			driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Shalini");
			driver.findElementByXPath("//*[@text='Female']").click();
			
			//I want to scroll but I have to click on the menu button
			driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
			
			//I want to click on let's shop
			driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		}
		
		@Test(enabled = false)
		public void TC2() throws InterruptedException
		{
			//Negative testing
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//I want to enter the name
			//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Shalini");
			driver.findElementByXPath("//*[@text='Female']").click();
			
			//I want to scroll but I have to click on the menu button
			driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
			
			//I want to click on let's shop
			driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
			Thread.sleep(3000);
			
			//Whenever you get an error message in mobile native app you have to use toast it means error to capture error message
			String message = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
			System.out.println(message);
			
			//I want to capture the error and print it in console
		}
	
		@Test(enabled = false)
		public void TC3()
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//I want to enter the name
			driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Shalini");
			driver.findElementByXPath("//*[@text='Female']").click();
			
			//I want to scroll but I have to click on the menu button
			driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
			
			//I want to click on let's shop
			driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
			
			//Will it take me to the next screen
			//I want to click on add to cart of both the products text and xpath
			
			
			//driver.findElementByXPath("//*[@text='ADD TO CART']").click();
			//driver.findElementByXPath("//*[@text='ADD TO CART']").click();
			//driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
			//driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
			
			//First thing is I want to scroll in a different way
			//I want to find how many products are there
			
			//I want to scroll to an element to make the element in the instance of 0
			//I want to scroll based on the product list which is identified by Alpesh
			//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));");
			//What if I want to click on specific element add to cart Jordan 6 rings
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\"))");
			//what if i want to click on the specific elemnt add to cart jordon 6 rings
			//driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))");
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
		
		@Test
		public void TC4() throws InterruptedException, IOException
		{
			service = startServer();
			driver = capability();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//I want to enter the name
			driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Shalini");
			driver.findElementByXPath("//*[@text='Female']").click();
			
			//I want to scroll but I have to click on the menu button
			driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
			
			//I want to click on let's shop
			driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
			
			driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
			driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
			
			driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
			Thread.sleep(3000);
			//This is for forst value
			String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
			//I have to remove the dollar sign
			amount1 = amount1.substring(1);
			Double amountvalue = Double.parseDouble(amount1);
			//System.out.println(amount1);
			
			//This is for second value
			String amount2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
			amount2 = amount2.substring(1);
			Double amount2value = Double.parseDouble(amount2);
			//System.out.println();
			//System.out.println(amount2);
			
			//I want to add amountvalue with amount2value
			Double Totalamount = amountvalue + amount2value;
			
			//I should do it for the final value
			String Total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
			Total = Total.substring(1);
			Double Totalvalue = Double.parseDouble(Total);
			
			//Asert to check if the value is added 
			Assert.assertEquals(Totalvalue, Totalamount);
			System.out.println("The amount is equal");
			
			WebElement tap = driver.findElementByXPath("//*[@text='Send me e-mails on discounts related to selected products in future']");
			
			Thread.sleep(3000);
			
			TouchAction ta = new TouchAction(driver);
			ta.tap(tapOptions().withElement(element(tap))).perform();
			WebElement LP = driver.findElementByAndroidUIAutomator("text(\"Please read our terms of conditions\")");
			ta.longPress(longPressOptions().withElement(element(LP)).withDuration(ofSeconds(2))).release().perform();
			
			driver.findElementById("android:id/button1").click();
			driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
			Thread.sleep(9000);
			System.out.println("The WebPage is open");
			
			//What happens when I visit to WebPage
			//So how do I know whether I am in native app or webapp
			
			//This can be used when you have a multiple mobile view
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
			    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
			}
			
			//This will take me from native app to hybrid app
		    driver.context("WEBVIEW_com.androidsample.generalstore");

		
		    driver.findElement(By.xpath("//*[@name='q']")).sendKeys("moolya");
	    	driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
	    	Thread.sleep(5000);
		
	    	//This will take me back to native app
	    	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		    driver.context("NATIVE_APP");
		    service.stop();
		
		}
		}


