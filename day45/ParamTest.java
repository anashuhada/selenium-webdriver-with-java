package day45;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParamTest {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	void setup(String br, String url) {
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		// case "edge" : driver = new EdgeDriver(); break;
		// case "safari" : driver = new SafariDriver(); break;
		default : System.out.println("Invalid browser"); return; // return will exit from the entire code
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1) 
	void testLogo() throws InterruptedException {
		boolean logo = driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();
		Assert.assertEquals(logo, true);
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	void testTitle() throws InterruptedException {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(priority=3)
	void testURL() throws InterruptedException {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/v1/");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();  
	}

}
