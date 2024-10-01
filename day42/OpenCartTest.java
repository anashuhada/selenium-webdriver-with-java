package day42;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OpenCartTest {
	
	WebDriver driver;
	
	@Test(priority=1)
	void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	void logoStatus() throws InterruptedException {
		Thread.sleep(3000);
		boolean logo = driver.findElement(By.xpath("//img[@title='Your Store']")).isDisplayed();
		System.out.println("Logo status: " + logo);
	}
	
	@Test(priority=3)
	void searchProduct() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Mac");
		driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']")).click();
	}
	
	@Test(priority=4)
	void clickProduct() throws InterruptedException {
	    List<WebElement> countProduct = driver.findElements(By.xpath("//div[@class='description']//a"));
	    // System.out.println("Number of products: " + countProduct.size());
	    
	    for(WebElement cP : countProduct) {
	        //WebElement product = driver.findElements(By.xpath("//div[@class='description']//a")).get(i);
	        String text = cP.getText();
	        
	        if(text.equals("iMac")) {
	            
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.elementToBeClickable(cP));
	            
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", cP);
	            
	            System.out.println("iMac clicked!");
	            
	            // Thread.sleep(3000); 
	            break;
	        }
	    }
	}
	
	@Test(priority=5)
	void closeApp() {
		driver.close();
	}
}
