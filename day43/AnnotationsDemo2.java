package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
1) Login -> @BeforeMethod ** need to login multiple times before main test 
2) Search functionality -> @Test
3) Logout -> @AfterMethod ** need to login multiple times after main test
4) Login
5) Advance search -> @Test
6) Logout 
*/

public class AnnotationsDemo2 {

	@BeforeMethod
	void login() {
		System.out.println("This is login...");
	}
	
	@AfterMethod
	void logout() {
		System.out.println("This is logout...");
	}
	
	@Test(priority=1)
	void search() {
		System.out.println("This is search...");
	}
	
	@Test(priority=2)
	void advancedSearch() {
		System.out.println("This is advanced search");
	}
	
}
