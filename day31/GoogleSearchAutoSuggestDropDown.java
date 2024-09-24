package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchAutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		// Search input box
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		Thread.sleep(5000);
		
		List<WebElement> listSearch = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
	
		System.out.println("Total searches: " + listSearch.size());
	
		/*for(int i = 0; i < listSearch.size(); i++) {
			String txt = listSearch.get(i).getText();
			System.out.println(txt);
			
			if(txt.equals("selenium ide")) {
				listSearch.get(i).click();
				break;
			}
		}*/
		
		for(WebElement list : listSearch) {
			
			String txt = list.getText();
			
			if(txt.equals("selenium ide")) {
				list.click();
				break;
			}
		}
	
	
	
	}

}
