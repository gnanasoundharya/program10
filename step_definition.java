package definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class step_definition {
	WebDriver driver;
	String url =  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@Given("i should be in login page")
	public void i_should_be_in_login_page() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	    	}
	@When("when enter username {string}")
	public void when_enter_username(String string)  {
		WebElement web= driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		web.sendKeys(string);
	   
	}
	@When("enter the password {string}")
	public void enter_the_password(String string)  {
		WebElement web1 = driver.findElement(By.xpath("//input[@name='password']"));
		web1.sendKeys(string); 
		
	}
	
	@When("click on the login button")
	public void click_on_the_login_button() throws InterruptedException {
		WebElement web2 = driver.findElement(By.xpath("//button[@type='submit']"));
		web2.click();
		Thread.sleep(2000);
	    
	}
	@Then("i should see the username as {string}")
	public void i_should_see_the_username_as(String string) throws InterruptedException {
		WebElement s =driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[1]/a/div[2]/img"));
		System.out.println(string);	   
	
	}

}
