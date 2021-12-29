package selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class dropDown_RadioBTN {
	
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
				driver.get("http://demo.guru99.com/test/newtours/");
	}
	
	@Test
	public void testcase01() throws InterruptedException
	{
		
	
		driver.findElement(By.xpath("//*[@type='text' and @name='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@type='password' and @name='password']")).sendKeys("admin@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='submit' and @name='submit']")).click();
		driver.findElement(By.linkText("Flights")).click();
		//this is to click on the radio button
		driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']")).click();//for radio buttons
		
		//if i have to work with drop down
		WebElement cc = driver.findElement(By.name("passCount")); //for dropdown boxes
		Select sel1= new Select(cc);
		//sel1.selectByValue("3");
		 
		
		List<WebElement> values = sel1.getOptions();
		for (int i=0; i<values.size();i++)
		{
			System.out.println(values.get(i).getText());
		}
		
		sel1.selectByVisibleText("4");
		
		
		// i want to check what value is selected in drop down// i want to fetch the value.
		WebElement first = sel1.getFirstSelectedOption();
		System.out.println(first.getAttribute("value"));
	}
	
	@AfterTest
	public void AT() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	
}
