package seleniumexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookSignUpAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Shruthi\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525805640%7Cb%7Cnew%20facebook%20account%7C&placement=&creative=550525805640&keyword=new%20facebook%20account&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696221432%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-11078544207%26loc_physical_ms%3D20453%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjwpqCZBhAbEiwAa7pXeV6jjsK2bsjfDFErZiWJ7fgfysNcNI9NrUk2IbfOD-4YohTdCpPz2hoCp2kQAvD_BwE");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("DEF");
		driver.findElement(By.name("reg_email__")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("abc123");
		driver.findElement(By.id("day")).sendKeys("10");
		driver.findElement(By.id("month")).sendKeys("Jun");
		driver.findElement(By.id("year")).sendKeys("2000");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/label")).click();
		driver.findElement(By.name("websubmit")).click();
		
	}

}
