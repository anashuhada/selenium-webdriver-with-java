package day47;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	WebDriver driver;
		
	// constructor - using PageFactory
	LoginPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // mandatory
	}
	
	// initElements initiates all the elements using driver
	
	// locators
	// @FindBy(xpath="//input[@placeholder='username']")
	@FindBy(how=How.XPATH, using="//input[@placeholder='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@placeholder='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(tagName="a")
	List<WebElement> links;
	
	// actions
	public void setUsername(String user) {
		txtUsername.sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		txtPassword.click();
	}

}
