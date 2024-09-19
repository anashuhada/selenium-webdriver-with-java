package day22;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoblaze.com/index.html");
		
		driver.manage().window().maximize();
		
		// total number of links
		List<WebElement> links = driver.findElements(By.className("nav-link"));
		System.out.println("Total number of links: " + links.size());
		
		// total number of images
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total number of images: " + images.size());
		
		// click on any product link using linkText
		driver.findElement(By.linkText("Nexus 6")).click();
	}

}
