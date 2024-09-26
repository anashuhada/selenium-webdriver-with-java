package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait
		
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		// drag and drop 1
		// source element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement rome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DHTMLgoodies_dragableElement5']")));
		
		// target element
		WebElement italy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='box106']")));

		// drag and drop action
		act.dragAndDrop(rome, italy).perform();
		
		// drag and drop 2
		// source
		WebElement washingston = driver.findElement(By.xpath("//div[@id='DHTMLgoodies_dragableElement2']"));
		
		// target
		WebElement usa = driver.findElement(By.xpath("//div[@id='box103']"));
		
		act.dragAndDrop(washingston, usa).perform();
		
	}

}
