package seleniumexamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;




public class HRMFogetPassword {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Shruthi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//String a=driver.getTitle();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']/p")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//button")).click(); //presses "cancel"
		//String b=driver.getTitle();
		String url = driver.getCurrentUrl();
		//Assert.assertEquals(a,b,"actual result and expected results are not matching");
		//Assert.assertEquals(url,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login","actual result and expected results are not matching");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("After assertion");

		
		

	}

}
