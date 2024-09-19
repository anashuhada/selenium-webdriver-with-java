package day28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// parent window
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();
		
		// child window
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		for(String winID : windowIDs) {
			// can use url as well
			// String url = driver.switchTo().window(winID).getCurrentUrl();
			String title = driver.switchTo().window(winID).getTitle();
			System.out.println(title);
			
			// if multiple windows (title.equals("OrangeHRM") || title.equals("other window"))
			if(title.equals("OrangeHRM")) {
				driver.close();
			}
		}

	}

}
