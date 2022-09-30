package cucumber.stepDefinitions;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.asserts.SoftAssert;

public class First {
	//WebDriver driver = new ChromeDriver();
	private static WebDriver driver = null;
	@Given("browser is open and application is in login page")
	
	public void browser_is_open_and_application_is_in_login_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Shruthi\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 }

	@When("user enters user name and password")
	public void user_enters_user_name_and_password() {
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("home page is displayed")
	public void home_page_is_displayed() {
	    String actualResult;
	    String expectedResult="PIM";
	    actualResult=driver.findElement(By.xpath("//img[@alt='client brand banner']")).getText();
	  SoftAssert soft=new SoftAssert();
	    soft.assertEquals(actualResult,expectedResult);
	    
	}

	@Then("user is logged out")
	public void user_loggedout() {
		driver.findElement(By.xpath("//li//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	    
	}


}
