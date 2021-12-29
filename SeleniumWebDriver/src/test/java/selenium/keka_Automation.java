package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class keka_Automation {

	public WebDriver driver;
		
		@BeforeTest
		public void BT() throws InterruptedException
		{
			// setting up chrome driver from WDM.
			WebDriverManager.chromedriver().setup();
			// this line to open a chrome browser.
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			// i want to open URL
			driver.get("https://moolya.keka.com/#/home/dashboard");
			Thread.sleep(5000);
		}
		
		@Test (priority = 0, enabled = false)
		public void clockIn() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@name='provider']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("swapnil.pawar@moolya.com");
			driver.findElement(By.xpath("//*[@class='VfPpkd-vQzf8d']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Swapnil@123");
			driver.findElement(By.xpath("//*[@class='VfPpkd-vQzf8d']")).click();
			Thread.sleep(6000);
			// For clock-In 
			// failing here !!
			driver.findElement(By.xpath("//*[contains(text(),'Web Clock-In')]")).click();
			Thread.sleep(6000);
		}
		
		@Test (priority = 0, enabled = true)
		public void clockOut() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@name='provider']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("swapnil.pawar@moolya.com");
			driver.findElement(By.xpath("//*[@class='VfPpkd-vQzf8d']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Swapnil@123");
			driver.findElement(By.xpath("//*[@class='VfPpkd-vQzf8d']")).click();
			Thread.sleep(6000);
			// For clock-out
			driver.findElement(By.xpath("//*button[contains(text(),'Clock-out')]")).click();
			Thread.sleep(6000); 
			
			/*
			  // Common Logic :- 
						// I want to fetch all the link names (by using tagName locator)
						List<WebElement> links = driver.findElements(By.tagName("a"));
						System.out.println(links.size());
						// I want to print each link which is visible.
						for(WebElement e:links)
						{
							String link = e.getText();
							System.out.println(link);
						}
		    */
		}


		@AfterTest (enabled = false)
		public void AT() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.close();
		}
		
}
