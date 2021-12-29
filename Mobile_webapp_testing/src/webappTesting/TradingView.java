package webappTesting;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TradingView extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capability();
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("flipkart");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		List<AndroidElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		
		WebElement wb = driver.findElement(By.xpath("//*[@class='q8U8x MBeuO ynAwRc oewGkc LeUQr']"));
		wb.click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@class='_3NH1qf _2x71WM']")).click();
		Thread.sleep(15000);
		
		driver.close();
		
	}

}
