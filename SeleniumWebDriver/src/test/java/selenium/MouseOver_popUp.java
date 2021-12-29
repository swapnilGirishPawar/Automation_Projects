package selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class MouseOver_popUp {
	
	public WebDriver driver;
	
	@BeforeTest
	public void BT()
	{
		// setting up chrome driver from WDM.
				WebDriverManager.chromedriver().setup();
				// this line to open a chrome browser.
				
				WebDriver driver = new ChromeDriver(); // either we can use ChromeDriver = new ChromeDriver();
				driver.manage().window().maximize();
				// i want to open URL
				//driver.get("https://opensource-demo.orangehrmlive.com/");
				driver.get("https://demoqa.com/alerts");
				//driver.get("https://www.demoblaze.com");
				//driver.navigate().to("https://demoqa.com/alerts");
	}
	
	@Test (enabled = false)
	public void demo()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('login2').click()");
		js.executeScript("document.getElementById('loginusername').value = 'Admin'");
		js.executeScript("document.getElementById('loginpassword').value = 'Admin123'");
		driver.findElement(By.xpath("//*[@onclick='logIn()']")).click();
	}
	
	@Test (enabled = false)
	public void testcase2() throws InterruptedException
	{

		WebElement username = driver.findElement(By.xpath("//*[@id='txtUsername']"));
		String fetch = driver.findElement(By.xpath("//*[contains(text(),'( Username : Admin | Password : admin123 )')]")).getText();
		System.out.println(fetch);
		if(username.isEnabled())
		{
			username.clear();
			username.sendKeys("admin");
			Thread.sleep(3000);
		}
		if(username.isDisplayed())
		{
			String un = username.getAttribute("value");
			System.out.println(un);
		}
		WebElement password = driver.findElement(By.xpath("//*[@id='txtPassword']"));
		if(password.isEnabled())
		{
			password.clear();
			password.sendKeys("admin123");
			Thread.sleep(3000);
		}
		if(password.isDisplayed())
		{
			String ps = password.getAttribute("value");
			System.out.println(ps);
		}
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
	}
	
	@Test (enabled = false)
	public void HRM_mouseOver() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(3000);
		
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
	
		/*
		// I want to click on link - use linkText.
		driver.findElement(By.linkText("PIM")).click();
		// go to the back 
		driver.navigate().back(); // for back arrow
		Thread.sleep(1500);
		driver.navigate().forward(); // for forward arrow 
		driver.navigate().refresh();
		*/
		
		// I want to mouse over the elements 
		WebElement link  = driver.findElement(By.linkText("PIM"));
		Actions MO = new Actions(driver);
		MO.moveToElement(link).build().perform();
		Thread.sleep(2500);
		WebElement link2  = driver.findElement(By.linkText("Configuration"));
		MO.moveToElement(link2).build().perform();
		Thread.sleep(2500);
		//MO.sendKeys(link2,(Keys.ENTER)).perform();
		MO.sendKeys(Keys.ARROW_DOWN).perform();
		MO.sendKeys(Keys.ARROW_DOWN).perform();
		MO.sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(3000);
		
		
		/*// to Logout from dashBoard
		driver.findElement(By.linkText("Welcome Bosch")).click();
		Thread.sleep(2500);
		driver.findElement(By.linkText("Logout")).click();*/
	}
	
	
	// Wokring with Popups.
	@Test
	public void pup_up() throws InterruptedException
	{
		// Normal Pop Up
		driver.findElement(By.xpath("//*[@id='alertButton']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// Timed pop Up
		driver.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
		Thread.sleep(7000);
		alert.accept();
		
		//Confirm or Cancel pop Up
		driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
		Thread.sleep(1000);
		alert.accept();
		
		//Prompt to enter pop Up
		driver.findElement(By.xpath("//*[@id='promtButton']")).click();
		Thread.sleep(1000);
		alert.sendKeys("Swapnil Pawar");
		alert.accept();
	}
	
	@AfterTest
	public void AT() throws InterruptedException
	{
		Thread.sleep(1500);
		driver.close();
	}

}
