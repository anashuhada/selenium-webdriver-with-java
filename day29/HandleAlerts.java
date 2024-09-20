package day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.manage().window().maximize();
		
		// 1) normal alert with single button - OK button
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	
		Thread.sleep(5000);
		
		// need to switchTo alert window, then accept (OK button) to close the alert 
		// driver.switchTo().alert().accept(); // for single operation
		// need to store in var if multiple operation 
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());		
		myAlert.accept();
		
		// 2) confirmation alert - OK and cancel button
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		
		Thread.sleep(5000);
		
		// close alert using OK button
		driver.switchTo().alert().accept();
		
		// close alert using Cancel button
		driver.switchTo().alert().dismiss();
		
		// 3) prompt alert - input box
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		
		Thread.sleep(5000);
		
		Alert myAlert2 = driver.switchTo().alert();
		myAlert2.sendKeys("Welcome");
		myAlert2.accept();
	}

}
