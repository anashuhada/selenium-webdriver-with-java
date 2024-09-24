package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentMultiDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();

		// open the drop down field
		// driver.findElement(By.xpath("//select[@id='colors']")).click();
		
		// count total number of options
		List<WebElement> total = driver.findElements(By.xpath("//select[@id='colors']//option"));
		System.out.println("Total number of options: "+ total.size());
		
		// print all the options
		for(int i = 0; i < total.size(); i++) {
			System.out.println(total.get(i).getText());
			
			String op = total.get(i).getText();
			
			if(op.equals("Blue") || op.equals("White")) {
				total.get(i).click();
			}
			
		}
		
	}

}
