package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class elements {

	public static void main(String[] args) throws InterruptedException {
		
		// first thing to set chrome driver to open chrome browser
		System.setProperty("webdriver.chrome.driver","C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		// firefox driver to use firefox browser
		//System.setProperty("webdriver.gecko.driver","C:\\Swapnil\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");	
		
		WebDriver driver = new ChromeDriver();
		// to open URL
		driver.get("https://opensource-demo.orangehrmlive.com");
		//before login I want to get application name.
		String beforeTitle = driver.getTitle();
		//enter the username & password details by using locator-xpath
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
		//Click login button by using locator-id
		driver.findElement(By.id("btnLogin")).click();
		String afterTitle = driver.getTitle();
		
		// comparing both titles are same or not.
		if (beforeTitle.equals(afterTitle))
		{
			System.out.println("Logout");
			driver.findElement(By.xpath("//*[@id='welcome']")).click();
			Thread.sleep(2500);
			driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
			Thread.sleep(2000);
			driver.close();
		}
		else 
		{
			driver.close();
		}
		
		// to hold on screen for 3 sec. :- Thread.sleep(3000);
		//to close the brower :- driver.close();
	}

}
