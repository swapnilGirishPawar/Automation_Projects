package webappTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {

	public static AndroidDriver<AndroidElement> capability() throws MalformedURLException {
		
		// check  the capabilities of remote device, not running on desktop web, running on mobile web
		DesiredCapabilities cap = new DesiredCapabilities();
		//name of emulator- name of device ---mandatory
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixelphone");
		// platform which we are testing
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//Not mandatory for Android, default is appium, Mandatory for IOS
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		// this is to test only WebApp...not native or hybrid app
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		// chromedriver is nessesary.
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Swapnil\\Selenium\\chromedriver_win32\\chromedriver.exe");
	
		
		// i m going to run this in emulator, but not connect appium...coz appium help to connect with emulator.
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		// Dont want to write capabilities for all classes, SO want to keep it common and import in all classes
		return driver;
	}

}
