package day46;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners(day46.MyListener.class)

public class SauceDemo {

WebDriver driver;
	
	@BeforeClass
	void setup() throws InterruptedException {
		driver = new ChromeDriver(); 		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test(priority=1) 
	void testLogo() throws InterruptedException {
		boolean logo = driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();
		Assert.assertEquals(logo, true);
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	void testURL() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/");
	}
	
	@Test(priority=3, dependsOnMethods={"testURL"})
	void testTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@AfterMethod
	@AfterClass
	void tearDown() {
		driver.quit();  
	}
	
}
