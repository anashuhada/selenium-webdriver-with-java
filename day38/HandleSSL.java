package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		// accept SSL cert
		options.setAcceptInsecureCerts(true); // asking for accept insecure certs
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println("Title of the page: " + driver.getTitle());
		
	}

}
