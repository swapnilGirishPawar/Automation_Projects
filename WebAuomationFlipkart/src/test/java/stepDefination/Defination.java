package stepDefination;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Defination {
	
	public WebDriver driver;

// Scenario - 01	
	@Given("i should open the browser and navigate to login page of FLipkart")
	public void i_should_open_the_browser_and_navigate_to_login_page_of_f_lipkart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
	}

	@When("Enter valid Name {string}")
	public void enter_valid_name(String username) {
		driver.findElement(By.xpath("//*[@class ='_2IX_2- VJZDxU']")).sendKeys(username);
		
	}

	@When("Enter Valid password {string}")
	public void enter_valid_password(String password) {
		driver.findElement(By.xpath("//*[@class ='_2IX_2- _3mctLh VJZDxU']")).sendKeys(password);
	}

	@When("Click on login button")
	public void click_on_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class ='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(5000);
	}

	@Then("i should see the Home page of flipkart {string}")
	public void i_should_see_the_home_page_of_flipkart(String expected) {
		
		String actual = driver.findElement(By.xpath("//*[@class='exehdJ']")).getText();
		Assert.assertEquals(actual, expected);
		driver.close();		
	}
	
// Scenario - 02	
	
	@Given("i should open the browser and navigate to login page of Flipkart")
	public void i_should_open_the_browser_and_navigate_to_login_page_of_flipkart() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
	}
	
	@When("Enter invalid Name {string}")
	public void enter_invalid_name(String username) {
		driver.findElement(By.xpath("//*[@class ='_2IX_2- VJZDxU']")).sendKeys(username);
	}

	@When("Enter invalid password {string}")
	public void enter_invalid_password(String password) {
		driver.findElement(By.xpath("//*[@class ='_2IX_2- _3mctLh VJZDxU']")).sendKeys(password);
	}

	@Then("i should see the Invalid Credentials {string}")
	public void i_should_see_the_invalid_credentials(String expected) {
		
		String actual = driver.findElement(By.xpath("//*[@class='_2YULOR']/.//span[contains(text(),'Your username or password is incorrect')]"))
			.getText();
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
	
	
// Search Functionality:-
	//Scenario:-
	
	@Given("I should open the flipkart website.")
	public void i_should_open_the_flipkart_website() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
	}

	@When("Enter the Email ID {string}")
	public void enter_the_email_id(String username) {
		driver.findElement(By.xpath("//*[@class ='_2IX_2- VJZDxU']")).sendKeys(username);
	}

	@When("Enter the password  {string}")
	public void enter_the_password(String password) {
		driver.findElement(By.xpath("//*[@class ='_2IX_2- _3mctLh VJZDxU']")).sendKeys(password);
	}

	@When("Click on the login button")
	public void click_on_the_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class ='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(5000);
	}

	@When("Search for Product - {string}")
	public void search_for_product(String Products) throws InterruptedException {
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys(Products);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
	}

	@Then("I should see the relevant search results {string}")
	public void i_should_see_the_relevant_search_results(String Product) {
		System.out.println(Product+" is Displayed.");
		driver.close();
	}
	
	
// Add to cart Functionality
	
	@When("Click on the add to on particular product {string}")
	public void click_on_the_add_to_on_particular_product(String product) throws InterruptedException {
		driver.findElement(By.partialLinkText("APPLE iPhone 13 (Pink, 256 GB)")).click();
        Thread.sleep(4000);
	}

	@When("click on Add to Cart Option.")
	public void click_on_add_to_cart_option() throws InterruptedException {
		 //to shift tabs
        String windowHandle = driver.getWindowHandle();
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(1));
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element =driver.findElement(By.xpath("//*[@class ='_2KpZ6l _1t_O3S _2ti6Tf _3AWRsL']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class ='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).click();
	}

	@Then("I should able to see the same searched product in the Cart page.")
	public void i_should_able_to_see_the_same_searched_product_in_the_cart_page() {
		String expected = "Price details";
		String actual = driver.findElement(By.xpath("//*[@class='_3aPjap']")).getText();
		Assert.assertEquals(actual, expected);
		
	}
	
	
}



// Expected --------     Given from dev
// Actual   --------     What we get from actual website - we need to fetch.


