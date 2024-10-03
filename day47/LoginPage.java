package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	// constructor will find a element method to initiate the webdriver
	LoginPage(WebDriver driver) {
		this.driver = driver; 
	}
	
	// locators for all the elements
	By txtUsernameLoc = By.xpath("//input[@placeholder='username']");
	By txtPasswordLoc = By.xpath("//input[@placeholder='password']");
	By btnLoginLoc = By.xpath("//button[@type='submit']");
	
	// action methods
	public void setUsername(String user) {
		driver.findElement(txtUsernameLoc).sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(txtPasswordLoc).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(btnLoginLoc).click();
	}
	

}
