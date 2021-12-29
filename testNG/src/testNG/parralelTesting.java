package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class parralelTesting {
	public WebDriver driver;
	@Parameters("mybrowser")
	@BeforeTest
	public void BT(String mybrowser)
	{
			if (mybrowser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
				  driver = new ChromeDriver();
				  
			}
			else
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Swapnil\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
				driver = new InternetExplorerDriver();
			}		
	}
	
	@Test
	public void testcase01()
	{
		//driver.manage().window().maximize();
		driver.get("http://www.flipkart.com");
		String title = driver.getTitle();
		System.out.println(title);	
	}
	
	@AfterTest
	public void AT() throws InterruptedException
	{
		Thread.sleep(1500);
		driver.close();
		
	}
}
