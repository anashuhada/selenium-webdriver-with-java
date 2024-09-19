package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com");
		
		// maximize the browser window
		driver.manage().window().maximize();
		
		// tag and id: tag#id
		// driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts"); // also valid
		
		// tag and class: tag.classname
		// driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-shirts");
	
		// tag and attribute: tag[attribute="value"]
		driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirts");
	
		// tag, class and attribute: tag.classname[attribute="value"]
		driver.findElement(By.cssSelector("input.search-box-text[name='q'")).sendKeys("T-shirts");
	}

}
