package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://en.wikipedia.org/wiki/List_of_national_flags_of_sovereign_states");

		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// 1) scroll down page by pixel number
		js.executeScript("window.scrollBy(0,3000)", "");
		// 3000
		System.out.println(js.executeScript("return window.pageYOffset", "")); // capture the pixel when scrolling down
		
		// 2) scroll down the page till element is visible
		WebElement bahrain = driver.findElement(By.xpath("//a[@href='/wiki/Flag_of_Bahrain'][normalize-space()='Bahrain']"));
		js.executeScript("arguments[0].scrollIntoView()", bahrain);
		bahrain.click();
		// 5351
		System.out.println(js.executeScript("return window.pageYOffset", "")); // capture the pixel when scrolling down

		// 3) scroll down page till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		// 87311
		System.out.println(js.executeScript("return window.pageYOffset", "")); // capture the pixel when scrolling down
	
		// 4) scrolling up to initial position 
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset", "")); // capture the pixel when scrolling down
		
	}

}
