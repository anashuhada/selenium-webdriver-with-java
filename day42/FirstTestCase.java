package day42;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

// 1) open app
// 2) login
// 3) logout

public class FirstTestCase {

	@Test(priority = 1) 
	void openApp()
	{
		System.out.println("Opening application...");
	}
	
	@Test(priority = 2) 
	void loginApp()
	{
		System.out.println("Login into application...");
	}
	
	@Test(priority = 3) 
	void logoutApp() {
		System.out.println("Logout from application...");
	}
 }
