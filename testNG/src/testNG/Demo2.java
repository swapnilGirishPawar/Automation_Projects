package testNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2 {
	WebDriver driver;
	
	@BeforeTest
	public void BT() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com");
		  Thread.sleep(2000);
	}

	@Test
	public void loginTest() throws InterruptedException
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
	}
	
	@Test (dependsOnMethods = "loginTest")
	public void logoutTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void AT()
	{
		driver.close();
	}
}