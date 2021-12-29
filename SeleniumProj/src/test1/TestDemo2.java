package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDemo2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com");
		WebElement username = driver.findElement(By.xpath("//*[@id='txtUsername']"));
		
		if(username.isEnabled())
		{
			username.clear();
			username.sendKeys("Admin");
		}
		if(username.isDisplayed())
		{
			System.out.println("Is Displayed !");
		}
		
		
	}

}
