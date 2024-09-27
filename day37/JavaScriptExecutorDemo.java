package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
		// driver is an object of ChromeDriver class
		WebDriver driver = new ChromeDriver();
		// ChromeDriver driver = new ChromeDriver();
		// JavascriptExecutor js = driver;
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();

		WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
	
		// upcasting
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// passing the text into inputBox - alternate of sendKeys()
		js.executeScript("arguments[0].setAttribute('value', 'Johnny')", inputBox);
	
		WebElement radioBtn = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radioBtn);
		
	}

}
