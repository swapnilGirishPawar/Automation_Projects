 package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class radioButtons {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver();
		// maximize the screen.
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@name='submit']")).click();
		Thread.sleep(2500);
		
		// not able to get id for flights so we can use.
		driver.findElement(By.linkText("Flights")).click();
		Thread.sleep(2500);
		
		// interacting with radio button.
		WebElement trip = driver.findElement(By.xpath("//*[@name='tripType']"));
		if(trip.isSelected())
		{
			System.out.println("trip type is already selected");
		}
		
		driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']")).click();
		
		// this how I save the element in dd variable.
		WebElement dd = driver.findElement(By.name("fromMonth"));
		Select sel = new Select(dd);
		sel.selectByValue("2");
		
		WebElement ps = driver.findElement(By.name("passCount"));
		Select sel2 = new Select(ps);
		sel2.selectByVisibleText("3");
		
		driver.findElement(By.xpath("//*[@name='servClass' and @value='First']")).click();
		driver.findElement(By.name("findFlights")).click();
		
		
		
	}

}
