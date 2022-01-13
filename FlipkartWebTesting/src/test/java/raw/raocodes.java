package raw;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class raocodes {
public WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions MO = new Actions(driver);
		Actions act = new Actions(driver);
		driver.get("https://flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class ='_2IX_2- VJZDxU']")).sendKeys("8888402650");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_2IX_2- _3mctLh VJZDxU']")).sendKeys("swapnil123");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@class ='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		//driver.findElement(By.xpath("//*[@class ='_3704LK']"));
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys("Iphone 13");
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		
// 1
		driver.findElement(By.partialLinkText("APPLE iPhone 13 (Blue, 128 GB)")).click();
		Thread.sleep(5000);		
		
//to shift tabs
		String windowHandle = driver.getWindowHandle();
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(1));
		Thread.sleep(5000);
		
//scroll to specs
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element =driver.findElement(By.xpath("//*[@class ='_3dtsli']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(5000);
		
//scroll to review
		WebElement Element2 =driver.findElement(By.xpath("//*[@class ='_3HKIdy']"));
		js.executeScript("arguments[0].scrollIntoView();", Element2);
		Thread.sleep(5000);
		
//scroll and hold to generate similar products 
		WebElement Element3 =driver.findElement(By.xpath("//*[@class ='_1RVm3P']"));
		js.executeScript("arguments[0].scrollIntoView();", Element3);
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'Similar Products')]"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		
	}
}
