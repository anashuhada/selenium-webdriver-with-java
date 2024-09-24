package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com");
		
		driver.manage().window().maximize();
		
		// find total number of rows in a table
		int totalRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Total number of rows: " + totalRows); // 7
		
		// int totalRows = driver.findElements(By.tagName("tr")).size(); // valid for single table
		
		// find total number of columns in a table
		int totalCols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Total number of columns: " + totalCols); // 4
	
		// Read data from specific row and col - eg: 5th row and 1st column
		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("5th row and 1st column: " + bookName); // Master In Selenium
	
		String subName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[7]//td[3]")).getText();
		System.out.println("7th row and 3rd column: " + subName);
		
		// print table header
		System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price");
		
		// read data from all the rows and columns 
		/*for(int r = 2; r <= totalRows; r++) {
			for(int c = 1; c <= totalCols; c++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]")).getText();
				System.out.print(value + "\t");			
			}
			System.out.println();
		}*/
		
		// print book names written by author Mukesh
		/*for(int r = 2; r <= totalRows; r++) {
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]")).getText();
			// System.out.println(authorName);
			
			if(authorName.equals("Mukesh")) {
				String book = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]")).getText();
				System.out.println(book + "\t" + authorName);
			}
		
		}*/
		
		// find total price of all the books - price column
		int total = 0;
		
		for(int r = 2; r <= totalRows; r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[4]")).getText();
			total = total + Integer.parseInt(price);
			System.out.println(total);
		}
		
		driver.close();
		
	}

}
