package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		
		driver.manage().window().maximize();
		
		// login steps
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// clicking on PIM (navigation bar)
		driver.findElement(By.xpath("//a[normalize-space()='PIM']")).click();
		
		Thread.sleep(5000);
		
		// clicking on drop down
		
		// count number of options
		
		// printing options - use enhanced loop
		
		// to inspect: element -> event listeners -> remove blur option
		
		
	}

}
