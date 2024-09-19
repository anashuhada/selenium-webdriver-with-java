package day26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.manage().window().maximize();
		
		// isDisplayed()
		WebElement elementDisplayed = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")); // valid
		System.out.println("Display status of logo: " + elementDisplayed.isDisplayed());
		
		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed(); // valid
		System.out.println("Display status of logo: " + status);
		
		// isEnabled() - input box, drop down, radio button, check box; enable means allow providing data
		boolean statusEnabled = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("Enable status: " + statusEnabled);
		
		// isSelected()
		WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selection...");
		System.out.println(maleRadioBtn.isSelected()); // false
		System.out.println(femaleRadioBtn.isSelected()); // false
		
		System.out.println("After selecting male radio button...");
		maleRadioBtn.click();
		System.out.println(maleRadioBtn.isSelected()); // true
		System.out.println(femaleRadioBtn.isSelected()); // false
		
		// check box
		boolean newsletterCheck = driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println("Newsletter check box status: " + newsletterCheck);
	}

}
