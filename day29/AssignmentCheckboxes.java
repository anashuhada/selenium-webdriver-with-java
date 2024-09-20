package day29;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();
		
		// select one check box
		driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).click();

		// select all check boxes - must look for the same attributes
		/*List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		
		for(int i = 1; i < rows.size(); i++) {
			// construct the XPath as same as the web page
			String xPath = "//tbody/tr" + "[" + i + "]" + "/td[4]/input[1]";
			System.out.println(xPath);
		}*/
				
		for(int i = 1; i <= 5; i++) {
			// construct the XPath as same as the web page
			String xPath = "//tbody/tr" + "[" + i + "]" + "/td[4]/input[1]";
			// System.out.println(xPath);
			
			// pass into findElement
			WebElement checkbox = driver.findElement(By.xpath(xPath));
			checkbox.click();
		}
			
		// select first 2 check boxes
		for(int i = 1; i <= 2; i++) {
		// construct the XPath as same as the web page
		String xPath = "//tbody/tr" + "[" + i + "]" + "/td[4]/input[1]";
		
		// pass into findElement
		WebElement checkbox = driver.findElement(By.xpath(xPath));
		checkbox.click();
		}
		
		// unselect check boxes if they are selected
		// create checkboxes var into ArrayList() so that can add the index of check box
		List<WebElement> checkboxes = new ArrayList<>(); // convert WebElement to List so that can get the index
														 // because WebElement only for single value
														 // List<WebElement> checkboxes = new ArrayList<>();
														 // is used to create a list that will hold multiple WebElement objects
		for(int i = 1; i <= 5; i++) {
			// construct the XPath as same as the web page
			String xPath = "//tbody/tr" + "[" + i + "]" + "/td[4]/input[1]";
			
			// pass into findElement
			WebElement checkbox = driver.findElement(By.xpath(xPath));
			checkbox.click();
			checkboxes.add(checkbox);
		}
		
		Thread.sleep(5000);
		
		/*for(int i = 0; i < checkboxes.size(); i++) {
			if(checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
		}*/
		
		for(WebElement ch: checkboxes) {
			if(ch.isSelected()) {
				ch.click();
			}
		}
	}

}
