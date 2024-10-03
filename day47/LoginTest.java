package day47;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test
	void testLogin() {
		
		// create object of LoginPage class
		LoginPage2 lp = new LoginPage2(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.clickLogin();
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@AfterMethod
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
	
}
