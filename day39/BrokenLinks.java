package day39;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1) Check link has href="https://xyz.com" in attribute
2) Hit https://xyz.com -> server -> get status code
3) Status code >= 400 is broken link, < 400 is not a broken link
*/

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
	
		System.out.println("Total number of links: " + links.size()); // 48
		
		int noOfBrokenLinks = 0;
		
		for(WebElement linkElement: links) {
			String hrefAttValue = linkElement.getAttribute("href");
			
			// check link has attribute href 
			try {
				if(hrefAttValue == null || hrefAttValue.isEmpty()) {
					System.out.println("href attribute is null and empty - impossible to check");
					continue; // skip to another link 
							  // url should be executed when this condition is true
							  // if not match the url should not be executed 
							  // just to keep the current value
				}
				
			// hit url to the server 
			URL linkURL = new URL(hrefAttValue); // convert href value from string to url class object
			HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); // open connection to server
			conn.connect(); // connect to server and send request to the server
			
			if(conn.getResponseCode() >= 400) {
				System.out.println(hrefAttValue + " broken link");
				noOfBrokenLinks++;
			}
			else {
				System.out.println(hrefAttValue + " not a broken link");
			}
			}
			catch(Exception e) {	
			}
		
		}
		
		System.out.println("Number of broken links: " + noOfBrokenLinks); // 42
		
	}

}
