package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestKeyboardActions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://gotranscript.com/text-compare");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@placeholder='Paste one version of the text here.']")).sendKeys("Selenium"); 

		Actions act = new Actions(driver);
		
		// cmd + A
		act.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).perform();
		
		// cmd + C
		act.keyDown(Keys.COMMAND).sendKeys("C").keyUp(Keys.COMMAND).perform();
		
		// tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		// cmd + V
		act.keyDown(Keys.COMMAND).sendKeys("V").keyUp(Keys.COMMAND).perform();
	
	}

}
