package day39;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMElementsAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		driver.manage().window().maximize();
		
		// shadow element
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot(); 
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#shadow-element")); // look for the element
		
		// nested shadow element
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		shadow1.findElement(By.cssSelector("#nested-shadow-element"));
		
		// multi-nested shadow element
		SearchContext shadow2 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow3 = shadow2.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow4 = shadow3.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		shadow4.findElement(By.cssSelector("#multi-nested-shadow-element"));
		
	}

}
