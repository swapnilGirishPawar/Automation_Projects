package dataDrivenByApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.*;



public class dataDrivenApache {
	
	public WebElement driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
	
		 System.setProperty("webdriver.chrome.driver", "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			//to open the URL 
			driver.get("https://opensource-demo.orangehrmlive.com");
	
			
		File excel = new File("C:\\Users\\user\\Desktop\\TestDataApache.xlsx");
		FileInputStream fis = new FileInputStream(excel); // use to read data from file.
		
		// Apache POI supports two formats 1. XLS & 2. XLSX
		// 2 methods - 1. xssf for XLSX   &     2. hssf for XLS
//		 
		
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sh = wb.getSheetAt(0);
		 
//		
		 
			int roucount = sh.getLastRowNum();
		 for (int i=0;i<roucount;i++)
		 {
			 String username = sh.getRow(i).getCell(0).getStringCellValue();
			 String password = sh.getRow(i).getCell(1).getStringCellValue();
			 driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(username);
				driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
				driver.findElement(By.id("btnLogin")).click();
				Thread.sleep(3000);
				
				
				//this is after login titile
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='welcome']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
				Thread.sleep(3000);	 
		 }
		 
		driver.close();

}
}
