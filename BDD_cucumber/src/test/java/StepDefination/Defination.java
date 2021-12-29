package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Defination {
	
	public WebDriver driver;
	
	
	@Given("i should open the browser and navigate to login page of orangeHRM")
	public void i_should_open_the_browser_and_navigate_to_login_page_of_orange_hrm() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(2000);
	}
	

	
	// First And second Scenario
	
	@When("Enter valid Name {string}")
	public void enter_valid_name(String username) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(username);;
	}	
	@When("Enter Valid password {string}")
	public void enter_valid_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("txtPassword")).sendKeys(password);;
	}
	@When("Click on login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("btnLogin")).click();
	}
	@Then("i should see the username as welcome Peter {string}")
	public void i_should_see_the_username_as_welcome_peter(String uname) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String name = driver.findElement(By.id("welcome")).getText();
		System.out.println(name);
		Assert.assertEquals(name, uname);
		Thread.sleep(3000);
		driver.close();
	}

// Third Scenario 
	
	@When("Enter invalid Name {string}")
	public void enter_invalid_name(String username) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(username);;
	}
	@When("Enter invalid password {string}")
	public void enter_invalid_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("txtPassword")).sendKeys(password);;
	}
	@Then("i should see the Invalid Credentials {string}")
	public void i_should_see_the_invalid_credentials(String uname) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String name = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(name, uname);
		Thread.sleep(3000);
		driver.close();
	}
}
