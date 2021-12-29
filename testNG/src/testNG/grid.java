package testNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class grid {
	public RemoteWebDriver driver;
	@Test
	public void gridTest() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL("http://192.168.43.83:4444/wd/hub"),cap);
		  driver.get("https://opensource-demo.orangehrmlive.com");
			
			driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123");
			
			driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
			String title = driver.getTitle();
			System.out.println(title);
				driver.findElement(By.xpath("//*[@id='welcome']")).click();
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
				Thread.sleep(4000);
		
	}
	
}
