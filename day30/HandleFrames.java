package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		driver.manage().window().maximize();
		
		// frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		
		// switchTo.frame(WebElement)
		driver.switchTo().frame(frame1); // passed frame as a WebElement -> switch to frame1
		
		// interact with the element in the web page
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
	
		// go back to the page because we cannot directly switch to another frame, then after go back to the page, we can switch to another frame
		driver.switchTo().defaultContent();
		
		// frame 2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2); // there's id/name just directly pass it, no need to create WebElement
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");
	
		driver.switchTo().defaultContent(); // comes out from the frame (section) -> go back to the page 
		
		// frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		
		// interact with the element
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");
	
		// inner iframe - part of frame 3; has only one frame in inner iframe
		driver.switchTo().frame(0); // switching to frame using index
		
		// driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();	
		WebElement rdBtn = driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", rdBtn);
		
		driver.switchTo().defaultContent();
	
	}

}
