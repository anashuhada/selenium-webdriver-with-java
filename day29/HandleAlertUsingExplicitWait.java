package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Handle alert without using switchTo().alert()
// Other method: using explicit wait
public class HandleAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10)); // explicit wait
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		
		Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent()); // condition alertIsPresent() returns true  
		System.out.println(myAlert.getText());		
		myAlert.accept();
	}

}
