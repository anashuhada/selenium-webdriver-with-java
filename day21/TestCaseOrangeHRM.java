package day21;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseOrangeHRM {

	public static void main(String[] args) {
		
		// 1) Launch browser - Google Chrome
		WebDriver driver = new ChromeDriver();
		
		// 2) Open URL https://opensource-demo.orangehrmlive.com/
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		// 3) Validate title should be OrangeHRM
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals("OrangeHRM")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		// 4) Close browser
		driver.close();
	}

}
