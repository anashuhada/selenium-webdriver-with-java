package day26;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		// get() - opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000); // throws InterruptedException
		
		// getTitle() - returns title of the page
		System.out.println(driver.getTitle()); // OrangeHRM
		
		// getCurrentUrl() – returns url of the page
		System.out.println(driver.getCurrentUrl()); // https://opensource-demo.orangehrmlive.com/web/index.php/auth/login		
		
		// getPageSource() – returns source code of the page
		System.out.println(driver.getPageSource());
		
		// getWindowHandle() – returns ID of the single browser window
		String windowID = driver.getWindowHandle();		
		System.out.println("Window ID: " + windowID);
		
		// getWindowHandles() – returns ID’s of the multiple browser windows
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();	// this will open new browser window	
		Set<String> windowIDs = driver.getWindowHandles();	
		System.out.println(windowIDs);
		
		// driver.close() - close one browser
		// driver.quit() - close multiple browsers
		
	}

}
