package dataDrivenByApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class temp {

	 public WebElement driver;
	public static void main(String[] args) throws IOException, InterruptedException {

		
		System.setProperty("webdrier.chrome.driver","C:\\Swapnil\\Selenium\\chromedriver_win32");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		//creating new file
		File excel =  new File("C:\\Users\\user\\Desktop\\TestDataApache.xlsx");
		// this is to read the data from file.
		FileInputStream fis = new FileInputStream(excel);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		
		
		int roucount = sh.getLastRowNum();
		for (int i=0;i<roucount;i++)
		{
			String username = sh.getRow(0).getCell(0).getStringCellValue();
			String password = sh.getRow(0).getCell(1).getStringCellValue();
			
			driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			//this is after login titile
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='welcome']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
			Thread.sleep(2000);	
		}
		driver.close();
		
		
		
		
		
		
	
	
	}
}