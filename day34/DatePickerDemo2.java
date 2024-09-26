package day34;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerDemo2 {
	
	// user defined method for converting month from String -> Month object
	static Month convertMonth(String month) {
		// <String (key), Month (value)>
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		// extract the month
		Month vMonth = monthMap.get(month);
		
		if(vMonth == null) {
			System.out.println("Invalid Month...");
		}
		
		return vMonth;
	}
	
	static void selectDatePicker(WebDriver driver, String reqYear, String reqMonth, String reqDate) {
		
		// select year
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-year']")));
		Select selectYear = new Select(yearDropDown);
		selectYear.selectByVisibleText(reqYear);
				
		// select month
		while(true) {
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				
			// convert reqMonth and displayMonth into Month Object
			Month expectedMonth = convertMonth(reqMonth);
			Month currentMonth = convertMonth(displayMonth);
					
			// compare months 
			int result = expectedMonth.compareTo(currentMonth);
					
			// returns 0 - months are equal
			// > 0 - future month
			// < 0 - previous month
					
			if(result < 0) {
				// previous month
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
					
			else if(result > 0) {
				// future month
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
					
			// equal
			else {
				break;
			}
				
		}
				
		// select date
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> allDates = wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a")));
				
		for(WebElement dt : allDates) {
			if(dt.getText().equals(reqDate)) {
				dt.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();
		
		// input DOB
		String reqYear = "2021";
		String reqMonth = "June";
		String reqDate = "15";

		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		// System.out.print("Clicked");
		
		selectDatePicker(driver, reqYear, reqMonth, reqDate);
	
	}

}
