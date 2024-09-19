package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepCommand {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();
		
		Thread.sleep(5000); // pause the execution within 5 seconds
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
	}

}
