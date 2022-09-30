package seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HRMLeave {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Shruthi\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		HRMLeave obj=new HRMLeave();	// class object
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {}
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {}
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.xpath("//li//a[@class='oxd-topbar-body-nav-tab-item']")).click();
		driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'CAN')]")).click();
		
		driver.findElement(By.xpath("//div[@class='oxd-date-input']//input")).sendKeys("2022-09-22");
		driver.findElement(By.xpath("//textarea")).sendKeys("Not well");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		
	
		
		
		

	}

}
