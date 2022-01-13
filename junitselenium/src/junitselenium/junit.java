package junitselenium;

import javax.swing.text.html.HTML;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class junit {
	
	@Test
	public void tc01() {
		
		WebDriver driver = new HtmlUnitDriver();
		driver.get("https://flipkart.com");
		driver.manage().window().maximize();

	}

}
