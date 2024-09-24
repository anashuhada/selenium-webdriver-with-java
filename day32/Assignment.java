package day32;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com");
		
		driver.manage().window().maximize();
		
		// select fromPort
		WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select fromDrop = new Select(fromPort);
		fromDrop.selectByVisibleText("Portland");
		
		// select toPort
		WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select toDrop = new Select(toPort);
		toDrop.selectByVisibleText("New York");
		
		// click button find flights
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		// total rows
		int totalRow = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		System.out.println("Total rows: " + totalRow);

		// total columns
		int totalCol = driver.findElements(By.xpath("//table[@class='table']//th")).size();
		System.out.println("Total columns: " + totalCol);
	
		// read data from rows and columns
		/*for(int r = 1; r <= totalRow; r++) {
			for(int c = 1; c <= totalCol; c++) {
				String rolCol = driver.findElement(By.xpath("//table[@class='table']//tr["+ r +"]//td[" + c + "]")).getText();
				System.out.println(rolCol);
			}
			
			Thread.sleep(5000);
		}*/
		
		// read column price only	
		for(int rowPrice = 1; rowPrice <= totalRow; rowPrice++) {
			String pr = driver.findElement(By.xpath("//table[@class='table']//tr[" + rowPrice + "]//td[6]")).getText();
			System.out.println(pr);
		}
	
	}

}
