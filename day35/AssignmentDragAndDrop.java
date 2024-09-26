package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentDragAndDrop {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		// Debit Side
		WebElement bankSource = driver.findElement(By.xpath("//a[normalize-space()='BANK']")); // source
		WebElement bankTarget = driver.findElement(By.xpath("//ol[@id='bank']")); // target
		act.dragAndDrop(bankSource, bankTarget).perform();
		
		WebElement amountSource = driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]")); // source
		WebElement amountTarget = driver.findElement(By.xpath("//ol[@id='amt7']")); // target
		act.dragAndDrop(amountSource, amountTarget).perform();
		
		// Credit Side
		WebElement salesSource = driver.findElement(By.xpath("//a[normalize-space()='SALES']")); // source
		WebElement salesTarget = driver.findElement(By.xpath("//ol[@id='loan']")); // target
		act.dragAndDrop(salesSource, salesTarget).perform();
		
		WebElement priceSales = driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]")); // source
		WebElement amountSales = driver.findElement(By.xpath("//ol[@id='amt8']")); // target
		act.dragAndDrop(priceSales, amountSales).perform();
	}
}
