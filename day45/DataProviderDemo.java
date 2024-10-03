package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderDemo {

	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email, String password) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(status == true) {
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}

	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
	
	// indices={index1,index2,...}
	@DataProvider(name="dp", indices={0,3})
	// create test data and return the test data to test method
	Object[][] loginData() {
		
		Object data[][] = {
			{"abc@gmail.com", "test123"},
			{"xyz@gmail.com", "test012"},
			{"john@gmail.com", "test@123"},
			{"jordan.smith@yopmail.com", "P@ssw0rd@123"},
			{"johncanedy@gmail.com", "test"}			
		};
		
		return data;
		
	}
}
