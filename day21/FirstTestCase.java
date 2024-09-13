package day21;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//Test Case
//1) Launch browser - Google Chrome
//2) Open URL https://demo.opencart.com/
//3) Validate title should be "Your Store"
//4) Close browser

public class FirstTestCase {

	public static void main(String[] args) {
		
		// 1) Launch browser
    	// ChromeDriver driver = new ChromeDriver(); // ChromeDriver object to launch the browser
    	// WebDriver - parent, ChromeDriver - child
    	// child stores object in parent -> upcasting
    	WebDriver driver = new ChromeDriver();
    	
    	// 2) Open URL
    	driver.get("https://demo.opencart.com/");
    	
    	// 3) Validate title should be "Your Store" - expected result purpose
    	String actualTitle = driver.getTitle();
    	
    	if(actualTitle.equals("Your Store")) {
    		System.out.println("Test Passed");
    	}
    	else {
    		System.out.println("Test Failed");
    	}
    	
    	// 4) Close browser
    	driver.close();
    	// driver.quit();

	}

}
