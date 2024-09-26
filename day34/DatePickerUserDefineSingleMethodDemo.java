package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerUserDefineSingleMethodDemo {
	
	// select upcoming date
	static void selectUpcomingDate(WebDriver driver, String year, String month, String date) {
		// select month and year
		while(true) { // always true
			// conditions
			String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); // actual month
			String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); // actual year
				
			// if internal condition true
			if(currMonth.equals(month) && currYear.equals(year)) {
				break; // stop 
			}
					
			// if internal condition false, keep clicking next button until true
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next triangle button
			// Thread.sleep(3000);
			}
		
		// select the date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		for(WebElement dt : allDates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
					
	}
	
	// select previous date
	static void selectPreviousDate(WebDriver driver, String year, String month, String date) {
		// select month and year
		while(true) { // always true
			// conditions
			String currMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); // actual month
			String currYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); // actual year
				
			// if internal condition true
			if(currMonth.equals(month) && currYear.equals(year)) {
				break; // stop 
			}
					
			// if internal condition false, keep clicking next button until true
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // prev triangle button
			// Thread.sleep(3000);
			}
		
		// select the date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		for(WebElement dt : allDates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
					
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker");
		
		driver.manage().window().maximize();
		
		// switch to frame
		driver.switchTo().frame(0);
		
		// method 1 using sendKeys()
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("09/25/2024"); // mm/dd/yyyy
		
		// method 2 using date picker 
				
		// open date picker box
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
				
		// selectUpcomingDate(driver, "2025", "March", "11");
		selectPreviousDate(driver, "2023", "March", "11");
		
	}

}
