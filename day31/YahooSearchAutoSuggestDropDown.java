package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearchAutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://malaysia.yahoo.com");

		driver.manage().window().maximize();
		
		// pass keyword
		driver.findElement(By.xpath("//input[@name='p']")).sendKeys("coffee");
		
		Thread.sleep(5000);
		
		// count total number of list
		List<WebElement> searches = driver.findElements(By.xpath("//ul[@role='listbox' and @id='_yb_sa-listbox']//li"));
		System.out.println("Total searches: "+ searches.size());
		
		// choose coffee bean and click
		/*for(int i = 0; i < searches.size(); i++) {
			System.out.println(searches.get(i).getText());
			
			String op = searches.get(i).getText();
			
			if(op.equals("coffee bean")) {
				searches.get(i).click();
				break;
			}
			
		}*/
		
		for(WebElement s: searches) {
			if(s.getText().equals("coffee prince")) {
				s.click();
				break;
			}
		}
		
	}

}
