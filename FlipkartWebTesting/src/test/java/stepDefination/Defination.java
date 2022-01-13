package stepDefination;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Defination {

	public WebDriver driver;
	
	@Given("I should open the flipkart website.")
	public void i_should_open_the_flipkart_website() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");
	    throw new io.cucumber.java.PendingException();
	}

	@When("Enter the Email ID.")
	public void enter_the_email_id() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@class ='_2IX_2- VJZDxU']")).sendKeys("pswapnil032@gmail.com");
	    throw new io.cucumber.java.PendingException();
	}

	@When("Enter the password.")
	public void enter_the_password() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@class ='_2IX_2- _3mctLh VJZDxU']")).sendKeys("swapnil123");
	    throw new io.cucumber.java.PendingException();
	}

	@When("Click on the login button.")
	public void click_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@class ='_2KpZ6l _2HKlqd _3AWRsL']")).click();
	    throw new io.cucumber.java.PendingException();
	}

	@When("Search for Product - {string}")
	public void search_for_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@class ='_3704LK']")).sendKeys("Iphone 13");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see the relevant search results.")
	public void i_should_see_the_relevant_search_results() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
	    throw new io.cucumber.java.PendingException();
	}
	
}


