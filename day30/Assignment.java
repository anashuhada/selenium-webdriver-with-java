package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		// wait method - implicit
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames");
		
		driver.manage().window().maximize();
		
		// create web element
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		
		// switch to frame 5
		driver.switchTo().frame(frame5);
		
		// interact with element
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("This is frame 5");
		
		// click the hyperlink in inner frame 5
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		
		// get out from the frame to go to the page
		// driver.switchTo().defaultContent();
				
		// inner frame from the hyperlink
		// driver.switchTo().frame(0);
		// System.out.println("Successfully entered inner frame");
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='UI Vision by a9t9 software - Image-Driven Automation']"));
		System.out.println("Logo status displayed: " + logo.isDisplayed());
		
		driver.switchTo().defaultContent();

	}

}
