package day38;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunTestIncognitoMode {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--incognito");
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
