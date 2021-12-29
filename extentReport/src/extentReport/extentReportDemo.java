package extentReport;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentReportDemo {

	public static void main(String[] args) {
		
		// use to generate HTML reports
		
		ExtentReports extent;
		ExtentTest logger;
		
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-optput\\swapnil.html",true);
		
		// load the config file from src folder.
		extent.loadConfig(new File(System.getProperty("user.dir") + "/src/extent-config.xml"));
		
		// start the testing
		logger = extent.startTest("New Testing");
		System.setProperty("webdriver.chrome.driver", "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		logger.log(LogStatus.PASS, "Web Page opened !");
		
		
		
		driver.close();
		logger.log(LogStatus.PASS, "Browser closed succesfully !");
		extent.endTest(logger);
		extent.flush();
		extent.close();
		
		
	}

}
