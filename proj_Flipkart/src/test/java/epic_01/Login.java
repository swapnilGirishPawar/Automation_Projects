package epic_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.core.util.FilePathUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	
public WebDriver driver;
	
	@BeforeTest
	public void BT()
	{
		// setting up chrome driver from WDM.
				WebDriverManager.chromedriver().setup();
				// this line to open a chrome browser.
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				// i want to open URL
				driver.get("http://www.flipkart.com/");
	}
	
	// Valid Login to Logout flow.
	@Test
	public void testcase_01() throws InterruptedException 
	{	
		System.out.println("tc-01");
		driver.findElement(By.xpath("//*[@class='_2IX_2- VJZDxU']")).sendKeys("9975518490");
		driver.findElement(By.xpath("//*[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("9975518490");
		driver.findElement(By.xpath("//*[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(1500);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@class='_2IX_2- VJZDxU']")).sendKeys("8888402650");
		driver.findElement(By.xpath("//*[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("Swapnil@321432");
		driver.findElement(By.xpath("//*[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(1500);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@class='_2IX_2- VJZDxU']")).sendKeys("8888402650");
		driver.findElement(By.xpath("//*[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("swapnil123");
		driver.findElement(By.xpath("//*[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(1500);
		
		WebElement profile = driver.findElement(By.xpath("//*[contains(text(),'Swapnil')]"));
		Actions MO = new Actions(driver);
		MO.moveToElement(profile).build().perform();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
	}
	
	@AfterTest (enabled = true)
	public void AT() throws InterruptedException
	{
		Thread.sleep(1500);
		driver.close();
	}	
}
