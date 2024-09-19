package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocatorsAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoblaze.com");
		
		// tag#id
		driver.findElement(By.cssSelector("input#recipient-email"));
		
		// tag.classname
		driver.findElement(By.cssSelector("div.carousel-item"));
		
		// tag[attribute='value']
		driver.findElement(By.cssSelector("div[role='document'"));
		
		// tag.classname[attribute='value']
		driver.findElement(By.cssSelector("a.nav-link[id='signin2']"));
	}

}
