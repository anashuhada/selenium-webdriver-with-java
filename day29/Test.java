package day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();
		
		// 1) select one single specific check box
		driver.findElement(By.xpath("//tbody/tr//input[@type='checkbox']")).click();
		
		// 2) select all the check boxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//tbody/tr//input[@type='checkbox']"));
		
		for(int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		
		for(WebElement ch : checkboxes) {
			ch.click();
		}
		
		// 3) select last 3 check boxes
		int totalCheckboxes = checkboxes.size();
		
		for(int i = totalCheckboxes - 3; i < totalCheckboxes; i++) {
			checkboxes.get(i).click();
		}
		
		// 4) select first 3 check boxes
		for(int i = 0; i < 3; i++) {
			System.out.println(checkboxes.get(i).getAttribute("value"));
			checkboxes.get(i).click();
		}
		
		// 5) unselect check boxes if they are selected
		for(int i = 0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		
		for(WebElement ch : checkboxes) {
			if(ch.isSelected()) {
				ch.click(); // un-click
			}
		}
		
	}

}
