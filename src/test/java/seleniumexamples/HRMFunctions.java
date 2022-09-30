package seleniumexamples;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HRMFunctions {
	WebDriver driver = new ChromeDriver();
	void login() throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Shruthi\\chromedriver.exe");
		HRMFunctions obj = new HRMFunctions();
		obj.login();
		obj.search("Admin");
		obj.search("admin", "Paul Collings");
		
	}
	public void search(String username)
	{
		driver.findElement(By.xpath("//li/a")).click();
		driver.findElement(By.xpath("//form//div[2]//input")).sendKeys(username);
		driver.findElement(By.xpath("//form//div//button[2]")).click();
	}
	public void search(String username,String empname) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li/a")).click();
		driver.findElement(By.xpath("//form//div[2]//input")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form//div[2]//input[@placeholder='Type for hints...']")).sendKeys(empname);
		driver.findElement(By.xpath("//form//div//button[2]")).click();
	}
	

}
