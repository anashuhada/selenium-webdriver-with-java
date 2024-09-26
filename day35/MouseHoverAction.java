package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com");
		
		driver.manage().window().maximize();
		
		WebElement desktops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

		Actions act = new Actions(driver);
		
		// mouse hover action - moveToElement(element)
		act.moveToElement(desktops).moveToElement(mac).click().build().perform();
		act.moveToElement(desktops).moveToElement(mac).click().perform(); // even without build(), perform() can create an action implicitly
																		  // build() is an option
		// build() - create an action
		// perform() - complete an action
	}

}
