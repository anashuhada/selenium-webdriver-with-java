package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.manage().window().maximize();
		
		// open drop down options
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); 
		
		// select single option 
		// driver.findElement(By.xpath("//input[@value='Java']")).click();

		// capture all the options and find out size
		// //ul//label = //ul[contains(@class, 'multiselect-container dropdown-menu')]//label
	
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container dropdown-menu')]//label"));
		System.out.println("Number of options: " + options.size());
		
		// printing options
		// normal loop
		/*for(int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}*/
	
		// enhanced for loop
		for(WebElement op : options) {
			System.out.println(op.getText());
		}
		
		// select multiple options
		for(WebElement op : options) {
			
			String option = op.getText();
			
			/*if(op.getText().equals("Java") || op.getText().equals("Python") || op.getText().equals("MySQL")) {
				
			}*/
			
			if(option.equals("Java") || option.equals("Python") || option.equals("MySQL")) {
				op.click();
			}
		}
		
	}

}
