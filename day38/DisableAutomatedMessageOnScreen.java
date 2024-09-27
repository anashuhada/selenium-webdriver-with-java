package day38;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Test Case
//1) Launch browser - Google Chrome
//2) Open URL https://demo.opencart.com/
//3) Validate title should be "Your Store"
//4) Close browser

public class DisableAutomatedMessageOnScreen {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
    	// remove "Chrome is being controlled by automated test software" 
    	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
    			
    	WebDriver driver = new ChromeDriver(options);
    	
    	driver.get("https://testautomationpractice.blogspot.com");
    	
    	String actualTitle = driver.getTitle();
    	
    	if(actualTitle.equals("Automation Testing Practice")) {
    		System.out.println("Test Passed");
    	}
    	else {
    		System.out.println("Test Failed");
    	}
    	
    	driver.close();

	}

}
