package day42;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// open app
// test logo displayed
// login
// close

public class OrangeHRMTest {
	
	WebDriver driver;
	
  @Test(priority=1)
  void openApp() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com");
	  driver.manage().window().maximize();
  }
  
  @Test(priority=2)
  void testLogo() throws InterruptedException {
	  Thread.sleep(3000);
	  boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	  System.out.println("Logo is displayed: " + status);
  }
  
  @Test(priority=3)
  void testLogin() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  @Test(priority=4)
  void testLogout() {
	  driver.close();
  }
  
}
