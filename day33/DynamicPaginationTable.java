package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
		
		driver.manage().window().maximize();
		
		// driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demoadmin");
		WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear(); // to clear input box history
		username.sendKeys("demoadmin");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demopass");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		/* close window if it's available
		 if( driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
		 driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		 }
		 */
		
		// driver.findElement(By.xpath("//a[@class='parent']")).click();
		
		// driver.findElement(By.xpath("//ul[@id='collapse9']//a[contains(text(),'Customers')]")).click();
		
		// String s = "Showing 1 to 20 of 875 (44 Pages)";
		String text = driver.findElement(By.xpath("//div[contains(text(),'Pages'")).getText();
		int totalPages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1)); // 44
		
		// repeating pages 
		for(int p = 1; p <= totalPages; p++) {
			if(p > 1) {
				WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text(),=" + "p" + "]"));
				activePage.click();
				Thread.sleep(5000);
			}
			
			// reading data from the page
			int noRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			for(int r = 1; r <= noRows; r++) {
				String custName = driver.findElement(By.xpath("table[@class='table table-bordered table-hover']//tbody//tr[" + r +"]//td[2]")).getText();
				String email = driver.findElement(By.xpath("table[@class='table table-bordered table-hover']//tbody//tr[" + r +"]//td[3]")).getText();
				String status = driver.findElement(By.xpath("table[@class='table table-bordered table-hover']//tbody//tr[" + r +"]//td[5]")).getText();
				System.out.println(custName + "\t" + email + "\t" + status);
			}
		}

	}

}
