package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/#google_vignette");

		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		// getLocation() -> x and y axis (point)
		WebElement minSlider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		
		// min slider - increase the value of x axis
		System.out.println("Default min slider: " + minSlider.getLocation()); // (59, 289) - current location
		// System.out.println(minSlider.getLocation().getX());
		// System.out.println(minSlider.getLocation().getY());
		act.dragAndDropBy(minSlider, 100, 289).perform(); // 59 + 100 - x axis
		System.out.println("Min slider after moving: " + minSlider.getLocation());
	
		// max slider - decrease the value of x axis
		WebElement maxSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
		System.out.println("Default max slider: " + maxSlider.getLocation()); // (767, 289)
		act.dragAndDropBy(maxSlider, -67, 289).perform();  // (696, 250)
		System.out.println("Max slider after moving: " + maxSlider.getLocation());
		
	}

}
