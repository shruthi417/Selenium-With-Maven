package testngexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
import seleniumexamples.HRMFunctions;
public class TestNg {

	@Test()
	void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Shashank\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}	
	
	@Test()
	void forgot() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Shashank\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {}
		String ini=driver.getTitle();
		
		driver.findElement(By.xpath("//body//div//form[@class='oxd-form']//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);

		String s=driver.getTitle();
		Assert.assertEquals(ini,s,"OrangeHRM");
		
		
		
	}
	@Test()
	void leave() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Shruthi\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		HRMFunctions obj=new HRMFunctions();	
		
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
