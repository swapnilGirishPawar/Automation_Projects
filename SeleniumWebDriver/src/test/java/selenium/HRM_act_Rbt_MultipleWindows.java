package selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;	

public class HRM_act_Rbt_MultipleWindows {
	
	public WebDriver driver;
	
	@BeforeTest
	public void BT()
	{
		// setting up chrome driver from WDM.
		WebDriverManager.chromedriver().setup();
		// this line to open a chrome browser.
		WebDriver driver = new ChromeDriver();
		//driver = new ChromeDriver();
		// to maximize the window
		//driver.manage().window().maximize();
		// i want to open URL
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://www.google.com/");
		//driver.get("https://demoqa.com/browser-windows");
	}
	@Test (enabled = false)
	public void login() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
		//WebElement login = driver.findElement(By.xpath("//*[@id='btnLogin']"));
		Actions act = new Actions(driver);
		//act.moveToElement(login).build().perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB).perform();
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
	}

	@Test (enabled = false)
	public void gmail() throws InterruptedException, AWTException
	{
		System.out.println(driver.getTitle());
		
		WebElement link  = driver.findElement(By.linkText("Gmail"));
		WebDriverWait wt = new WebDriverWait(driver, 30);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gmail")));
		
		Actions act = new Actions(driver);
		act.contextClick(link).build().perform();
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		System.out.println(driver.getTitle());
		
	}
	
	@Test (enabled = false)
	public void testQA()
	{
		// this is for fetch window ID
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		WebElement tabWindow = driver.findElement(By.id("tabButton")); // windowButton for new Window
		for (int i=0;i<2;i++)
		{
			tabWindow.click();
		}
		
		// I want to fetch all window handles ID , Set String is for mltiple string storing.
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		String lastWindow = "";
		for (String handle : allWindows)
		{
			driver.switchTo().window(handle);
			driver.get("https://www.google.com/");
			lastWindow = handle;
		}
		
		
		//INCOMPLETE:- 
		/*
		Iterator<String> i = allWindows.iterator();
		while (i.hasNext())
		{
			String childWindow=i.next();
			if (parentWindow != childWindow)
			{
				
			}
		}*/
		
		// I want to switch to parent window
		driver.switchTo().window(parentWindow);
		driver.get("https://www.flipkart.com/");
		
		driver.switchTo().window(lastWindow);
		driver.get("https://www.amazon.com/");
		
	}

	
	@AfterTest
	public void AT() throws InterruptedException
	{
		Thread.sleep(3000); 
		driver.close();
	}
}
