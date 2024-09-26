package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		
		driver.manage().window().maximize();
		
		// switch to frame
		driver.switchTo().frame("iframeResult");
		
		WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
		box1.clear();
		box1.sendKeys("Welcome");
		
		WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement btn = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		// double click action on the button
		Actions act = new Actions(driver);
		act.doubleClick(btn).perform();
		
		// validation - box2 should be the same as box1
		String text = box2.getAttribute("value"); // because no inner text
		System.out.println(text);
		
		if(text.equals("Welcome")) {
			System.out.println("Text copied");
		}
		else {
			System.out.println("Text not copied properly");
		}
		
	}

}
