package dataDrivenByApachePOI;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {

	public static void main(String[] args) throws IOException {
		
		// take screenshot !
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			//to open the URL 
			driver.get("https://opensource-demo.orangehrmlive.com");
			 driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
			 // to capture ss.
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\Swapnil\\eclipse\\image\\orangehrm.png"));
			driver.close();
	}

}
