package day27;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		// Fluent wait declaration - fixed syntax from documentation
		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		// withTimeout(Duration.ofSeconds(30)): max time 
		// pollingEvery(Duration.ofSeconds(5)): time interval 5, 5, 5, 5, 5, 5 to check the availability of the element
		// ignoring(NoSuchElementException.class): ignore the exception within the time interval
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();
		
		// use
		WebElement txtUsername = myWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@placeholder='Username']"));
			}
		});
		
		txtUsername.sendKeys("Admin");
		
	}

}
