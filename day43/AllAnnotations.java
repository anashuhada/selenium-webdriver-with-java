package day43;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class AllAnnotations {
	
	@BeforeSuite
	void beforeSuite() {
		System.out.println("This is BeforeSuite");
	}
	
	@AfterSuite
	void afterSuite() {
		System.out.println("This is AfterSuite");
	}
	
	@BeforeTest
	void beforeTest() {
		System.out.println("This is BeforeTest");
	}

	@AfterTest
	void afterTest() {
		System.out.println("This is AfterTest");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("This is BeforeClass");
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("This is AfterClass");
	}
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("This is BeforeMethod");
	}
	
	@AfterMethod
	void afterMethod() {
		System.out.println("This is AfterMethod");
	}
	
	@Test(priority=1)
	void testMethod1() {
		System.out.println("This is Test Method 1");
	}
	
	@Test(priority=2)
	void testMethod2() {
		System.out.println("This is Test Method 2");
	}
	
}
