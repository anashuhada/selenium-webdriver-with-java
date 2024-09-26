package day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com");

		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);

		WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		// control registerLink
		act.keyDown(Keys.CONTROL).click(registerLink).keyUp(Keys.CONTROL).perform();
	
		// switch to registration page
		/*Set<String> id = driver.getWindowHandles(); // Get window handles as a Set
		ArrayList<String> windowList = new ArrayList<>(id); // Convert Set to ArrayList*/
		List<String> id = new ArrayList(driver.getWindowHandles());
		
		// Registration 
		driver.switchTo().window(id.get(1)); // switch to child/second window
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Zareen Ayla");
	
		// Home page
		driver.switchTo().window(id.get(0)); // switch to parent/home page window
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Tshirts");
		
	}

}
