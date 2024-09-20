package day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");	
		
		driver.manage().window().maximize();
		
		// 1) select one single specific check box
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		// 2) select all the check boxes
		// capture all the check boxes only
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		// normal loop
		for(int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		
		// enhanced loop
		for(WebElement ch: checkboxes) {
			ch.click();
		}
		
		// 3) select last 3 check boxes
		// total check boxes - specific number of check boxes needed
		// total = 7, specific = only 3, 7 - 3 = 4, so 4 is the starting index
		// can only use with normal loop
		for(int i = 4; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		
		// 4) select first 3 check boxes
		for(int i = 0; i < 3; i++) {
			checkboxes.get(i).click();
		}
		
		// 5) unselect check boxes if they are selected
		for(int i = 0; i < 3; i++) {
			// System.out.println(checkboxes.get(i).getAttribute("value"));
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		
		for(int i = 0; i < checkboxes.size(); i++) {
			if(checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
		}
	}

}
