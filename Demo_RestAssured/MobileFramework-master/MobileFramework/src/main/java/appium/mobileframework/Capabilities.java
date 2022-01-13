package appium.mobileframework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Capabilities {
	public static String apppackage,appactivity,devicename,platformname;
	
	public AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkifserverisRunning(4723);
		if(!flag)
		{
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C://Users//user//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723));
		service.start();
		
	}
		return service;
	}
	
	public static boolean checkifserverisRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serversocket;
		try{
			serversocket = new ServerSocket(port);
			serversocket.close();
		}
		catch(IOException e)
		{
			isServerRunning = true;
		}
		finally {
			serversocket=null;
		}
		return isServerRunning;
	}
	
	public static void StartEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\emulator.bat");
		Thread.sleep(15000);
	}

	public static AndroidDriver<AndroidElement> capability() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileReader fis = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\Global.properties");
		Properties pro = new Properties();
		pro.load(fis);
		apppackage = pro.getProperty("apppackage");
		appactivity = pro.getProperty("appactivity");
		devicename = pro.getProperty("devicename");
		platformname = pro.getProperty("platformname");
if(devicename.contains("amol"))
{
	StartEmulator();
	Thread.sleep(15000);
	
}
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,devicename);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,platformname);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,apppackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appactivity);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		 AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	        //I don't want to write this capability again and again for all the classes so I want to keep this common and import this in all the classes
	        return driver;
	}

}
