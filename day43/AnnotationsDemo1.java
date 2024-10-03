package day43;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
1)	Login -> @BeforeClass
2)	Search functionality -> @Test
3)	Advance search -> @Test
4)	Logout -> @AfterClass

*/

public class AnnotationsDemo1 {

	@BeforeClass
	void login() {
		System.out.println("This is login...");
	}
	
	@AfterClass
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
