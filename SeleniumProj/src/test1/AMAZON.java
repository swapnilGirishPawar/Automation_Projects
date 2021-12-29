package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AMAZON {
	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver","C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver();
		// maximize the screen.
		driver.manage().window().maximize();
		driver.get("http://www.amazon.com");
		driver.findElement(By.xpath("//*[@href='/b?node=16225007011']")).click();
	}
}
