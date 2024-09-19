package day22;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
		
		// WebDriver -> interface
		// ChromeDriver -> class
		// This is the driver instance
		WebDriver driver = new ChromeDriver();
		
		// open the web app
		driver.get("https://demo.opencart.com/");
		
		// maximize the size of window
		driver.manage().window().maximize();
		
		// findElement().action();
		// use name as the locator
		driver.findElement(By.name("search")).sendKeys("Mac");

		// use id as the locator
		boolean logoDisplayStatus = driver.findElement(By.id("logo")).isDisplayed();
		System.out.println(logoDisplayStatus); // true
		
		// linkText (a href, otherwise it's inner text) 
		driver.findElement(By.linkText("Tablets")).click(); // preferred
	
		// partLinkText - only the partial of the actual link text 
		driver.findElement(By.partialLinkText("blets")).click(); // not recommended might be conflict because other might have the same text in the same page
	
		// TagName and Class - a group of elements/multiple elements
		// total number of links within the page/total images in the page
		// List allows duplicates
		
		// class name
		List<WebElement> headerLink = driver.findElements(By.className("list-inline-item"));
		
		// total number of elements
		System.out.println("Total number of elements: " + headerLink.size());
	
		// tag name
		List<WebElement> tagLink = driver.findElements(By.tagName("a"));
		System.out.println("Total number of elements: " + tagLink.size());
	
		// total number of images
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total number of images: "+ images.size());
	}

}
