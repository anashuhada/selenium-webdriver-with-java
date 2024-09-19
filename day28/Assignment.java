package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();
		
		// find input box and pass input
		WebElement searchInput = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		searchInput.sendKeys("Selenium");
		searchInput.sendKeys(Keys.ENTER);
		
		// count number of links appear
		List<WebElement> countLinks= driver.findElements(By.xpath("//a[contains(normalize-space(text()), 'Selenium')]"));
		System.out.println("Number of links: "+ countLinks.size());
		
		// click on each link using for each loop 
		for(WebElement link : countLinks) {
			// System.out.println(link.getText());
			link.click();
		}
		
		// get window ID's for every browser window
		 Set<String> windowIDs = driver.getWindowHandles();
		
		// close specific browser window
		 for(String winID : windowIDs) {
			 String title = driver.switchTo().window(winID).getTitle();
			  // System.out.println(title);
			 
			 // close window title Selenium dioxide - Wikipedia and Selenium - Wikipedia
			 if(title.equals("Selenium dioxide - Wikipedia") || title.equals("Selenium - Wikipedia")) {
				 System.out.println("Window " + title + " closed");
				 driver.close();
			 }
		 }
		
	}

}
