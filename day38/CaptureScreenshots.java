package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application");
		
		driver.manage().window().maximize();
		
		// 1) full/entire page screenshot
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE); // store the screenshot but don't know where being saved
		
		// path to save the screenshots
		File targetFile = new File(System.getProperty("user.dir") + "/screenshots/fullpage.png");

		sourceFile.renameTo(targetFile); // copy sourceFile to targetFile*/
		
		// 2) capture the screenshot of specific section
		/*WebElement payment = driver.findElement(By.xpath("//div[@id='payment']"));
		
		File sourceFile = payment.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "/screenshots/payment.png"); 
		
		sourceFile.renameTo(targetFile);*/
		
		// 3) capture the screenshot of web element
		WebElement logo = driver.findElement(By.xpath("//img[@class='navbar-logo-img navbar-logo-img-normal']"));
		
		File sourceFile = logo.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "/screenshots/logo.png"); 
		
		sourceFile.renameTo(targetFile);
	
		driver.close();
	
	}

}
