package webappTesting;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DemoClass extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capability();
		System.out.println("this will open browser in emulator");
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Moolya twitter");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		
		List<AndroidElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(AndroidElement e:links)
		{
			String link = e.getText();
			System.out.println(link);
		}
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(4000);
		// i am storing an element in a webelement, so that i can scroll using js executer.
		WebElement wb = driver.findElement(By.xpath("//*[contains(text(),'Moolya Testing (@moolyatesting) / Twitter')]"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", wb);
		wb.click();
		
	
		
		driver.findElement(By.linkText("Moolya | LinkedIn")).click();
		
		
		
		
		//driver.findElement(By.xpath("//*[@class='q8U8x MBeuO ynAwRc oewGkc LeUQr']")).click();
		
	}

}
