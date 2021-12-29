package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jsexecutor {
	
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
				//driver.get("https://opensource-demo.orangehrmlive.com/");
				//driver.get("https://demoqa.com/frames");
				driver.get("C:\\Users\\user\\Downloads\\janki2.html");
	}
	
	@Test (enabled = false)
	public void JS() throws InterruptedException
	{
		// JS / java script exectutor which is an interface to webDriver
				JavascriptExecutor js = (JavascriptExecutor)driver; 
				// to get title 
				String title = js.executeScript("return document.title").toString();
				System.out.println(title);
				String domain = js.executeScript("return document.domain").toString();
				System.out.println(domain);
				
				
				js.executeScript("history.go(0)");
				// put username.
				js.executeScript("document.getElementById('txtUsername').value = 'Admin'");
				// put password.
				js.executeScript("document.getElementById('txtPassword').value = 'admin123'");
				
				js.executeScript("document.getElementById('btnLogin').click()");
				// click on PIM
				js.executeScript("document.getElementById('menu_pim_viewPimModule').click()");
				// click on Employee List
				js.executeScript("document.getElementById('menu_pim_viewEmployeeList').click()");
				// scroll the window down
				js.executeScript("window.scrollBy(0,250)");
				
				js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
				Thread.sleep(300);
				js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
				
				js.executeScript("document.getElementById('ohrmList_chkSelectRecord_37').scrollIntoView()");
				Thread.sleep(300);
				
				String table = 
						js.executeScript("return document.getElementById('resultTable').innerText").toString();
				//System.out.println(table);
				
				js.executeScript("alert ('Welcome to world of JS')");
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				
				js.executeScript("Confirm(This ts to cancle )");
				Thread.sleep(3000);
				String msg = driver.switchTo().alert().getText();
				System.out.println("PopUp message is = " +msg);
				driver.switchTo().alert().dismiss();
				
				Thread.sleep(3000);
				js.executeScript("prompt('Enter yes/No', 'Yes/No')");
				driver.switchTo().alert().sendKeys("YES");
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				
				
	}
	
	@Test (enabled = false)
	public void frame() throws InterruptedException
	{
		// getting the all the frames 
		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		System.out.println(frame.size());
		
		// to print the all frame names or ID
		for(WebElement e :frame)
		{
			System.out.println(e.getAttribute("id"));
		}
		
		// to go inside any perticular frame
		driver.switchTo().frame("frame1");
		String txt = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(txt);
		
		// this is to comeout of the frame
		driver.switchTo().defaultContent();
		// now I can switch to another frame.
		driver.switchTo().frame("frame2");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		
	}
	
	@Test
	public void HTML_File()
	{
		String txt = driver.findElement(By.xpath("//*//table/tbody/tr[2]/td[3]")).getText();
		System.out.println(txt);
	}
	
	@AfterTest
	public void AT() throws InterruptedException
	{
		Thread.sleep(1500);
		driver.close();
		
		
	}

}
