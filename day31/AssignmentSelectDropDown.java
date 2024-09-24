package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentSelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states");
		
		driver.manage().window().maximize();
		
		WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country' and @id='country-list']"));
		
		Select selectCountry = new Select(countryDropDown);
		
		// capture the options from the drop down
		List<WebElement> countryOptions = selectCountry.getOptions();
		
		// count total number of options in country drop down list
		System.out.println("Total number of options: "+ countryOptions.size());
		
		// print all the options
		// normal for loop
		for(int i = 1; i < countryOptions.size(); i++) {
			System.out.println(countryOptions.get(i).getText()); // all countries
			
			if(countryOptions.get(i).getText().equals("USA")) {
				selectCountry.selectByIndex(i);
				System.out.println(countryOptions.get(i).getText());
				countryOptions.get(i).click();
			}
			
		}
		
		// enchanced for loop
		for(WebElement op : countryOptions) {
			System.out.println(op.getText());
			
			if(op.getText().equals("India")) {
				selectCountry.selectByValue("4");
				op.click();
			}
		}
		
	}

}
