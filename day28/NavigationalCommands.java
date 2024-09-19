package day28;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		
		// driver.get("https://demo.nopcommerce.com/"); - accepts URL only in String format
		
		// 1) navigate().to(url) - can pass String and form of URL Object
		// String format
		driver.navigate().to("https://demo.opencart.com");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Object format
		// URL myURL = new URL("https://demo.nopcommerce.com");
		// driver.navigate().to(myURL);
		
		// 2) navigate().back()
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		// 3) navigate().forward()
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		// 4) navigate().refresh()
		driver.navigate().refresh();
		
	}

}
