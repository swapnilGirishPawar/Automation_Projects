package flipkarttestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class login {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_2IX_2- VJZDxU']")).sendKeys("rajatashhpa@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_2IX_2- _3mctLh VJZDxU']")).sendKeys("Lovelybhai@14");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		driver.findElement(By.xpath("//*[@class ='_3704LK']"));
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys("Iphone 13");
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys("Nike shoes");
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys("USpolo shirts");
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys(Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys("Chocolates");
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(6000);
		driver.close();
		
	}

	
	}

