package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentDoubleClickAndDragAndDrop {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();
		
		// Actions class object
		Actions act = new Actions(driver);
		
		// double click
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Selenium");
		
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		String field2Text = field2.getAttribute("type"); // must use getAttribute() because there's inner text
		System.out.println(field2Text);
		
		// perform double click
		act.doubleClick(button).build().perform();	
		
		// drag and drop
		// source 
		WebElement sourceDrag = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		// target 
		WebElement targetDrop = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		act.dragAndDrop(sourceDrag, targetDrop).perform();
		
	}

}
