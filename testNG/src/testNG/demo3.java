package testNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo3 {

public WebDriver driver;
	
	@BeforeTest
	
	  public void beforeMethod() throws InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
			 //i want to maximize the browser
			 driver.manage().window().maximize();
			 Thread.sleep(2000);
			driver.navigate().to("http://demo.guru99.com/test/newtours/index.php");
	  }
	
	@Test()
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("adminrocks");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("adminflops");
		driver.findElement(By.xpath("//*[@name='submit']")).click();
	Assert.assertEquals("sunil", "moolya");
	
	}
	
	@Test(dependsOnMethods = ("login"),alwaysRun = true)
	public void logout() throws InterruptedException
	{
		
		//i have to click on flights//6th locator
				driver.findElement(By.linkText("Flights")).click();
				
				//i am interacting on a radio button
				driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']")).click();
		
	}
	
	@AfterTest
	public void AT()
	{
		driver.close();
	}
}
