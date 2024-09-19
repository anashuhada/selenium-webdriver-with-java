package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		// get(url)
		driver.get("https://testautomationpractice.blogspot.com");
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		
		// getTitle()
		System.out.println(driver.getTitle());
		
		// getCurrentUrl()
		System.out.println(driver.getCurrentUrl());
		
		// getPageSource()
		System.out.println(driver.getPageSource());
		
		// getWindowHandle()
		System.out.println("Window ID: "+ driver.getWindowHandle());
		
		// getWindowHandles()
		// 1) make auto click for second window
		// driver.findElement(By.linkText("merrymoonmary")).click();
		
		// 2) getWindowHandles() will return multiple window IDs, must use Set<String>
		// Set<String> window = driver.getWindowHandles();
		// System.out.println(window);
		
		// isDisplayed
		// 1) logo
		boolean logoDisplayed = driver.findElement(By.xpath("//img[@class='wikipedia-icon']")).isDisplayed();
		System.out.println("Logo status is diplayed: " + logoDisplayed);
		
		// 2) text
		boolean textDisplayed = driver.findElement(By.xpath("//h2[normalize-space()='Drag and Drop']")).isDisplayed();	
		System.out.println("Drag and Drop status is displayed: " + textDisplayed);
		
		// isEnabled
		// 1) input box 
		boolean inputEnabled = driver.findElement(By.xpath("//input[@id='name']")).isEnabled();
		System.out.println("Input box is enabled: " + inputEnabled);
		
		// 2) slider
		boolean sliderEnabled = driver.findElement(By.xpath("//div[@id='slider']")).isEnabled();
		System.out.println("Slider is enabled: " + sliderEnabled);
		
		// isSelected
		// 1) radio button
		// use WebElement if need to use the variable multiple times, boolean for one-time check
		WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@id='male']"));
		WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@id='female']"));
		
		System.out.println("Before selecting radio button...");
		System.out.println("Radio button is selected: " + maleRadioBtn.isSelected()); // false
		System.out.println("Radio button is selected: " + femaleRadioBtn.isSelected()); // false
		
		System.out.println("After selecting female radio button...");
		femaleRadioBtn.click(); // auto-click
		System.out.println("Radio button is selected: " + maleRadioBtn.isSelected()); // false
		System.out.println("Radio button is selected: " + femaleRadioBtn.isSelected()); // true
		
		// 2) check box
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='monday']"));	
		WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='tuesday']"));
		WebElement checkBox3 = driver.findElement(By.xpath("//input[@id='wednesday']"));
		
		System.out.println("Before selecting any check boxes...");
		System.out.println(checkBox1.isSelected()); // false
		System.out.println(checkBox2.isSelected()); // false
		System.out.println(checkBox3.isSelected()); // false
		
		System.out.println("After selecting checkBox1 and checkBox3...");
		checkBox1.click();
		checkBox3.click();
		System.out.println(checkBox1.isSelected()); // true
		System.out.println(checkBox2.isSelected()); // false
		System.out.println(checkBox3.isSelected()); // true
		
		// 3) drop down list
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
		System.out.println("Before selecting any drop down...");
		System.out.println(dropDown.isSelected());
		
		// 1) create Select object
		// 2) pass value by using selectByVisibleText("")
		// 3) getFirstSelectedOption()
		// 4) finally getText()
		
		// create Select object to interact with the drop down
		Select selectCountry = new Select(dropDown);
		
		// after selecting
		// select option using selectByVisibleText("") / selectByValue("") / selectByIndex[]
		selectCountry.selectByVisibleText("United Kingdom");
		
		// select getFirstSelectedOption() -> getText()
		WebElement selectedOption = selectCountry.getFirstSelectedOption();
		System.out.println("After selecting a country...");
		System.out.println("The country selected is: " + selectedOption.getText());
	
		// driver.close();
		
		driver.findElement(By.linkText("merrymoonmary")).click();
		
		Thread.sleep(5000);
		driver.quit();	
	}

}
