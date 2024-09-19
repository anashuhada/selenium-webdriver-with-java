package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com");
		
		driver.manage().window().maximize();
		
		// XPath with single attribute
		// driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Mac");
				
		// XPath with multiple attributes
		// driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("Mac");
		
		// XPath with and operator
		// driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("Mac");
		
		// XPath with or operator
		// driver.findElement(By.xpath("//input[@name='search' or @placeholder='Search']")).sendKeys("Mac");
		
		// XPath with text()
		// driver.findElement(By.xpath("//a[text()='MacBook']")).click();
		// boolean featuredIsDisplayed = driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		// System.out.println(featuredIsDisplayed);
		
		// String valueText = driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		// System.out.println(valueText);
		
		// XPath with contains() - suitable with dynamic elements
		// driver.findElement(By.xpath("//input[contains(@placeholder, 'Sea')]")).sendKeys("Mac");
		
		// XPath with starts-with() - follow the sequence of the string
		// driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]")).sendKeys("Mac");
		
		// Chained XPath
		boolean chainedXPath= driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(chainedXPath);
		System.out.println("PASSED");
	}

}
