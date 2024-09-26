package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {
		
	WebDriver driver = new ChromeDriver();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	driver.get("https://text-compare.com");

	driver.manage().window().maximize();
		
	Actions act = new Actions(driver);
	
	// enter input
	driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");
	
	// ctrl + A - select the whole text
	// keyDown press the key
	// keyUp release the key
	act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
	
	// ctrl + C - copy the text
	act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
	
	// tab - shift to the next box
	act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	
	// ctrl + V - paste the text
	act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
	
	}

}
