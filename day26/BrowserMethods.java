package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000); // throws InterruptedException
		
		// getWindowHandles() – returns ID’s of the multiple browser windows
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();	// this will open new browser window	
		// Set<String> windowIDs = driver.getWindowHandles();	
		// System.out.println(windowIDs);
		
		Thread.sleep(5000); // throws InterruptedException
		
		// driver.close(); // it will close the first window
		driver.quit(); // it will close the both windows
	}

}
