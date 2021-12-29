package SpotifyLiteTesting;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class mainTest extends capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capability();
		System.out.println("App is running ! ");
	}

}
