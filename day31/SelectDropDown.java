package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();
		
		WebElement dropCountry = driver.findElement(By.xpath("//select[@id='country']"));
		Select dpCountrySelect = new Select(dropCountry); // create Select class object
		
		// select option from the drop down
		// 1) selectByVisibleText() - inner text
		dpCountrySelect.selectByVisibleText("United Kingdom");
		
		// 2) selectByValue() - value is an attribute of an element
		dpCountrySelect.selectByValue("japan");
		
		// 3) selectByIndex() - have to count index manually
		dpCountrySelect.selectByIndex(5);
		
		// capture the options from the drop down
		List<WebElement> options = dpCountrySelect.getOptions();
		
		// total number of options
		System.out.println("Total number of options: " + options.size());
		
		// printing the options
		// normal for loop
		for(int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		
		// enhanced for loop
		for(WebElement op: options) {
			System.out.println(op.getText());
		}
		
		
	}

}
